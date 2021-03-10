package ru.usovsu.parser.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.usovsu.parser.entity.TopicSqlRu;
import ru.usovsu.parser.repository.TopicSqlRuRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ParserSqlRuService {

    private final TopicSqlRuRepository topicSqlRuRepository;
    public List<String> links;
    public List<TopicSqlRu> messageList;


    public void addTopicSql(TopicSqlRu topicSqlRu) {
        this.topicSqlRuRepository.save(topicSqlRu);
    }

    public void deleteTopicSql(TopicSqlRu topicSqlRu) {
        this.topicSqlRuRepository.delete(topicSqlRu);
    }

    public void editTopicSql(TopicSqlRu topicSqlRu) {
        this.topicSqlRuRepository.save(topicSqlRu);
    }


    public String urlReqSimple() {
        return "https://www.sql.ru/forum/job-offers";
    }

    public void parseDef() throws IOException {
        log.debug("parseDef() start working");
        links = new ArrayList<>();

        Document forum = Jsoup.connect(urlReqSimple()).get();
        Elements table = forum.getElementsByClass("postslisttopic");

        //Получаем URL каждой вакансии
        for (Element e : table) {
            String url = e.select("a[href]").first().attr("href");
            links.add(url);
        }

        //Проходим по списку вакансии
        for (String url : links) {
            Document msgBody = Jsoup.connect(url).get();
            Elements msgBodyElem = msgBody.getElementsByClass("msgBody");
            StringBuilder resultMsgBodyElem = new StringBuilder();
            Element msg = msgBodyElem.select(".msgBody").next().first();

            for (TextNode subString : msg.textNodes()) {
                if (!subString.text().equals(" ")) {
                    String nevedomyaXernya =
                            resultMsgBodyElem.append(subString).append(System.lineSeparator()).toString();
                }
            }
            String dateVacancy = msgBody.select("td.msgFooter").first().text();
            dateVacancy = dateVacancy.substring(0, dateVacancy.indexOf('['));
            topicSqlRuRepository.save(new TopicSqlRu(resultMsgBodyElem, dateVacancy));

        }
    }
}



package ru.usovsu.parser.service;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usovsu.parser.entity.TopicSqlRu;
import ru.usovsu.parser.repository.TopicSqlRuRepository;

import java.io.IOException;
import java.util.*;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class ParserSqlRuService {

    private final TopicSqlRuRepository topicSqlRuRepository;


    public void addTopicSql(TopicSqlRu topicSqlRu) {
        this.topicSqlRuRepository.save(topicSqlRu);
    }

    public void deleteTopicSql(TopicSqlRu topicSqlRu) {
        this.topicSqlRuRepository.delete(topicSqlRu);
    }

    public void editTopicSql(TopicSqlRu topicSqlRu) {
        this.topicSqlRuRepository.save(topicSqlRu);
    }

    public List<TopicSqlRu> topicA;
    public List<TopicSqlRu> messageList;
    private String url;


    public void setUrl(String url) {

        this.url = urlReqSimple();
    }

    public String urlReqSimple() {
        String urlReq = "https://www.sql.ru/forum/job-offers";
        return urlReq;
    }

    @Autowired
    public void parseDef() throws IOException {
        System.out.println("parseDef() working");


        topicA = new ArrayList<>();
//        messageList = new ArrayList<>();
        Map<String, String> topic = new HashMap<>();
        Map<StringBuilder, String> messageList = new HashMap<>();


        Document forum = Jsoup.connect(urlReqSimple()).get();
        Elements table = forum.getElementsByClass("postslisttopic");

        for (Element e : table) {
            String title = e.select("a[href]")
                    .first()
                    .text();
            String url = e.select("a[href]")
                    .first()
                    .attr("href");

            topicA.add(new TopicSqlRu(title, url));
            topic.put(title, url);

            for (TopicSqlRu t : topicA) {
                String urlTopic = t.getUrl();
                Document msgBody = Jsoup.connect(urlTopic).get();
                Elements msgBodyElem = msgBody.getElementsByClass("msgBody");
                StringBuilder resultMsgBodyElem = new StringBuilder();
                Element msg = msgBodyElem
                        .select(".msgBody")
                        .next()
                        .first();
                for (TextNode subString : msg.textNodes()) {
                    if (!subString.text()
                            .equals(" ")) {
                        resultMsgBodyElem
                                .append(subString)
                                .append(System.lineSeparator())
                                .toString();
                    }
                }
                String dateVacancy = msgBody
                        .select("td.msgFooter")
                        .first()
                        .text();
                dateVacancy = dateVacancy
                        .substring(0, dateVacancy.indexOf('['));
                messageList.put(resultMsgBodyElem, dateVacancy);
            }
        }
            Map topicList = new HashMap();
            topicList.put(topic, messageList);
            System.out.println(topicList);
    }
}



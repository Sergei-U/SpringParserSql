package ru.usovsu.parser.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.usovsu.parser.entity.TopicSqlRu;
import ru.usovsu.parser.service.ParserSqlRuService;

import java.io.IOException;

/**
 *
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ParserSqlRuController {

    private final ParserSqlRuService parserSqlRuService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addTopic (@RequestBody TopicSqlRu topicSqlRu) {
        this.parserSqlRuService.addTopicSql(topicSqlRu);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteTopic(@RequestBody TopicSqlRu topicSqlRu) {
        this.parserSqlRuService.deleteTopicSql(topicSqlRu);
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editTopic( @RequestBody TopicSqlRu topicSqlRu) {
        this.parserSqlRuService.editTopicSql(topicSqlRu);
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void testTopic(@RequestBody TopicSqlRu topicSqlRu) throws IOException {this.parserSqlRuService.parseDef();}
}

package ru.sbtqa.apifactoryexample.entries;

import net.minidev.json.JSONArray;
import org.junit.Assert;
import ru.sbtqa.tag.apifactory.ApiEntry;
import ru.sbtqa.tag.apifactory.ApiFactory;
import ru.sbtqa.tag.apifactory.annotation.ApiAction;
import ru.sbtqa.tag.apifactory.annotation.ApiValidationRule;
import ru.sbtqa.tag.parsers.JsonParser;
import ru.sbtqa.tag.parsers.core.exceptions.ParserException;

@ApiAction(method = "get", title = "получить статьи", path = "posts")
public class GetPostsEntry extends ApiEntry {

    @ApiValidationRule(title = "верное количество статей")
    public void resultsCount() throws ParserException {
        String responce = ApiFactory.getApiFactory().getResponseRepository().getBody(this.getClass());
        JsonParser jparser = new JsonParser();
        JSONArray posts = jparser.read(responce, "$.[*]");
        Assert.assertEquals("Incorrect count of posts", 100, posts.size());

    }
}

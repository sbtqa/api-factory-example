package ru.sbtqa.apifactoryexample.entries;

import net.minidev.json.JSONArray;
import org.junit.Assert;
import ru.sbtqa.tag.apifactory.ApiEntry;
import ru.sbtqa.tag.apifactory.ApiFactory;
import ru.sbtqa.tag.apifactory.annotation.ApiAction;
import ru.sbtqa.tag.apifactory.annotation.ApiRequestParam;
import ru.sbtqa.tag.apifactory.annotation.ApiValidationRule;
import ru.sbtqa.tag.parsers.JsonParser;
import ru.sbtqa.tag.parsers.core.exceptions.ParserException;

@ApiAction(method = "get", title = "получить пост", path = "posts?id=%id")
public class Post extends ApiEntry {

    @ApiRequestParam(title = "id")
    private static String id = "1";

    @ApiValidationRule(title = "статус запроса успешен")
    public void resultsCount() throws ParserException {
        String responce = ApiFactory.getApiFactory().getResponseRepository().getBody(this.getClass());
        JsonParser jparser = new JsonParser();
        String userId = ((JSONArray)jparser.read(responce, "$.[:1].userId")).get(0).toString();
        Assert.assertEquals("Incorrect userId", "1", userId);

    }
}

package ru.sbtqa.apifactoryexample.steps;


import org.junit.Before;
import ru.sbtqa.tag.apifactory.ApiFactory;
import ru.sbtqa.tag.apifactory.rest.RestEntityImpl;
import ru.sbtqa.tag.parsers.JsonParser;

public class StepDefinitions {

    @Before
    public void setUp(){
        ApiFactory.getApiFactory().setParser(JsonParser.class);
        ApiFactory.getApiFactory().setRest(RestEntityImpl.class);
    }
}

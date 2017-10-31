package ru.sbtqa.apifactoryexample;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.cucumber.TagCucumber;

@RunWith(TagCucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"ru.sbtqa.tag.apifactory.stepdefs"},
        features = {"src/test/resources/features"},
        tags = {"@test1"}
)
public class CucumberTest {
}

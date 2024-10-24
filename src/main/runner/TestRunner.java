package main.runner;

import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.plugin.Plugin;

@RunWith(Cucumber.class)
@CucumberOptions(
     features = {"src/test/java/demoqa/features"},
     glue = { "test.java.demoqa.uiStepdefs" , "test.java.demoqa"},
tags = "@RegTC",
        plugin = {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_output/cucumber.xml"

        }




)
public class TestRunner extends AbstractTestNGCucumberTests {





}

package main.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
     features = {"src/test/java/demoqa/features"},
     glue = { "test.java.demoqa.uiStepdefs" , "test.java.demoqa"},
tags = "@RegTC",
        plugin = {

        }



)
public class TestRunner extends AbstractTestNGCucumberTests {


}

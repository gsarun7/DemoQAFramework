package main.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
     features = {"src/test/java/demoqa/features"},
     glue = { "test.java.demoqa.uiStepdefs" , "test.java.demoqa.Hooks"},

        plugin = {

        }



)
public class TestRunner extends AbstractTestNGCucumberTests {


}

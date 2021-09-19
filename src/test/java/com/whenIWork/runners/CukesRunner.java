package com.whenIWork.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue= "com/whenIWork/step_definitions",
        tags =  ""
)
public class CukesRunner {


}

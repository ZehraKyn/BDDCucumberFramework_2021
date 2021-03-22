package com.swaglabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        // plugin is for reports, pretty is for the console
        plugin = {"pretty", "html:target/site/cucumber-pretty.html"},

        snippets = CucumberOptions.SnippetType.CAMELCASE,

        //glue: Specify step definition package path to connect with feature file
        glue = {"com/swaglabs/stepdefinitions"},

        features = {"src/test/resources/features"},

        tags = "@checkout",

        dryRun = false,

        monochrome = true

)

public class TestRunner {


}

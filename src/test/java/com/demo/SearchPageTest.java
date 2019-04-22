package com.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/demo/Search_page.feature"},
        strict = false, 
        glue = {"com.demo.infrastructure.driver",
                "com.demo.searchpage"})
public class SearchPageTest {
}
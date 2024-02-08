package com.cucumber_tutorialsninja.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/",
		glue = "com.cucumber_tutorialsninja.StepDefinitions",
		//dryRun = true,
		tags = "@alltestLogin",
		monochrome = false,
		plugin = { "pretty" ,"html:target/cucumber-html-report.html" ,"json:target/cucumber.json" }
		)
public class TestRunner {
	

} 

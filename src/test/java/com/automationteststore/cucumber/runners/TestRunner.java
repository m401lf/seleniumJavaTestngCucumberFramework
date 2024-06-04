package com.automationteststore.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/com/automationteststore/cucumber/features/",
        glue = "com/automationteststore/cucumber/stepDefinitions",
        publish = true,
        monochrome = true,
        //dryRun = true,
        //tags = "@Login001",
        //tags = "@LoginWithDataTable",
        //tags= "@LoginWithoutAssertions",
        //tags = "@Forgotten",
        //tags = "@RecoveryForgottenPassword",
        //tags = "@Registration1",
        //tags = "@Registration001",
        //tags = "@RegistrationDataTable",
        //tags = "@RegistrationDataTableWithoutAssertions",
        tags = "@Reg001",
        //tags = "@Homepage_CompleteOrder_E2E_1",


        plugin = {
                "pretty",
                "json:target/json_output/cucumber.json",
                "junit:target/junit_xml_output/cucumber.xml",
                "html:target/html_output/cucumber.html",
                "html:cucumberReport/cucumber.html"

        })

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

package com.anurag.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anurag.automation.base.BaseTest;
import com.anurag.automation.page.SearchGoogleTest;

public class GoogleTest extends BaseTest {
    
    @Test
    public void verifyGoogletitle(){
        String actual_title = driver.getTitle();
        System.out.println("Title is: "+actual_title);

        Assert.assertTrue(actual_title.contains("Google"), "Title does not contain Google");
    }

    @Test
    public void verifyGoogleSearch(){
        SearchGoogleTest googlePage = new SearchGoogleTest(driver);
        googlePage.enterSearchTerm("Cristiano Ronaldo");

        String actual_title = driver.getTitle();
        System.out.println("Title after search is: "+actual_title);

        Assert.assertTrue(actual_title.contains("Cristiano Ronaldo"), "Title does not contain Cristiano Ronaldo");
    }
}

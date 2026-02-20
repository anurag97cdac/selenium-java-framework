package com.anurag.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchGoogleTest {
    
    WebDriver driver;

    public SearchGoogleTest(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="APjFqb")
    private WebElement searchBox;

    public void enterSearchTerm(String searchTerm){
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }
}

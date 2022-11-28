package com.tolmachevsv;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchTest {

    @Test
    void shouldFindJunit5Code() {
        open("https:/github.com");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#repo-content-pjax-container").shouldHave(text("SoftAssertions"));
        $(("[id=user-content-3-using-junit5-extend-test-class]")).parent()
                        .shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}

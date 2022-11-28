package com.tolmachevsv;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void swapRectangles() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // сработало спокойно
        $("#column-a").dragAndDropTo($("#column-b"));
        // не работает, пробовал разные Xoffset
//        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
    }
}

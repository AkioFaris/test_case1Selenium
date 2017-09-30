package task3.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {

    @FindBy(css = ".uui-slider.blue.range.ui-slider")
    private SelenideElement sliderTrack;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    private Double getStepInPixels() {
        return sliderTrack.getSize().width / 100.0;
    }

    private Double getPosInPixels(SelenideElement slider) {
        return Double.parseDouble(slider.getCssValue("left")
                .replaceAll("px", "")) + slider.getSize().width / 2.0;
    }

    private int getSliderPosition(SelenideElement slider) {
        return new Integer(slider.getText());
    }

    private void correctPosition(SelenideElement slider, int position) {
        int currPos = getSliderPosition(slider);
        if (currPos == position)
            return;
        int xOffset = (int) Math.round(getStepInPixels());
        int yOffset = 0;
        if (currPos > position)
            xOffset *= -1;
        while (currPos != position) {
            actions().clickAndHold(slider)
                    .moveByOffset(xOffset, yOffset)
                    .release()
                    .build()
                    .perform();
            currPos = getSliderPosition(slider);
        }
    }

    private void moveSliderToPos(SelenideElement slider, int position) {
        int xOffset = (int) Math.round(position * getStepInPixels() - getPosInPixels(slider));
        int yOffset = 0;
        actions().clickAndHold(slider)
                .moveByOffset(xOffset, yOffset)
                .release()
                .build()
                .perform();
        correctPosition(slider, position);
    }

    public void setSliders(int leftSliderPos, int rightSliderPos) {
        if (rightSliderPos < leftSliderPos)
            return;
        sliderTrack.scrollTo();
        if (getSliderPosition(sliders.get(1)) <= leftSliderPos) {
            moveSliderToPos(sliders.get(1), rightSliderPos);
            moveSliderToPos(sliders.get(0), leftSliderPos);
        } else {
            moveSliderToPos(sliders.get(0), leftSliderPos);
            moveSliderToPos(sliders.get(1), rightSliderPos);
        }

    }

    public void checkSliders(int leftSliderPos, int rightSliderPos) {
        sliderTrack.scrollTo();
        sliders.get(0).shouldHave(exactText(Integer.toString(leftSliderPos)));
        sliders.get(1).shouldHave(exactText(Integer.toString(rightSliderPos)));
    }
}

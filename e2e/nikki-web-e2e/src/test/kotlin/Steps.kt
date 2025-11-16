import com.codeborne.selenide.Selectors.shadowDeepCss
import com.thoughtworks.gauge.Step
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.conditions.*

class Steps {
    @Step("トップ画面を開く")
    fun nikkiStep() {
       open("/")
    }

    @Step("タイトル<title>が表示されていること")
    fun titleStep(title: String) {
        `$`(shadowDeepCss("h1")).shouldHave(Text(title))
    }
}

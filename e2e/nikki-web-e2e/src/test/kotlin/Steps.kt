import com.thoughtworks.gauge.Step
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.conditions.*

class Steps {
    @Step("ヘルスチェック画面を開く")
    fun nikkiStep() {
       open("/healthCheck")
    }

    @Step("タイトル<title>が表示されていること")
    fun titleStep(title: String) {
        `$`("h1").shouldHave(Text(title))
    }
}

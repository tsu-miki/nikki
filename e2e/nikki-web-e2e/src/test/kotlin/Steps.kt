import com.thoughtworks.gauge.Step
import com.codeborne.selenide.Selenide.*
import sun.tools.jconsole.inspector.XOpenTypeViewer

class Steps {
    @Step("ヘルスチェック画面を開く")
    fun nikkiStep() {
       open("/healthCheck")
    }
}

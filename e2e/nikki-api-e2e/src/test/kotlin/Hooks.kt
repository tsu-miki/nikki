import com.uzabase.playtest2.core.config.Configuration.Companion.playtest2
import com.uzabase.playtest2.http.config.http
import com.thoughtworks.gauge.BeforeSuite
import java.net.URI

class Hooks {
    @BeforeSuite
    fun beforeSuite() {
        playtest2 {
            listOf(http(URI("http://localhost:8080").toURL()))
        }
    }
}
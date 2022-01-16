package kr.lul.blog.oop.procedure

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import mu.KotlinLogging

class ProcedureKtTest : BehaviorSpec({
    val log = KotlinLogging.logger { }

    given("현재 버전이 1.2.3 이고") {
        val current = "1.2.3"
        log.info("[GIVEN] current=$current")

        `when`("필요 버전이 1.2.0 이면") {
            val required = "1.2.0"
            log.info("[WHEN] required=$required")

            then("업데이트 불필요.") {
                checkUpdate(current, required) shouldBe false
            }
        }

        `when`("필요 버전이 1.2.3 면") {
            val required = "1.2.3"
            log.info("[WHEN] required=$required")

            then("업데이트 불필요.") {
                checkUpdate(current, required) shouldBe false
            }
        }

        `when`("필요 버전이 1.2.4 면") {
            val required = "1.2.4"
            log.info("[WHEN] required=$required")

            then("업데이트 필요.") {
                checkUpdate(current, required) shouldBe true
            }
        }

        `when`("필요 버전이 1.2.10 이면") {
            val required = "1.2.10"
            log.info("[WHEN] required=$required")

            then("업데이트 필요.") {
                // 테스트 실패.
                checkUpdate(current, required) shouldBe true
            }
        }
    }
})

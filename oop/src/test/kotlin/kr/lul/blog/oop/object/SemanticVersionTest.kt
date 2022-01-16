package kr.lul.blog.oop.`object`

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.comparables.shouldBeLessThan
import mu.KotlinLogging

class SemanticVersionTest : BehaviorSpec({
    val log = KotlinLogging.logger { }

    given("현재 버전이 1.2.3 이고") {
        val current = SemanticVersion("1.2.3")
        log.info("[GIVEN] current=$current")

        `when`("필요 버전이 1.2.0 이면") {
            val required = SemanticVersion("1.2.0")
            log.info("[WHEN] required=$required")

            then("업데이트 불필요.") {
                current shouldBeGreaterThan required
            }
        }

        `when`("필요 버전이 1.2.3 면") {
            val required = SemanticVersion("1.2.3")
            log.info("[WHEN] required=$required")

            then("업데이트 불필요.") {
                current shouldBeGreaterThanOrEqualTo required
            }
        }

        `when`("필요 버전이 1.2.4 면") {
            val required = SemanticVersion("1.2.4")
            log.info("[WHEN] required=$required")

            then("업데이트 필요.") {
                current shouldBeLessThan required
            }
        }

        `when`("필요 버전이 1.2.10 이면") {
            val required = SemanticVersion("1.2.10")
            log.info("[WHEN] required=$required")

            then("업데이트 필요.") {
                // 테스트 실패.
                current shouldBeLessThan required
            }
        }
    }
})

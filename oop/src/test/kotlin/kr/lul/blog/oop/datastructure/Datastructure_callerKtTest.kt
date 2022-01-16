package kr.lul.blog.oop.datastructure

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import mu.KotlinLogging

@Suppress("ClassName", "SpellCheckingInspection")
class Datastructure_callerKtTest : BehaviorSpec({
    val log = KotlinLogging.logger { }

    given("'1.2.3' 문자열을") {
        val name = "1.2.3"
        log.info("[GIVEN] name=$name")

        `when`("SemanticVersion으로 변환을 하면") {
            val version = convert(name)
            log.info("[WHEN] version=$version")

            then("버전 코어를 확인할 수 있다.") {
                version.major shouldBe 1
                version.minor shouldBe 2
                version.patch shouldBe 3
                version.preRelease.shouldBeNull()
                version.build.shouldBeNull()
            }
        }
    }

    given("'1.0.0-alpha' 문자열을") {
        val name = "1.0.0-alpha"
        log.info("[GIVEN] name=$name")

        `when`("변환을 하면") {
            val version = convert(name)
            log.info("[WHEN] version=$version")

            then("pre-release 확인 가능.") {
                version.major shouldBe 1
                version.minor shouldBe 0
                version.patch shouldBe 0
                version.preRelease shouldBe "alpha"
                version.build.shouldBeNull()
            }
        }
    }

    given("'1.0.0+20130313144700' 문자열을") {
        val name = "1.0.0+20130313144700"
        log.info("[GIVEN] name=$name")

        `when`("변환을 하면") {
            val version = convert(name)
            log.info("[WHEN] version=$version")

            then("빌드를 확인할 수 있다.") {
                version.major shouldBe 1
                version.minor shouldBe 0
                version.patch shouldBe 0
                version.preRelease.shouldBeNull()
                version.build shouldBe "20130313144700"
            }
        }
    }

    given("'1.0.0-beta+exp.sha.5114f85' 문자열을") {
        val name = "1.0.0-beta+exp.sha.5114f85"
        log.info("[GIVEN] name=$name")

        `when`("변환을 하면") {
            val version = convert(name)
            log.info("[WHEN] version=$version")

            then("빌드를 확인할 수 있다.") {
                version.major shouldBe 1
                version.minor shouldBe 0
                version.patch shouldBe 0
                version.preRelease shouldBe "beta"
                version.build shouldBe "exp.sha.5114f85"
            }
        }
    }
})

package kr.lul.blog.oop.string

import mu.KotlinLogging

private val log = KotlinLogging.logger { }

/**
 * 현재 버전과 필요 버전을 비교해서 필요 버전이 더 높은 버전이라면 업데이트를 실행한다.
 *
 * 현재 버전이 9 이고 필요 버전이 10 이라면 문자열 비교로는 업데이트를 실행하지 못 한다.
 *
 * @param current 유의적 버전 사양의 현재 버전.
 * @param required 유의적 버전 사양의 필요 버전.
 */
fun checkUpdate(current: String, required: String): Boolean {
    log.trace("#checkAndUpdate args : current=$current, required=$required")
    return if (current < required) {
        log.trace("#checkAndUpdate do update.")
        true
    } else {
        false
    }
}

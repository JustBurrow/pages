package kr.lul.blog.oop.procedure

import mu.KotlinLogging

private val LOG = KotlinLogging.logger { }

const val VERSION_CORE_PATTERN = "(\\d+)\\.(\\d+)\\.(\\d+)"
const val PRE_RELEASE_PATTERN = "[\\da-zA-Z]+(\\.[\\da-zA-Z]+)*"
const val BUILD_PATTERN = "[\\da-zA-Z]+"
const val VERSION_PATTERN = "$VERSION_CORE_PATTERN(-$PRE_RELEASE_PATTERN)?(\\+$BUILD_PATTERN)?"
val VERSION_REGEX = VERSION_PATTERN.toRegex()

/**
 * 현재 버전과 필요 버전을 비교해서 필요 버전이 더 높은 버전이라면 업데이트를 실행한다.
 *
 * @param current 유의적 버전 사양의 현재 버전.
 * @param required 유의적 버전 사양의 필요 버전.
 */
fun checkUpdate(current: String, required: String): Boolean {
    LOG.info("#checkUpdate args : current=$current, required=$required")

    val currentValues = VERSION_REGEX.find(current)!!.groupValues
    val requiredValues = VERSION_REGEX.find(required)!!.groupValues
    LOG.info("#checkUpdate : currentValues=$currentValues, requiredValues=$requiredValues")

    val currentMajor = currentValues[1].toInt(10)
    val currentMinor = currentValues[2].toInt(10)
    val currentPatch = currentValues[3].toInt(10)
    LOG.info("#checkUpdate currentMajor=$currentMajor, currentMinor=$currentMinor, currentPatch=$currentPatch")

    val requiredMajor = requiredValues[1].toInt(10)
    val requiredMinor = requiredValues[2].toInt(10)
    val requiredPatch = requiredValues[3].toInt(10)
    LOG.info("#checkUpdate requiredMajor=$requiredMajor, requiredMinor=$requiredMinor, requiredPatch=$requiredPatch")

    return if (
            currentMajor < requiredMajor ||
            (currentMajor == requiredMajor && currentMinor < requiredMinor) ||
            (currentMajor == requiredMajor && currentMinor == requiredMinor && currentPatch < requiredPatch)
    ) {
        LOG.info("#checkUpdate : need to update.")
        true
    } else {
        false
    }
}

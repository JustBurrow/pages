package kr.lul.blog.oop.datastructure

/**
 * 버전을 확인해서 업데이트를 한 후에 어떤 기능을 실행하는 가상의 로직.
 */
fun someLogic() {
    val current = "1.2.3"   // 어디선가 읽어온 현재 버전.
    val required = "1.2.4"  // 어디선가 읽어온 필요 버전.

    val currentVersion = convert(current)
    val requiredVersion = convert(required)

    if (checkUpdate(currentVersion, requiredVersion)) {
        // 업데이트 실행.
    }

    // 기타 기능.
}


const val VERSION_CORE_PATTERN = "(\\d+)\\.(\\d+)\\.(\\d+)"
const val PRE_RELEASE_PATTERN = "[\\da-zA-Z-]+(\\.[\\da-zA-Z-]+)*"
const val BUILD_PATTERN = "[\\da-zA-Z-]+(\\.[\\da-zA-Z-]+)*"
const val VERSION_PATTERN = "$VERSION_CORE_PATTERN(-($PRE_RELEASE_PATTERN))?(\\+($BUILD_PATTERN))?"
val VERSION_REGEX = VERSION_PATTERN.toRegex()

fun convert(name: String): SemanticVersion {
    val values = VERSION_REGEX.find(name)!!.groupValues

    val major = values[1].toInt(10)
    val minor = values[2].toInt(10)
    val patch = values[3].toInt(10)
    val preRelease = values[5].ifBlank { null }
    val build = values[8].ifBlank { null }

    return SemanticVersion(major, minor, patch, preRelease, build)
}
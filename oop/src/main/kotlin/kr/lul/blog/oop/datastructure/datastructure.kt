package kr.lul.blog.oop.datastructure

/**
 * 현재 버전과 필요 버전을 비교해서 필요 버전이 더 높은 버전이라면 업데이트를 실행한다.
 *
 * @param current 유의적 버전 사양의 현재 버전.
 * @param required 유의적 버전 사양의 필요 버전.
 */
fun checkUpdate(current: SemanticVersion, required: SemanticVersion): Boolean {
    return current.major < required.major ||
            (current.major == required.major && current.minor < required.minor) ||
            (current.major == required.major && current.minor == required.minor && current.patch < required.patch)
}
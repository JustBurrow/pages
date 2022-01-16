package kr.lul.blog.oop.procedure

/**
 * 버전을 확인해서 업데이트를 한 후에 어떤 기능을 실행하는 가상의 로직.
 */
fun someLogic() {
    val current = "1.2.3"   // 어디선가 읽어온 현재 버전.
    val required = "1.2.4"  // 어디선가 읽어온 필요 버전.

    if (checkUpdate(current, required)) {
        // 업데이트 실행.
    }

    // 기타 기능.
}
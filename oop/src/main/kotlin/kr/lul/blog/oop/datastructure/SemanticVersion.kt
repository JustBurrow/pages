package kr.lul.blog.oop.datastructure

/**
 * [Semantic Versioning 2.0.0](https://semver.org/) 기본 자료구조.
 *
 * @author justburrow
 * @since 2022/01/08
 */
data class SemanticVersion(
        val major: Int,
        val minor: Int,
        val patch: Int,
        val preRelease: String?,
        val build: String?
)

package kr.lul.blog.oop.`object`

/**
 * @author justburrow
 * @since 2022/01/16
 */
class SemanticVersion : Comparable<SemanticVersion> {
    companion object {
        const val VERSION_CORE_PATTERN = "(\\d+)\\.(\\d+)\\.(\\d+)"
        const val PRE_RELEASE_PATTERN = "[\\da-zA-Z-]+(\\.[\\da-zA-Z-]+)*"
        const val BUILD_PATTERN = "[\\da-zA-Z-]+(\\.[\\da-zA-Z-]+)*"
        const val VERSION_PATTERN = "$VERSION_CORE_PATTERN(-($PRE_RELEASE_PATTERN))?(\\+($BUILD_PATTERN))?"

        val VERSION_CORE_REGEX = VERSION_CORE_PATTERN.toRegex()
        val PRE_RELEASE_REGEX = PRE_RELEASE_PATTERN.toRegex()
        val BUILD_REGEX = BUILD_PATTERN.toRegex()
        val VERSION_REGEX = VERSION_PATTERN.toRegex()
    }

    var major: Int
        private set(value) {
            if (0 > value) {
                throw IllegalArgumentException("negative major number : major=$value")
            }
            field = value
        }

    var minor: Int
        private set(value) {
            if (0 > value) {
                throw IllegalArgumentException("negative minor number : minor=$value")
            }
            field = value
        }

    var patch: Int
        private set(value) {
            if (0 > value) {
                throw IllegalArgumentException("negative patch number : patch=$value")
            }
            field = value
        }

    var preRelease: String?
        private set(value) {
            field = if (null == value) {
                value
            } else {
                if (!value.matches(PRE_RELEASE_REGEX)) {
                    throw IllegalArgumentException("illegal pre-release : preRelease=$value")
                } else {
                    value
                }
            }
        }

    var build: String?
        private set(value) {
            field = if (null == value) {
                value
            } else {
                if (!value.matches(BUILD_REGEX)) {
                    throw IllegalArgumentException("illegal build : build=$value")
                } else {
                    value
                }
            }
        }

    constructor(name: String) {
        VERSION_REGEX.find(name)!!.groupValues.also {
            major = it[1].toInt(10)
            minor = it[2].toInt(10)
            patch = it[3].toInt(10)
            preRelease = it[5].ifBlank { null }
            build = it[8].ifBlank { null }
        }
    }

    constructor(
            major: Int, minor: Int, patch: Int,
            preRelease: String? = null, build: String? = null
    ) {
        this.major = major
        this.minor = minor
        this.patch = patch
        this.preRelease = preRelease
        this.build = build
    }


    override fun compareTo(other: SemanticVersion): Int {
        var rv = major.compareTo(other.major)
        if (0 == rv)
            rv = minor.compareTo(other.minor)
        if (0 == rv)
            rv = patch.compareTo(other.patch)

        return rv
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SemanticVersion

        return major == other.major
                && minor == other.minor
                && patch == other.patch
                && preRelease == other.preRelease
                && build == other.build
    }

    override fun hashCode(): Int {
        var result = major
        result = 31 * result + minor
        result = 31 * result + patch
        result = 31 * result + (preRelease?.hashCode() ?: 0)
        result = 31 * result + (build?.hashCode() ?: 0)
        return result
    }

    /**
     * @return version coreの文字列。
     */
    override fun toString(): String {
        var rv = "$major.$minor.$patch"
        if (null != preRelease)
            rv = "$rv-$preRelease"
        if (null != build)
            rv = "$rv+$build"
        return rv
    }
}
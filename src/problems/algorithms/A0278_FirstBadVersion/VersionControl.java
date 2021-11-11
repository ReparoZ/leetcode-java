package problems.algorithms.A0278_FirstBadVersion;

/**
 * The isBadVersion API Judge Parent Class
 *
 * @author reparo
 * @date 2021/11/11
 */
public class VersionControl {

    public static int badVersionIndex = 0;

    boolean isBadVersion(int version) {
        return version >= badVersionIndex;
    }
}

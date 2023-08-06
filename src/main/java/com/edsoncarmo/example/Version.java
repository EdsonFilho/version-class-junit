package com.edsoncarmo.example;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The Version class represents a software version in the format "major.minor.patch[-SNAPSHOT]".
 * It allows parsing and comparing versions based on their numeric components.
 *
 * <p>Usage:
 * Version version1 = new Version("3.2.0");
 * Version version2 = new Version("3.2.1");
 *
 * int result = version1.compareTo(version2);
 * if (result < 0) {
 *     System.out.println("version1 is older than version2");
 * } else if (result > 0) {
 *     System.out.println("version1 is newer than version2");
 * } else {
 *     System.out.println("version1 and version2 are equal");
 * }
 *
 * @see Comparable
 */
public class Version implements Comparable<Version> {

    private static final String SNAPSHOT = "-SNAPSHOT";

    private Integer major;
    private Integer minor;
    private Integer patch;
    private boolean snapshot;

    /**
     * Constructs a new Version object by parsing the given version string.
     *
     * <p>The version string must be in the format "major.minor.patch[-SNAPSHOT]", where:
     * - major: represents the major version number.
     * - minor: represents the minor version number.
     * - patch: represents the patch version number.
     * - -SNAPSHOT (optional): indicates that this version is a snapshot version.
     *
     * <p>Examples of valid version strings: "3.2.0", "1.0.10-SNAPSHOT", "2.5.1".
     *
     * @param versionString The version string to parse and create the Version object.
     * @throws IllegalArgumentException If the version string is not in the correct format.
     */
    public Version(String versionString) throws IllegalArgumentException {
        // If versionString is null
        if (versionString == null)
            throw new IllegalArgumentException("version must not be null!");
        // If versionString is empty
        if ("".equals(versionString))
            throw new IllegalArgumentException("version must not be empty!");
        // If versionString is in corrct format
        boolean regex = Pattern.matches("\\d+(\\.\\d+){0,2}(-SNAPSHOT)?", versionString);
        if (!regex) {
            throw new IllegalArgumentException("version must match: 'major.minor.patch(-SNAPSHOT)'!");
        }

        // If versionString ends with -SNAPSHOT
        if (versionString.endsWith("-SNAPSHOT")) {
            this.snapshot = true;
            versionString = versionString.substring(0, versionString.length() - SNAPSHOT.length());
        }
        try {
            String[] arr = versionString.split("\\.");
            this.major = Integer.parseInt(arr[0]);
            this.minor = arr[1] != null ? Integer.parseInt(arr[1]) : 0;
            this.patch = arr[2] != null ? Integer.parseInt(arr[2]) : 0;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid version format. Expected format: 3.2.0");
        }
    }

    public boolean isSnapshot() {
        return snapshot;
    }

    @Override
    public String toString() {
        return  major + '.' + minor + '.' + patch + (snapshot ? "-SNAPSHOT" : "");
    }

    @Override
    public int compareTo(Version version) {
        Integer result;
        // Compare major version
        result = major.compareTo(version.major);
        if (result != 0)
            return result;
        // Compare minor version
        result = minor.compareTo(version.minor);
        if (result != 0)
            return result;
        // Compare patch version
        result = patch.compareTo(version.patch);
        if (result != 0)
            return result;
        // If versions are equal, check if one of them is a snapshot
        if (snapshot && !version.snapshot)
            return -1; // This version is a snapshot, and the other is not
        if (!snapshot && version.snapshot)
            return 1; // The other version is a snapshot, and this is not
        // Both versions are equal
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version = (Version) o;
        return snapshot == version.snapshot && Objects.equals(major, version.major) && Objects.equals(minor, version.minor) && Objects.equals(patch, version.patch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snapshot, major, minor, patch);
    }
}

package com.edsoncarmo.example;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Version version1 = new Version("3.2.0");
        Version version2 = new Version("3.2.1");
        Version version3 = new Version("3.2.0-SNAPSHOT");

        System.out.println("Version 1 compared to Version 2: " + version1.compareTo(version2)); // Output: -1
        System.out.println("Version 2 compared to Version 1: " + version2.compareTo(version1)); // Output: 1
        System.out.println("Version 1 compared to Version 3: " + version1.compareTo(version3)); // Output: 1
        System.out.println("Version 3 compared to Version 1: " + version3.compareTo(version1)); // Output: -1
        System.out.println("Version 2 compared to Version 3: " + version2.compareTo(version3)); // Output: 1
        System.out.println("Version 3 compared to Version 2: " + version3.compareTo(version2)); // Output: -1
        System.out.println("Version 1 compared to itself: " + version1.compareTo(version1));    // Output: 0
    }
}
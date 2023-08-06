# Unit tests with JUnit 4 for Version class

This project has been created to demonstrate how to use JUnit 4 for testing a 'Version' Java class with unit tests.

## Table of Contents

- [Overview](#overview)
- [Installation](#installation)
- [Usage](#usage)
- [Tests](#tests)

## Overview

The 'Version' class represents a software version in the format "major.minor.patch[-SNAPSHOT]".
It allows parsing and comparing versions based on their numeric components.
 
## Installation

To clone the application run the following command:
<code>git clone https://github.com/EdsonFilho/version-class-junit.git</code>

## Usage

To build the application run the following command:

<code>mvn clean package</code>

After running this command, a file called version-class-junit-1.0-SNAPSHOT.jar will be created on the /target directory.

To run the application run the following command:

<code>java -jar target/version-class-junit-1.0-SNAPSHOT.jar</code>

## Tests

To run the unit tests run the following command:

<code>mvn test</code> 

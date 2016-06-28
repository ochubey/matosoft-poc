# MatSoft Proof of concept

[![Build Status][build_status]](https://snap-ci.com/ochubey/matosoft-poc/branch/master)

## Description

This is an POC of usage Geb+Spock combination.

## Usage

Clone latest version and be sure to provide correct credentials for test execution:

    git clone https://github.com/ochubey/matosoft-poc.git

The following commands will launch the tests with the individual browsers:

    ./gradlew cleanTest chromeTest -DloginName="{defining correct email}" -Dpassword="{defining correct password}"
    ./gradlew cleanTest firefoxTest -DloginName="{defining correct email}" -Dpassword="{defining correct password}"

To run with all, you can run:

    ./gradlew clean test -DloginName="{defining correct email}" -Dpassword="{defining correct password}"

Replace `./gradlew` with `gradlew.bat` in the above examples if you're on Windows.

[build_status]: https://snap-ci.com/ochubey/matosoft-poc/branch/master/build_image "Build Status"

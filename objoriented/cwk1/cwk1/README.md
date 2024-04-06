# COMP1721 Coursework 1

* [Using Gradle](#using-gradle)
* [Tests & Style Checking](#tests-and-style-checking)
* [Running The Main Application](#running-the-main-application)
* [Advanced Tasks](#advanced-tasks)
* [Cleaning Up](#cleaning-up)
* [Submitting](#submitting)

## Using Gradle

Everything you need to do in this assignment, aside from editing code, is
handled by the Gradle build system.  You can run Gradle from the command
line, or use it from within VS Code or IntelliJ IDE if you prefer (see below).

**You do not need to install Gradle yourself**, as we've included a
'Gradle wrapper' that will download a compatible version of the tool, along
with various library dependencies, if required.  **This will be very slow
the first time that it runs!**

You should run Gradle commands in the `cwk1` directory.  On Linux, macOS or
Windows Subsystem for Linux (WSL2), use `./gradlew`.  On Windows, use
`gradlew`. (The commands below assume the use of Linux, macOS or WSL2.)

**NOTE: if your PC is running anti-virus software, you should add an exclusion
for the `cwk1` directory to avoid potential problems with Gradle.**

### If Using Visual Studio Code

You can simplify the use of Gradle by installing the Gradle Tasks extension.
This will add a Gradle button to the side bar.  Clicking on this will
activate a panel in which you can see and run the Gradle tasks for the
various projects.

### If Using IntelliJ IDEA

**Please use the most recent version of the IntelliJ, on your own PC.
We do not support the use of older versions for the coursework, and may
not be able to help you if you encounter problems.**

Use the *New Project* button to import `cwk1` as the project directory.
After the project has been imported, you should be able to use the Gradle
button on the right-hand edge of the IntelliJ window to activate the Gradle
tool window.  From here you can access a hierarchical list of all the
supported Gradle tasks.  The list entries you will need to use for the
main tasks of the coursework are

    Tasks/verification/test
    Tasks/verification/style
    Tasks/application/run
    Tasks/application/runNoFile

Double-click on a list entry to run it for the first time.  After you've
done this, IntelliJ will create a 'run configuration' for it, allowing you
to rerun it in future in a more convenient way.  You can see the available
run configurations in a drop-down box at the top of the IDE window. Just
select your required configuration, then click on the *Run* button
(the green triangle) to run it.

## Tests and Style Checking

To run all the unit tests, recompiling code where necessary, do

    ./gradlew test

Test names and status (PASSED or FAILED) are listed in the terminal.
A **test report** is also generated in HTML, containing detailed information
about the tests and any failures that have occurred.  You can access this
by pointing your browser at `build/reports/tests/test/index.html`.
We suggest you keep this page open in a browser tab, refreshing it after
each test run, so that you always have full information available on test
results.

Note that Gradle won't normally rerun tests if they have all passed, unless
you've changed something in your code.  You can force it to recompile
everything and rerun the tests using

    ./gradlew test --rerun-tasks

To check coding style for all classes (apart from the tests), do

    ./gradlew style

If there are any style violations, you'll see a count reported in the
terminal window.  A full report on the violations can be viewed by pointing
your browser at `build/reports/checkstyle/main.html`.

**Treat this as a rough guide.** Note that style checking is not exhaustive,
and we may still penalise you on style grounds even if no violations are
reported here.  As with unit tests, Gradle normally won't rerun the style
check unless you change something in your code.

## Running The Main Application

The `TrackInfo` application expects an input filename to be supplied as a
command line argument.  If no filename is supplied, it should print a usage
message, showing the user that a filename is required.

To run the application with `data/walk.csv` as a command line argument,
do this:

    ./gradlew run

The expected behaviour in this case is that information on the GPS track
stored in `data/walk.csv` will be displayed.

You can run the application without a command line argument like this:

    ./gradlew runNoFile

The expected behaviour here is that the program should display a usage
message, telling the user that a filename must be provided on the
command line.

Note: if for some reason you want to run the program on a different
file, you can do this directly, bypassing Gradle, by moving into the
directory containing the |.java| files and using the normal |javac|
and |java| commands.

## Advanced Tasks

There are two optional Advanced tasks, to implement the `ConvertToKML`
application or the `ElevationPlot` application - see the coursework
specification for more details.  You should pick just ONE of these
if you wish to submit something for the Advanced task.

The `ConvertToKML` application should be implemented in the provided
file named `ConvertToKML.java`.  You can run it on file `data/walk.csv`
like this:

    ./gradlew runKML

If the application has been implemented correctly, this Gradle task
should generate its output as a file named `walk.kml`, in the `build`
subdirectory.

If you wish to implement the `ElevationPlot` application instead, you
will first need to edit the file `build.gradle` file and uncomment the
indicated sections of it by removing the `//` at the start of the
relevant lines.  After that, the application code should be written in
the provided file named `PlotApplication.java`.

To run the `ElevationPlot` application, do

    ./gradlew runPlot

Note: if implementing `ElevationPlot`, we strongly recommend using your own
PC and a more recent version of Java than the one available on SoC Linux
machines.

## Cleaning Up

To remove all files generated by the build process, use

    ./gradlew clean

## Submitting

Your coursework solution must be submitted to Minerva as a single Zip
archive, containing all source code but omitting any compiler output or
other build artifacts.  Such a Zip archive can be generated like so:

    ./gradlew submission

If you are using IntelliJ, you will be able to generate the Zip archive
by double-clicking on `Tasks/submission/submission` in the Gradle tool
window.

This will produce a Zip archive named `cwk1.zip`, containing everything that
you need to submit.  **You must then submit this manually to Minerva**, using
the link provided in the *Submit My Work* area.

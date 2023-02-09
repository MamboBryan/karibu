# Karibu

POC of a library that requires a file to build successfully.

## What Am Trying To Achieve
- add the library in the `build.gradle/build.gradle.kts` file
- library checks if in the root directory `details.cpp` file exists
- if it doesn't exist, build fails and throws an error
- if it succeeds it proceeds to change content
- the running app should show the name of the specified in the `details.cpp` for the project module

## Looks

|                                Expected                                 |                               Actual                                |
|:-----------------------------------------------------------------------:|:-------------------------------------------------------------------:|
| <img src="images/expected.png" width="200" hspace="2" alt="expected" /> | <img src="images/actual.png" width="200" hspace="2" alt="actual" /> |

## What To Do 
- [ ] publish library to `jitpack.io`
- [ ] library should check if `details.cpp` file exists on install
- [ ] Build should fail if file doesn't exist 
- [ ] Library replaces the contents of the details.cpp file inside the library with
the contents found in the details.cpp file found in the root directory

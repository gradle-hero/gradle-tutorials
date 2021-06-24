**Shows inputs and outputs working for a custom task. The inputs and outputs are defined outside the task class.**

The `JoinQuote` class defined in *build.gradle* takes as input two files, and produces an output file
containing the joined text from input files.

### Demonstrating UP-TO-DATE checks

1. Run `./gradlew joinQuote` and see that the task is executed (i.e. not *UP-TO-DATE*)
1. Verify that *build/full-quote.txt* has been created
1. Run `./gradlew joinQuote` and see that the task is not executed since it's *UP-TO-DATE*

#### Changing an input
1. Change *quote-part-1.txt* and/or *quote-part-2.txt*
1. Run `./gradlew joinQuote` and see that the task is executed (i.e. not *UP-TO-DATE*)

#### Changing an output
1. Run `./gradlew clean` to delete *build/full-quote.txt*
1. Run `./gradlew joinQuote` and see that the task is executed (i.e. not *UP-TO-DATE*)
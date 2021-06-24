Shows inputs and outputs working for the `Copy` task class.

A `copyFile` task is defined using the `Copy` task class. It copies *message.txt* to the *build* directory.

### Demonstrating UP-TO-DATE checks

1. Run `./gradlew copyFile` and see that the task is executed (i.e. not *UP-TO-DATE*)
1. Verify that *build/message.txt* has been created   
1. Run `./gradlew copyFile` and see that the task is not executed since it's *UP-TO-DATE*
   
#### Changing an input
1. Change *message.txt*
1. Run `./gradlew copyFile` and see that the task is executed (i.e. not *UP-TO-DATE*)

#### Changing an output
1. Run `./gradlew clean` to delete *build/message.txt*
1. Run `./gradlew copyFile` and see that the task is executed (i.e. not *UP-TO-DATE*)
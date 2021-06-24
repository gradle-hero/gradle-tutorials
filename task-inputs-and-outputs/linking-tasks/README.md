**Shows how to link the output of one task to the input of another.**

There are two tasks involved in this project:

1. an *addQuotationMarks* task of type `AddQuotationMarks` takes as input a quote file. It produces an output file
containing the quote surrounded by quotation marks.
1. an *addQuoteSource* task of type `AddQuoteSource` takes as input a quote file and a quote source string. 
It produces an output file containing the quote and the quote source.

### Demonstrating UP-TO-DATE checks

1. Run `./gradlew addQuoteSource` and see that both tasks are executed (i.e. not *UP-TO-DATE*)
1. Verify that *build/quote-with-source.txt* has been created
1. Run `./gradlew addQuoteSource` and see that neither tasks is executed since they're *UP-TO-DATE*

Note that *addQuotationMarks* is also executed since by linking the tasks Gradle automatically adds a task dependency.

#### Changing an input
1. Change *quote.txt*
1. Run `./gradlew addQuoteSource` and see that both tasks are executed (i.e. not *UP-TO-DATE*)

#### Changing an output
1. Run `./gradlew clean` to delete all task outputs
1. Run `./gradlew addQuoteSource` and see that both tasks are executed (i.e. not *UP-TO-DATE*)
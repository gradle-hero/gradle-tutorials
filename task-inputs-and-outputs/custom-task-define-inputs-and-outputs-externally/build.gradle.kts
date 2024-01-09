plugins {
    base
}

abstract class JoinQuote : DefaultTask() {
    @get:InputFile
    abstract val firstInputFile: RegularFileProperty
    @get:InputFile
    abstract val secondInputFile: RegularFileProperty
    @get:OutputFile
    abstract val outputFile: RegularFileProperty
    @TaskAction
    fun join() {
        outputFile.get().asFile.writeText(
            firstInputFile.get().asFile.readText() + secondInputFile.get().asFile.readText()
        )
    }
}

tasks.register<JoinQuote>("joinQuote") {
    firstInputFile.set(layout.projectDirectory.file("quote-part-1.txt"))
    secondInputFile.set(layout.projectDirectory.file("quote-part-2.txt"))
    outputFile.set(layout.buildDirectory.file("full-quote.txt"))
}
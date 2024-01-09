plugins {
    base
}

abstract class JoinQuote : DefaultTask() {
    @get:InputFile
    abstract val firstInputFile : RegularFileProperty
    @get:InputFile
    abstract val secondInputFile : RegularFileProperty
    @get:OutputFile
    abstract val outputFile : RegularFileProperty
    init {
        firstInputFile.convention(project.layout.projectDirectory.file("quote-part-1.txt"))
        secondInputFile.convention(project.layout.projectDirectory.file("quote-part-2.txt"))
        outputFile.convention(project.layout.buildDirectory.file("full-quote.txt"))
    }
    @TaskAction
    fun join() {
        outputFile.get().asFile.writeText(
            firstInputFile.get().asFile.readText() + secondInputFile.get().asFile.readText()
        )
    }
}

tasks.register<JoinQuote>("joinQuote")
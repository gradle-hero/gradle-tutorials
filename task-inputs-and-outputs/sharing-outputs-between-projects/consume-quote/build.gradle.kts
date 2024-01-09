plugins {
    base
}

val quote by configurations.creating
dependencies {
    quote(project(mapOf("path" to ":produce-quote", "configuration" to "quote")))
}

abstract class AddQuoteSource : DefaultTask() {
    @get:Input
    abstract val source: Property<String>
    @get:InputFiles
    abstract val inputFiles : ConfigurableFileCollection
    @get:OutputFile
    abstract val outputFile: RegularFileProperty
    init {
        outputFile.convention(project.layout.buildDirectory.file("quote-with-source.txt"))
    }
    @TaskAction
    fun join() {
        outputFile.get().asFile.writeText("${inputFiles.singleFile.readText()}\n\n${source.get()}")
    }
}

tasks.register<AddQuoteSource>("addQuoteSource") {
    source = "Dr. No (1963)"
    inputFiles.from(quote)
}
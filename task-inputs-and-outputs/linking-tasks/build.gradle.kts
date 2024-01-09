plugins {
    base
}

abstract class AddQuotationMarks : DefaultTask() {
    @get:InputFile
    abstract val inputFile: RegularFileProperty
    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    init {
        inputFile.convention(project.layout.projectDirectory.file("quote.txt"))
        outputFile.convention(project.layout.buildDirectory.file("quote-with-quotation-marks.txt"))
    }

    @TaskAction
    fun join() {
        outputFile.get().asFile.writeText("\"${inputFile.get().asFile.readText(Charsets.UTF_8)}\"")
    }
}

val addQuotationMarks by tasks.registering(AddQuotationMarks::class)

abstract class AddQuoteSource : DefaultTask() {
    @get:Input
    abstract val source: Property<String>
    @get:InputFile
    abstract val inputFile: RegularFileProperty
    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    init {
        outputFile.convention(project.layout.buildDirectory.file("quote-with-source.txt"))
    }

    @TaskAction
    fun join() {
        outputFile.get().asFile.writeText("${inputFile.get().asFile.readText(Charsets.UTF_8)}\n\n${source.get()}")
    }
}

tasks.register<AddQuoteSource>("addQuoteSource") {
    source = "Dr. No (1963)"
    inputFile = addQuotationMarks.get().outputFile
}
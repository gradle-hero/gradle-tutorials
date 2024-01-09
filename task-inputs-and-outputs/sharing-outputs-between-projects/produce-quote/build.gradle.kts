plugins {
    base
}

configurations {
    create("quote")
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

artifacts {
    add("quote", addQuotationMarks)
}
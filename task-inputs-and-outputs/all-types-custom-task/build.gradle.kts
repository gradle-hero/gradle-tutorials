plugins {
    base
}

abstract class AllTypes : DefaultTask() {
    //inputs
    @get:Input
    abstract val inputString: Property<String>
    @get:InputFile
    abstract val inputFile: RegularFileProperty
    @get:InputDirectory
    abstract val inputDirectory: DirectoryProperty
    @get:InputFiles
    abstract val inputFileCollection: ListProperty<RegularFile>
    @get:Classpath
    abstract val inputClasspath: ListProperty<RegularFile>

    // outputs
    @get:OutputFile
    abstract val outputFile: RegularFileProperty
    @get:OutputDirectory
    abstract val outputDirectory: DirectoryProperty
    @get:OutputFiles
    abstract val outputFiles: ListProperty<RegularFile>
    @get:OutputDirectories
    abstract val outputDirectories: ListProperty<Directory>

    init {
        inputString.convention("default value")
        inputFile.convention(project.layout.projectDirectory.file("default-file.txt"))
        inputDirectory.convention(project.layout.projectDirectory.dir("default-dir"))
        inputFileCollection.convention(
            listOf(
                project.layout.projectDirectory.file("default-file-1.txt"),
                project.layout.projectDirectory.file("default-file-2.txt")
            )
        )
        inputClasspath.convention(listOf(project.layout.projectDirectory.file("MyClass.class")))

        outputFile.convention(project.layout.buildDirectory.file("default-file.txt"))
        outputDirectory.convention(project.layout.projectDirectory.dir("default-dir"))
        outputFiles.set(
            listOf(
                project.layout.buildDirectory.file("default-file-1.txt").get(),
                project.layout.buildDirectory.file("default-file-2.txt").get()
            )
        )
        outputDirectories.set(
            listOf(
                project.layout.projectDirectory.dir("default-dir-1"),
                project.layout.projectDirectory.dir("default-dir-2")
            )
        )
    }
}

tasks.register<AllTypes>("allTypes")
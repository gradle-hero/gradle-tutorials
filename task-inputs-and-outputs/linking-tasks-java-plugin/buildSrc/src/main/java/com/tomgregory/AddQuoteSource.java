package com.tomgregory;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AddQuoteSource extends DefaultTask {
    @Input
    public abstract Property<String> getSource();

    @InputFile
    abstract RegularFileProperty getInputFile();

    @OutputFile
    abstract RegularFileProperty getOutputFile();

    public AddQuoteSource() {
        getOutputFile().convention(getProject().getLayout().getBuildDirectory().file("quote-with-source.txt"));
    }

    @TaskAction
    void join() throws IOException {
        String inputFileContents = Files.readString(getInputFile().get().getAsFile().toPath());

        try (FileWriter fileWriter = new FileWriter(getOutputFile().get().getAsFile())) {
            fileWriter.write(inputFileContents);
            fileWriter.write("\n\n");
            fileWriter.write(getSource().get());
        }
    }
}
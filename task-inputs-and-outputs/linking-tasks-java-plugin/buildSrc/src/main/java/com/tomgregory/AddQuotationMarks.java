package com.tomgregory;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

abstract class AddQuotationMarks extends DefaultTask {
    @InputFile
    abstract RegularFileProperty getInputFile();

    @OutputFile
    abstract RegularFileProperty getOutputFile();

    public AddQuotationMarks() {
        getInputFile().convention(getProject().getLayout().getProjectDirectory().file("quote.txt"));
        getOutputFile().convention(getProject().getLayout().getProjectDirectory().file("quote-with-quotation-marks.txt"));
    }

    @TaskAction
    void join() throws IOException {
        String inputFileContents = Files.readString(getInputFile().get().getAsFile().toPath());

        try (FileWriter fileWriter = new FileWriter(getOutputFile().get().getAsFile())) {
            fileWriter.write(inputFileContents);
        }
    }
}
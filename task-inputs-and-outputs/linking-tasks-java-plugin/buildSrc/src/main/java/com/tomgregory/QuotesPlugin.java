package com.tomgregory;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskProvider;

class QuotesPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        TaskProvider<AddQuotationMarks> addQuotationMarks = project.getTasks().register("addQuotationMarks", AddQuotationMarks.class);
        TaskProvider<AddQuoteSource> addQuoteSource = project.getTasks().register("addQuoteSource", AddQuoteSource.class);

        addQuoteSource.configure(it -> it.getInputFile().set(addQuotationMarks.get().getOutputFile()));
    }
}
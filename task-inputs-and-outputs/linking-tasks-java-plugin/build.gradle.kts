import com.tomgregory.AddQuoteSource

plugins {
    base
    id("com.tomgregory.quotes")
}

tasks.named<AddQuoteSource>("addQuoteSource") {
    source.set("Dr. No (1963)")
}
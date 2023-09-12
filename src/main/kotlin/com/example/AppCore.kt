package com.example

import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class AppCore(val kafkaClientWrapper: KafkaClientWrapper) {

    companion object {
        private val LOG = LoggerFactory.getLogger(AppCore::class.java)
    }

    fun process(listener : String, event: String) {
        LOG.info("Processing event: {}/{}", listener, event)
        if (event == "HELLO") {
            kafkaClientWrapper.produce("WORLD")
        }
    }
}

package com.example

import jakarta.annotation.PostConstruct
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class KafkaClientWrapper(val kafkaClient: MyKafkaClient) {

    companion object {
        private val LOG = LoggerFactory.getLogger(KafkaClientWrapper::class.java)
    }

    fun produce(foo : String) {
        LOG.info("Sending '{}'", foo)
        kafkaClient.sendFoo(foo)
        LOG.info("Sent '{}'", foo)
    }

    @PostConstruct
    fun postConstruct() {
        produce("HELLO")
    }
}

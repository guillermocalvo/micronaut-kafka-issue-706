package com.example

import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.LoggerFactory

@KafkaListener(clientId = "b", offsetReset = OffsetReset.EARLIEST, uniqueGroupId = true)
class ListenerB(val appCore: AppCore) {

    companion object {
        private val LOG = LoggerFactory.getLogger(ListenerB::class.java)
    }

    @Topic("foo")
    fun receive(event: String) {
        LOG.info("Received foo: {}", event)
        appCore.process("B", event)
    }
}

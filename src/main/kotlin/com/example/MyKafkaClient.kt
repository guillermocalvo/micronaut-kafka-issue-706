package com.example

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient(id = "client")
interface MyKafkaClient {

    @Topic("foo")
    fun sendFoo(event: String)
}

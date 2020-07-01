package com.cxl.demo.utils

import org.springframework.data.redis.core.RedisTemplate
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title("test RedisUtilsTest")
@Subject(RedisUtilsTest)
class RedisUtilsTest extends Specification {

    def redisTemplate = Stub(RedisTemplate.class)
    def redisUtileTest = new RedisUtils(redisTemplate)

    def "test get value"() {
        when:
        redisUtileTest.setValue("test","test")
        then:
        redisTemplate.opsForValue().get("test") >> "test"
    }
}

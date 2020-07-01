package com.cxl.demo.service


import com.cxl.demo.mapper.DemoMapper
import com.cxl.demo.service.impl.DemoServiceImpl
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll;

/**
 * @author Chenxiaoling
 * @date 2020/6/20 7:33 下午
 */

@SpringBootTest(classes =[DemoServiceTest.class])
class DemoServiceTest extends Specification{
    def datMapper = Mock(DemoMapper.class)
    def codeService = new DemoServiceImpl(datMapper)

    @Unroll
    def "getList test : return list"() {
        when:
        codeService.getList()
        then:
        noExceptionThrown()
    }

}

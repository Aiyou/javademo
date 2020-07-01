package com.cxl.demo.controller

import com.cxl.demo.filter.DemoFilter
import com.cxl.demo.interceptor.PermissionInterceptor
import com.cxl.demo.service.DemoService
import com.cxl.demo.utils.Consts
import com.cxl.demo.utils.RedisUtils;
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Chenxiaoling
 * @date 2020/6/20 7:32 下午
 */
@SpringBootTest(classes =[DemoControllerTest.class])
class DemoControllerTest extends Specification {
    def codeService = Stub(DemoService.class)
    def redisUtils = Stub(RedisUtils.class)
    def underTest = new DemoController(codeService)
    def filter = new DemoFilter()
    def interceptor = new PermissionInterceptor(redisUtils)
    def mocMvc = MockMvcBuilders.standaloneSetup(underTest).addFilters(filter).addInterceptors(interceptor).build()
    def token = "eyJhbGciOiJIUzI1NiIsInR5cGUiOiJKV1QifQ==.eyJhcHBsaWNhdGlvbklkIjoiMTIzNDU2IiwiZXhwIjoiMTU5Mjg5Njg1OSIsInNlcnZpY2VMb2NhdGlvbiI6IjEiLCJ1c2VyVXVpZCI6Ijk3ZmY2OGQ4LTlkNmMtMTFlOS1hYTFlLTBhNTgwYWU5NDk3ZiJ9.hX3Ed+8K7lb9Cc2fiKVd1Is6L8b/TaUlMPAltlqb6/0=";

    @Unroll
    def "the getdevicelist interface test，returns status OK"() {

        when:
        def res = mocMvc.perform(
                get("/demo/v1/getList").header(Consts.AUTHORIZATION, token).param("lang","cn")
        )
        then:
        res.andExpect(status().isOk())
    }
}

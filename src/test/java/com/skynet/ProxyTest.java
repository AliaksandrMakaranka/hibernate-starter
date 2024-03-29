package com.skynet;

import com.skynet.entity.Company;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    void testDynamic() {
        Company company = new Company();
        Proxy.newProxyInstance(company.getClass().getClassLoader(), company.getClass().getInterfaces(),
                (o, method, objects) -> method.invoke(company, objects));
    }
}

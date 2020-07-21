package com.timewentby.proxy;

import org.junit.Test;


public class NetworkProxyTest {

    @Test
    public void proxyTest() {
        Computer computer = new Computer();
        NetworkProxy networkProxy = new NetworkProxy(computer);
        networkProxy.online();
    }
}
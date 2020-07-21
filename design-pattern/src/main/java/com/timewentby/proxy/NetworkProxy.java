package com.timewentby.proxy;

public class NetworkProxy implements Network {


    private Network network;

    public NetworkProxy(Network network) {
        this.network = network;
    }


    @Override
    public void online() {
        System.out.println("网络代理类NetworkProxy开始代理上网...");
        network.online();
    }
}

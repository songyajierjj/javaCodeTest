package com.designpattern.jiegoumoshi.bridge;

public class BridgeTest {

    public static void main(String[] args) {
        Bridge bridge = new MyBridge();
        Sourceable sourceable1 = new SourceSub1();
        bridge.setSource(sourceable1);
        bridge.method();

        Sourceable sourceable2 = new SourceSub2();
        bridge.setSource(sourceable2);
        bridge.method();
    }
}

package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.node.CachedNode;

public class Class40_Sub5_Sub11 extends CachedNode {
    public static int anInt2621 = 0;
    public static volatile int eventClickY = 0;
    public static int anInt2628 = 0;
    public static volatile boolean clearScreen = true;

    public int anInt2633 = 0;

    public static void method631(Actor arg0) {
        int i = arg0.anInt3125 * 128 + 64 * arg0.anInt3096;
        int i_0_ = arg0.anInt3112 + -MovedStatics.pulseCycle;
        if(arg0.anInt3073 == 0) {
            arg0.initialFaceDirection = 1024;
        }
        if(arg0.anInt3073 == 1) {
            arg0.initialFaceDirection = 1536;
        }
        if(arg0.anInt3073 == 2) {
            arg0.initialFaceDirection = 0;
        }
        int i_1_ = arg0.anInt3096 * 64 + 128 * arg0.anInt3081;
        arg0.worldX += (i - arg0.worldX) / i_0_;
        if(arg0.anInt3073 == 3) {
            arg0.initialFaceDirection = 512;
        }
        arg0.anInt3074 = 0;
        arg0.worldY += (-arg0.worldY + i_1_) / i_0_;
    }

    public void method634(Buffer arg0) {
        while(true) {
            int i = arg0.getUnsignedByte();
            if(i == 0) {
                break;
            }
            method635(i, 512, arg0);
        }
    }

    public void method635(int arg0, int arg1, Buffer arg2) {
        if(arg1 != 512) {
            method631(null);
        }
        if(arg0 == 5) {
            anInt2633 = arg2.getUnsignedShortBE();
        }
    }
}

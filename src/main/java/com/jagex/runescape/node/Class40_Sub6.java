package com.jagex.runescape.node;

import com.jagex.runescape.MovedStatics;
import com.jagex.runescape.RSCanvas;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.CacheIndex;

public class Class40_Sub6 extends Node {

    public byte[] aByteArray2102;
    public CacheArchive cacheArchive;
    public int anInt2112;
    public CacheIndex cacheIndex;

    public static void method1055(byte[] arg0, CacheIndex cacheIndex, int cacheIndexId) {
        Class40_Sub6 class40_sub6 = new Class40_Sub6();
        class40_sub6.key = cacheIndexId;
        class40_sub6.aByteArray2102 = arg0;
        class40_sub6.anInt2112 = 0;
        class40_sub6.cacheIndex = cacheIndex;
        synchronized(RSCanvas.aLinkedList_53) {
            RSCanvas.aLinkedList_53.pushBack(class40_sub6);
        }
        MovedStatics.method332(600);
    }
}

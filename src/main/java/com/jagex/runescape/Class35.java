package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;

import java.awt.*;

public class Class35 implements Interface3 {
    public static int anInt1728 = 0;
    public static int anInt1730 = 0;
    public static Frame gameFrame;
    public static int songTimeout = 0;
    public static boolean aBoolean1734 = false;
    public static boolean aBoolean1735 = true;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1744;
    public static byte[][][] tile_overlay_rotation;

    public LinkedList aLinkedList_1727 = new LinkedList();
    public EntryTable[] aClass40_Sub10Array1740;
    public int anInt1748;
    public CacheArchive aCacheArchive_1749;
    public double aDouble1750 = 1.0;
    public int anInt1752;
    public int anInt1753;

    public Class35(CacheArchive arg0, CacheArchive arg1, int arg2, double arg3, int arg4) {
        anInt1748 = 128;
        anInt1753 = 0;
        anInt1752 = arg2;
        aCacheArchive_1749 = arg1;
        aDouble1750 = arg3;
        anInt1748 = arg4;
        anInt1753 = anInt1752;
        int[] is = arg0.method192(0, true);
        int i = is.length;
        aClass40_Sub10Array1740 = new EntryTable[arg0.fileLength(0)];
        for(int i_4_ = 0; i > i_4_; i_4_++) {
            Buffer class40_sub1 = new Buffer(arg0.getFile(is[i_4_], 0));
            aClass40_Sub10Array1740[is[i_4_]] = new EntryTable(class40_sub1);
        }

    }

    public static Class40_Sub5_Sub15 method421(
            CacheArchive arg0, byte arg1, int arg2, CacheArchive arg3, boolean arg4
    ) {
        if(arg1 < 40) {
            return null;
        }
        boolean bool = true;
        int[] is = arg0.method192(arg2, true);
        for(int i = 0; is.length > i; i++) {
            byte[] is_0_ = arg0.method182(is[i], arg2);
            if(is_0_ == null) {
                bool = false;
            } else {
                int i_1_ = 0xff & is_0_[1] | (0xff & is_0_[0]) << 8;
                byte[] is_2_;
                if(arg4) {
                    is_2_ = arg3.method182(i_1_, 0);
                } else {
                    is_2_ = arg3.method182(0, i_1_);
                }
                if(is_2_ == null) {
                    bool = false;
                }
            }
        }
        if(!bool) {
            return null;
        }
        try {
            return new Class40_Sub5_Sub15(arg0, arg3, arg2, arg4);
        } catch(Exception exception) {
            return null;
        }
    }


    public void method422(int arg0) {
        for(int i = arg0; aClass40_Sub10Array1740.length > i; i++) {
            if(aClass40_Sub10Array1740[i] != null) {
                aClass40_Sub10Array1740[i].method870();
            }
        }
        aLinkedList_1727 = new LinkedList();
        anInt1753 = anInt1752;
    }

    public int[] getTexturePixels(int arg0, int arg1) {
        EntryTable class40_sub10 = aClass40_Sub10Array1740[arg1];
        if(class40_sub10 != null) {
            if(class40_sub10.anIntArray2139 != null) {
                aLinkedList_1727.removeNode(class40_sub10);
                class40_sub10.aBoolean2146 = true;
                return class40_sub10.anIntArray2139;
            }
            boolean bool = class40_sub10.method869(aDouble1750, anInt1748, aCacheArchive_1749);
            if(bool) {
                if(anInt1753 == 0) {
                    EntryTable class40_sub10_3_ = (EntryTable) aLinkedList_1727.method899();
                    class40_sub10_3_.method870();
                } else {
                    anInt1753--;
                }
                aLinkedList_1727.removeNode(class40_sub10);
                class40_sub10.aBoolean2146 = true;
                return class40_sub10.anIntArray2139;
            }
        }
        return null;
    }

    public int method14(boolean arg0, int arg1) {
        if(!arg0) {
            return 115;
        }
        if(aClass40_Sub10Array1740[arg1] != null) {
            return aClass40_Sub10Array1740[arg1].anInt2137;
        }
        return 0;
    }

    public boolean method13(byte arg0, int arg1) {
        if(arg0 > -99) {
            return true;
        }
        return aClass40_Sub10Array1740[arg1].aBoolean2143;
    }

    public void method424(double arg1) {
        aDouble1750 = arg1;
        method422(0);
    }

    public void method425(byte arg0, int arg1) {
        int i = 0;
        if(arg0 == 6) {
            for(/**/; i < aClass40_Sub10Array1740.length; i++) {
                EntryTable class40_sub10 = aClass40_Sub10Array1740[i];
                if(class40_sub10 != null && class40_sub10.anInt2136 != 0 && class40_sub10.aBoolean2146) {
                    class40_sub10.method868(arg1);
                    class40_sub10.aBoolean2146 = false;
                }
            }
        }
    }

    public boolean method15(int arg0, byte arg1) {
        if(arg1 != -90) {
            return false;
        }
        return anInt1748 == 64;
    }
}

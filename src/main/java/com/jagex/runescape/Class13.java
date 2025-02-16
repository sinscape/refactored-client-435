package com.jagex.runescape;

import com.jagex.runescape.node.Class40_Sub6;
import com.jagex.runescape.node.NodeCache;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.Wall;

public class Class13 {
    public static NodeCache aClass9_406 = new NodeCache(64);
    public static boolean[] playerArray = new boolean[5];
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_418;
    public static int anInt419 = 2;
    public static int mouseX = 0;
    public static int[] anIntArray421;

    public static void method241(Actor arg0, byte arg2) {
        if(arg0.worldX < 128 || arg0.worldY < 128 || arg0.worldX >= 13184 || arg0.worldY >= 13184) {
            arg0.playingAnimation = -1;
            arg0.anInt3112 = 0;
            arg0.anInt3107 = 0;
            arg0.graphicId = -1;
            arg0.worldX = arg0.anInt3096 * 64 + 128 * arg0.pathY[0];
            arg0.worldY = arg0.pathX[0] * 128 + 64 * arg0.anInt3096;
            arg0.method790(0);
        }
        if(arg0 == Player.localPlayer && (arg0.worldX < 1536 || arg0.worldY < 1536 || arg0.worldX >= 11776 || arg0.worldY >= 11776)) {
            arg0.graphicId = -1;
            arg0.anInt3107 = 0;
            arg0.anInt3112 = 0;
            arg0.playingAnimation = -1;
            arg0.worldX = arg0.pathY[0] * 128 + arg0.anInt3096 * 64;
            arg0.worldY = 64 * arg0.anInt3096 + arg0.pathX[0] * 128;
            arg0.method790(0);
        }
        if(arg0.anInt3112 > MovedStatics.pulseCycle)
            Class40_Sub5_Sub11.method631(arg0);
        else if(arg0.anInt3107 < MovedStatics.pulseCycle)
            Class44.method898(255, arg0);
        else
            PlayerAppearance.method381(arg0);
        Class40_Sub5_Sub17_Sub1.method762(arg0);
        Class40_Sub5_Sub15.method736(true, arg0);
        if(arg2 != 107)
            method249(false);
    }

    public static void method242(byte arg0) {
        if(arg0 > -88)
            method247(null, (byte) 34);
        for(; ; ) {
            Class40_Sub6 class40_sub6;
            synchronized(RSCanvas.aLinkedList_53) {
                class40_sub6 = (Class40_Sub6) IdentityKit.aLinkedList_2604.method913(25447);
            }
            if(class40_sub6 == null)
                break;
            class40_sub6.cacheArchive.method198(false, class40_sub6.aByteArray2102, (int) class40_sub6.key, class40_sub6.cacheIndex);
        }
    }

    public static void handleInterfaceActions(int areaId, int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, int widgetId) {
        if(GameInterface.decodeGameInterface(widgetId)) {
            Class48.handleInterfaceActions(areaId, mouseX, mouseY, minX, minY, maxX, maxY, GameInterface.cachedInterfaces[widgetId], -1, 0, 0);
        }
    }

    public static int method244(int arg0, int arg1, int arg3) {
        if(arg1 > 179)
            arg0 /= 2;
        if(arg1 > 192)
            arg0 /= 2;
        if(arg1 > 217)
            arg0 /= 2;
        if(arg1 > 243)
            arg0 /= 2;
        return arg1 / 2 + (arg0 / 32 << 7) + (arg3 / 4 << 10);
    }

    public static synchronized byte[] method246(int arg1) {
        if(arg1 == 100 && Wall.anInt356 > 0) {
            byte[] is = GroundItemTile.aByteArrayArray1377[--Wall.anInt356];
            GroundItemTile.aByteArrayArray1377[Wall.anInt356] = null;
            return is;
        }
        if(arg1 == 5000 && Main.anInt1764 > 0) {
            byte[] is = Class44.aByteArrayArray1039[--Main.anInt1764];
            Class44.aByteArrayArray1039[Main.anInt1764] = null;
            return is;
        }
        if(arg1 == 30000 && VarbitDefinition.anInt2359 > 0) {
            byte[] is = RSCanvas.aByteArrayArray47[--VarbitDefinition.anInt2359];
            RSCanvas.aByteArrayArray47[VarbitDefinition.anInt2359] = null;
            return is;
        }
        return new byte[arg1];
    }

    public static int[] method247(GameInterface arg0, byte arg1) {
        if(arg1 <= 74)
            anInt419 = -37;
        int i;
        if(arg0.id < 0)
            i = arg0.parentId >> 16;
        else
            i = arg0.id >> 16;
        if(!GameInterface.decodeGameInterface(i))
            return null;
        int i_11_ = arg0.currentX;
        int i_12_ = arg0.currentY;
        int i_13_ = arg0.parentId;
        while(i_13_ != -1) {
            GameInterface gameInterface = GameInterface.cachedInterfaces[i][i_13_ & 0xffff];
            i_11_ += gameInterface.currentX;
            if(!arg0.lockScroll)
                i_11_ -= gameInterface.scrollWidth;
            i_12_ += gameInterface.currentY;
            i_13_ = gameInterface.parentId;
            if(!arg0.lockScroll)
                i_12_ -= gameInterface.scrollPosition;
        }
        int[] is = new int[2];
        is[0] = i_11_;
        is[1] = i_12_;
        return is;
    }

    public static void method249(boolean arg0) {
        if(!arg0)
            method244(-58, 116, 98);
        if(GameObject.frame != null) {
            synchronized(GameObject.frame) {
                GameObject.frame = null;
            }
        }
    }
}

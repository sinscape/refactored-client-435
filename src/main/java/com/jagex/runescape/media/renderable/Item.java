package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;

public class Item extends Renderable {
    public static boolean[] obfuscatedKeyStatus = new boolean[112];
    public static int anInt3065 = -1;

    public int itemCount;
    public int itemId;

    public static void calculateCameraPosition() {
        int sceneX = Buffer.cameraOffsetX + Player.localPlayer.worldX;
        int sceneY = Player.localPlayer.worldY + Class48.cameraOffsetY;
        if(Class40_Sub5_Sub6.currentCameraPositionH - sceneX < -500 ||
                -sceneX + Class40_Sub5_Sub6.currentCameraPositionH > 500 ||
                MovedStatics.currentCameraPositionV + -sceneY < -500 ||
                -sceneY + MovedStatics.currentCameraPositionV > 500) {
            MovedStatics.currentCameraPositionV = sceneY;
            Class40_Sub5_Sub6.currentCameraPositionH = sceneX;
        }
        if(Class40_Sub5_Sub6.currentCameraPositionH != sceneX) {
            Class40_Sub5_Sub6.currentCameraPositionH += (-Class40_Sub5_Sub6.currentCameraPositionH + sceneX) / 16;
        }
        if(MovedStatics.currentCameraPositionV != sceneY) {
            MovedStatics.currentCameraPositionV += (-MovedStatics.currentCameraPositionV + sceneY) / 16;
        }

        if(obfuscatedKeyStatus[96] && !Console.console.consoleOpen) {
            Wall.cameraVelocityHorizontal += (-24 - Wall.cameraVelocityHorizontal) / 2;
        } else if(obfuscatedKeyStatus[97] && !Console.console.consoleOpen) {
            Wall.cameraVelocityHorizontal += (24 - Wall.cameraVelocityHorizontal) / 2;
        } else {
            Wall.cameraVelocityHorizontal /= 2;
        }
        if(obfuscatedKeyStatus[98] && !Console.console.consoleOpen) {
            Class60.cameraVelocityVertical += (12 + -Class60.cameraVelocityVertical) / 2;
        } else if(obfuscatedKeyStatus[99] && !Console.console.consoleOpen) {
            Class60.cameraVelocityVertical += (-12 - Class60.cameraVelocityVertical) / 2;
        } else {
            Class60.cameraVelocityVertical /= 2;
        }
        int i_1_ = MovedStatics.currentCameraPositionV >> 7;
        GroundItemTile.cameraHorizontal = Wall.cameraVelocityHorizontal / 2 + GroundItemTile.cameraHorizontal & 0x7ff;
        int i_2_ = Class40_Sub5_Sub6.currentCameraPositionH >> 7;
        Class65.cameraVertical += Class60.cameraVelocityVertical / 2;
        int i_3_ = 0;
        if(Class65.cameraVertical < 128) {
            Class65.cameraVertical = 128;
        }
        if(Class65.cameraVertical > 383) {
            Class65.cameraVertical = 383;
        }
        int i_4_ = Class37.getFloorDrawHeight(Player.worldLevel, Class40_Sub5_Sub6.currentCameraPositionH,
                MovedStatics.currentCameraPositionV
        );
        if(i_2_ > 3 && i_1_ > 3 && i_2_ < 100 && i_1_ < 100) {
            for(int i_5_ = -4 + i_2_; i_5_ <= 4 + i_2_; i_5_++) {
                for(int i_6_ = -4 + i_1_; 4 + i_1_ >= i_6_; i_6_++) {
                    int i_7_ = Player.worldLevel;
                    if(i_7_ < 3 && (0x2 & OverlayDefinition.tile_flags[1][i_5_][i_6_]) == 2) {
                        i_7_++;
                    }
                    int i_8_ = i_4_ + -MovedStatics.tile_height[i_7_][i_5_][i_6_];
                    if(i_8_ > i_3_) {
                        i_3_ = i_8_;
                    }
                }
            }
        }
        int i_9_ = i_3_ * 192;
        if(i_9_ > 98048) {
            i_9_ = 98048;
        }
        if(i_9_ < 32768) {
            i_9_ = 32768;
        }
        if(MovedStatics.secondaryCameraVertical < i_9_) {
            MovedStatics.secondaryCameraVertical += (-MovedStatics.secondaryCameraVertical + i_9_) / 24;
        } else if(MovedStatics.secondaryCameraVertical > i_9_) {
            MovedStatics.secondaryCameraVertical += (-MovedStatics.secondaryCameraVertical + i_9_) / 80;
        }
    }

    public static void method778(HuffmanEncoding arg1) {
        IdentityKit.aHuffmanEncoding_2590 = arg1;
    }

    public static void method779(Component arg0, boolean arg1, CacheArchive arg2, CacheArchive arg3) {
        if(!ISAAC.aBoolean512) {
            Class8.flameLeftBackground = Class40_Sub5_Sub13.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            GameObject.flameRightBackground = Class40_Sub5_Sub13.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            Class39.aProducingGraphicsBuffer_907 = Class40_Sub5_Sub13.createGraphicsBuffer(509, 171, arg0);
            Rasterizer.resetPixels();
            Class51.aProducingGraphicsBuffer_1206 = Class40_Sub5_Sub13.createGraphicsBuffer(360, 132, arg0);
            Rasterizer.resetPixels();
            MovedStatics.loginBoxGraphics = Class40_Sub5_Sub13.createGraphicsBuffer(360, 200, arg0);
            Rasterizer.resetPixels();
            Class17.aProducingGraphicsBuffer_463 = Class40_Sub5_Sub13.createGraphicsBuffer(202, 238, arg0);
            Rasterizer.resetPixels();
            KeyFocusListener.aProducingGraphicsBuffer_1285 = Class40_Sub5_Sub13.createGraphicsBuffer(203, 238, arg0);
            Rasterizer.resetPixels();
            GameObjectDefinition.aProducingGraphicsBuffer_2524 = Class40_Sub5_Sub13.createGraphicsBuffer(74, 94, arg0);
            Rasterizer.resetPixels();
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631 = Class40_Sub5_Sub13.createGraphicsBuffer(
                    75, 94, arg0);
            Rasterizer.resetPixels();
            byte[] is = arg2.method170("", Native.titleImage);
            ImageRGB class40_sub5_sub14_sub4 = new ImageRGB(is, arg0);
            Class8.flameLeftBackground.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(0, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-637, 0);
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-128, 0);
            Class51.aProducingGraphicsBuffer_1206.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-202, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-202, -171);
            Class17.aProducingGraphicsBuffer_463.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(0, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-562, -265);
            GameObjectDefinition.aProducingGraphicsBuffer_2524.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-128, -171);
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-562, -171);
            int[] is_18_ = new int[class40_sub5_sub14_sub4.imageWidth];
            for(int i = 0; i < class40_sub5_sub14_sub4.imageHeight; i++) {
                for(int i_19_ = 0; i_19_ < class40_sub5_sub14_sub4.imageWidth; i_19_++) {
                    is_18_[i_19_] = class40_sub5_sub14_sub4.pixels[
                            i * class40_sub5_sub14_sub4.imageWidth + class40_sub5_sub14_sub4.imageWidth + -i_19_ - 1];
                }
                for(int i_20_ = 0; i_20_ < class40_sub5_sub14_sub4.imageWidth; i_20_++) {
                    class40_sub5_sub14_sub4.pixels[i_20_ + class40_sub5_sub14_sub4.imageWidth * i] = is_18_[i_20_];
                }
            }
            Class8.flameLeftBackground.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(382, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-255, 0);
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(254, 0);
            Class51.aProducingGraphicsBuffer_1206.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(180, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(180, -171);
            Class17.aProducingGraphicsBuffer_463.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(382, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-180, -265);
            GameObjectDefinition.aProducingGraphicsBuffer_2524.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(254, -171);
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.prepareRasterizer();
            class40_sub5_sub14_sub4.drawInverse(-180, -171);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg3, Native.logo, "");
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            class40_sub5_sub14_sub4.drawImage(-128 + 382 + -(class40_sub5_sub14_sub4.imageWidth / 2), 18);
            Class40_Sub5_Sub15.loginScreenBox = Main.method359(Native.titleBox, "", arg3);
            Class59.imgLoginScreenButton = Main.method359(Native.titleButton, "", arg3);
            Class22.aClass40_Sub5_Sub14_Sub2Array535 = IndexedImage.getMultipleIndexedImages(arg3, Native.runes, "");
            Class39.aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for(int i = 0; i < 33920; i++) {
                Class39.aClass40_Sub5_Sub14_Sub4_918.pixels[i] = Class8.flameLeftBackground.pixels[i];
            }
            for(int i = 0; i < 33920; i++) {
                SceneTile.aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = GameObject.flameRightBackground.pixels[i];
            }
            Class51.anIntArray1198 = new int[256];
            for(int i = 0; i < 64; i++) {
                Class51.anIntArray1198[i] = i * 262144;
            }
            for(int i = 0; i < 64; i++) {
                Class51.anIntArray1198[64 + i] = 1024 * i + 16711680;
            }
            for(int i = 0; i < 64; i++) {
                Class51.anIntArray1198[128 + i] = 16776960 + i * 4;
            }
            for(int i = 0; i < 64; i++) {
                Class51.anIntArray1198[i + 192] = 16777215;
            }
            Renderable.anIntArray2865 = new int[256];
            for(int i = 0; i < 64; i++) {
                Renderable.anIntArray2865[i] = i * 1024;
            }
            for(int i = 0; i < 64; i++) {
                Renderable.anIntArray2865[i + 64] = 4 * i + 65280;
            }
            for(int i = 0; i < 64; i++) {
                Renderable.anIntArray2865[128 + i] = i * 262144 + 65535;
            }
            if(!arg1) {
                method779(null, false, null, null);
            }
            for(int i = 0; i < 64; i++) {
                Renderable.anIntArray2865[i + 192] = 16777215;
            }
            Class40_Sub5_Sub17_Sub6.anIntArray3248 = new int[256];
            for(int i = 0; i < 64; i++) {
                Class40_Sub5_Sub17_Sub6.anIntArray3248[i] = i * 4;
            }
            for(int i = 0; i < 64; i++) {
                Class40_Sub5_Sub17_Sub6.anIntArray3248[64 + i] = 255 + i * 262144;
            }
            for(int i = 0; i < 64; i++) {
                Class40_Sub5_Sub17_Sub6.anIntArray3248[128 + i] = i * 1024 + 16711935;
            }
            for(int i = 0; i < 64; i++) {
                Class40_Sub5_Sub17_Sub6.anIntArray3248[192 + i] = 16777215;
            }
            Class42.anIntArray1013 = new int[256];
            MovedStatics.anIntArray1445 = new int[32768];
            Landscape.anIntArray1168 = new int[32768];
            FramemapDefinition.method879(null);
            Class40_Sub5_Sub17_Sub6.anIntArray3255 = new int[32768];
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
            MovedStatics.anIntArray178 = new int[32768];
            Class26.loginScreenState = 0;
            if(RSCanvas.anInt60 != 0 && !VertexNormal.lowMemory) {
                Class33.method412(false, CacheArchive.musicCacheArchive, 0, (byte) 66, Native.titleSong, 10, "",
                        RSCanvas.anInt60
                );
            } else {
                Class33.method405(10);
            }
            GameShell.method19(false);
            Class40_Sub5_Sub11.clearScreen = true;
            ISAAC.aBoolean512 = true;
        }
    }


    public Model getRotatedModel() {
        return ItemDefinition.forId(itemId, 10).asGroundStack(true, itemCount);
    }
}

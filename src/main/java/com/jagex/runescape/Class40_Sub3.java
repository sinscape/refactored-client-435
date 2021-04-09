package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.node.Node;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class40_Sub3 extends Node {
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2019;
    public static int anInt2020;
    public static int[] soundDelay = new int[50];
    public static int anInt2024 = 1;
    public static boolean aBoolean2026 = false;
    public static int anInt2032 = 0;
    public int anInt2017;
    public int anInt2018;
    public int anInt2025;
    public int anInt2027;
    public int anInt2028;
    public int anInt2030;
    public int anInt2031 = -1;
    public int anInt2033 = 0;
    public int anInt2035;
    public int anInt2036;
    public int anInt2038;
    public int anInt2039;


    public static void startup() {
        if(Class40_Sub5_Sub6.loadingPercent == 0) {
            Npc.currentScene = new Scene(MovedStatics.tile_height);
            for(int i = 0; i < 4; i++) {
                Landscape.currentCollisionMap[i] = new CollisionMap(104, 104);
            }
            Class40_Sub5_Sub13.minimapImage = new ImageRGB(512, 512);
            MovedStatics.anInt1607 = 5;
            Class40_Sub5_Sub6.loadingPercent = 20;
            Native.currentLoadingText = English.startingGameEngine;
        } else if(Class40_Sub5_Sub6.loadingPercent == 20) {
            //            int[] is = new int[9];
            //            for (int i = 0; i < 9; i++) {
            //                int i_0_ = 15 + 32 * i + 128;
            //                int i_1_ = 3 * i_0_ + 600;
            //                int i_2_ = Rasterizer3D.sinetable[i_0_];
            //                is[i] = i_2_ * i_1_ >> 16;
            //            }
            //            Scene.method95(500, 800, 512, 334, is);
            ScreenController.setBounds();
            MovedStatics.anInt1607 = 10;
            Native.currentLoadingText = English.preparedVisibilityMap;
            Class40_Sub5_Sub6.loadingPercent = 30;
        } else if(Class40_Sub5_Sub6.loadingPercent == 30) {
            CacheArchive.skeletonCacheArchive = CacheArchive.loadArchive(0, true, false, true);
            CacheArchive.skinDefinitionCacheArchive = CacheArchive.loadArchive(1, true, false, true);
            CacheArchive.gameDefinitionsCacheArchive = CacheArchive.loadArchive(2, true, true, false);
            CacheArchive.gameInterfaceCacheArchive = CacheArchive.loadArchive(3, true, false, true);
            CacheArchive.soundEffectCacheArchive = CacheArchive.loadArchive(4, true, false, true);
            CacheArchive.gameWorldMapCacheArchive = CacheArchive.loadArchive(5, true, true, true);
            CacheArchive.musicCacheArchive = CacheArchive.loadArchive(6, false, true, true);
            CacheArchive.modelCacheArchive = CacheArchive.loadArchive(7, true, false, true);
            CacheArchive.gameImageCacheArchive = CacheArchive.loadArchive(8, true, false, true);
            CacheArchive.gameTextureCacheArchive = CacheArchive.loadArchive(9, true, false, true);
            CacheArchive.huffmanCacheArchive = CacheArchive.loadArchive(10, true, false, true);
            CacheArchive.jingleCacheArchive = CacheArchive.loadArchive(11, true, false, true);
            CacheArchive.clientScriptCacheArchive = CacheArchive.loadArchive(12, true, false, true);
            Class40_Sub5_Sub6.loadingPercent = 40;
            Native.currentLoadingText = English.connectingToUpdateServer;
            MovedStatics.anInt1607 = 20;
        } else if(Class40_Sub5_Sub6.loadingPercent == 40) {
            int i = 0;
            i += CacheArchive.skeletonCacheArchive.getPercentLoaded() * 5 / 100;
            i += 5 * CacheArchive.skinDefinitionCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.gameDefinitionsCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.gameInterfaceCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.soundEffectCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.gameWorldMapCacheArchive.getPercentLoaded() / 100;
            i += CacheArchive.musicCacheArchive.getPercentLoaded() * 5 / 100;
            i += 40 * CacheArchive.modelCacheArchive.getPercentLoaded() / 100;
            i += CacheArchive.gameImageCacheArchive.getPercentLoaded() * 5 / 100;
            i += CacheArchive.gameTextureCacheArchive.getPercentLoaded() * 5 / 100;
            i += 5 * CacheArchive.huffmanCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.jingleCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.clientScriptCacheArchive.getPercentLoaded() / 100;
            if(i == 100) {
                Class40_Sub5_Sub6.loadingPercent = 45;
                Native.currentLoadingText = English.loadedUpdateList;
                MovedStatics.anInt1607 = 30;
            } else {
                if(i != 0) {
                    Native.currentLoadingText = English.checkingForUpdates + i + Native.percent;
                }
                MovedStatics.anInt1607 = 30;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 45) {
            MovedStatics.method446(Main.signlink, 0, !VertexNormal.lowMemory);
            Class49.aClass40_Sub9_Sub1_1152 = MouseHandler.method1003(Main.signlink, MouseHandler.gameCanvas);
            Class55.aClass48_1289 = new Class48(22050, CollisionMap.anInt141);
            Class40_Sub5_Sub6.loadingPercent = 50;
            Native.currentLoadingText = English.preparedSoundEngine;
            MovedStatics.anInt1607 = 35;
        } else if(Class40_Sub5_Sub6.loadingPercent == 50) {
            int i = 0;
            if(TypeFace.fontSmall != null) {
                i++;
            } else {
                TypeFace.fontSmall = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, "", Native.aClass1_2101);
            }
            if(WallDecoration.fontNormal != null) {
                i++;
            } else {
                WallDecoration.fontNormal = TypeFace.loadTypeFace(
                        CacheArchive.gameImageCacheArchive, "", Native.aClass1_1580);
            }
            if(TypeFace.fontBold != null) {
                i++;
            } else {
                TypeFace.fontBold = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, "", Native.aClass1_1921);
            }
            if(i < 3) {
                Native.currentLoadingText = English.loadingFonts + (i * 100 / 3) + Native.percent;
                MovedStatics.anInt1607 = 40;
            } else {
                Class40_Sub5_Sub6.loadingPercent = 60;
                MovedStatics.anInt1607 = 40;
                Native.currentLoadingText = English.loadedFonts;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 60) {
            int i = Class60.method988(CacheArchive.huffmanCacheArchive, CacheArchive.gameImageCacheArchive);
            int i_3_ = 5;
            if(i < i_3_) {
                Native.currentLoadingText = English.loadingTitleScreen + (100 * i / i_3_) + Native.percent;
                MovedStatics.anInt1607 = 50;
            } else {
                Console.console = new Console();
                Native.currentLoadingText = English.loadedTitleScreen;
                MovedStatics.anInt1607 = 50;
                OverlayDefinition.updateOverlay(5);
                Class40_Sub5_Sub6.loadingPercent = 70;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 70) {
            if(CacheArchive.gameDefinitionsCacheArchive.method185((byte) 98)) {
                MovedStatics.method441(CacheArchive.gameDefinitionsCacheArchive);
                UnderlayDefinition.method616(CacheArchive.gameDefinitionsCacheArchive);
                method977(CacheArchive.gameDefinitionsCacheArchive, CacheArchive.modelCacheArchive);
                method980(CacheArchive.modelCacheArchive, VertexNormal.lowMemory,
                        CacheArchive.gameDefinitionsCacheArchive
                );
                Main.method357(CacheArchive.modelCacheArchive, CacheArchive.gameDefinitionsCacheArchive);
                Class42.method885(
                        CacheArchive.gameDefinitionsCacheArchive, Class22.membersWorld, CacheArchive.modelCacheArchive);
                MovedStatics.method236(CacheArchive.skinDefinitionCacheArchive,
                        CacheArchive.gameDefinitionsCacheArchive, CacheArchive.skeletonCacheArchive
                );
                Class55.method966(CacheArchive.modelCacheArchive, CacheArchive.gameDefinitionsCacheArchive);
                Landscape.method936(CacheArchive.gameDefinitionsCacheArchive);
                Main.method43(CacheArchive.gameDefinitionsCacheArchive);
                GameInterface.createInterfaceMemoryBuffers();
                Class40_Sub5_Sub6.loadingPercent = 80;
                MovedStatics.anInt1607 = 60;
                Native.currentLoadingText = English.loadedConfig;
            } else {
                Native.currentLoadingText =
                        English.loadingConfig + CacheArchive.gameDefinitionsCacheArchive.method202() + Native.percent;
                MovedStatics.anInt1607 = 60;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 80) {
            int i = 0;
            if(AnimationSequence.minimapCompass != null) {
                i++;
            } else {
                AnimationSequence.minimapCompass = HuffmanEncoding.method1028(
                        CacheArchive.gameImageCacheArchive, Native.compass, "");
            }
            if(SpotAnimDefinition.minimapEdge == null) {
                SpotAnimDefinition.minimapEdge = HuffmanEncoding.method1028(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_1427, "");
            } else {
                i++;
            }
            if(SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301 != null) {
                i++;
            } else {
                SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301 = IndexedImage.getMultipleIndexedImages(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_671, "");
            }
            if(Class8.aClass40_Sub5_Sub14_Sub4Array296 == null) {
                Class8.aClass40_Sub5_Sub14_Sub4Array296 = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.mapFunction, "");
            } else {
                i++;
            }
            if(AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474 != null) {
                i++;
            } else {
                AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474 = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_2114, "");
            }
            if(FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603 == null) {
                FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603 = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_2161, "");
            } else {
                i++;
            }
            if(ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204 != null) {
                i++;
            } else {
                ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204 = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.headiconsPrayer, "");
            }
            if(UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567 == null) {
                UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567 = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_1230, "");
            } else {
                i++;
            }
            if(LinkedList.aClass40_Sub5_Sub14_Sub4_1057 == null) {
                LinkedList.aClass40_Sub5_Sub14_Sub4_1057 = HuffmanEncoding.method1028(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_2109, "");
            } else {
                i++;
            }
            if(aClass40_Sub5_Sub14_Sub4Array2019 == null) {
                aClass40_Sub5_Sub14_Sub4Array2019 = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_203, "");
            } else {
                i++;
            }
            if(Class37.cursorCross != null) {
                i++;
            } else {
                Class37.cursorCross = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_2179, "");
            }
            if(MovedStatics.mapDots == null) {
                MovedStatics.mapDots = MovedStatics.method526(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_183, "");
            } else {
                i++;
            }
            if(MovedStatics.aClass40_Sub5_Sub14_Sub2Array215 == null) {
                MovedStatics.aClass40_Sub5_Sub14_Sub2Array215 = IndexedImage.getMultipleIndexedImages(
                        CacheArchive.gameImageCacheArchive, Native.scrollbar, "");
            } else {
                i++;
            }
            if(Class40_Sub5_Sub13.moderatorIcon != null) {
                i++;
            } else {
                Class40_Sub5_Sub13.moderatorIcon = IndexedImage.getMultipleIndexedImages(
                        CacheArchive.gameImageCacheArchive, Native.aClass1_881, "");
            }
            if(i < 14) {
                Native.currentLoadingText = English.loadingSprites + (100 * i / 14) + Native.percent;
                MovedStatics.anInt1607 = 70;
            } else {
                SpotAnimDefinition.minimapEdge.trim();
                int i_4_ = (int) (Math.random() * 21.0) - 10;
                int i_5_ = (int) (21.0 * Math.random()) - 10;
                int i_6_ = (int) (41.0 * Math.random()) - 20;
                int i_7_ = -10 + (int) (21.0 * Math.random());
                for(int i_8_ = 0; Class8.aClass40_Sub5_Sub14_Sub4Array296.length > i_8_; i_8_++) {
                    Class8.aClass40_Sub5_Sub14_Sub4Array296[i_8_].method717(i_6_ + i_4_, i_5_ + i_6_, i_7_ + i_6_);
                }
                SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301[0].mixPalette(
                        i_4_ + i_6_, i_5_ + i_6_, i_6_ + i_7_);
                Native.currentLoadingText = English.loadedSprites;
                MovedStatics.anInt1607 = 70;
                Class40_Sub5_Sub6.loadingPercent = 85;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 85) {
            int i = KeyFocusListener.method955(CacheArchive.gameImageCacheArchive);
            int i_9_ = ActorDefinition.method576();
            if(i < i_9_) {
                Native.currentLoadingText = English.loadingGameScreen + (i * 100 / i_9_) + Native.percent;
                MovedStatics.anInt1607 = 80;
            } else {
                Native.currentLoadingText = English.loadedGamescreen;
                Class40_Sub5_Sub6.loadingPercent = 90;
                MovedStatics.anInt1607 = 80;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 90) {
            if(CacheArchive.gameTextureCacheArchive.method185((byte) 62)) {
                Class35 class35 = new Class35(CacheArchive.gameTextureCacheArchive, CacheArchive.gameImageCacheArchive,
                        20, 0.8, !VertexNormal.lowMemory ? 128 : 64
                );
                Rasterizer3D.method703(class35);
                Rasterizer3D.method711(0.8);
                Class40_Sub5_Sub6.loadingPercent = 110;
                MovedStatics.anInt1607 = 90;
                Native.currentLoadingText = English.loadedTextures;
            } else {
                Native.currentLoadingText =
                        English.loadingTextures + CacheArchive.gameTextureCacheArchive.method202() + Native.percent;
                MovedStatics.anInt1607 = 90;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 110) {
            Class12.mouseCapturer = new Class39();
            Main.signlink.method394(10, Class12.mouseCapturer);
            Native.currentLoadingText = English.loadedInputHandler;
            Class40_Sub5_Sub6.loadingPercent = 120;
            MovedStatics.anInt1607 = 94;
        } else if(Class40_Sub5_Sub6.loadingPercent == 120) {
            if(CacheArchive.huffmanCacheArchive.method194(Native.huffman, "")) {
                HuffmanEncoding huffmanEncoding = new HuffmanEncoding(
                        CacheArchive.huffmanCacheArchive.method170("", Native.huffman));
                Item.method778(huffmanEncoding);
                Class40_Sub5_Sub6.loadingPercent = 130;
                Native.currentLoadingText = English.loadedWordpack;
                MovedStatics.anInt1607 = 96;
            } else {
                Native.currentLoadingText = English.loadingWordPack + Native.aClass1_1348;
                MovedStatics.anInt1607 = 96;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 130) {
            if(!CacheArchive.gameInterfaceCacheArchive.method185((byte) 66)) {
                Native.currentLoadingText =
                        English.loadingInterfaces + (4 * CacheArchive.gameInterfaceCacheArchive.method202() / 5) +
                                Native.percent;
                MovedStatics.anInt1607 = 100;
            } else if(CacheArchive.clientScriptCacheArchive.method185((byte) 69)) {
                Native.currentLoadingText = English.loadedInterfaces;
                Class40_Sub5_Sub6.loadingPercent = 140;
                MovedStatics.anInt1607 = 100;
            } else {
                Native.currentLoadingText =
                        English.loadingInterfaces + (80 + CacheArchive.clientScriptCacheArchive.method202() / 5) +
                                Native.percent;
                MovedStatics.anInt1607 = 100;
            }
        } else if(Class40_Sub5_Sub6.loadingPercent == 140) {
            OverlayDefinition.updateOverlay(10);
        }
    }

    public static UnderlayDefinition method531(byte arg0, int arg1) {
        UnderlayDefinition underlayDefinition = (UnderlayDefinition) WallDecoration.aClass9_1247.get(arg1);
        if(underlayDefinition != null) {
            return underlayDefinition;
        }
        byte[] is = Actor.aCacheArchive_3150.getFile(arg1, 1);
        underlayDefinition = new UnderlayDefinition();
        if(is != null) {
            underlayDefinition.readValues(new Buffer(is));
        }
        underlayDefinition.calculateHsl();
        if(arg0 >= -39) {
            English.commandFpson = null;
        }
        WallDecoration.aClass9_1247.put(arg1, underlayDefinition);
        return underlayDefinition;
    }

    public static void method977(CacheArchive arg1, CacheArchive arg2) {
        MovedStatics.aCacheArchive_654 = arg2;
        Class49.aCacheArchive_1150 = arg1;
        PlayerAppearance.identityKitLength = Class49.aCacheArchive_1150.fileLength(3);
    }

    public static void method980(CacheArchive arg1, boolean lowMemory, CacheArchive arg3) {
        CacheArchive.definitionCache = arg3;
        GameObjectDefinition.count = CacheArchive.definitionCache.fileLength(6);
        Class35.aBoolean1734 = lowMemory;
        RSString.aCacheArchive_1705 = arg1;
    }
}

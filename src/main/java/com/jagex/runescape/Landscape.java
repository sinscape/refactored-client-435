package com.jagex.runescape;

import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.FileOperations;
import com.jagex.runescape.cache.def.FramemapDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.OldEngine.MapDecompressor;

import java.io.IOException;

public class Landscape {
    public static int anInt1157 = 0;
    public static int mouseY = 0;
    public static CollisionMap[] currentCollisionMap = new CollisionMap[4];
    public static int[] anIntArray1168;
    public static int anInt1170 = 0;
    public static int anInt1171 = 0;
    public static int[][] distanceValues = new int[104][104];
    public static String[] menuActionTexts = new String[500];
    public static ProducingGraphicsBuffer framePieceRight;
    public static int[] anIntArray1186;

    public static void loadRegion() {
        Main.method364((byte) -34, false);
        Class37.anInt874 = 0;
        boolean bool = true;
        for(int i = 0; i < RSString.terrainData.length; i++) {
            if(LinkedList.anIntArray1071[i] != -1 && RSString.terrainData[i] == null) {
                RSString.terrainData[i] = CacheArchive.gameWorldMapCacheArchive.getFile(
                        0, LinkedList.anIntArray1071[i]);
                if(RSString.terrainData[i] == null) {
                    Class37.anInt874++;
                    bool = false;
                }
            }
            if(Class13.anIntArray421[i] != -1 && GenericTile.objectData[i] == null) {
                GenericTile.objectData[i] = CacheArchive.gameWorldMapCacheArchive.method176(
                        Class13.anIntArray421[i], 0, Class44.anIntArrayArray1030[i]);
                if(GenericTile.objectData[i] == null) {
                    Class37.anInt874++;
                    bool = false;
                }
            }
        }
        if(bool) {
            bool = true;
            IdentityKit.anInt2591 = 0;
            for(int i = 0; RSString.terrainData.length > i; i++) {
                byte[] is = GenericTile.objectData[i];
                if(is != null) {
                    int i_2_ = (ISAAC.mapCoordinates[i] & 0xff) * 64 - Class26.baseY;
                    int i_3_ = (ISAAC.mapCoordinates[i] >> 8) * 64 - SpotAnimDefinition.baseX;
                    if(GroundItemTile.loadGeneratedMap) {
                        i_3_ = 10;
                        i_2_ = 10;
                    }
                    bool &= Class40_Sub7.method840((byte) -67, is, i_3_, i_2_);
                }
            }
            if(bool) {
                if(ProducingGraphicsBuffer.anInt1634 != 0) {
                    Class51.method940(0, English.loadingPleaseWait, true, Native.aClass1_2423);
                }
                RSCanvas.method46(0);
                Npc.currentScene.initToNull();
                System.gc();
                for(int z = 0; z < 4; z++) {
                    currentCollisionMap[z].reset();
                }
                for(int z = 0; z < 4; z++) {
                    for(int x = 0; x < 104; x++) {
                        for(int y = 0; y < 104; y++) {
                            OverlayDefinition.tile_flags[z][x][y] = (byte) 0;
                        }
                    }
                }
                Class65.method1020();
                int dataLength = RSString.terrainData.length;
                Class37.method436();
                Main.method364((byte) -34, true);
                if(!GroundItemTile.loadGeneratedMap) {
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetY = -Class26.baseY + (0xff & ISAAC.mapCoordinates[pointer]) * 64;
                        int offsetX = -SpotAnimDefinition.baseX + 64 * (ISAAC.mapCoordinates[pointer] >> 8);
                        byte[] is = RSString.terrainData[pointer];
                        if(FileOperations.FileExists("./data/maps/" + LinkedList.anIntArray1071[pointer] + ".dat")) {
                            System.out.println(
                                    "reading file: " + "./data/maps/" + LinkedList.anIntArray1071[pointer] + ".dat");
                            is = FileOperations.ReadFile("./data/maps/" + LinkedList.anIntArray1071[pointer] + ".dat");
                        } else {
                            System.out.println("MISSING GROUND: " + LinkedList.anIntArray1071[pointer] + " " + pointer);
                        }
                        if(is != null) {
                            AnimationSequence.loadTerrainBlock(currentCollisionMap, (Class51.regionX - 6) * 8, is, -6,
                                    offsetX, offsetY, 8 * (-6 + Class17.regionY)
                            );
                        }
                    }
                    for(int pointer = 0; dataLength > pointer; pointer++) {
                        int offsetX = -SpotAnimDefinition.baseX + (ISAAC.mapCoordinates[pointer] >> 8) * 64;
                        int offsetY = -Class26.baseY + 64 * (ISAAC.mapCoordinates[pointer] & 0xff);
                        byte[] data = RSString.terrainData[pointer];
                        if(data == null && Class17.regionY < 800) {
                            MovedStatics.initiateVertexHeights(offsetY, (byte) 103, 64, 64, offsetX);
                        }
                    }
                    Main.method364((byte) -34, true);
                    for(int region = 0; dataLength > region; region++) {
                        //                        System.out.println("Requesting map: "+Class13.anIntArray421[i_12_]);
                        // load maps in here
                        byte[] data = GenericTile.objectData[region];
                        if(FileOperations.FileExists("./data/maps/" + Class13.anIntArray421[region] + ".cmap")) {
                            MapDecompressor.objectLoader("./data/maps/" + Class13.anIntArray421[region] + ".cmap");
                        } else if(FileOperations.FileExists("./data/maps/" + Class13.anIntArray421[region] + ".dat")) {
                            System.out.println(
                                    "reading file: " + "./data/maps/" + Class13.anIntArray421[region] + ".dat");
                            data = FileOperations.ReadFile("./data/maps/" + Class13.anIntArray421[region] + ".dat");
                        } else {
                            try {
                                data = MapDecompressor.grabMap(Class13.anIntArray421[region]);
                            } catch(IOException e) {
                            }
                        }
                        if(data != null) {
                            int offsetX = -SpotAnimDefinition.baseX + (ISAAC.mapCoordinates[region] >> 8) * 64;
                            int offsetY = 64 * (0xff & ISAAC.mapCoordinates[region]) - Class26.baseY;
                            GameObject.loadObjectBlock(offsetX, Npc.currentScene, currentCollisionMap, data, offsetY);
                        } else {
                            System.out.println("Missing map: " + Class13.anIntArray421[region]);
                        }
                    }
                }
                if(GroundItemTile.loadGeneratedMap) {
                    for(int z = 0; z < 4; z++) {
                        for(int x = 0; x < 13; x++) {
                            for(int y = 0; y < 13; y++) {
                                int data = OverlayDefinition.constructMapTiles[z][x][y];
                                boolean bool_19_ = false;
                                if(data != -1) {
                                    int tileRotation = (0x6 & data) >> 1;
                                    int tileX = (data & 0xffd2c2) >> 14;
                                    int tileZ = data >> 24 & 0x3;
                                    int tileY = (data & 0x3ffb) >> 3;
                                    int tileCoordinates = (tileX / 8 << 8) + tileY / 8;
                                    for(int pointer = 0; pointer < ISAAC.mapCoordinates.length; pointer++) {
                                        if(ISAAC.mapCoordinates[pointer] == tileCoordinates &&
                                                RSString.terrainData[pointer] != null) {
                                            loadTerrainSubblock(y * 8, 8 * (tileX & 0x7), tileZ, z, x * 8,
                                                    (0x7 & tileY) * 8, tileRotation, RSString.terrainData[pointer],
                                                    currentCollisionMap
                                            );
                                            bool_19_ = true;
                                            break;
                                        }
                                    }
                                }
                                if(!bool_19_) {
                                    MovedStatics.method455(8 * y, z, x * 8);
                                }
                            }
                        }
                    }
                    for(int x = 0; x < 13; x++) {
                        for(int y = 0; y < 13; y++) {
                            int displayMap = OverlayDefinition.constructMapTiles[0][x][y];
                            if(displayMap == -1) {
                                MovedStatics.initiateVertexHeights(y * 8, (byte) 120, 8, 8, 8 * x);
                            }
                        }
                    }
                    Main.method364((byte) -34, true);
                    for(int z = 0; z < 4; z++) {
                        for(int x = 0; x < 13; x++) {
                            for(int y = 0; y < 13; y++) {
                                int bits = OverlayDefinition.constructMapTiles[z][x][y];
                                if(bits != -1) {
                                    int tileZ = (bits & 0x3ba82fb) >> 24;
                                    int tileX = 0x3ff & bits >> 14;
                                    int tileRotation = bits >> 1 & 0x3;
                                    int tileY = bits >> 3 & 0x7ff;
                                    int tileCoordinates = (tileX / 8 << 8) + tileY / 8;
                                    for(int i_38_ = 0; i_38_ < ISAAC.mapCoordinates.length; i_38_++) {
                                        if(tileCoordinates == ISAAC.mapCoordinates[i_38_] &&
                                                GenericTile.objectData[i_38_] != null) {
                                            Class24.method341(8 * (tileX & 0x7), Npc.currentScene, 0, z, tileRotation,
                                                    tileZ, GenericTile.objectData[i_38_], 8 * y, currentCollisionMap,
                                                    8 * (tileY & 0x7), x * 8
                                            );
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Main.method364((byte) -34, true);
                RSCanvas.method46(0);
                ISAAC.method281(Npc.currentScene, 27324, currentCollisionMap);
                Main.method364((byte) -34, true);
                int z = Class64.lowestPlane;
                if(Player.worldLevel < z) {
                    z = Player.worldLevel;
                }
                if(z < -1 + Player.worldLevel) {
                    z = -1 + Player.worldLevel;
                }
                if(!VertexNormal.lowMemory) {
                    Npc.currentScene.setHeightLevel(0);
                } else {
                    Npc.currentScene.setHeightLevel(Class64.lowestPlane);
                }
                for(int x = 0; x < 104; x++) {
                    for(int y = 0; y < 104; y++) {
                        FramemapDefinition.spawnGroundItem(y, x);
                    }
                }
                ISAAC.method285();
                GameObjectDefinition.objectModelCache.clear();
                if(Class35.gameFrame != null) {
                    SceneCluster.packetBuffer.putPacket(121);
                    SceneCluster.packetBuffer.putIntBE(1057001181);
                }
                if(!GroundItemTile.loadGeneratedMap) {
                    int i_42_ = (-6 + Class51.regionX) / 8;
                    int i_43_ = (Class17.regionY - 6) / 8;
                    int i_44_ = (6 + Class17.regionY) / 8;
                    int i_45_ = (Class51.regionX + 6) / 8;
                    for(int i_46_ = -1 + i_42_; i_46_ <= 1 + i_45_; i_46_++) {
                        for(int i_47_ = -1 + i_43_; i_47_ <= i_44_ + 1; i_47_++) {
                            if(i_42_ > i_46_ || i_46_ > i_45_ || i_47_ < i_43_ || i_47_ > i_44_) {
                                CacheArchive.gameWorldMapCacheArchive.method195(
                                        0, Native.aClass1_1085 + i_46_ + Native.aClass1_303 + i_47_);
                                CacheArchive.gameWorldMapCacheArchive.method195(
                                        0, Native.aClass1_553 + i_46_ + Native.aClass1_303 + i_47_);
                            }
                        }
                    }
                }
                if(GameInterface.fullscreenInterfaceId != -1) {
                    OverlayDefinition.updateOverlay(35);
                } else {
                    OverlayDefinition.updateOverlay(30);
                }
                MovedStatics.method973();
                SceneCluster.packetBuffer.putPacket(178);
                RSRuntimeException.method1057(126);
            } else {
                ProducingGraphicsBuffer.anInt1634 = 2;
            }
        } else {
            ProducingGraphicsBuffer.anInt1634 = 1;
        }

    }

    public static void method934(int arg0, int arg2, int arg3, int arg4) {
        for(
                Class40_Sub2 class40_sub2 = (Class40_Sub2) MovedStatics.aLinkedList_2268.method902();
                class40_sub2 != null; class40_sub2 = (Class40_Sub2) MovedStatics.aLinkedList_2268.method909()
        ) {
            if(class40_sub2.anInt1997 != -1 || class40_sub2.anIntArray2005 != null) {
                int i_48_ = 0;
                if(arg0 <= class40_sub2.anInt2013) {
                    if(arg0 < class40_sub2.anInt1994) {
                        i_48_ += class40_sub2.anInt1994 - arg0;
                    }
                } else {
                    i_48_ += -class40_sub2.anInt2013 + arg0;
                }
                if(arg4 > class40_sub2.anInt2007) {
                    i_48_ += -class40_sub2.anInt2007 + arg4;
                } else if(arg4 < class40_sub2.anInt2003) {
                    i_48_ += -arg4 + class40_sub2.anInt2003;
                }
                if(class40_sub2.anInt2000 < -64 + i_48_ || RSCanvas.anInt65 == 0 || arg2 != class40_sub2.anInt1993) {
                    if(class40_sub2.aClass40_Sub9_Sub2_2001 != null) {
                        Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2001);
                        class40_sub2.aClass40_Sub9_Sub2_2001 = null;
                    }
                    if(class40_sub2.aClass40_Sub9_Sub2_2010 != null) {
                        Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2010);
                        class40_sub2.aClass40_Sub9_Sub2_2010 = null;
                    }
                } else {
                    i_48_ -= 64;
                    if(i_48_ < 0) {
                        i_48_ = 0;
                    }
                    int i_49_ = (-i_48_ + class40_sub2.anInt2000) * RSCanvas.anInt65 / class40_sub2.anInt2000;
                    if(class40_sub2.aClass40_Sub9_Sub2_2001 == null) {
                        if(class40_sub2.anInt1997 >= 0) {
                            Effect effect = Effect.method429(
                                    CacheArchive.soundEffectCacheArchive, class40_sub2.anInt1997, 0);
                            if(effect != null) {
                                Class40_Sub12_Sub1 class40_sub12_sub1 = effect.method428().method875(
                                        Class55.aClass48_1289);
                                Class40_Sub9_Sub2 class40_sub9_sub2 = Class40_Sub9_Sub2.method864(
                                        class40_sub12_sub1, 100, i_49_);
                                class40_sub9_sub2.method860(-1);
                                Class49.aClass40_Sub9_Sub1_1152.method846(class40_sub9_sub2);
                                class40_sub2.aClass40_Sub9_Sub2_2001 = class40_sub9_sub2;
                            }
                        }
                    } else {
                        class40_sub2.aClass40_Sub9_Sub2_2001.method857(i_49_);
                    }
                    if(class40_sub2.aClass40_Sub9_Sub2_2010 == null) {
                        if(class40_sub2.anIntArray2005 != null && (class40_sub2.anInt2014 -= arg3) <= 0) {
                            int i_50_ = (int) ((double) class40_sub2.anIntArray2005.length * Math.random());
                            Effect effect = Effect.method429(CacheArchive.soundEffectCacheArchive,
                                    class40_sub2.anIntArray2005[i_50_], 0
                            );
                            if(effect != null) {
                                Class40_Sub12_Sub1 class40_sub12_sub1 = effect.method428().method875(
                                        Class55.aClass48_1289);
                                Class40_Sub9_Sub2 class40_sub9_sub2 = Class40_Sub9_Sub2.method864(
                                        class40_sub12_sub1, 100, i_49_);
                                class40_sub9_sub2.method860(0);
                                Class49.aClass40_Sub9_Sub1_1152.method846(class40_sub9_sub2);
                                class40_sub2.anInt2014 = class40_sub2.anInt2012 +
                                        (int) ((double) (-class40_sub2.anInt2012 + class40_sub2.anInt2002) *
                                                Math.random());
                                class40_sub2.aClass40_Sub9_Sub2_2010 = class40_sub9_sub2;
                            }
                        }
                    } else {
                        class40_sub2.aClass40_Sub9_Sub2_2010.method857(i_49_);
                        if(!class40_sub2.aClass40_Sub9_Sub2_2010.method863()) {
                            class40_sub2.aClass40_Sub9_Sub2_2010 = null;
                        }
                    }
                }
            }
        }
    }


    public static void method936(CacheArchive arg1) {
        RSCanvas.aCacheArchive_61 = arg1;

    }

    public static void loadTerrainSubblock(
            int arg0, int arg2, int arg3, int arg4, int x, int arg6, int arg7, byte[] arg8, CollisionMap[] arg9
    ) {
        for(int i = 0; i < 8; i++) {
            for(int y = 0; y < 8; y++) {
                if(x + i > 0 && i + x < 103 && arg0 + y > 0 && y + arg0 < 103) {
                    arg9[arg4].clippingData[x + i][y + arg0] = HuffmanEncoding.method1021(
                            arg9[arg4].clippingData[x + i][y + arg0], -16777217);
                }
            }
        }
        Buffer class40_sub1 = new Buffer(arg8);
        for(int i = 0; i < 4; i++) {
            for(int i_1_ = 0; i_1_ < 64; i_1_++) {
                for(int i_2_ = 0; i_2_ < 64; i_2_++) {
                    if(i == arg3 && i_1_ >= arg2 && 8 + arg2 > i_1_ && i_2_ >= arg6 && 8 + arg6 > i_2_) {
                        Class48.method922(x + Class24.method338(arg7, false, i_1_ & 0x7, i_2_ & 0x7), arg7,
                                class40_sub1, arg0 + Class33.method410(i_1_ & 0x7, 0x7 & i_2_, arg7, false), 0, 0, arg4
                        );
                    } else {
                        Class48.method922(-1, 0, class40_sub1, -1, 0, 0, 0);
                    }
                }
            }
        }
    }
}

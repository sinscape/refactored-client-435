package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.tile.SceneTile;
import tech.henning.fourthreefive.Configuration;

import java.text.MessageFormat;

public class HuffmanEncoding {
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1541;
    public static int anInt1545 = 0;
    public static int reportAbuseInterfaceID = -1;
    public static int anInt1559 = 7759444;
    public static int[] anIntArray1564 = new int[]{
            -1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1,
            0, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19,
            20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40,
            41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226,
            232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
    };

    public int[] chatDecryptKeys;
    public int[] chatMask;
    public byte[] chatBitSizes;

    public HuffmanEncoding(byte[] arg0) {
        int i = arg0.length;
        chatBitSizes = arg0;
        chatMask = new int[i];
        int[] is = new int[33];
        chatDecryptKeys = new int[8];
        int i_29_ = 0;
        for(int i_30_ = 0; i_30_ < i; i_30_++) {
            int i_31_ = arg0[i_30_];
            if(i_31_ != 0) {
                int i_32_ = 1 << -i_31_ + 32;
                int i_33_ = is[i_31_];
                chatMask[i_30_] = i_33_;
                int i_34_;
                if((i_32_ & i_33_) == 0) {
                    for(int i_35_ = -1 + i_31_; i_35_ >= 1; i_35_--) {
                        int i_36_ = is[i_35_];
                        if(i_36_ != i_33_) {
                            break;
                        }
                        int i_37_ = 1 << -i_35_ + 32;
                        if((i_36_ & i_37_) == 0) {
                            is[i_35_] = UnderlayDefinition.bitWiseOR(i_36_, i_37_);
                        } else {
                            is[i_35_] = is[-1 + i_35_];
                            break;
                        }
                    }
                    i_34_ = i_33_ | i_32_;
                } else {
                    i_34_ = is[-1 + i_31_];
                }
                is[i_31_] = i_34_;
                for(int i_38_ = i_31_ + 1; i_38_ <= 32; i_38_++) {
                    if(i_33_ == is[i_38_]) {
                        is[i_38_] = i_34_;
                    }
                }
                int i_39_ = 0;
                for(int i_40_ = 0; i_40_ < i_31_; i_40_++) {
                    int i_41_ = -2147483648 >>> i_40_;
                    if((i_41_ & i_33_) != 0) {
                        if(chatDecryptKeys[i_39_] == 0) {
                            chatDecryptKeys[i_39_] = i_29_;
                        }
                        i_39_ = chatDecryptKeys[i_39_];
                    } else {
                        i_39_++;
                    }
                    if(chatDecryptKeys.length <= i_39_) {
                        int[] is_42_ = new int[chatDecryptKeys.length * 2];
                        System.arraycopy(chatDecryptKeys, 0, is_42_, 0, chatDecryptKeys.length);
                        chatDecryptKeys = is_42_;
                    }
                    i_41_ >>>= 1;
                }
                if(i_39_ >= i_29_) {
                    i_29_ = i_39_ + 1;
                }
                chatDecryptKeys[i_39_] = ~i_30_;
            }
        }

    }

    public static int method1021(int arg0, int arg1) {

        return arg0 & arg1;

    }


    public static RSString method1024(boolean arg0, byte arg1, int arg2) {
        if(arg1 > -30) {
            English.connectingToFriendserver = null;
        }
        return PacketBuffer.method521(arg0, 10, arg2);
    }

    public static void processNpcMenuOptions(ActorDefinition actorDefinition, int x, int y, int index) {
        if(ActorDefinition.menuActionRow < 400) {
            if(actorDefinition.childrenIds != null) {
                actorDefinition = actorDefinition.getChildDefinition(-1);
            }
            if(actorDefinition != null && actorDefinition.isClickable) {
                String class1 = actorDefinition.name;
                if(actorDefinition.combatLevel != 0) {
                    class1 = class1 + SceneTile.getCombatLevelColour(
                            Player.localPlayer.combatLevel, actorDefinition.combatLevel) + Native.aClass1_569 +
                            English.prefixLevel + actorDefinition.combatLevel + Native.rightParenthasis;
                }
                if(Class8.itemSelected == 1) {
                    OverlayDefinition.addActionRow(
                            English.use, index, x, y, 49, Native.aClass1_3295 + Native.toYellow + class1);
                } else if(Main.widgetSelected == 1) {
                    if((0x2 & ItemDefinition.selectedMask) == 2) {
                        OverlayDefinition.addActionRow(Native.aClass1_1918, index, x, y, 21,
                                Native.aClass1_611 + Native.toYellow + class1
                        );
                    }
                } else {
                    String[] class1s = actorDefinition.options;
                    if(Class60.aBoolean1402) {
                        class1s = MovedStatics.method968(class1s);
                    }
                    if(class1s != null) {
                        for(int i = 4; i >= 0; i--) {
                            if(class1s[i] != null && !class1s[i].equalsIgnoreCase(English.attack)) {
                                int i_3_ = 0;
                                if(i == 0) {
                                    i_3_ = 12;
                                }
                                if(i == 1) {
                                    i_3_ = 30;
                                }
                                if(i == 2) {
                                    i_3_ = 4;
                                }
                                if(i == 3) {
                                    i_3_ = 34;
                                }
                                if(i == 4) {
                                    i_3_ = 20;
                                }
                                OverlayDefinition.addActionRow(class1s[i], index, x, y, i_3_, Native.yellow + class1);
                            }
                        }
                    }
                    if(class1s != null) {
                        for(int i = 4; i >= 0; i--) {
                            if(class1s[i] != null && class1s[i].equalsIgnoreCase(English.attack)) {
                                int i_4_ = 0;
                                if(Player.localPlayer.combatLevel < actorDefinition.combatLevel) {
                                    i_4_ = 2000;
                                }
                                int i_5_ = 0;
                                if(i == 0) {
                                    i_5_ = 12 + i_4_;
                                }
                                if(i == 1) {
                                    i_5_ = i_4_ + 30;
                                }
                                if(i == 2) {
                                    i_5_ = i_4_ + 4;
                                }
                                if(i == 3) {
                                    i_5_ = i_4_ + 34;
                                }
                                if(i == 4) {
                                    i_5_ = 20 + i_4_;
                                }
                                OverlayDefinition.addActionRow(class1s[i], index, x, y, i_5_, Native.yellow + class1);
                            }
                        }
                    }
                    StringBuilder examineText = new StringBuilder();
                    examineText.append(MessageFormat.format("<col=ffff00>{0}</col>", actorDefinition.name));
                    if(Configuration.DEBUG_CONTEXT) {
                        examineText.append(" <col=00ff00>(</col>");
                        examineText.append(
                                MessageFormat.format("<col=ffffff>{0}</col>", Integer.toString(actorDefinition.id)));
                        examineText.append("<col=00ff00>) (</col>");
                        examineText.append(MessageFormat
                                .format("<col=ffffff>{0}, {1}</col>", Integer.toString(x + SpotAnimDefinition.baseX),
                                        Integer.toString(y + Class26.baseY)
                                ));
                        examineText.append("<col=00ff00>)</col>");


                    }
                    OverlayDefinition.addActionRow(English.examine, index, x, y, 1001, examineText.toString());
                }
            }
        }
    }

    public static boolean method1027(int arg0) {
        return arg0 >= 48 && arg0 <= 57;
    }

    public static ImageRGB method1028(CacheArchive arg0, String arg1, String arg3) {
        int i = arg0.getHash(arg1);
        int i_13_ = arg0.method179(i, arg3);
        return Class48.method927(i_13_, arg0, true, i);
    }

    public static void method1030() {
        for(
                Class40_Sub2 class40_sub2 = (Class40_Sub2) MovedStatics.aLinkedList_2268.method902();
                class40_sub2 != null; class40_sub2 = (Class40_Sub2) MovedStatics.aLinkedList_2268.method909()
        ) {
            if(class40_sub2.gameObjectDefinition != null) {
                class40_sub2.method528();
            }
        }
    }

    public int decrypt(byte[] readBuffer, int length, byte[] writeBuffer, int bufferPos) {
        if(length == 0) {
            return 0;
        }
        int i = 0;
        int idx = bufferPos;
        for(int j = 0; j < length; j++) {
            byte readByte = readBuffer[idx];
            if(readByte >= 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            int i_2_;
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            if((0x40 & readByte) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            if((0x20 & readByte) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            if((0x10 & readByte) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            if((readByte & 0x8) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            if((0x4 & readByte) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            if((0x2 & readByte) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            if((readByte & 0x1) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if((i_2_ = chatDecryptKeys[i]) < 0) {
                writeBuffer[j] = (byte) (~i_2_);
                i = 0;
            }
            idx++;
        }
        return idx - bufferPos + 1;
    }

    public int encrypt(int bufferPos, int sourceLength, byte[] source, byte[] dest) {
        int i = 0;
        int i_6_ = bufferPos << 3;
        for(int index = 0; index < sourceLength; index++) {
            int textByte = 0xff & source[index];
            int mask = chatMask[textByte];
            int size = chatBitSizes[textByte];
            if(size == 0) {
                throw new RuntimeException("No codeword for data value " + textByte);
            }
            int bitOffset2 = i_6_ >> 3;
            int bitOffset = 0x7 & i_6_;
            i_6_ += size;
            i &= -bitOffset >> 31;
            int i_12_ = bitOffset2 + (size + bitOffset - 1 >> 3);
            bitOffset += 24;
            dest[bitOffset2] = (byte) (i = UnderlayDefinition.bitWiseOR(i, mask >>> bitOffset));
            if(bitOffset2 < i_12_) {
                bitOffset2++;
                bitOffset -= 8;
                dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                if(i_12_ > bitOffset2) {
                    bitOffset -= 8;
                    bitOffset2++;
                    dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                    if(bitOffset2 < i_12_) {
                        bitOffset2++;
                        bitOffset -= 8;
                        dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                        if(bitOffset2 < i_12_) {
                            bitOffset -= 8;
                            bitOffset2++;
                            dest[bitOffset2] = (byte) (i = mask << -bitOffset);
                        }
                    }
                }
            }
        }
        return (7 + i_6_ >> 3) - bufferPos;
    }
}

package com.jagex.runescape.scene.tile;

import com.jagex.runescape.Class40_Sub5_Sub13;
import com.jagex.runescape.Class40_Sub5_Sub15;
import com.jagex.runescape.LinkedList;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.util.CollisionMap;

public class Wall {
    public static int cameraVelocityHorizontal = 0;
    public static int anInt350;
    public static int[] walkingQueueY = new int[4000];
    public static GameInterface aGameInterface_353 = null;
    public static int anInt356 = 0;
    public static LinkedList[][][] groundItems = new LinkedList[4][104][104];

    public int hash;
    public int x;
    public int y;
    public int z;
    public int orientationA;
    public int orientationB;
    public Renderable secondary;
    public Renderable primary;
    public int config = 0;

    public Wall() {
        hash = 0;
    }


    public static void renderSplitPrivateMessages() {
        if(CollisionMap.anInt165 != 0) {
            TypeFace class40_sub5_sub14_sub1 = WallDecoration.fontNormal;
            int i = 0;
            if(Class40_Sub5_Sub15.systemUpdateTime != 0) {
                i = 1;
            }
            for(int i_0_ = 0; i_0_ < 100; i_0_++) {
                if(ChatBox.chatMessages[i_0_] != null) {
                    String class1 = ChatBox.chatPlayerNames[i_0_];
                    int i_1_ = 0;
                    int i_2_ = ChatBox.chatTypes[i_0_];
                    if(class1 != null && class1.startsWith(Native.whiteCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 1;
                    }
                    if(class1 != null && class1.startsWith(Native.goldCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 2;
                    }
                    if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 ||
                            ChatBox.privateChatMode == 1 && Player.hasFriend(class1))) {
                        int i_3_ = 329 - 13 * i;
                        int i_4_ = 4;
                        i++;
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, -1 + i_3_, 65535);
                        i_4_ += class40_sub5_sub14_sub1.getStringWidth(English.from);
                        i_4_ += class40_sub5_sub14_sub1.method689(32);
                        if(i_1_ == 1) {
                            Class40_Sub5_Sub13.moderatorIcon[0].drawImage(i_4_, i_3_ - 12);
                            i_4_ += 14;
                        }
                        if(i_1_ == 2) {
                            Class40_Sub5_Sub13.moderatorIcon[1].drawImage(i_4_, -12 + i_3_);
                            i_4_ += 14;
                        }
                        class40_sub5_sub14_sub1.drawString(
                                class1 + Native.aClass1_515 + ChatBox.chatMessages[i_0_], i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(class1 + Native.aClass1_515 + ChatBox.chatMessages[i_0_],
                                i_4_, -1 + i_3_, 65535
                        );
                        if(i >= 5) {
                            return;
                        }
                    }
                    if(i_2_ == 5 && ChatBox.privateChatMode < 2) {
                        int i_5_ = -(i * 13) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_, 0);
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_ - 1, 65535);
                        if(i >= 5) {
                            return;
                        }
                    }
                    if(i_2_ == 6 && ChatBox.privateChatMode < 2) {
                        int i_6_ = -(13 * i) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(
                                English.to + Native.aClass1_1123 + class1 + Native.aClass1_515 +
                                        ChatBox.chatMessages[i_0_], 4, i_6_, 0);
                        class40_sub5_sub14_sub1.drawString(
                                English.to + Native.aClass1_1123 + class1 + Native.aClass1_515 +
                                        ChatBox.chatMessages[i_0_], 4, i_6_ + -1, 65535);
                        if(i >= 5) {
                            return;
                        }
                    }
                }
            }
        }
    }
}

package com.jagex.runescape.frame;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.RasterizerInstanced;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.Wall;

public class Minimap extends FramePieceRenderer {
    private static int[] resizableMinimapOffsets1;
    private static int[] resizableMinimapOffsets2;
    private static ProducingGraphicsBuffer resizableMiniMapimage;
    private static int[] resizableMinimapLineOffsets;
    private final ProducingGraphicsBuffer tempResizableMiniMapimage;
    private int[] resizableCompasOffsets1;
    private int[] resizableCompasOffsets2;

    public Minimap() {
        this.tempResizableMiniMapimage = Class40_Sub5_Sub13.createGraphicsBuffer(210, 210, MouseHandler.gameCanvas);
        resizableMinimapOffsets1 = new int[200];
        resizableMinimapOffsets2 = new int[200];
        for(int i = 0; i < resizableMinimapOffsets2.length; i++) {
            resizableMinimapOffsets1[i] = 200;
            resizableMinimapOffsets2[i] = 0;
        }

        resizableMiniMapimage = Class40_Sub5_Sub13.createGraphicsBuffer(210, 210, MouseHandler.gameCanvas);
        rasterizerInstanced = new RasterizerInstanced(this.tempResizableMiniMapimage);

    }

    public void drawResizableMiniMapArea(int x, int y) {
        ScreenController.drawFramePiece(resizableMiniMapimage, x, y);
    }

    public void RenderResizableMiniMapArea(int x, int y) {
        if(this.resizableCompasOffsets1 == null) {
            resizableCompasOffsets1 = new int[33];
            resizableCompasOffsets2 = new int[33];
            for(int y1 = 0; y1 < 33; y1++) {
                int i_15_ = 0;
                int i_16_ = 999;
                for(int x1 = 0; x1 < 34; x1++) {
                    if(MovedStatics.minimapBackgroundImage.imgPixels[MovedStatics.minimapBackgroundImage.imgWidth * y1 +
                            x1] == 0) {
                        if(i_16_ == 999) {
                            i_16_ = x1;
                        }
                    } else if(i_16_ != 999) {
                        i_15_ = x1;
                        break;
                    }
                }
                resizableCompasOffsets2[y1] = i_16_;
                resizableCompasOffsets1[y1] = -i_16_ + i_15_;
            }
        }
        if(MovedStatics.minimapState == 2) {
            resizableMiniMapimage.prepareRasterizer();
            resizableMinimapLineOffsets = Rasterizer3D.setLineOffsets(resizableMinimapLineOffsets);
            byte[] mmBackgroundPixels = MovedStatics.minimapBackgroundImage.imgPixels;
            int[] rasterPixels = Rasterizer.destinationPixels;
            int pixelCount = mmBackgroundPixels.length;
            for(int i = 0; i < pixelCount; i++) {
                if(mmBackgroundPixels[i] == 0) {
                    rasterPixels[i] = 0;
                }
            }
            Rasterizer.drawFilledRectangle(0, 0, 210, 210, 0x242017);
            Rasterizer.drawFilledRectangle(5, 5, 200, 200, 0x000000);

            //        Rasterizer.drawFilledRectangle(x-43,y, 43, 43, 0x242017);
            Rasterizer.drawFilledRectangle(0, 0, 20, 42, 0x242017);
            Rasterizer.drawFilledRectangle(0, 0, 42, 20, 0x242017);

            Rasterizer.drawCircle(21, 21, 20, 0x242017);
            AnimationSequence.minimapCompass.shapeImageToPixels(5, 5, 33, 33, 25, 25, GroundItemTile.cameraHorizontal,
                    256, resizableCompasOffsets2, resizableCompasOffsets1
            );


            Class65.method1018();

            ScreenController.drawFramePiece(resizableMiniMapimage, x, y);
            return;
        }

        int i = 48 + Player.localPlayer.worldX / 32;
        int i_8_ = 464 + -(Player.localPlayer.worldY / 32);
        int i_9_ = GroundItemTile.cameraHorizontal + Class43.cameraYawOffset & 0x7ff;
        shapeImageToPixels(Class40_Sub5_Sub13.minimapImage, 5, 5, 200, 200, i, i_8_, i_9_, Class51.mapZoomOffset + 256,
                resizableMinimapOffsets2, resizableMinimapOffsets1
        );
        drawResizableMinimapDots();
        rasterizerInstanced.drawFilledRectangle(105, 105, 3, 3, 16777215);
        rasterizerInstanced.drawFilledRectangle(0, 0, 210, 5, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 205, 210, 5, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 0, 5, 210, 0x242017);
        rasterizerInstanced.drawFilledRectangle(205, 0, 5, 210, 0x242017);

        //        Rasterizer.drawFilledRectangle(x-43,y, 43, 43, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 0, 20, 42, 0x242017);
        rasterizerInstanced.drawFilledRectangle(0, 0, 42, 20, 0x242017);

        rasterizerInstanced.drawCircle(21, 21, 20, 0x242017);
        shapeImageToPixels(AnimationSequence.minimapCompass, 5, 5, 33, 33, 25, 25, GroundItemTile.cameraHorizontal, 256,
                resizableCompasOffsets2, resizableCompasOffsets1
        );

        System.arraycopy(tempResizableMiniMapimage.pixels, 0, resizableMiniMapimage.pixels, 0,
                resizableMiniMapimage.pixels.length
        );
        //        Class65.method1018();

        //        ScreenController.drawFramePiece(resizableMiniMapimage, x, y);

    }

    private void drawResizableMinimapDots() {
        for(int i = 0; GameObject.minimapHintCount > i; i++) {
            int hintX = 2 + 4 * Actor.minimapHintX[i] + -(Player.localPlayer.worldX / 32);
            int hintY = 2 + 4 * LinkedList.minimapHintY[i] - Player.localPlayer.worldY / 32;
            drawOnResizableMinimap(hintX, hintY, MouseHandler.minimapHint[i]);
        }
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                LinkedList linkedList = Wall.groundItems[Player.worldLevel][x][y];
                if(linkedList != null) {
                    int itemY = -(Player.localPlayer.worldY / 32) + 2 + y * 4;
                    int itemX = -(Player.localPlayer.worldX / 32) + 2 + x * 4;
                    drawOnResizableMinimap(itemX, itemY, MovedStatics.mapDots[0]);
                }
            }
        }
        for(int i = 0; Player.npcCount > i; i++) {
            Npc npc = Player.npcs[Player.npcIds[i]];
            if(npc != null && npc.isVisible()) {
                ActorDefinition definition = npc.actorDefinition;
                if(definition.childrenIds != null) {
                    definition = definition.getChildDefinition(-1);
                }
                if(definition != null && definition.renderOnMinimap && definition.isClickable) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 + -(Player.localPlayer.worldY / 32);
                    drawOnResizableMinimap(npcX, npcY, MovedStatics.mapDots[1]);
                }
            }
        }
        for(int i = 0; Player.localPlayerCount > i; i++) {
            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i]];
            if(player != null && player.isVisible()) {
                int playerX = player.worldX / 32 + -(Player.localPlayer.worldX / 32);
                int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                boolean isFriend = false;
                long name = RSString.nameToLong(player.playerName);
                for(int friend = 0; Player.friendsCount > friend; friend++) {
                    if(name == Class59.friends[friend] && Player.friendWorlds[friend] != 0) {
                        isFriend = true;
                        break;
                    }
                }
                boolean isTeammate = false;
                if(Player.localPlayer.teamId != 0 && player.teamId != 0 && player.teamId == Player.localPlayer.teamId) {
                    isTeammate = true;
                }
                if(isFriend) {
                    drawOnResizableMinimap(playerX, playerY, MovedStatics.mapDots[3]);
                } else if(isTeammate) {
                    drawOnResizableMinimap(playerX, playerY, MovedStatics.mapDots[4]);
                } else {
                    drawOnResizableMinimap(playerX, playerY, MovedStatics.mapDots[2]);
                }
            }
        }
        if(Player.headIconDrawType != 0 && MovedStatics.pulseCycle % 20 < 10) {
            if(Player.headIconDrawType == 1 && HuffmanEncoding.anInt1545 >= 0 &&
                    Player.npcs.length > HuffmanEncoding.anInt1545) {
                Npc npc = Player.npcs[HuffmanEncoding.anInt1545];
                if(npc != null) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 - Player.localPlayer.worldY / 32;
                    drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], npcX, npcY);
                }
            }
            if(Player.headIconDrawType == 2) {
                int hintY = -(Player.localPlayer.worldY / 32) + 2 + 4 * (-Class26.baseY + MovedStatics.anInt175);
                int hintX = 4 * (ProducingGraphicsBuffer.anInt1637 - SpotAnimDefinition.baseX) -
                        (-2 + Player.localPlayer.worldX / 32);
                drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], hintX, hintY);
            }
            if(Player.headIconDrawType == 10 && ProducingGraphicsBuffer.anInt1623 >= 0 &&
                    Player.trackedPlayers.length > ProducingGraphicsBuffer.anInt1623) {
                Player player = Player.trackedPlayers[ProducingGraphicsBuffer.anInt1623];
                if(player != null) {
                    int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                    int playerX = player.worldX / 32 - Player.localPlayer.worldX / 32;
                    drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], playerX, playerY);
                }
            }
        }
        if(VarbitDefinition.destinationX != 0) {
            int flagX = 2 + VarbitDefinition.destinationX * 4 + -(Player.localPlayer.worldX / 32);
            int flagY = 2 + 4 * Class55.destinationY + -(Player.localPlayer.worldY / 32);
            drawOnResizableMinimap(flagX, flagY, Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[0]);
        }
    }

    public void drawOnResizableMinimap(int x, int y, ImageRGB sprite) {
        if(sprite == null) {
            return;
        }
        int angle = 0x7ff & Class43.cameraYawOffset + GroundItemTile.cameraHorizontal;
        int l = y * y + x * x;
        if(l > 17000) {
            return;
        }
        int sine = Model.SINE[angle];
        int cosine = Model.COSINE[angle];
        sine = sine * 256 / (Class51.mapZoomOffset + 256);
        cosine = cosine * 256 / (Class51.mapZoomOffset + 256);
        int i_3_ = cosine * x + y * sine >> 16;
        int i_4_ = -(x * sine) + cosine * y >> 16;
        drawImage(sprite, 106 + i_3_ + -(sprite.maxWidth / 2), -(sprite.maxHeight / 2) + -i_4_ + 106);
    }

    public void drawMinimapMark(ImageRGB sprite, int mapX, int mapY) {
        int len = mapX * mapX + mapY * mapY;
        if(len > 4225 && len < 90000) {
            int theta = 0x7ff & GroundItemTile.cameraHorizontal + Class43.cameraYawOffset;
            int sine = Model.SINE[theta];
            int cosine = Model.COSINE[theta];
            sine = sine * 256 / (Class51.mapZoomOffset + 256);
            cosine = cosine * 256 / (Class51.mapZoomOffset + 256);
            int y = cosine * mapY - sine * mapX >> 16;
            int x = mapX * cosine + mapY * sine >> 16;
            double angle = Math.atan2(x, y);
            int drawX = (int) (Math.sin(angle) * 63.0);
            int drawY = (int) (57.0 * Math.cos(angle));
            drawRotated(sprite, -10 + 94 + drawX + 4, 83 + -drawY + -20, 15, 15, 20, 20, 256, angle);
        } else {
            drawOnResizableMinimap(mapY, mapX, sprite);
        }
    }

}

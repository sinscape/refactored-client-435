package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.scene.InteractiveObject;

import java.awt.*;
import java.io.*;

public class Class55 {
    public static int mouseInvInterfaceIndex = 0;
    public static Class48 aClass48_1289;
    public static volatile int eventClickX = 0;
    public static int anInt1296 = -1;
    public static int anInt1299 = 2301979;
    public static int destinationY = 0;

    public static String method959(int arg0, Throwable arg1) throws IOException {
        String string;
        if(arg1 instanceof RSRuntimeException) {
            RSRuntimeException runtimeexception_sub1 = (RSRuntimeException) arg1;
            string = runtimeexception_sub1.aString1653 + " | ";
            arg1 = runtimeexception_sub1.aThrowable1652;
        } else {
            string = "";
        }
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        arg1.printStackTrace(printwriter);
        printwriter.close();
        String string_0_ = stringwriter.toString();
        BufferedReader bufferedreader = new BufferedReader(new StringReader(string_0_));
        if(arg0 != 0) {
            return null;
        }
        String string_1_ = bufferedreader.readLine();
        while(true) {
            String string_2_ = bufferedreader.readLine();
            if(string_2_ == null) {
                break;
            }
            int i = string_2_.indexOf('(');
            int i_3_ = string_2_.indexOf(')', i + 1);
            if(i >= 0 && i_3_ >= 0) {
                String string_4_ = string_2_.substring(1 + i, i_3_);
                int i_5_ = string_4_.indexOf(".java:");
                if(i_5_ >= 0) {
                    string_4_ = string_4_.substring(0, i_5_) + string_4_.substring(5 + i_5_);
                    string += string_4_ + ' ';
                    continue;
                }
                string_2_ = string_2_.substring(0, i);
            }
            string_2_ = string_2_.trim();
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf(' '));
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf('\t'));
            string += string_2_ + ' ';
        }
        string += "| " + string_1_;
        return string;
    }

    public static Class40_Sub5_Sub15 method960(int arg1) {
        Class40_Sub5_Sub15 class40_sub5_sub15 = (Class40_Sub5_Sub15) Class42.aClass9_998.get(arg1);
        if(class40_sub5_sub15 != null) {
            return class40_sub5_sub15;
        }
        class40_sub5_sub15 = Class35.method421(VarbitDefinition.aCacheArchive_2364, (byte) 79, arg1,
                ClientScriptRunner.aCacheArchive_2162, false
        );
        if(class40_sub5_sub15 != null) {
            Class42.aClass9_998.put(arg1, class40_sub5_sub15);
        }
        return class40_sub5_sub15;
    }


    public static int method963(int arg0, byte arg1, int arg2) {
        if(arg0 > arg2) {
            int i = arg2;
            arg2 = arg0;
            arg0 = i;
        }
        if(arg1 != -62) {
            aClass48_1289 = null;
        }
        int i;
        for(/**/; arg0 != 0; arg0 = i) {
            i = arg2 % arg0;
            arg2 = arg0;
        }
        return arg2;
    }

    public static void drawTabGraphics() {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            MovedStatics.tabImageProducer.drawGraphics(553, 205, graphics);
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void removeMouseListeners(Component mouseCanvas) {
        mouseCanvas.removeMouseListener(GameObject.frame);
        mouseCanvas.removeMouseMotionListener(GameObject.frame);
        mouseCanvas.removeFocusListener(GameObject.frame);
    }

    public static void method966(CacheArchive arg1, CacheArchive arg2) {
        UnderlayDefinition.aCacheArchive_2582 = arg1;
        InteractiveObject.aCacheArchive_488 = arg2;
    }
}

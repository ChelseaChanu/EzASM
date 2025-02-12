package com.ezasm;

import java.awt.Color;

public class Theme {

    Color BACKGROUND, FOREGROUND, CURRENTLINE, COMMENT, CYAN, GREEN, ORANGE, PINK, PURPLE, RED, YELLOW;

    // based on https://github.com/dracula/dracula-theme
    public static Theme Dracula = new Theme(0x282a36, 0x44475a, 0xf8f8f2, 0x6272a4, 0x8be9fd, 0x50fa7b, 0xffb86c,
            0xff79c6, 0xbd93f9, 0xff5555, 0xf1fa8c);
    // based on https://github.com/endormi/vscode-2077-theme
    public static Theme Purple = new Theme(0x0d0936, 0x210b66, 0xe4eeff, 0x0098df, 0x0ab2fa, 0x06ad00, 0xffd400,
            0xea00d9, 0x6f46af, 0xee1682, 0xffff99);
    // based on https://github.com/atom/one-light-syntax
    public static Theme Light = new Theme(0xfafafa, 0xa0a1a7, 0x383a42, 0x404045, 0x0184bc, 0x28a626, 0x986801,
            0xd548d3, 0x8c329a, 0xd92020, 0xfffb0f);

    public Theme(int bg, int cl, int fg, int cmt, int cyan, int grn, int org, int pnk, int prp, int red, int ylw) {
        BACKGROUND = new Color(bg);
        FOREGROUND = new Color(fg);
        CURRENTLINE = new Color(cl);
        COMMENT = new Color(cmt);
        CYAN = new Color(cyan);
        GREEN = new Color(grn);
        ORANGE = new Color(org);
        PINK = new Color(pnk);
        PURPLE = new Color(prp);
        RED = new Color(red);
        YELLOW = new Color(ylw);
    }

    public Color getBackground() {
        return BACKGROUND;
    }

    public Color getForeground() {
        return FOREGROUND;
    }

    public Color getCurrentline() {
        return CURRENTLINE;
    }

    public Color getComment() {
        return COMMENT;
    }

    public Color getCyan() {
        return CYAN;
    }

    public Color getGreen() {
        return GREEN;
    }

    public Color getOrange() {
        return ORANGE;
    }

    public Color getPink() {
        return PINK;
    }

    public Color getPurple() {
        return PURPLE;
    }

    public Color getRed() {
        return RED;
    }

    public Color getYellow() {
        return YELLOW;
    }
}

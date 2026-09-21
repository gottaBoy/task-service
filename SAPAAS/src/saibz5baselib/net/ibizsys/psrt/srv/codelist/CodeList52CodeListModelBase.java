/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="4bc61b3ad9d6a7d6ae1fd5797228aa9f", name="\u56fe\u8868\u63a7\u4ef6_\u8868\u683c\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u8868\u683c", realtext="\u65e0\u8868\u683c"), @CodeItem(value="TOPLEFT", text="\u4e0a\u5de6", realtext="\u4e0a\u5de6"), @CodeItem(value="TOP", text="\u4e0a\u4e2d", realtext="\u4e0a\u4e2d"), @CodeItem(value="TOPRIGHT", text="\u4e0a\u53f3", realtext="\u4e0a\u53f3"), @CodeItem(value="BOTTOMLEFT", text="\u4e0b\u5de6", realtext="\u4e0b\u5de6"), @CodeItem(value="BOTTOM", text="\u4e0b\u4e2d", realtext="\u4e0b\u4e2d"), @CodeItem(value="BOTTOMRIGHT", text="\u4e0b\u53f3", realtext="\u4e0b\u53f3"), @CodeItem(value="LEFTTOP", text="\u5de6\u4e0a", realtext="\u5de6\u4e0a"), @CodeItem(value="LEFT", text="\u5de6\u4e2d", realtext="\u5de6\u4e2d"), @CodeItem(value="LEFTBOTTOM", text="\u5de6\u4e0b", realtext="\u5de6\u4e0b"), @CodeItem(value="RIGHTTOP", text="\u53f3\u4e0a", realtext="\u53f3\u4e0a"), @CodeItem(value="RIGHT", text="\u53f3\u4e2d", realtext="\u53f3\u4e2d"), @CodeItem(value="RIGHTBOTTOM", text="\u53f3\u4e0b", realtext="\u53f3\u4e0b")})
public abstract class CodeList52CodeListModelBase
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String TOPLEFT = "TOPLEFT";
    public static final String TOP = "TOP";
    public static final String TOPRIGHT = "TOPRIGHT";
    public static final String BOTTOMLEFT = "BOTTOMLEFT";
    public static final String BOTTOM = "BOTTOM";
    public static final String BOTTOMRIGHT = "BOTTOMRIGHT";
    public static final String LEFTTOP = "LEFTTOP";
    public static final String LEFT = "LEFT";
    public static final String LEFTBOTTOM = "LEFTBOTTOM";
    public static final String RIGHTTOP = "RIGHTTOP";
    public static final String RIGHT = "RIGHT";
    public static final String RIGHTBOTTOM = "RIGHTBOTTOM";

    public CodeList52CodeListModelBase() {
        this.initAnnotation(CodeList52CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList52CodeListModel", this);
    }
}


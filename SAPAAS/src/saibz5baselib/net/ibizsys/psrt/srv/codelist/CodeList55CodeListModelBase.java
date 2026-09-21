/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="0bd398af7ee9eb10505c7a11de90596a", name="\u8bed\u8a00\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DEF.LNAME", text="\u5b9e\u4f53\u5c5e\u6027\u903b\u8f91\u540d\u79f0", realtext="\u5b9e\u4f53\u5c5e\u6027\u903b\u8f91\u540d\u79f0"), @CodeItem(value="CL.ITEM.LNAME", text="\u4ee3\u7801\u8868\u9879", realtext="\u4ee3\u7801\u8868\u9879"), @CodeItem(value="TBB.TEXT", text="\u5de5\u5177\u680f\u6309\u94ae\u6587\u672c", realtext="\u5de5\u5177\u680f\u6309\u94ae\u6587\u672c"), @CodeItem(value="TBB.TOOLTIP", text="\u5de5\u5177\u680f\u6309\u94ae\u63d0\u793a", realtext="\u5de5\u5177\u680f\u6309\u94ae\u63d0\u793a"), @CodeItem(value="MENUITEM.CAPTION", text="\u83dc\u5355\u9879\u6587\u672c", realtext="\u83dc\u5355\u9879\u6587\u672c"), @CodeItem(value="PAGE.HEADER", text="\u754c\u9762\u5934\u90e8\u6807\u9898", realtext="\u754c\u9762\u5934\u90e8\u6807\u9898"), @CodeItem(value="PAGE.COMMON", text="\u754c\u9762\u5e38\u89c4", realtext="\u754c\u9762\u5e38\u89c4"), @CodeItem(value="CONTROL", text="\u63a7\u4ef6\u6587\u672c", realtext="\u63a7\u4ef6\u6587\u672c"), @CodeItem(value="ERROR.STD", text="\u6807\u51c6\u9519\u8bef", realtext="\u6807\u51c6\u9519\u8bef"), @CodeItem(value="CTRL", text="\u5904\u7406\u903b\u8f91", realtext="\u5904\u7406\u903b\u8f91"), @CodeItem(value="COMMON", text="\u901a\u7528", realtext="\u901a\u7528"), @CodeItem(value="OTHER", text="\u5176\u5b83", realtext="\u5176\u5b83")})
public abstract class CodeList55CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DEF_LNAME = "DEF.LNAME";
    public static final String CL_ITEM_LNAME = "CL.ITEM.LNAME";
    public static final String TBB_TEXT = "TBB.TEXT";
    public static final String TBB_TOOLTIP = "TBB.TOOLTIP";
    public static final String MENUITEM_CAPTION = "MENUITEM.CAPTION";
    public static final String PAGE_HEADER = "PAGE.HEADER";
    public static final String PAGE_COMMON = "PAGE.COMMON";
    public static final String CONTROL = "CONTROL";
    public static final String ERROR_STD = "ERROR.STD";
    public static final String CTRL = "CTRL";
    public static final String COMMON = "COMMON";
    public static final String OTHER = "OTHER";

    public CodeList55CodeListModelBase() {
        this.initAnnotation(CodeList55CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList55CodeListModel", this);
    }
}


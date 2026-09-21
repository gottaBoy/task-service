/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="8d3b4c9afc144220b6ca8822295511dd", name="\u5e73\u53f0\u8bed\u8a00\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DE.LNAME", text="\u5b9e\u4f53\u903b\u8f91\u540d\u79f0\uff08DE.LNAME.*\uff09", realtext="\u5b9e\u4f53\u903b\u8f91\u540d\u79f0\uff08DE.LNAME.*\uff09"), @CodeItem(value="DEF.LNAME", text="\u5c5e\u6027\u903b\u8f91\u540d\u79f0\uff08DEF.LNAME.*\uff09", realtext="\u5c5e\u6027\u903b\u8f91\u540d\u79f0\uff08DEF.LNAME.*\uff09"), @CodeItem(value="CL.ITEM.LNAME", text="\u4ee3\u7801\u8868\u9879\uff08CL.ITEM.LNAME.*\uff09", realtext="\u4ee3\u7801\u8868\u9879\uff08CL.ITEM.LNAME.*\uff09"), @CodeItem(value="CL.ITEM.TOOLTIP", text="\u4ee3\u7801\u8868\u9879\u63d0\u793a\uff08CL.ITEM.TOOLTIP.*\uff09", realtext="\u4ee3\u7801\u8868\u9879\u63d0\u793a\uff08CL.ITEM.TOOLTIP.*\uff09"), @CodeItem(value="TBB.TEXT", text="\u5de5\u5177\u680f\u6309\u94ae\u6587\u672c\uff08TBB.TEXT.*\uff09", realtext="\u5de5\u5177\u680f\u6309\u94ae\u6587\u672c\uff08TBB.TEXT.*\uff09"), @CodeItem(value="TBB.TOOLTIP", text="\u5de5\u5177\u680f\u6309\u94ae\u63d0\u793a\uff08TBB.TOOLTIP.*\uff09", realtext="\u5de5\u5177\u680f\u6309\u94ae\u63d0\u793a\uff08TBB.TOOLTIP.*\uff09"), @CodeItem(value="MENUITEM.CAPTION", text="\u83dc\u5355\u9879\u6587\u672c\uff08MENUITEM.CAPTION.*\uff09", realtext="\u83dc\u5355\u9879\u6587\u672c\uff08MENUITEM.CAPTION.*\uff09"), @CodeItem(value="PAGE.HEADER", text="\u754c\u9762\u5934\u90e8\u6807\u9898\uff08PAGE.HEADER.*\uff09", realtext="\u754c\u9762\u5934\u90e8\u6807\u9898\uff08PAGE.HEADER.*\uff09"), @CodeItem(value="PAGE.COMMON", text="\u754c\u9762\u5e38\u89c4\uff08PAGE.COMMON.*\uff09", realtext="\u754c\u9762\u5e38\u89c4\uff08PAGE.COMMON.*\uff09"), @CodeItem(value="PAGE", text="\u754c\u9762\u6587\u672c\uff08PAGE.*\uff09", realtext="\u754c\u9762\u6587\u672c\uff08PAGE.*\uff09"), @CodeItem(value="CONTROL", text="\u63a7\u4ef6\u6587\u672c\uff08CONTROL.*\uff09", realtext="\u63a7\u4ef6\u6587\u672c\uff08CONTROL.*\uff09"), @CodeItem(value="ERROR.STD", text="\u6807\u51c6\u9519\u8bef\uff08ERROR.STD.*\uff09", realtext="\u6807\u51c6\u9519\u8bef\uff08ERROR.STD.*\uff09"), @CodeItem(value="CTRL", text="\u5904\u7406\u903b\u8f91\uff08CTRL.*\uff09", realtext="\u5904\u7406\u903b\u8f91\uff08CTRL.*\uff09"), @CodeItem(value="COMMON", text="\u901a\u7528\uff08COMMON.*\uff09", realtext="\u901a\u7528\uff08COMMON.*\uff09"), @CodeItem(value="OTHER", text="\u5176\u5b83\uff08OTHER.*\uff09", realtext="\u5176\u5b83\uff08OTHER.*\uff09")})
public class SysLanResTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DE_LNAME = "DE.LNAME";
    public static final String DEF_LNAME = "DEF.LNAME";
    public static final String CL_ITEM_LNAME = "CL.ITEM.LNAME";
    public static final String CL_ITEM_TOOLTIP = "CL.ITEM.TOOLTIP";
    public static final String TBB_TEXT = "TBB.TEXT";
    public static final String TBB_TOOLTIP = "TBB.TOOLTIP";
    public static final String MENUITEM_CAPTION = "MENUITEM.CAPTION";
    public static final String PAGE_HEADER = "PAGE.HEADER";
    public static final String PAGE_COMMON = "PAGE.COMMON";
    public static final String PAGE = "PAGE";
    public static final String CONTROL = "CONTROL";
    public static final String ERROR_STD = "ERROR.STD";
    public static final String CTRL = "CTRL";
    public static final String COMMON = "COMMON";
    public static final String OTHER = "OTHER";

    public SysLanResTypeCodeListModel() {
        this.initAnnotation(SysLanResTypeCodeListModel.class);
        this.setUserData2("LanResType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysLanResTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysLanResTypeCodeListModel");
    }
}


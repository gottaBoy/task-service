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

@CodeList(id="356149e2e57a808c6914f744e02c694f", name="\u6570\u636e\u6e90\u8fde\u63a5", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\u8fde\u63a5", realtext="\u9ed8\u8ba4\u8fde\u63a5"), @CodeItem(value="DB2", text="\u6570\u636e\u8fde\u63a52", realtext="\u6570\u636e\u8fde\u63a52"), @CodeItem(value="DB3", text="\u6570\u636e\u8fde\u63a53", realtext="\u6570\u636e\u8fde\u63a53"), @CodeItem(value="DB4", text="\u6570\u636e\u8fde\u63a54", realtext="\u6570\u636e\u8fde\u63a54"), @CodeItem(value="DB5", text="\u6570\u636e\u8fde\u63a55", realtext="\u6570\u636e\u8fde\u63a55"), @CodeItem(value="DB6", text="\u6570\u636e\u8fde\u63a56", realtext="\u6570\u636e\u8fde\u63a56"), @CodeItem(value="DB7", text="\u6570\u636e\u8fde\u63a57", realtext="\u6570\u636e\u8fde\u63a57"), @CodeItem(value="DB8", text="\u6570\u636e\u8fde\u63a58", realtext="\u6570\u636e\u8fde\u63a58"), @CodeItem(value="DB9", text="\u6570\u636e\u8fde\u63a59", realtext="\u6570\u636e\u8fde\u63a59"), @CodeItem(value="DB10", text="\u6570\u636e\u8fde\u63a510", realtext="\u6570\u636e\u8fde\u63a510"), @CodeItem(value="DB11", text="\u6570\u636e\u8fde\u63a511", realtext="\u6570\u636e\u8fde\u63a511"), @CodeItem(value="DB12", text="\u6570\u636e\u8fde\u63a512", realtext="\u6570\u636e\u8fde\u63a512")})
public class SysDeployDBModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String DB2 = "DB2";
    public static final String DB3 = "DB3";
    public static final String DB4 = "DB4";
    public static final String DB5 = "DB5";
    public static final String DB6 = "DB6";
    public static final String DB7 = "DB7";
    public static final String DB8 = "DB8";
    public static final String DB9 = "DB9";
    public static final String DB10 = "DB10";
    public static final String DB11 = "DB11";
    public static final String DB12 = "DB12";

    public SysDeployDBModeCodeListModel() {
        this.initAnnotation(SysDeployDBModeCodeListModel.class);
        this.setUserData2("DataSourceLink");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDeployDBModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDeployDBModeCodeListModel");
    }
}


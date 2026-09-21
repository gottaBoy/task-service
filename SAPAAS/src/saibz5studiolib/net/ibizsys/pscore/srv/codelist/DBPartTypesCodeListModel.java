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

@CodeList(id="72EE3124-C305-4013-B0A1-289E18339602", name="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSPORTLET", text="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6", realtext="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u95e8\u6237\u90e8\u4ef6\u6210\u5458\uff0c\u6302\u8f7d\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="CONTAINER", text="\u5e03\u5c40\u5bb9\u5668", realtext="\u5e03\u5c40\u5bb9\u5668", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u57fa\u672c\u5e03\u5c40\u9762\u677f\uff0c\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="RAWITEM", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u76f4\u63a5\u5185\u5bb9\u9879\uff0c\u8f93\u51fa\u6587\u672c\u6216\u56fe\u7247\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458")})
public class DBPartTypesCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSPORTLET = "SYSPORTLET";
    public static final String CONTAINER = "CONTAINER";
    public static final String RAWITEM = "RAWITEM";

    public DBPartTypesCodeListModel() {
        this.initAnnotation(DBPartTypesCodeListModel.class);
        this.setUserData2("DashboardPartType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBPartTypesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBPartTypesCodeListModel");
    }
}


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

@CodeList(id="68c2e2e49bf5bd4b843a637fb7e03c3d", name="\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSPORTLET", text="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6", realtext="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u95e8\u6237\u90e8\u4ef6\u6210\u5458\uff0c\u6302\u8f7d\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="APPMENU", text="\u5feb\u6377\u83dc\u5355\u680f", realtext="\u5feb\u6377\u83dc\u5355\u680f", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u89c6\u56fe\u6210\u5458\uff0c\u6302\u8f7d\u5e94\u7528\u89c6\u56fe\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="APPVIEW", text="\u5e94\u7528\u89c6\u56fe", realtext="\u5e94\u7528\u89c6\u56fe", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u5e94\u7528\u83dc\u5355\u6210\u5458\uff0c\u6302\u8f7d\u5e94\u7528\u83dc\u5355\u90e8\u4ef6\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="CONTAINER", text="\u5e03\u5c40\u5bb9\u5668", realtext="\u5e03\u5c40\u5bb9\u5668", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u57fa\u672c\u5e03\u5c40\u9762\u677f\uff0c\u652f\u6301\u5b50\u6210\u5458"), @CodeItem(value="RAWITEM", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9", userdata="\u6570\u636e\u770b\u677f\u4e2d\u7684\u76f4\u63a5\u5185\u5bb9\u9879\uff0c\u8f93\u51fa\u6587\u672c\u6216\u56fe\u7247\u3002\u4e0d\u652f\u6301\u5b50\u6210\u5458")})
public class AppPVPartTypesCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSPORTLET = "SYSPORTLET";
    public static final String APPMENU = "APPMENU";
    public static final String APPVIEW = "APPVIEW";
    public static final String CONTAINER = "CONTAINER";
    public static final String RAWITEM = "RAWITEM";

    public AppPVPartTypesCodeListModel() {
        this.initAnnotation(AppPVPartTypesCodeListModel.class);
        this.setUserData2("AppDashboardPartType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppPVPartTypesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppPVPartTypesCodeListModel");
    }
}


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

@CodeList(id="fa580f9b849761458dc2c5ea17044118", name="\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPSTARTVIEW", text="\u5e94\u7528\u542f\u52a8\u89c6\u56fe", realtext="\u5e94\u7528\u542f\u52a8\u89c6\u56fe"), @CodeItem(value="APPWELCOMEVIEW", text="\u5e94\u7528\u6b22\u8fce\u89c6\u56fe", realtext="\u5e94\u7528\u6b22\u8fce\u89c6\u56fe"), @CodeItem(value="APPLOGINVIEW", text="\u5e94\u7528\u767b\u5f55\u89c6\u56fe", realtext="\u5e94\u7528\u767b\u5f55\u89c6\u56fe"), @CodeItem(value="APPLOGOUTVIEW", text="\u5e94\u7528\u6ce8\u9500\u89c6\u56fe", realtext="\u5e94\u7528\u6ce8\u9500\u89c6\u56fe"), @CodeItem(value="APPFILEUPLOADVIEW", text="\u5e94\u7528\u6587\u4ef6\u4e0a\u4f20\u89c6\u56fe", realtext="\u5e94\u7528\u6587\u4ef6\u4e0a\u4f20\u89c6\u56fe"), @CodeItem(value="APPPICUPLOADVIEW", text="\u5e94\u7528\u56fe\u7247\u4e0a\u4f20\u89c6\u56fe", realtext="\u5e94\u7528\u56fe\u7247\u4e0a\u4f20\u89c6\u56fe"), @CodeItem(value="APPDATAUPLOADVIEW", text="\u5e94\u7528\u6570\u636e\u5bfc\u5165\u89c6\u56fe", realtext="\u5e94\u7528\u6570\u636e\u5bfc\u5165\u89c6\u56fe"), @CodeItem(value="APPFUNCPICKUPVIEW", text="\u5e94\u7528\u529f\u80fd\u9009\u62e9\u89c6\u56fe", realtext="\u5e94\u7528\u529f\u80fd\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="APPERRORVIEW", text="\u5e94\u7528\u9519\u8bef\u663e\u793a\u89c6\u56fe", realtext="\u5e94\u7528\u9519\u8bef\u663e\u793a\u89c6\u56fe"), @CodeItem(value="APPWFSTEPDATAVIEW", text="\u5e94\u7528\u6d41\u7a0b\u5904\u7406\u8bb0\u5f55\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u5904\u7406\u8bb0\u5f55\u89c6\u56fe"), @CodeItem(value="APPWFSTEPACTORVIEW", text="\u5e94\u7528\u6d41\u7a0b\u5f53\u524d\u5904\u7406\u4eba\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u5f53\u524d\u5904\u7406\u4eba\u89c6\u56fe"), @CodeItem(value="APPWFSTEPTRACEVIEW", text="\u5e94\u7528\u6d41\u7a0b\u8ddf\u8e2a\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u8ddf\u8e2a\u89c6\u56fe"), @CodeItem(value="APPWFSENDBACKVIEW", text="\u5e94\u7528\u6d41\u7a0b\u56de\u9000\u64cd\u4f5c\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u56de\u9000\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="APPWFSUPPLYINFOVIEW", text="\u5e94\u7528\u6d41\u7a0b\u8865\u5145\u4fe1\u606f\u64cd\u4f5c\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u8865\u5145\u4fe1\u606f\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="APPWFADDSTEPBEFOREVIEW", text="\u5e94\u7528\u6d41\u7a0b\u524d\u52a0\u7b7e\u64cd\u4f5c\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u524d\u52a0\u7b7e\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="APPWFADDSTEPAFTERVIEW", text="\u5e94\u7528\u6d41\u7a0b\u540e\u52a0\u7b7e\u64cd\u4f5c\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u540e\u52a0\u7b7e\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="APPWFTAKEADVICEVIEW", text="\u5e94\u7528\u6d41\u7a0b\u5f81\u6c42\u610f\u89c1\u64cd\u4f5c\u89c6\u56fe", realtext="\u5e94\u7528\u6d41\u7a0b\u5f81\u6c42\u610f\u89c1\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="APPWFREDIRECTVIEW", text="\u5e94\u7528\u5168\u5c40\u6d41\u7a0b\u5de5\u4f5c\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u5e94\u7528\u5168\u5c40\u6d41\u7a0b\u5de5\u4f5c\u91cd\u5b9a\u5411\u89c6\u56fe"), @CodeItem(value="APPREDIRECTVIEW", text="\u5e94\u7528\u5168\u5c40\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u5e94\u7528\u5168\u5c40\u91cd\u5b9a\u5411\u89c6\u56fe")})
public class AppUtilViewsCodeListModel
extends StaticCodeListModelBase {
    public static final String APPSTARTVIEW = "APPSTARTVIEW";
    public static final String APPWELCOMEVIEW = "APPWELCOMEVIEW";
    public static final String APPLOGINVIEW = "APPLOGINVIEW";
    public static final String APPLOGOUTVIEW = "APPLOGOUTVIEW";
    public static final String APPFILEUPLOADVIEW = "APPFILEUPLOADVIEW";
    public static final String APPPICUPLOADVIEW = "APPPICUPLOADVIEW";
    public static final String APPDATAUPLOADVIEW = "APPDATAUPLOADVIEW";
    public static final String APPFUNCPICKUPVIEW = "APPFUNCPICKUPVIEW";
    public static final String APPERRORVIEW = "APPERRORVIEW";
    public static final String APPWFSTEPDATAVIEW = "APPWFSTEPDATAVIEW";
    public static final String APPWFSTEPACTORVIEW = "APPWFSTEPACTORVIEW";
    public static final String APPWFSTEPTRACEVIEW = "APPWFSTEPTRACEVIEW";
    public static final String APPWFSENDBACKVIEW = "APPWFSENDBACKVIEW";
    public static final String APPWFSUPPLYINFOVIEW = "APPWFSUPPLYINFOVIEW";
    public static final String APPWFADDSTEPBEFOREVIEW = "APPWFADDSTEPBEFOREVIEW";
    public static final String APPWFADDSTEPAFTERVIEW = "APPWFADDSTEPAFTERVIEW";
    public static final String APPWFTAKEADVICEVIEW = "APPWFTAKEADVICEVIEW";
    public static final String APPWFREDIRECTVIEW = "APPWFREDIRECTVIEW";
    public static final String APPREDIRECTVIEW = "APPREDIRECTVIEW";

    public AppUtilViewsCodeListModel() {
        this.initAnnotation(AppUtilViewsCodeListModel.class);
        this.setUserData2("AppUtilViewType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilViewsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilViewsCodeListModel");
    }
}


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

@CodeList(id="56096d794e604d6ed850bd5fa3a145fb", name="\u95e8\u6237\u90e8\u4ef6HTML\u5185\u5bb9\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INNER", text="\u5d4c\u5165", realtext="\u5d4c\u5165", userdata="\u8bf7\u6c42\u6307\u5b9aHTML\u8def\u5f84\uff0c\u5c06\u53cd\u9988\u7684\u5185\u5bb9\u63d2\u5165\u5230\u95e8\u6237\u90e8\u4ef6\u7684\u5185\u5bb9\u5bb9\u5668\u4e2d"), @CodeItem(value="IFRAME", text="IFrame", realtext="IFrame", userdata="\u4f7f\u7528IFrame\u6253\u5f00\u6307\u5b9a\u7684HTML\u8def\u5f84")})
public class PortletHtmlShowModeCodeListModel
extends StaticCodeListModelBase {
    public static final String INNER = "INNER";
    public static final String IFRAME = "IFRAME";

    public PortletHtmlShowModeCodeListModel() {
        this.initAnnotation(PortletHtmlShowModeCodeListModel.class);
        this.setUserData2("PortletHtmlShowMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletHtmlShowModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletHtmlShowModeCodeListModel");
    }
}


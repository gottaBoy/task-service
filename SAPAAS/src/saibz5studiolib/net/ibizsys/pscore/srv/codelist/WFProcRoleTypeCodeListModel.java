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

@CodeList(id="f1a798d3654560aa58f9b1b44e0eb5fb", name="\u6d41\u7a0b\u5904\u7406\u89d2\u8272\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WFROLE", text="\u5de5\u4f5c\u6d41\u89d2\u8272", realtext="\u5de5\u4f5c\u6d41\u89d2\u8272", userdata="\u6d41\u7a0b\u5904\u7406\u89d2\u8272\u5f15\u7528\u7cfb\u7edf\u5b9a\u4e49\u7684\u5de5\u4f5c\u6d41\u89d2\u8272"), @CodeItem(value="LASTTWOSTEPACTOR", text="\u4e0a\u4e24\u4e2a\u6b65\u9aa4\u64cd\u4f5c\u8005", realtext="\u4e0a\u4e24\u4e2a\u6b65\u9aa4\u64cd\u4f5c\u8005"), @CodeItem(value="LASTTHREESTEPACTOR", text="\u4e0a\u4e09\u4e2a\u6b65\u9aa4\u64cd\u4f5c\u8005", realtext="\u4e0a\u4e09\u4e2a\u6b65\u9aa4\u64cd\u4f5c\u8005"), @CodeItem(value="LASTSTEPACTOR", text="\u4e0a\u4e00\u6b65\u9aa4\u64cd\u4f5c\u8005", realtext="\u4e0a\u4e00\u6b65\u9aa4\u64cd\u4f5c\u8005"), @CodeItem(value="UDACTOR", text="\u5f53\u524d\u6570\u636e\u5c5e\u6027", realtext="\u5f53\u524d\u6570\u636e\u5c5e\u6027", userdata="\u6d41\u7a0b\u5904\u7406\u89d2\u8272\u4ece\u6d41\u7a0b\u6570\u636e\u7684\u6307\u5b9a\u5c5e\u6027\u4e2d\u8bfb\u53d6"), @CodeItem(value="CURACTOR", text="\u5f53\u524d\u64cd\u4f5c\u8005", realtext="\u5f53\u524d\u64cd\u4f5c\u8005")})
public class WFProcRoleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String WFROLE = "WFROLE";
    public static final String LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";
    public static final String LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";
    public static final String LASTSTEPACTOR = "LASTSTEPACTOR";
    public static final String UDACTOR = "UDACTOR";
    public static final String CURACTOR = "CURACTOR";

    public WFProcRoleTypeCodeListModel() {
        this.initAnnotation(WFProcRoleTypeCodeListModel.class);
        this.setUserData2("WFProcRoleType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcRoleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcRoleTypeCodeListModel");
    }
}


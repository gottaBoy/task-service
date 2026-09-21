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

@CodeList(id="E2597430-626A-47C3-9D28-51CD7AF83DFE", name="\u7f16\u8f91\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEEDITVIEW", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEEDITVIEW2", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DEEDITVIEW3", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09"), @CodeItem(value="DEEDITVIEW4", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09")})
public class DEEditViewTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEEDITVIEW = "DEEDITVIEW";
    public static final String DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String DEEDITVIEW3 = "DEEDITVIEW3";
    public static final String DEEDITVIEW4 = "DEEDITVIEW4";

    public DEEditViewTypeCodeListModel() {
        this.initAnnotation(DEEditViewTypeCodeListModel.class);
        this.setUserData2("DEEditViewType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEEditViewTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEEditViewTypeCodeListModel");
    }
}


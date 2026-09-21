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

@CodeList(id="092AC1C4-627A-4187-ADA9-D4A03F41BDB5", name="\u4e91\u5e73\u53f0\u6d41\u7a0b\u7f16\u8f91\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEWFEDITVIEW", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEWFEDITVIEW2", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DEWFEDITVIEW3", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09")})
public class DEWFEditViewTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String DEWFEDITVIEW2 = "DEWFEDITVIEW2";
    public static final String DEWFEDITVIEW3 = "DEWFEDITVIEW3";

    public DEWFEditViewTypeCodeListModel() {
        this.initAnnotation(DEWFEditViewTypeCodeListModel.class);
        this.setUserData2("DEWFEditViewType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEWFEditViewTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEWFEditViewTypeCodeListModel");
    }
}


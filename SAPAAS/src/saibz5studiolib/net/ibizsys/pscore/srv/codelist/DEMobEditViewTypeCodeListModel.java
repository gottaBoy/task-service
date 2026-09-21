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

@CodeList(id="B89D251B-5D85-4248-B96B-0A13A1E57A72", name="\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEMOBEDITVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEMOBEDITVIEW3", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09")})
public class DEMobEditViewTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEMOBEDITVIEW = "DEMOBEDITVIEW";
    public static final String DEMOBEDITVIEW3 = "DEMOBEDITVIEW3";

    public DEMobEditViewTypeCodeListModel() {
        this.initAnnotation(DEMobEditViewTypeCodeListModel.class);
        this.setUserData2("DEMobEditViewType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMobEditViewTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMobEditViewTypeCodeListModel");
    }
}


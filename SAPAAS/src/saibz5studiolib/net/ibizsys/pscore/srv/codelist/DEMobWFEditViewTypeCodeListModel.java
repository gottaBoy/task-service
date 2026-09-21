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

@CodeList(id="14B753F7-EAEA-4535-BBF2-1CF12A62B917", name="\u4e91\u5e73\u53f0\u79fb\u52a8\u7aef\u6d41\u7a0b\u7f16\u8f91\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEMOBWFEDITVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEMOBWFEDITVIEW3", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09")})
public class DEMobWFEditViewTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEMOBWFEDITVIEW = "DEMOBWFEDITVIEW";
    public static final String DEMOBWFEDITVIEW3 = "DEMOBWFEDITVIEW3";

    public DEMobWFEditViewTypeCodeListModel() {
        this.initAnnotation(DEMobWFEditViewTypeCodeListModel.class);
        this.setUserData2("DEMobWFEditViewType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMobWFEditViewTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMobWFEditViewTypeCodeListModel");
    }
}


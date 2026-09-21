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

@CodeList(id="c49e867a5b1f4905b57f0b868845ee6f", name="\u4e91\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DER1N", text="1:N\u5173\u7cfb", realtext="1:N\u5173\u7cfb", iconpath="default/psdedritem/icon_dritemtype_der1n.png", iconpathx="default/psdedritem/icon_dritemtype_der1n@{0}x.png", userdata="\u5173\u7cfb\u754c\u9762\u662f\u5f53\u524d\u5b9e\u4f53\u3010\u4e00\u5bf9\u591a\u3011\u5173\u7cfb\u7684\u4ece\u5b9e\u4f53\u754c\u9762"), @CodeItem(value="SYSDER1N", text="\u7cfb\u7edf1:N\u5173\u7cfb", realtext="\u7cfb\u7edf1:N\u5173\u7cfb", iconpath="default/psdedritem/icon_dritemtype_sysder1n.png", iconpathx="default/psdedritem/icon_dritemtype_sysder1n@{0}x.png", userdata="\u5173\u7cfb\u754c\u9762\u662f\u5f53\u524d\u7cfb\u7edf\u3010\u4e00\u5bf9\u591a\u3011\u5173\u7cfb\u7684\u4ece\u5b9e\u4f53\u754c\u9762\uff0c\u4e00\u822c\u6307\u5b9a\u5173\u7cfb\u7684\u4e3b\u5b9e\u4f53\u4e0e\u5f53\u524d\u5b9e\u4f53\u5b58\u5728\u3010\u4e00\u5bf9\u4e00\u3011\u7684\u5173\u7cfb"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u5173\u7cfb", realtext="\u81ea\u5b9a\u4e49\u5173\u7cfb", iconpath="default/psdedritem/icon_dritemtype_custom.png", iconpathx="default/psdedritem/icon_dritemtype_custom@{0}x.png", userdata="\u5173\u7cfb\u754c\u9762\u4e0e\u5f53\u524d\u5b9e\u4f53\u5e76\u4e0d\u5b58\u5728\u663e\u793a\u7684\u5173\u7cfb\uff0c\u4e00\u822c\u7528\u4e8e\u5448\u73b0\u7cfb\u7edf\u7ea7\u522b\u7684\u6570\u636e\uff0c\u7531\u754c\u9762\u81ea\u884c\u89e3\u91ca\u5173\u7cfb\u5448\u73b0\uff0c\u5982\u6d41\u7a0b\u5b9e\u4f8b\u6b65\u9aa4\u754c\u9762\u7b49")})
public class DEDRItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DER1N = "DER1N";
    public static final String SYSDER1N = "SYSDER1N";
    public static final String CUSTOM = "CUSTOM";

    public DEDRItemTypeCodeListModel() {
        this.initAnnotation(DEDRItemTypeCodeListModel.class);
        this.setUserData2("DEDRItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDRItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDRItemTypeCodeListModel");
    }
}


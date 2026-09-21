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

@CodeList(id="1e0ff89f40df862465d8b9316baa75a6", name="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u7f13\u5b58\u8303\u56f4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GLOBAL", text="\u5168\u5c40", realtext="\u5168\u5c40", userdata="\u5168\u5c40\u4f7f\u7528\u540c\u4e00\u4e2a\u7f13\u5b58"), @CodeItem(value="ORG", text="\u7ec4\u7ec7", realtext="\u7ec4\u7ec7", userdata="\u5f53\u524d\u7ec4\u7ec7\u4f7f\u7528\u540c\u4e00\u4e2a\u7f13\u5b58"), @CodeItem(value="USER", text="\u7528\u6237", realtext="\u7528\u6237", userdata="\u6bcf\u4e2a\u7528\u6237\u7ef4\u6301\u81ea\u5df1\u4e13\u6709\u7684\u7f13\u5b58")})
public class DEDSCacheScopeCodeListModel
extends StaticCodeListModelBase {
    public static final String GLOBAL = "GLOBAL";
    public static final String ORG = "ORG";
    public static final String USER = "USER";

    public DEDSCacheScopeCodeListModel() {
        this.initAnnotation(DEDSCacheScopeCodeListModel.class);
        this.setUserData2("DECacheScope");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDSCacheScopeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDSCacheScopeCodeListModel");
    }
}


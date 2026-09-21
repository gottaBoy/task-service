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

@CodeList(id="b559fe8fd84a6c1e406ad3010c4739c6", name="\u90e8\u4ef6\u540e\u53f0\u5904\u7406\u5bf9\u8c61\u7f13\u5b58\u8303\u56f4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u7cfb\u7edf\u5168\u5c40", realtext="\u7cfb\u7edf\u5168\u5c40", userdata="\u7cfb\u7edf\u5168\u5c40\u7f13\u5b58\u754c\u9762\u5904\u7406\u54cd\u5e94\u5185\u5bb9"), @CodeItem(value="2", text="\u7ec4\u7ec7\u673a\u6784\u5168\u5c40", realtext="\u7ec4\u7ec7\u673a\u6784\u5168\u5c40", userdata="\u4ee5\u5f53\u524d\u7528\u6237\u8eab\u4efd\u7ec4\u7ec7\u673a\u6784\u7ef4\u5ea6\u7f13\u5b58\u754c\u9762\u5904\u7406\u54cd\u5e94\u5185\u5bb9"), @CodeItem(value="3", text="\u7528\u6237\u5168\u5c40", realtext="\u7528\u6237\u5168\u5c40", userdata="\u4ee5\u5f53\u524d\u7528\u6237\u8eab\u4efd\u7ef4\u5ea6\u7f13\u5b58\u754c\u9762\u5904\u7406\u54cd\u5e94\u5185\u5bb9"), @CodeItem(value="4", text="\u5e94\u7528\u5168\u5c40", realtext="\u5e94\u7528\u5168\u5c40", userdata="\u5e94\u7528\u5168\u5c40\u7f13\u5b58\u754c\u9762\u5904\u7406\u54cd\u5e94\u5185\u5bb9")})
public class ACCacheScopeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer GLOBAL = 1;
    public static final int INT_GLOBAL = 1;
    public static final Integer ORG = 2;
    public static final int INT_ORG = 2;
    public static final Integer USER = 3;
    public static final int INT_USER = 3;
    public static final Integer APP = 4;
    public static final int INT_APP = 4;

    public ACCacheScopeCodeListModel() {
        this.initAnnotation(ACCacheScopeCodeListModel.class);
        this.setUserData2("CtrlHandlerCacheScope");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ACCacheScopeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ACCacheScopeCodeListModel");
    }
}


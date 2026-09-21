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

@CodeList(id="dfb24a17c9fe7491bc3420007dff951a", name="\u4e91\u5e73\u53f0\u90e8\u670d\u52a1\u63a5\u53e3\u5904\u7406\u5bf9\u8c61\uff08\u5ba2\u6237\u7aef\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SAASADMIN", text="SaaS\u5e94\u7528\u7ba1\u7406\u63a5\u53e3", realtext="SaaS\u5e94\u7528\u7ba1\u7406\u63a5\u53e3"), @CodeItem(value="WFSERVICE", text="\u5de5\u4f5c\u6d41\u5f15\u64ce\u670d\u52a1\u63a5\u53e3", realtext="\u5de5\u4f5c\u6d41\u5f15\u64ce\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="WFCALLBACK", text="\u5de5\u4f5c\u6d41\u5f15\u64ce\u56de\u8c03\u63a5\u53e3", realtext="\u5de5\u4f5c\u6d41\u5f15\u64ce\u56de\u8c03\u63a5\u53e3"), @CodeItem(value="USERAUTH", text="\u7528\u6237\u6388\u6743\u670d\u52a1\u63a5\u53e3", realtext="\u7528\u6237\u6388\u6743\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="ORGSERVICE", text="\u7ec4\u7ec7\u7ba1\u7406\u670d\u52a1\u63a5\u53e3", realtext="\u7ec4\u7ec7\u7ba1\u7406\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="ORGCALLBACK", text="\u7ec4\u7ec7\u670d\u52a1\u56de\u8c03\u63a5\u53e3", realtext="\u7ec4\u7ec7\u670d\u52a1\u56de\u8c03\u63a5\u53e3"), @CodeItem(value="CORESERVICE", text="SaaS\u6838\u5fc3\u670d\u52a1\u63a5\u53e3", realtext="SaaS\u6838\u5fc3\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class PredefinedServiceAPIClientCodeListModel
extends StaticCodeListModelBase {
    public static final String SAASADMIN = "SAASADMIN";
    public static final String WFSERVICE = "WFSERVICE";
    public static final String WFCALLBACK = "WFCALLBACK";
    public static final String USERAUTH = "USERAUTH";
    public static final String ORGSERVICE = "ORGSERVICE";
    public static final String ORGCALLBACK = "ORGCALLBACK";
    public static final String CORESERVICE = "CORESERVICE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public PredefinedServiceAPIClientCodeListModel() {
        this.initAnnotation(PredefinedServiceAPIClientCodeListModel.class);
        this.setUserData2("PredefinedServiceAPIClient");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedServiceAPIClientCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedServiceAPIClientCodeListModel");
    }
}


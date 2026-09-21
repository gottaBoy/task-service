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

@CodeList(id="2ae6358212a6f25f86d454c4d7161abd", name="\u5e94\u7528\u529f\u80fd\u6253\u5f00\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="INDEXVIEWTAB", text="\u5e94\u7528\u5bb9\u5668\u5206\u9875", realtext="\u5e94\u7528\u5bb9\u5668\u5206\u9875"), @CodeItem(value="INDEXVIEWPOPUP", text="\u5e94\u7528\u5bb9\u5668\u5f39\u51fa", realtext="\u5e94\u7528\u5bb9\u5668\u5f39\u51fa"), @CodeItem(value="INDEXVIEWPOPUPMODAL", text="\u5e94\u7528\u5bb9\u5668\u5f39\u51fa\uff08\u6a21\u5f0f\uff09", realtext="\u5e94\u7528\u5bb9\u5668\u5f39\u51fa\uff08\u6a21\u5f0f\uff09"), @CodeItem(value="HTMLPOPUP", text="\u72ec\u7acb\u7f51\u9875\u5f39\u51fa", realtext="\u72ec\u7acb\u7f51\u9875\u5f39\u51fa"), @CodeItem(value="TOP", text="\u9876\u7ea7\u9875\u9762", realtext="\u9876\u7ea7\u9875\u9762")})
public class AppFuncOpenModeCodeListModel
extends StaticCodeListModelBase {
    public static final String INDEXVIEWTAB = "INDEXVIEWTAB";
    public static final String INDEXVIEWPOPUP = "INDEXVIEWPOPUP";
    public static final String INDEXVIEWPOPUPMODAL = "INDEXVIEWPOPUPMODAL";
    public static final String HTMLPOPUP = "HTMLPOPUP";
    public static final String TOP = "TOP";

    public AppFuncOpenModeCodeListModel() {
        this.initAnnotation(AppFuncOpenModeCodeListModel.class);
        this.setUserData2("AppFuncOpenMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppFuncOpenModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppFuncOpenModeCodeListModel");
    }
}


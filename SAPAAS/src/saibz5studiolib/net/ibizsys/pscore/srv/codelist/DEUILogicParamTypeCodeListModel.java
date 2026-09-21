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

@CodeList(id="46238C42-CA26-4079-A9FC-727994D18F52", name="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u53d8\u91cf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u6570\u636e\u5bf9\u8c61\u53d8\u91cf", realtext="\u6570\u636e\u5bf9\u8c61\u53d8\u91cf"), @CodeItem(value="4", text="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de", realtext="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de"), @CodeItem(value="5", text="\u8fc7\u6ee4\u5668", realtext="\u8fc7\u6ee4\u5668"), @CodeItem(value="6", text="\u6570\u636e\u5bf9\u8c61\u5217\u8868\u53d8\u91cf", realtext="\u6570\u636e\u5bf9\u8c61\u5217\u8868\u53d8\u91cf"), @CodeItem(value="12", text="\u6570\u636e\u5bf9\u8c61\u5b57\u5178\u53d8\u91cf", realtext="\u6570\u636e\u5bf9\u8c61\u5b57\u5178\u53d8\u91cf"), @CodeItem(value="7", text="\u5206\u9875\u67e5\u8be2\u7ed3\u679c\u53d8\u91cf", realtext="\u5206\u9875\u67e5\u8be2\u7ed3\u679c\u53d8\u91cf"), @CodeItem(value="10", text="\u7b80\u5355\u6570\u636e\u53d8\u91cf", realtext="\u7b80\u5355\u6570\u636e\u53d8\u91cf"), @CodeItem(value="11", text="\u7b80\u5355\u6570\u636e\u5217\u8868\u53d8\u91cf", realtext="\u7b80\u5355\u6570\u636e\u5217\u8868\u53d8\u91cf"), @CodeItem(value="24", text="\u5e94\u7528\u4e0a\u4e0b\u6587\u53d8\u91cf", realtext="\u5e94\u7528\u4e0a\u4e0b\u6587\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u4f1a\u8bdd\u5e94\u7528\u4e0a\u4e0b\u6587\u7684\u53d8\u91cf"), @CodeItem(value="25", text="\u89c6\u56fe\u8def\u7531\u53c2\u6570\u53d8\u91cf", realtext="\u89c6\u56fe\u8def\u7531\u53c2\u6570\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u5bfc\u822a\u89c6\u56fe\u53c2\u6570\u53d8\u91cf"), @CodeItem(value="26", text="\u89c6\u56fe\u5bfc\u822a\u6570\u636e\u53d8\u91cf", realtext="\u89c6\u56fe\u5bfc\u822a\u6570\u636e\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u89c6\u56fe\u7684\u5bfc\u822a\u6570\u636e\u53c2\u6570\u53d8\u91cf"), @CodeItem(value="27", text="\u5e94\u7528\u5168\u5c40\u53d8\u91cf", realtext="\u5e94\u7528\u5168\u5c40\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5230\u5f53\u524d\u5e94\u7528\u7684\u5168\u5c40\u5171\u4eab\u53d8\u91cf\uff0c\u53ef\u8fdb\u4e00\u6b65\u6307\u5b9a\u53c2\u6570\u6807\u8bb0"), @CodeItem(value="28", text="\u8def\u7531\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", realtext="\u8def\u7531\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u9876\u7ea7\u89c6\u56fe\uff08\u8def\u7531\u6216\u5f39\u7a97\u6a21\u5f0f\uff09\u7684\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf\uff0c\u53ef\u8fdb\u4e00\u6b65\u6307\u5b9a\u53c2\u6570\u6807\u8bb0"), @CodeItem(value="29", text="\u5f53\u524d\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", realtext="\u5f53\u524d\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u89c6\u56fe\uff08\u4ec5\u5728\u5f53\u524d\u89c6\u56fe\u8303\u56f4\uff09\u7684\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf\uff0c\u53ef\u8fdb\u4e00\u6b65\u6307\u5b9a\u53c2\u6570\u6807\u8bb0"), @CodeItem(value="1", text="\u4f1a\u8bdd\u53d8\u91cf", realtext="\u4f1a\u8bdd\u53d8\u91cf", userdata="\u5f53\u524d\u64cd\u4f5c\u4f1a\u8bdd\u53d8\u91cf\u5bf9\u8c61\uff0c\u652f\u6301\u540c\u4e00\u64cd\u4f5c\u4f1a\u8bdd\u591a\u4e2a\u903b\u8f91\u4e4b\u95f4\u7684\u53d8\u91cf\u5171\u4eab"), @CodeItem(value="2", text="\u73af\u5883\u53d8\u91cf", realtext="\u73af\u5883\u53d8\u91cf", userdata="\u5f53\u524d\u7684\u73af\u5883\u53d8\u91cf\u5bf9\u8c61"), @CodeItem(value="20", text="\u5f53\u524d\u89c6\u56fe\u5bf9\u8c61", realtext="\u5f53\u524d\u89c6\u56fe\u5bf9\u8c61", userdata="\u6307\u5b9a\u5f53\u524d\u6240\u5728\u7684\u89c6\u56fe\u5bf9\u8c61\u53d8\u91cf"), @CodeItem(value="21", text="\u5f53\u524d\u5bb9\u5668\u5bf9\u8c61", realtext="\u5f53\u524d\u5bb9\u5668\u5bf9\u8c61", userdata="\u6307\u5b9a\u5f53\u524d\u6240\u5728\u7684\u90e8\u4ef6\u5bb9\u5668\u5bf9\u8c61\u53d8\u91cf"), @CodeItem(value="22", text="\u5f53\u524d\u90e8\u4ef6\u5bf9\u8c61", realtext="\u5f53\u524d\u90e8\u4ef6\u5bf9\u8c61", userdata="\u6307\u5b9a\u5f53\u524d\u6240\u5728\u7684\u90e8\u4ef6\u5bf9\u8c61\u53d8\u91cf"), @CodeItem(value="23", text="\u6307\u5b9a\u90e8\u4ef6\u5bf9\u8c61", realtext="\u6307\u5b9a\u90e8\u4ef6\u5bf9\u8c61", userdata="\u6307\u5b9a\u540d\u79f0\u7684\u90e8\u4ef6\u5bf9\u8c61\u53d8\u91cf"), @CodeItem(value="30", text="\u5f53\u524d\u5e94\u7528\u5bf9\u8c61", realtext="\u5f53\u524d\u5e94\u7528\u5bf9\u8c61", userdata="\u6307\u5b9a\u5f53\u524d\u5e94\u7528\u5bf9\u8c61")})
public class DEUILogicParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer COMMON = 0;
    public static final int INT_COMMON = 0;
    public static final Integer LASTRETURN = 4;
    public static final int INT_LASTRETURN = 4;
    public static final Integer FILTER = 5;
    public static final int INT_FILTER = 5;
    public static final Integer ENTITYLIST = 6;
    public static final int INT_ENTITYLIST = 6;
    public static final Integer ENTITYMAP = 12;
    public static final int INT_ENTITYMAP = 12;
    public static final Integer PAGE = 7;
    public static final int INT_PAGE = 7;
    public static final Integer SIMPLE = 10;
    public static final int INT_SIMPLE = 10;
    public static final Integer SIMPLELIST = 11;
    public static final int INT_SIMPLELIST = 11;
    public static final Integer CONTEXT = 24;
    public static final int INT_CONTEXT = 24;
    public static final Integer VIEWNAVPARAM = 25;
    public static final int INT_VIEWNAVPARAM = 25;
    public static final Integer VIEWNAVDATAPARAM = 26;
    public static final int INT_VIEWNAVDATAPARAM = 26;
    public static final Integer APPGLOBALPARAM = 27;
    public static final int INT_APPGLOBALPARAM = 27;
    public static final Integer ROUTEVIEWSESSIONPARAM = 28;
    public static final int INT_ROUTEVIEWSESSIONPARAM = 28;
    public static final Integer VIEWSESSIONPARAM = 29;
    public static final int INT_VIEWSESSIONPARAM = 29;
    public static final Integer SESSION = 1;
    public static final int INT_SESSION = 1;
    public static final Integer ENV = 2;
    public static final int INT_ENV = 2;
    public static final Integer VIEW = 20;
    public static final int INT_VIEW = 20;
    public static final Integer CONTAINER = 21;
    public static final int INT_CONTAINER = 21;
    public static final Integer CTRL = 22;
    public static final int INT_CTRL = 22;
    public static final Integer SOMECTRL = 23;
    public static final int INT_SOMECTRL = 23;
    public static final Integer APP = 30;
    public static final int INT_APP = 30;

    public DEUILogicParamTypeCodeListModel() {
        this.initAnnotation(DEUILogicParamTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUILogicParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUILogicParamTypeCodeListModel");
    }
}


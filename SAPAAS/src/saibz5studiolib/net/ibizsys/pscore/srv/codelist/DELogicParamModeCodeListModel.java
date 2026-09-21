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

@CodeList(id="4992933d3148e070f28b61dd03ce0dd0", name="\u5b9e\u4f53\u903b\u8f91\u53d8\u91cf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u6570\u636e\u5bf9\u8c61\u53d8\u91cf", realtext="\u6570\u636e\u5bf9\u8c61\u53d8\u91cf"), @CodeItem(value="1", text="\u4f1a\u8bdd\u53d8\u91cf", realtext="\u4f1a\u8bdd\u53d8\u91cf", userdata="\u5f53\u524d\u64cd\u4f5c\u4f1a\u8bdd\u53d8\u91cf\u5bf9\u8c61\uff0c\u652f\u6301\u540c\u4e00\u64cd\u4f5c\u4f1a\u8bdd\u591a\u4e2a\u903b\u8f91\u4e4b\u95f4\u7684\u53d8\u91cf\u5171\u4eab"), @CodeItem(value="2", text="\u73af\u5883\u53d8\u91cf", realtext="\u73af\u5883\u53d8\u91cf", userdata="\u5f53\u524d\u7684\u73af\u5883\u53d8\u91cf\u5bf9\u8c61"), @CodeItem(value="3", text="\u6700\u540e\u6570\u636e\u53d8\u91cf", realtext="\u6700\u540e\u6570\u636e\u53d8\u91cf", userdata="\u64cd\u4f5c\u4e4b\u524d\u7684\u539f\u6709\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="4", text="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de", realtext="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de", userdata="\u5b58\u50a8\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de\u7684\u7ed3\u679c"), @CodeItem(value="5", text="\u8fc7\u6ee4\u5668", realtext="\u8fc7\u6ee4\u5668"), @CodeItem(value="6", text="\u6570\u636e\u5bf9\u8c61\u5217\u8868\u53d8\u91cf", realtext="\u6570\u636e\u5bf9\u8c61\u5217\u8868\u53d8\u91cf"), @CodeItem(value="12", text="\u6570\u636e\u5bf9\u8c61\u5b57\u5178\u53d8\u91cf", realtext="\u6570\u636e\u5bf9\u8c61\u5b57\u5178\u53d8\u91cf"), @CodeItem(value="7", text="\u5206\u9875\u67e5\u8be2\u7ed3\u679c\u53d8\u91cf", realtext="\u5206\u9875\u67e5\u8be2\u7ed3\u679c\u53d8\u91cf"), @CodeItem(value="8", text="\u6587\u4ef6\u5bf9\u8c61\u53d8\u91cf", realtext="\u6587\u4ef6\u5bf9\u8c61\u53d8\u91cf"), @CodeItem(value="9", text="\u6587\u4ef6\u5bf9\u8c61\u5217\u8868\u53d8\u91cf", realtext="\u6587\u4ef6\u5bf9\u8c61\u5217\u8868\u53d8\u91cf"), @CodeItem(value="10", text="\u7b80\u5355\u6570\u636e\u53d8\u91cf", realtext="\u7b80\u5355\u6570\u636e\u53d8\u91cf"), @CodeItem(value="11", text="\u7b80\u5355\u6570\u636e\u5217\u8868\u53d8\u91cf", realtext="\u7b80\u5355\u6570\u636e\u5217\u8868\u53d8\u91cf"), @CodeItem(value="13", text="AI\u4ea4\u8c08\u8bf7\u6c42", realtext="AI\u4ea4\u8c08\u8bf7\u6c42"), @CodeItem(value="14", text="AI\u4ea4\u8c08\u53cd\u9988", realtext="AI\u4ea4\u8c08\u53cd\u9988"), @CodeItem(value="24", text="\u5bfc\u822a\u4e0a\u4e0b\u6587\u53d8\u91cf", realtext="\u5bfc\u822a\u4e0a\u4e0b\u6587\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u4f1a\u8bdd\u5bfc\u822a\u4e0a\u4e0b\u6587\u7684\u53d8\u91cf"), @CodeItem(value="31", text="Web\u4e0a\u4e0b\u6587\u53d8\u91cf", realtext="Web\u4e0a\u4e0b\u6587\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u4f1a\u8bddWeb\u8bf7\u6c42\u4e0a\u4e0b\u6587\u7684\u53d8\u91cf"), @CodeItem(value="32", text="Web\u53cd\u9988\u53d8\u91cf", realtext="Web\u53cd\u9988\u53d8\u91cf", userdata="Web\u53cd\u9988\u53d8\u91cf\uff0c\u652f\u6301\u8bbe\u7f6e\u53cd\u9988\u4ee3\u7801\uff0c\u53cd\u9988\u5934\u53ca\u53cd\u9988\u4f53"), @CodeItem(value="27", text="\u5e94\u7528\u5168\u5c40\u53d8\u91cf\uff08\u524d\u7aef\u5904\u7406\u903b\u8f91\uff09", realtext="\u5e94\u7528\u5168\u5c40\u53d8\u91cf\uff08\u524d\u7aef\u5904\u7406\u903b\u8f91\uff09", userdata="\u7ed1\u5b9a\u5f53\u524d\u89c6\u56fe\u7684\u5bfc\u822a\u6570\u636e\u53c2\u6570\u53d8\u91cf")})
public class DELogicParamModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer COMMON = 0;
    public static final int INT_COMMON = 0;
    public static final Integer SESSION = 1;
    public static final int INT_SESSION = 1;
    public static final Integer ENV = 2;
    public static final int INT_ENV = 2;
    public static final Integer LAST = 3;
    public static final int INT_LAST = 3;
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
    public static final Integer FILE = 8;
    public static final int INT_FILE = 8;
    public static final Integer FILELIST = 9;
    public static final int INT_FILELIST = 9;
    public static final Integer SIMPLE = 10;
    public static final int INT_SIMPLE = 10;
    public static final Integer SIMPLELIST = 11;
    public static final int INT_SIMPLELIST = 11;
    public static final Integer CHATCOMPLETIONREQUEST = 13;
    public static final int INT_CHATCOMPLETIONREQUEST = 13;
    public static final Integer CHATCOMPLETIONRESULT = 14;
    public static final int INT_CHATCOMPLETIONRESULT = 14;
    public static final Integer CONTEXT = 24;
    public static final int INT_CONTEXT = 24;
    public static final Integer REQUEST = 31;
    public static final int INT_REQUEST = 31;
    public static final Integer RESPONSE = 32;
    public static final int INT_RESPONSE = 32;
    public static final Integer APPGLOBALPARAM = 27;
    public static final int INT_APPGLOBALPARAM = 27;

    public DELogicParamModeCodeListModel() {
        this.initAnnotation(DELogicParamModeCodeListModel.class);
        this.setUserData2("DELogicParamMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamModeCodeListModel");
    }
}


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

@CodeList(id="ccebccb996625189ef56c3d5359a9406", name="\u5b9e\u4f53\u5b58\u50a8\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u5b58\u50a8", realtext="\u65e0\u5b58\u50a8"), @CodeItem(value="1", text="SQL", realtext="SQL", userdata="\u4f7f\u7528\u5173\u7cfb\u6570\u636e\u5e93\u8fdb\u884c\u6570\u636e\u6301\u4e45\u5316"), @CodeItem(value="2", text="NoSQL", realtext="NoSQL", userdata="\u4f7f\u7528\u5bf9\u8c61\u6570\u636e\u5e93\u8fdb\u884c\u6570\u636e\u6301\u4e45\u5316"), @CodeItem(value="4", text="ServiceAPI", realtext="ServiceAPI", userdata="\u4f7f\u7528\u5916\u90e8\u63a5\u53e3\u8fdb\u884c\u6570\u636e\u6301\u4e45\u5316"), @CodeItem(value="9", text="SQL\uff08\u591a\u6a21\u5f0f\u652f\u6301\uff09", realtext="SQL\uff08\u591a\u6a21\u5f0f\u652f\u6301\uff09", userdata="\u652f\u6301\u591a\u6a21\u5f0f\u6570\u636e\u6301\u4e45\u5316\uff0c\u9ed8\u8ba4\u4e3a\u5173\u7cfb\u6570\u636e\u5e93"), @CodeItem(value="10", text="NoSQL\uff08\u591a\u6a21\u5f0f\u652f\u6301\uff09", realtext="NoSQL\uff08\u591a\u6a21\u5f0f\u652f\u6301\uff09", userdata="\u652f\u6301\u591a\u6a21\u5f0f\u6570\u636e\u6301\u4e45\u5316\uff0c\u9ed8\u8ba4\u4e3a\u5bf9\u8c61\u6570\u636e\u5e93"), @CodeItem(value="12", text="ServiceAPI\uff08\u591a\u6a21\u5f0f\u652f\u6301\uff09", realtext="ServiceAPI\uff08\u591a\u6a21\u5f0f\u652f\u6301\uff09", userdata="\u652f\u6301\u591a\u6a21\u5f0f\u6570\u636e\u6301\u4e45\u5316\uff0c\u9ed8\u8ba4\u4e3a\u5916\u90e8\u63a5\u53e3"), @CodeItem(value="128", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="256", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class DEStorageTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SQL = 1;
    public static final int INT_SQL = 1;
    public static final Integer NOSQL = 2;
    public static final int INT_NOSQL = 2;
    public static final Integer SERVICEAPI = 4;
    public static final int INT_SERVICEAPI = 4;
    public static final Integer SQLANDMORE = 9;
    public static final int INT_SQLANDMORE = 9;
    public static final Integer NOSQLANDMORE = 10;
    public static final int INT_NOSQLANDMORE = 10;
    public static final Integer SERVICEAPIANDMORE = 12;
    public static final int INT_SERVICEAPIANDMORE = 12;
    public static final Integer USER = 128;
    public static final int INT_USER = 128;
    public static final Integer USER2 = 256;
    public static final int INT_USER2 = 256;

    public DEStorageTypeCodeListModel() {
        this.initAnnotation(DEStorageTypeCodeListModel.class);
        this.setUserData2("DEStorageType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel");
    }
}


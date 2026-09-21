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

@CodeList(id="C05EBEB2-E349-4CB0-83E7-2E379E6AC41E", name="\u865a\u62df\u5b9e\u4f53\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u542f\u7528\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u5e38\u89c4\u591a\u7ee7\u627f\u6a21\u5f0f", realtext="\u5e38\u89c4\u591a\u7ee7\u627f\u6a21\u5f0f", userdata="\u5bf9\u591a\u4e2a\u5b9e\u4f53\u4f7f\u7528\u4e00\u5bf9\u4e00\u5173\u7cfb\u8fdb\u884c\u526a\u88c1\u7ec4\u88c5\uff0c\u5f62\u6210\u65b0\u7684\u5b9e\u4f53"), @CodeItem(value="2", text="\u9ad8\u7ea7\u7ee7\u627f\u6269\u5c55\u6a21\u5f0f", realtext="\u9ad8\u7ea7\u7ee7\u627f\u6269\u5c55\u6a21\u5f0f", userdata="\u5bf9\u6307\u5b9a\u5b9e\u4f53\u8fdb\u884c\u865a\u62df\u7ee7\u627f\uff0c\u6307\u5b9a\u5b9e\u4f53\u65e0\u9700\u8bbe\u7f6e\u4e3a\u7ee7\u627f\u4e3b\u5b9e\u4f53\uff0c\u4e00\u822c\u7528\u4e8e\u5bf9\u5b50\u7cfb\u7edf\u6216\u662f\u5916\u90e8\u670d\u52a1\u5b9e\u4f53\u7684\u529f\u80fd\u6269\u5c55"), @CodeItem(value="3", text="\u7d22\u5f15\u4e3b\u5b9e\u4f53\u6a21\u5f0f", realtext="\u7d22\u5f15\u4e3b\u5b9e\u4f53\u6a21\u5f0f", userdata="\u5c06\u591a\u4e2a\u7d22\u5f15\u4ece\u5b9e\u4f53\u8fdb\u884c\u6570\u636e\u8054\u5408\uff0c\u4ee5\u7edf\u4e00\u7684\u89c6\u89d2\u4f9b\u5916\u90e8\u4f7f\u7528"), @CodeItem(value="4", text="\u6df7\u5408\u591a\u7ee7\u627f\u6a21\u5f0f", realtext="\u6df7\u5408\u591a\u7ee7\u627f\u6a21\u5f0f", userdata="\u5f53\u524d\u5b9e\u4f53\u6df7\u5408\u591a\u4e2a\u5b9e\u4f53\u4f7f\u7528\u4e00\u5bf9\u4e00\u5173\u7cfb\u8fdb\u884c\u7ec4\u88c5\uff0c\u5f62\u6210\u65b0\u7684\u5b9e\u4f53"), @CodeItem(value="5", text="\u6df7\u5408\u591a\u7ee7\u627f\u6a21\u5f0f\uff08\u5408\u5e76\uff09", realtext="\u6df7\u5408\u591a\u7ee7\u627f\u6a21\u5f0f\uff08\u5408\u5e76\uff09", userdata="\u5f53\u524d\u5b9e\u4f53\u7ee7\u627f\u591a\u4e2a\u62bd\u8c61\u5b9e\u4f53\u7684\u5c5e\u6027\u548c\u5173\u7cfb")})
public class DEVirtualModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NO = 0;
    public static final int INT_NO = 0;
    public static final Integer MINHERIT = 1;
    public static final int INT_MINHERIT = 1;
    public static final Integer INHERIT = 2;
    public static final int INT_INHERIT = 2;
    public static final Integer INDEXMAJOR = 3;
    public static final int INT_INDEXMAJOR = 3;
    public static final Integer MIXMINHERIT = 4;
    public static final int INT_MIXMINHERIT = 4;
    public static final Integer MIXMINHERITMERGE = 5;
    public static final int INT_MIXMINHERITMERGE = 5;

    public DEVirtualModeCodeListModel() {
        this.initAnnotation(DEVirtualModeCodeListModel.class);
        this.setUserData2("DEVirtualMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEVirtualModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEVirtualModeCodeListModel");
    }
}


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

@CodeList(id="fd6db202d4cc857ed3158db85eaf5c6f", name="\u5b9e\u4f53\u884c\u4e3a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CREATE", text="\u521b\u5efa\u6570\u636e", realtext="\u521b\u5efa\u6570\u636e", userdata="\u6307\u5b9a\u884c\u4e3a\u4e3a\u5efa\u7acb\u6570\u636e\u7684\u64cd\u4f5c"), @CodeItem(value="READ", text="\u8bfb\u53d6\u6570\u636e", realtext="\u8bfb\u53d6\u6570\u636e", userdata="\u6307\u5b9a\u884c\u4e3a\u4e3a\u8bfb\u53d6\u6570\u636e\u7684\u64cd\u4f5c"), @CodeItem(value="UPDATE", text="\u66f4\u65b0\u6570\u636e", realtext="\u66f4\u65b0\u6570\u636e", userdata="\u6307\u5b9a\u884c\u4e3a\u4e3a\u66f4\u65b0\u6570\u636e\u7684\u64cd\u4f5c"), @CodeItem(value="DELETE", text="\u5220\u9664\u6570\u636e", realtext="\u5220\u9664\u6570\u636e", userdata="\u6307\u5b9a\u884c\u4e3a\u4e3a\u5220\u9664\u6570\u636e\u7684\u64cd\u4f5c"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u64cd\u4f5c", realtext="\u81ea\u5b9a\u4e49\u64cd\u4f5c", userdata="\u6307\u5b9a\u884c\u4e3a\u4e3a\u81ea\u5b9a\u4e49\u529f\u80fd\u64cd\u4f5c"), @CodeItem(value="GETDRAFT", text="\u83b7\u53d6\u8349\u7a3f", realtext="\u83b7\u53d6\u8349\u7a3f", userdata="\u6307\u5b9a\u884c\u4e3a\u4e3a\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u64cd\u4f5c"), @CodeItem(value="GETDRAFTFROM", text="\u83b7\u53d6\u8349\u7a3f\uff08\u6307\u5b9a\u6e90\u6570\u636e\uff09", realtext="\u83b7\u53d6\u8349\u7a3f\uff08\u6307\u5b9a\u6e90\u6570\u636e\uff09", userdata="\u6307\u5b9a\u884c\u4e3a\u4e3a\u4ece\u6e90\u6570\u636e\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u64cd\u4f5c"), @CodeItem(value="UNKNOWN", text="\u672a\u77e5\u64cd\u4f5c", realtext="\u672a\u77e5\u64cd\u4f5c", userdata="\u672a\u77e5\u7684\u64cd\u4f5c"), @CodeItem(value="MOVEORDER", text="\u79fb\u52a8\u4f4d\u7f6e", realtext="\u79fb\u52a8\u4f4d\u7f6e", userdata="\u79fb\u52a8\u4f4d\u7f6e"), @CodeItem(value="CHECKKEY", text="\u68c0\u67e5\u4e3b\u952e", realtext="\u68c0\u67e5\u4e3b\u952e", userdata="\u68c0\u67e5\u4e3b\u952e"), @CodeItem(value="SAVE", text="\u4fdd\u5b58\u6570\u636e", realtext="\u4fdd\u5b58\u6570\u636e", userdata="\u4fdd\u5b58\u6570\u636e\uff0c\u81ea\u52a8\u5224\u65ad\u65b0\u5efa\u6216\u66f4\u65b0"), @CodeItem(value="COPY", text="\u62f7\u8d1d\u6570\u636e", realtext="\u62f7\u8d1d\u6570\u636e", userdata="\u62f7\u8d1d\u6570\u636e\uff0c\u540c\u65f6\u62f7\u8d1d\u76f8\u5173\u6210\u5458\u6570\u636e"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DEActionModeCodeListModel
extends StaticCodeListModelBase {
    public static final String CREATE = "CREATE";
    public static final String READ = "READ";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String CUSTOM = "CUSTOM";
    public static final String GETDRAFT = "GETDRAFT";
    public static final String GETDRAFTFROM = "GETDRAFTFROM";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String MOVEORDER = "MOVEORDER";
    public static final String CHECKKEY = "CHECKKEY";
    public static final String SAVE = "SAVE";
    public static final String COPY = "COPY";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DEActionModeCodeListModel() {
        this.initAnnotation(DEActionModeCodeListModel.class);
        this.setUserData2("DEActionMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionModeCodeListModel");
    }
}


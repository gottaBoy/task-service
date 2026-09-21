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

@CodeList(id="c4e60d6c5159a694c208f85638034e8b", name="\u6570\u636e\u5e93\u503c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IGNORE", text="\u5ffd\u7565\u5904\u7406", realtext="\u5ffd\u7565\u5904\u7406"), @CodeItem(value="VERSION", text="\u7248\u672c\u53e0\u52a0", realtext="\u7248\u672c\u53e0\u52a0"), @CodeItem(value="CURDATETIME", text="\u5f53\u524d\u65e5\u671f\u65f6\u95f4", realtext="\u5f53\u524d\u65e5\u671f\u65f6\u95f4"), @CodeItem(value="CURDATE", text="\u5f53\u524d\u65e5\u671f", realtext="\u5f53\u524d\u65e5\u671f"), @CodeItem(value="VALUEFUNC", text="\u503c\u51fd\u6570", realtext="\u503c\u51fd\u6570")})
public class DBValueModeCodeListModel
extends StaticCodeListModelBase {
    public static final String IGNORE = "IGNORE";
    public static final String VERSION = "VERSION";
    public static final String CURDATETIME = "CURDATETIME";
    public static final String CURDATE = "CURDATE";
    public static final String VALUEFUNC = "VALUEFUNC";

    public DBValueModeCodeListModel() {
        this.initAnnotation(DBValueModeCodeListModel.class);
        this.setUserData2("DBValueMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBValueModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBValueModeCodeListModel");
    }
}


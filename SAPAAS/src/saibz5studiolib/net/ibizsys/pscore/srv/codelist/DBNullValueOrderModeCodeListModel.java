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

@CodeList(id="68f690608c95fd4db58fcff4ec326f97", name="\u6570\u636e\u5e93\u7a7a\u503c\u6392\u5e8f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FIRST", text="\u6700\u5148", realtext="\u6700\u5148", userdata="\u7a7a\u503c\u4f18\u5148\u4e8e\u975e\u7a7a\u503c\u8f93\u51fa"), @CodeItem(value="LAST", text="\u6700\u540e", realtext="\u6700\u540e", userdata="\u975e\u7a7a\u503c\u4f18\u5148\u4e8e\u7a7a\u503c\u8f93\u51fa")})
public class DBNullValueOrderModeCodeListModel
extends StaticCodeListModelBase {
    public static final String FIRST = "FIRST";
    public static final String LAST = "LAST";

    public DBNullValueOrderModeCodeListModel() {
        this.initAnnotation(DBNullValueOrderModeCodeListModel.class);
        this.setUserData2("DBNullValueOrderMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBNullValueOrderModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBNullValueOrderModeCodeListModel");
    }
}


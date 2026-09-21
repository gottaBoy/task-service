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

@CodeList(id="2381CAEB-72A5-4D8F-A860-FCA4268B938D", name="\u540e\u53f0\u4f5c\u4e1a\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u5f00\u59cb", realtext="\u672a\u5f00\u59cb"), @CodeItem(value="20", text="\u6267\u884c\u4e2d", realtext="\u6267\u884c\u4e2d"), @CodeItem(value="30", text="\u5df2\u6267\u884c", realtext="\u5df2\u6267\u884c"), @CodeItem(value="40", text="\u6267\u884c\u5931\u8d25", realtext="\u6267\u884c\u5931\u8d25")})
public class BackendActionStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTCREATED = 10;
    public static final int INT_NOTCREATED = 10;
    public static final Integer CREATING = 20;
    public static final int INT_CREATING = 20;
    public static final Integer CREATED = 30;
    public static final int INT_CREATED = 30;
    public static final Integer FAILED = 40;
    public static final int INT_FAILED = 40;

    public BackendActionStateCodeListModel() {
        this.initAnnotation(BackendActionStateCodeListModel.class);
        this.setUserData2("BackendActionState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel");
    }
}


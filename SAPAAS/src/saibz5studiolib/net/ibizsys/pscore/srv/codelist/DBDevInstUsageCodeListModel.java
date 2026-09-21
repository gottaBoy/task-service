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

@CodeList(id="1f58eab52ebcf1258687242006967cec", name="\u5f00\u53d1\u6570\u636e\u5e93\u4f7f\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEVELOP", text="\u5f00\u53d1\u4f7f\u7528", realtext="\u5f00\u53d1\u4f7f\u7528"), @CodeItem(value="DEPLOY", text="\u90e8\u7f72\u4f7f\u7528", realtext="\u90e8\u7f72\u4f7f\u7528"), @CodeItem(value="JIT", text="JIT\u4f7f\u7528", realtext="JIT\u4f7f\u7528")})
public class DBDevInstUsageCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVELOP = "DEVELOP";
    public static final String DEPLOY = "DEPLOY";
    public static final String JIT = "JIT";

    public DBDevInstUsageCodeListModel() {
        this.initAnnotation(DBDevInstUsageCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBDevInstUsageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBDevInstUsageCodeListModel");
    }
}


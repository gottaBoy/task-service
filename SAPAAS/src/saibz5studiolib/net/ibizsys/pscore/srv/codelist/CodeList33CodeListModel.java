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

@CodeList(id="2ffc9f2248bdb97ccef8791f2e02f1db", name="\u6570\u636e\u5e93\u7c7b\u578b\uff08\u810f\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DB2", text="DB2", realtext="DB2"), @CodeItem(value="ORACLE", text="ORACLE", realtext="ORACLE"), @CodeItem(value="MSSQL", text="MSSQLSERVER", realtext="MSSQLSERVER"), @CodeItem(value="MYSQL", text="MySQL", realtext="MySQL"), @CodeItem(value="SYBASE", text="SYBASE", realtext="SYBASE"), @CodeItem(value="INFORMIX", text="INFORMIX", realtext="INFORMIX")})
public class CodeList33CodeListModel
extends StaticCodeListModelBase {
    public static final String DB2 = "DB2";
    public static final String ORACLE = "ORACLE";
    public static final String MSSQL = "MSSQL";
    public static final String MYSQL = "MYSQL";
    public static final String SYBASE = "SYBASE";
    public static final String INFORMIX = "INFORMIX";

    public CodeList33CodeListModel() {
        this.initAnnotation(CodeList33CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeList33CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeList33CodeListModel");
    }
}


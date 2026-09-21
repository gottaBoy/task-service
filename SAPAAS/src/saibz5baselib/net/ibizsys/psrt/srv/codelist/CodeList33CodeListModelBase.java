/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="f2208088b9cb45cb566e01d78f56d2c7", name="\u6570\u636e\u5e93\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DB2", text="DB2", realtext="DB2"), @CodeItem(value="ORACLE", text="ORACLE", realtext="ORACLE"), @CodeItem(value="MSSQL", text="MSSQLSERVER", realtext="MSSQLSERVER"), @CodeItem(value="MYSQL", text="MySQL", realtext="MySQL"), @CodeItem(value="SYBASE", text="SYBASE", realtext="SYBASE"), @CodeItem(value="INFORMIX", text="INFORMIX", realtext="INFORMIX")})
public abstract class CodeList33CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DB2 = "DB2";
    public static final String ORACLE = "ORACLE";
    public static final String MSSQL = "MSSQL";
    public static final String MYSQL = "MYSQL";
    public static final String SYBASE = "SYBASE";
    public static final String INFORMIX = "INFORMIX";

    public CodeList33CodeListModelBase() {
        this.initAnnotation(CodeList33CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList33CodeListModel", this);
    }
}


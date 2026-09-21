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

@CodeList(id="4b58f4138b9f9f2a3e731e642ea226c0", name="\u6570\u636e\u5e93\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="DB2", text="DB2", realtext="DB2"), @CodeItem(value="MYSQL5", text="MySQL5", realtext="MySQL5"), @CodeItem(value="ORACLE", text="Oracle", realtext="Oracle"), @CodeItem(value="SQLSERVER", text="SqlServer", realtext="SqlServer"), @CodeItem(value="POSTGRESQL", text="PostgreSQL", realtext="PostgreSQL"), @CodeItem(value="PPAS", text="PPAS", realtext="PPAS"), @CodeItem(value="SQLITE", text="SQLite", realtext="SQLite"), @CodeItem(value="DM", text="DM", realtext="DM"), @CodeItem(value="HANA", text="HANA", realtext="HANA")})
public class DBTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DB2 = "DB2";
    public static final String MYSQL5 = "MYSQL5";
    public static final String ORACLE = "ORACLE";
    public static final String SQLSERVER = "SQLSERVER";
    public static final String POSTGRESQL = "POSTGRESQL";
    public static final String PPAS = "PPAS";
    public static final String SQLITE = "SQLITE";
    public static final String DM = "DM";
    public static final String HANA = "HANA";

    public DBTypeCodeListModel() {
        this.initAnnotation(DBTypeCodeListModel.class);
        this.setUserData2("DBType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBTypeCodeListModel");
    }
}


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

@CodeList(id="A335BC40-8D49-42A5-9087-A8749CD87732", name="\u4e91\u6570\u636e\u5e93\u7c7b\u578b\uff08\u9759\u6001\uff092", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="DB2", text="DB2", realtext="DB2"), @CodeItem(value="MySQL5", text="MySQL5", realtext="MySQL5"), @CodeItem(value="MYSQL5", text="MySQL5", realtext="MySQL5"), @CodeItem(value="Oracle", text="Oracle", realtext="Oracle"), @CodeItem(value="ORACLE", text="Oracle", realtext="Oracle"), @CodeItem(value="SqlServer", text="SqlServer", realtext="SqlServer"), @CodeItem(value="SQLSERVER", text="SqlServer", realtext="SqlServer"), @CodeItem(value="POSTGRESQL", text="PostgreSQL", realtext="PostgreSQL"), @CodeItem(value="PostgreSQL", text="PostgreSQL", realtext="PostgreSQL"), @CodeItem(value="PPAS", text="PPAS", realtext="PPAS"), @CodeItem(value="SQLITE", text="SQLite", realtext="SQLite"), @CodeItem(value="DM", text="DM", realtext="DM"), @CodeItem(value="HANA", text="HANA", realtext="HANA")})
public class DBType3CodeListModel
extends StaticCodeListModelBase {
    public static final String DB2 = "DB2";
    public static final String MYSQL5 = "MySQL5";
    public static final String MYSQL5_2 = "MYSQL5";
    public static final String ORACLE = "Oracle";
    public static final String ORACLE_2 = "ORACLE";
    public static final String SQLSERVER = "SqlServer";
    public static final String SQLSERVER_2 = "SQLSERVER";
    public static final String POSTGRESQL_2 = "POSTGRESQL";
    public static final String POSTGRESQL = "PostgreSQL";
    public static final String PPAS = "PPAS";
    public static final String SQLITE = "SQLITE";
    public static final String DM = "DM";
    public static final String HANA = "HANA";

    public DBType3CodeListModel() {
        this.initAnnotation(DBType3CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBType3CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBType3CodeListModel");
    }
}


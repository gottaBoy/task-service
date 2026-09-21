/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="0799d92cc31e56ef8cd479c62f30e1cc", name="\u6570\u636e\u5e93\u5b58\u50a8\u533a\u57df", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DBSTORAGE001", text="ORACLE\u6570\u636e\u5e93", realtext="ORACLE\u6570\u636e\u5e93"), @CodeItem(value="DBSTORAGE002", text="MSSQL \u6570\u636e\u5e93", realtext="MSSQL \u6570\u636e\u5e93"), @CodeItem(value="DBSTORAGE0022", text="ORACLE-arena\u6570\u636e\u5e93", realtext="ORACLE-arena\u6570\u636e\u5e93"), @CodeItem(value="DBSTORAGE003", text="\u6842\u6797\u94f6\u884c", realtext="\u6842\u6797\u94f6\u884c"), @CodeItem(value="DBSTORAGE004", text="ORACLE\u6570\u636e\u5e93\uff08\u57f9\u8bad\uff09", realtext="ORACLE\u6570\u636e\u5e93\uff08\u57f9\u8bad\uff09")})
public abstract class CodeList105CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DBSTORAGE001 = "DBSTORAGE001";
    public static final String DBSTORAGE002 = "DBSTORAGE002";
    public static final String DBSTORAGE0022 = "DBSTORAGE0022";
    public static final String DBSTORAGE003 = "DBSTORAGE003";
    public static final String DBSTORAGE004 = "DBSTORAGE004";

    public CodeList105CodeListModelBase() {
        this.initAnnotation(CodeList105CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel");
    }
}


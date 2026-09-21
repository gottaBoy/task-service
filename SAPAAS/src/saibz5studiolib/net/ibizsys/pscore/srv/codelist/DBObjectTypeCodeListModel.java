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

@CodeList(id="57947d48899296a511a4d188cae75a53", name="\u5e73\u53f0\u6570\u636e\u5e93\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TABLE", text="\u8868", realtext="\u8868"), @CodeItem(value="COLUMN", text="\u5217", realtext="\u5217"), @CodeItem(value="VIEW", text="\u89c6\u56fe", realtext="\u89c6\u56fe"), @CodeItem(value="FKEY", text="\u5916\u952e\u7ea6\u675f", realtext="\u5916\u952e\u7ea6\u675f"), @CodeItem(value="INDEX", text="\u6570\u636e\u5e93\u7d22\u5f15", realtext="\u6570\u636e\u5e93\u7d22\u5f15")})
public class DBObjectTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TABLE = "TABLE";
    public static final String COLUMN = "COLUMN";
    public static final String VIEW = "VIEW";
    public static final String FKEY = "FKEY";
    public static final String INDEX = "INDEX";

    public DBObjectTypeCodeListModel() {
        this.initAnnotation(DBObjectTypeCodeListModel.class);
        this.setUserData2("DBObjectType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBObjectTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBObjectTypeCodeListModel");
    }
}


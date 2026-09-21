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

@CodeList(id="57deb511fe73167614f358b6c7a4ff5f", name="\u4e91\u6570\u636e\u5e93\u8868\u7a7a\u95f4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="TABLESPACE", text="\u9ed8\u8ba4\u8868\u7a7a\u95f4", realtext="\u9ed8\u8ba4\u8868\u7a7a\u95f4"), @CodeItem(value="TABLESPACE2", text="\u8868\u7a7a\u95f42", realtext="\u8868\u7a7a\u95f42"), @CodeItem(value="TABLESPACE3", text="\u8868\u7a7a\u95f43", realtext="\u8868\u7a7a\u95f43"), @CodeItem(value="TABLESPACE4", text="\u8868\u7a7a\u95f44", realtext="\u8868\u7a7a\u95f44")})
public class DBTableSpaceCodeListModel
extends StaticCodeListModelBase {
    public static final String TABLESPACE = "TABLESPACE";
    public static final String TABLESPACE2 = "TABLESPACE2";
    public static final String TABLESPACE3 = "TABLESPACE3";
    public static final String TABLESPACE4 = "TABLESPACE4";

    public DBTableSpaceCodeListModel() {
        this.initAnnotation(DBTableSpaceCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBTableSpaceCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBTableSpaceCodeListModel");
    }
}


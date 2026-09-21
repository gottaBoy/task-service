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

@CodeList(id="2E422C05-7863-42B3-B894-76633D45FD01", name="\u6570\u636e\u5e93\u5bf9\u8c61\u540d\u79f0\u8f6c\u6362", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="UCASE", text="\u8f6c\u6362\u4e3a\u5927\u5199", realtext="\u8f6c\u6362\u4e3a\u5927\u5199"), @CodeItem(value="LCASE", text="\u8f6c\u6362\u4e3a\u5c0f\u5199", realtext="\u8f6c\u6362\u4e3a\u5c0f\u5199")})
public class DBObjNameCaseModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String UCASE = "UCASE";
    public static final String LCASE = "LCASE";

    public DBObjNameCaseModeCodeListModel() {
        this.initAnnotation(DBObjNameCaseModeCodeListModel.class);
        this.setUserData2("DBObjNameCaseMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBObjNameCaseModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBObjNameCaseModeCodeListModel");
    }
}


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

@CodeList(id="5e3013acc3a7f7c7f19d5f42a05fa42e", name="ER\u56fe\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSDATAENTITY", text="\u5b9e\u4f53", realtext="\u5b9e\u4f53"), @CodeItem(value="PSSYSDBTABLE", text="\u5173\u7cfb\u6570\u636e\u5e93\u8868", realtext="\u5173\u7cfb\u6570\u636e\u5e93\u8868"), @CodeItem(value="PSSUBSYSSADE", text="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53", realtext="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53"), @CodeItem(value="PSSYSBDTABLE", text="\u5927\u6570\u636e\u8868", realtext="\u5927\u6570\u636e\u8868"), @CodeItem(value="PSSYSSEARCHDOC", text="\u5168\u6587\u68c0\u7d22\u6587\u6863", realtext="\u5168\u6587\u68c0\u7d22\u6587\u6863"), @CodeItem(value="PSDESERVICEAPI", text="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3", realtext="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="PSAPPLOCALDE", text="\u5e94\u7528\u5b9e\u4f53", realtext="\u5e94\u7528\u5b9e\u4f53")})
public class SysERNodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSDATAENTITY = "PSDATAENTITY";
    public static final String PSSYSDBTABLE = "PSSYSDBTABLE";
    public static final String PSSUBSYSSADE = "PSSUBSYSSADE";
    public static final String PSSYSBDTABLE = "PSSYSBDTABLE";
    public static final String PSSYSSEARCHDOC = "PSSYSSEARCHDOC";
    public static final String PSDESERVICEAPI = "PSDESERVICEAPI";
    public static final String PSAPPLOCALDE = "PSAPPLOCALDE";

    public SysERNodeTypeCodeListModel() {
        this.initAnnotation(SysERNodeTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysERNodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysERNodeTypeCodeListModel");
    }
}


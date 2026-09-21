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

@CodeList(id="811feb0d0a652507b7dc00f92f43b095", name="\u5b9e\u4f53\u62a5\u8868\u5185\u5bb9\u683c\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PDF", text="PDF", realtext="PDF"), @CodeItem(value="HTML", text="HTML", realtext="HTML"), @CodeItem(value="DOCX", text="DOCX", realtext="DOCX"), @CodeItem(value="XLSX", text="XLSX", realtext="XLSX"), @CodeItem(value="JSON", text="JSON", realtext="JSON"), @CodeItem(value="XML", text="XML", realtext="XML"), @CodeItem(value="TEXT", text="TEXT", realtext="TEXT"), @CodeItem(value="MARKDOWN", text="MARKDOWN", realtext="MARKDOWN"), @CodeItem(value="WORD", text="WORD\uff08\u8fc7\u671f\uff09", realtext="WORD\uff08\u8fc7\u671f\uff09"), @CodeItem(value="EXCEL", text="EXCEL\uff08\u8fc7\u671f\uff09", realtext="EXCEL\uff08\u8fc7\u671f\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class ReportContentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PDF = "PDF";
    public static final String HTML = "HTML";
    public static final String DOCX = "DOCX";
    public static final String XLSX = "XLSX";
    public static final String JSON = "JSON";
    public static final String XML = "XML";
    public static final String TEXT = "TEXT";
    public static final String MARKDOWN = "MARKDOWN";
    public static final String WORD = "WORD";
    public static final String EXCEL = "EXCEL";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public ReportContentTypeCodeListModel() {
        this.initAnnotation(ReportContentTypeCodeListModel.class);
        this.setUserData2("ReportContentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ReportContentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ReportContentTypeCodeListModel");
    }
}


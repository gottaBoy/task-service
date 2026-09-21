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

@CodeList(id="761906D9-3B6C-4520-B7B4-B1E72DEC121B", name="\u5916\u90e8\u63a5\u53e3DTO\u5c5e\u6027\u6765\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SUBSYSSERVICEAPIDEFIELD", text="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027", realtext="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027", userdata="\u6765\u6e90\u4e8e\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027"), @CodeItem(value="SUBSYSSERVICEAPIDERS", text="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb", realtext="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb", userdata="\u6765\u6e90\u4e8e\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb")})
public class SubSysServiceAPIDTOFieldSourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SUBSYSSERVICEAPIDEFIELD = "SUBSYSSERVICEAPIDEFIELD";
    public static final String SUBSYSSERVICEAPIDERS = "SUBSYSSERVICEAPIDERS";

    public SubSysServiceAPIDTOFieldSourceTypeCodeListModel() {
        this.initAnnotation(SubSysServiceAPIDTOFieldSourceTypeCodeListModel.class);
        this.setUserData2("SubSysServiceAPIDTOFieldSourceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysServiceAPIDTOFieldSourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysServiceAPIDTOFieldSourceTypeCodeListModel");
    }
}


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

@CodeList(id="6d6e8c82c2ec4c1d3fcd64b7bc0c0523", name="\u7cfb\u7edf\u529f\u80fd\u5b9e\u4f53\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FILE", text="\u6587\u4ef6\u5b9e\u4f53", realtext="\u6587\u4ef6\u5b9e\u4f53"), @CodeItem(value="DATAAUDIT", text="\u6570\u636e\u5ba1\u8ba1\u8bb0\u5f55\u5b9e\u4f53", realtext="\u6570\u636e\u5ba1\u8ba1\u8bb0\u5f55\u5b9e\u4f53"), @CodeItem(value="DATAAUDITDETAIL", text="\u6570\u636e\u5ba1\u8ba1\u660e\u7ec6\u8bb0\u5f55\u5b9e\u4f53", realtext="\u6570\u636e\u5ba1\u8ba1\u660e\u7ec6\u8bb0\u5f55\u5b9e\u4f53"), @CodeItem(value="OTHER", text="\u5176\u5b83", realtext="\u5176\u5b83")})
public class SysUtilDETypeCodeListModel
extends StaticCodeListModelBase {
    public static final String FILE = "FILE";
    public static final String DATAAUDIT = "DATAAUDIT";
    public static final String DATAAUDITDETAIL = "DATAAUDITDETAIL";
    public static final String OTHER = "OTHER";

    public SysUtilDETypeCodeListModel() {
        this.initAnnotation(SysUtilDETypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUtilDETypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUtilDETypeCodeListModel");
    }
}


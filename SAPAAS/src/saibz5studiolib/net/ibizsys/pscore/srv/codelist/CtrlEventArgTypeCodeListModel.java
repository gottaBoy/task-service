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

@CodeList(id="bf7016109bf8b475b986c5ae1d655a7e", name="\u4e8b\u4ef6\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CTRL", text="\u89e6\u53d1\u90e8\u4ef6", realtext="\u89e6\u53d1\u90e8\u4ef6"), @CodeItem(value="DATAOBJ", text="\u4e8b\u4ef6\u6570\u636e\uff08\u6570\u636e\u5bf9\u8c61\uff09", realtext="\u4e8b\u4ef6\u6570\u636e\uff08\u6570\u636e\u5bf9\u8c61\uff09"), @CodeItem(value="DATAOBJS", text="\u4e8b\u4ef6\u6570\u636e\uff08\u6570\u636e\u5bf9\u8c61\u6570\u7ec4\uff09", realtext="\u4e8b\u4ef6\u6570\u636e\uff08\u6570\u636e\u5bf9\u8c61\u6570\u7ec4\uff09"), @CodeItem(value="DATA", text="\u4e8b\u4ef6\u6570\u636e\uff08\u7b80\u5355\u5c5e\u6027\uff09", realtext="\u4e8b\u4ef6\u6570\u636e\uff08\u7b80\u5355\u5c5e\u6027\uff09"), @CodeItem(value="DATAS", text="\u4e8b\u4ef6\u6570\u636e\uff08\u7b80\u5355\u5c5e\u6027\u6570\u7ec4\uff09", realtext="\u4e8b\u4ef6\u6570\u636e\uff08\u7b80\u5355\u5c5e\u6027\u6570\u7ec4\uff09"), @CodeItem(value="EVENTOBJ", text="\u4e8b\u4ef6\u5bf9\u8c61", realtext="\u4e8b\u4ef6\u5bf9\u8c61")})
public class CtrlEventArgTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CTRL = "CTRL";
    public static final String DATAOBJ = "DATAOBJ";
    public static final String DATAOBJS = "DATAOBJS";
    public static final String DATA = "DATA";
    public static final String DATAS = "DATAS";
    public static final String EVENTOBJ = "EVENTOBJ";

    public CtrlEventArgTypeCodeListModel() {
        this.initAnnotation(CtrlEventArgTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlEventArgTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlEventArgTypeCodeListModel");
    }
}


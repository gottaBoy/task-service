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

@CodeList(id="4b48ad6126b53d1f5e9bd7c6101ec47b", name="\u4e91\u5b9e\u4f53\u89c6\u56fe\u5f15\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u81ea\u5b9a\u4e49\uff09")
@CodeItems(value={@CodeItem(value="NEWDATA", text="\u65b0\u5efa\u6570\u636e\u89c6\u56fe", realtext="\u65b0\u5efa\u6570\u636e\u89c6\u56fe"), @CodeItem(value="EDITDATA", text="\u7f16\u8f91\u6570\u636e\u89c6\u56fe", realtext="\u7f16\u8f91\u6570\u636e\u89c6\u56fe"), @CodeItem(value="NEWDATAWIZARD", text="\u65b0\u5efa\u6570\u636e\u5411\u5bfc\u89c6\u56fe", realtext="\u65b0\u5efa\u6570\u636e\u5411\u5bfc\u89c6\u56fe"), @CodeItem(value="MPICKUPVIEW", text="\u6279\u6dfb\u52a0\u591a\u9009\u6570\u636e\u89c6\u56fe", realtext="\u6279\u6dfb\u52a0\u591a\u9009\u6570\u636e\u89c6\u56fe"), @CodeItem(value="RDITEM", text="\u91cd\u5b9a\u5411\u89c6\u56fe\u9879", realtext="\u91cd\u5b9a\u5411\u89c6\u56fe\u9879"), @CodeItem(value="EDITDATAX", text="\u7f16\u8f91\u6570\u636e\u89c6\u56fe\uff08\u52a8\u6001\u89c6\u56fe\uff09", realtext="\u7f16\u8f91\u6570\u636e\u89c6\u56fe\uff08\u52a8\u6001\u89c6\u56fe\uff09"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class ViewRVModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NEWDATA = "NEWDATA";
    public static final String EDITDATA = "EDITDATA";
    public static final String NEWDATAWIZARD = "NEWDATAWIZARD";
    public static final String MPICKUPVIEW = "MPICKUPVIEW";
    public static final String RDITEM = "RDITEM";
    public static final String EDITDATAX = "EDITDATAX";
    public static final String CUSTOM = "CUSTOM";

    public ViewRVModeCodeListModel() {
        this.initAnnotation(ViewRVModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewRVModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewRVModeCodeListModel");
    }
}


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

@CodeList(id="B853DD0E-F36F-4A43-8ADB-B941E9F6BB0E", name="\u6570\u636e\u6d41\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DFSYSRESOURCESOURCE", text="\u6570\u636e\u6d41\u9884\u7f6e\u8d44\u6e90\u6e90", realtext="\u6570\u636e\u6d41\u9884\u7f6e\u8d44\u6e90\u6e90"), @CodeItem(value="DFSORTPROCESS", text="\u6570\u636e\u6d41\u6392\u5e8f\u5904\u7406", realtext="\u6570\u636e\u6d41\u6392\u5e8f\u5904\u7406"), @CodeItem(value="DFSYSRESOURCESINK", text="\u6570\u636e\u6d41\u9884\u7f6e\u8d44\u6e90\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u9884\u7f6e\u8d44\u6e90\u6d88\u8d39", userdata="ULL \u503c"), @CodeItem(value="DFSYSDBSCHEMESOURCE", text="\u6570\u636e\u6d41\u6570\u636e\u5e93\u6e90", realtext="\u6570\u636e\u6d41\u6570\u636e\u5e93\u6e90"), @CodeItem(value="DFSYSDBSCHEMESINK", text="\u6570\u636e\u6d41\u6570\u636e\u5e93\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u6570\u636e\u5e93\u6d88\u8d39"), @CodeItem(value="DFSYSDATASYNCAGENTSOURCE", text="\u6570\u636e\u6d41\u6570\u636e\u540c\u6b65\u4ee3\u7406\u6e90", realtext="\u6570\u636e\u6d41\u6570\u636e\u540c\u6b65\u4ee3\u7406\u6e90"), @CodeItem(value="DFSYSDATASYNCAGENTSINK", text="\u6570\u636e\u6d41\u6570\u636e\u540c\u6b65\u4ee3\u7406\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u6570\u636e\u540c\u6b65\u4ee3\u7406\u6d88\u8d39"), @CodeItem(value="DFSYSBDSCHEMESOURCE", text="\u6570\u636e\u6d41\u5927\u6570\u636e\u5e93\u6e90", realtext="\u6570\u636e\u6d41\u5927\u6570\u636e\u5e93\u6e90"), @CodeItem(value="DFSYSBDSCHEMESINK", text="\u6570\u636e\u6d41\u5927\u6570\u636e\u5e93\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u5927\u6570\u636e\u5e93\u6d88\u8d39"), @CodeItem(value="DFSUBSYSSERVICEAPISOURCE", text="\u6570\u636e\u6d41\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u6e90", realtext="\u6570\u636e\u6d41\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u6e90"), @CodeItem(value="DFPREPAREPROCESS", text="\u6570\u636e\u6d41\u51c6\u5907\u5904\u7406", realtext="\u6570\u636e\u6d41\u51c6\u5907\u5904\u7406"), @CodeItem(value="DFSUBSYSSERVICEAPISINK", text="\u6570\u636e\u6d41\u5916\u90e8\u63a5\u53e3\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u5916\u90e8\u63a5\u53e3\u6d88\u8d39"), @CodeItem(value="DFMERGEPROCESS", text="\u6570\u636e\u6d41\u5408\u5e76\u5904\u7406", realtext="\u6570\u636e\u6d41\u5408\u5e76\u5904\u7406"), @CodeItem(value="DFJOINPROCESS", text="\u6570\u636e\u6d41\u8fde\u63a5\u5904\u7406", realtext="\u6570\u636e\u6d41\u8fde\u63a5\u5904\u7406"), @CodeItem(value="DFDEDATASETSOURCE", text="\u6570\u636e\u6d41\u5b9e\u4f53\u6570\u636e\u96c6\u6e90", realtext="\u6570\u636e\u6d41\u5b9e\u4f53\u6570\u636e\u96c6\u6e90"), @CodeItem(value="DFDEDATAFLOWSINK", text="\u6570\u636e\u6d41\u6570\u636e\u6d41\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u6570\u636e\u6d41\u6d88\u8d39"), @CodeItem(value="DFAGGREGATEPROCESS", text="\u6570\u636e\u6d41\u805a\u5408\u5904\u7406", realtext="\u6570\u636e\u6d41\u805a\u5408\u5904\u7406"), @CodeItem(value="DFDEACTIONSINK", text="\u6570\u636e\u6d41\u5b9e\u4f53\u884c\u4e3a\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u5b9e\u4f53\u884c\u4e3a\u6d88\u8d39"), @CodeItem(value="DFDEDATASYNCSINK", text="\u6570\u636e\u6d41\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6d88\u8d39", realtext="\u6570\u636e\u6d41\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6d88\u8d39")})
public class DEDataFlowNodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DFSYSRESOURCESOURCE = "DFSYSRESOURCESOURCE";
    public static final String DFSORTPROCESS = "DFSORTPROCESS";
    public static final String DFSYSRESOURCESINK = "DFSYSRESOURCESINK";
    public static final String DFSYSDBSCHEMESOURCE = "DFSYSDBSCHEMESOURCE";
    public static final String DFSYSDBSCHEMESINK = "DFSYSDBSCHEMESINK";
    public static final String DFSYSDATASYNCAGENTSOURCE = "DFSYSDATASYNCAGENTSOURCE";
    public static final String DFSYSDATASYNCAGENTSINK = "DFSYSDATASYNCAGENTSINK";
    public static final String DFSYSBDSCHEMESOURCE = "DFSYSBDSCHEMESOURCE";
    public static final String DFSYSBDSCHEMESINK = "DFSYSBDSCHEMESINK";
    public static final String DFSUBSYSSERVICEAPISOURCE = "DFSUBSYSSERVICEAPISOURCE";
    public static final String DFPREPAREPROCESS = "DFPREPAREPROCESS";
    public static final String DFSUBSYSSERVICEAPISINK = "DFSUBSYSSERVICEAPISINK";
    public static final String DFMERGEPROCESS = "DFMERGEPROCESS";
    public static final String DFJOINPROCESS = "DFJOINPROCESS";
    public static final String DFDEDATASETSOURCE = "DFDEDATASETSOURCE";
    public static final String DFDEDATAFLOWSINK = "DFDEDATAFLOWSINK";
    public static final String DFAGGREGATEPROCESS = "DFAGGREGATEPROCESS";
    public static final String DFDEACTIONSINK = "DFDEACTIONSINK";
    public static final String DFDEDATASYNCSINK = "DFDEDATASYNCSINK";

    public DEDataFlowNodeTypeCodeListModel() {
        this.initAnnotation(DEDataFlowNodeTypeCodeListModel.class);
        this.setUserData2("DEDataFlowNodeType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowNodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowNodeTypeCodeListModel");
    }
}


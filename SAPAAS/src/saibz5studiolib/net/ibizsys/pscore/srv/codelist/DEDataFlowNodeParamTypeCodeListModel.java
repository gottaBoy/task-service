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

@CodeList(id="03ABC6C8-0A04-49BC-817E-711242A2BF2A", name="\u5b9e\u4f53\u6570\u636e\u6d41\u8282\u70b9\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PREPAREPARAM", text="\u51c6\u5907\u53c2\u6570", realtext="\u51c6\u5907\u53c2\u6570", userdata="\u6307\u5b9a\u6570\u636e\u6d41\u7684\u51c6\u5907\u53c2\u6570"), @CodeItem(value="MERGEPARAM", text="\u5408\u5e76\u53c2\u6570", realtext="\u5408\u5e76\u53c2\u6570", userdata="\u6307\u5b9a\u5408\u5e76\u6570\u636e\u6d41\u7684\u53c2\u6570"), @CodeItem(value="AGGREGATEPARAM", text="\u805a\u5408\u53c2\u6570", realtext="\u805a\u5408\u53c2\u6570", userdata="\u6307\u5b9a\u805a\u5408\u6570\u636e\u6d41\u7684\u53c2\u6570"), @CodeItem(value="SORTPARAM", text="\u6392\u5e8f\u53c2\u6570", realtext="\u6392\u5e8f\u53c2\u6570", userdata="\u6307\u5b9a\u805a\u5408\u6570\u636e\u6d41\u7684\u53c2\u6570")})
public class DEDataFlowNodeParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PREPAREPARAM = "PREPAREPARAM";
    public static final String MERGEPARAM = "MERGEPARAM";
    public static final String AGGREGATEPARAM = "AGGREGATEPARAM";
    public static final String SORTPARAM = "SORTPARAM";

    public DEDataFlowNodeParamTypeCodeListModel() {
        this.initAnnotation(DEDataFlowNodeParamTypeCodeListModel.class);
        this.setUserData2("DEDataFlowNodeParamType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowNodeParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowNodeParamTypeCodeListModel");
    }
}


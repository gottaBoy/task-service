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

@CodeList(id="6E3EBE2A-CC1A-4FF3-B3D5-65BC02C39DFB", name="\u5b9e\u4f53\u6570\u636e\u6d41\u5c5e\u6027\u8303\u56f4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATASTREAM", text="\u6570\u636e\u6e90\u5c5e\u6027", realtext="\u6570\u636e\u6e90\u5c5e\u6027", userdata="\u6307\u5b9a\u6570\u636e\u6e90\u5c5e\u6027"), @CodeItem(value="DATASTREAM2", text="\u6570\u636e\u6e902\u5c5e\u6027", realtext="\u6570\u636e\u6e902\u5c5e\u6027", userdata="\u6307\u5b9a\u6570\u636e\u6e902\u5c5e\u6027")})
public class DEDataFlowFieldScopeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATASTREAM = "DATASTREAM";
    public static final String DATASTREAM2 = "DATASTREAM2";

    public DEDataFlowFieldScopeCodeListModel() {
        this.initAnnotation(DEDataFlowFieldScopeCodeListModel.class);
        this.setUserData2("DEDataFlowFieldScope");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowFieldScopeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowFieldScopeCodeListModel");
    }
}


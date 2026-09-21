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

@CodeList(id="6BC84A8C-E483-489F-8B49-2F5898D2108B", name="\u5b9e\u4f53\u6570\u636e\u6d41\u8fde\u63a5\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATASTREAM", text="\u6570\u636e\u6d41", realtext="\u6570\u636e\u6d41", userdata="\u6570\u636e\u6d411"), @CodeItem(value="DATASTREAM2", text="\u6570\u636e\u6d412", realtext="\u6570\u636e\u6d412", userdata="\u6570\u636e\u6d412")})
public class DEDataFlowLinkTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATASTREAM = "DATASTREAM";
    public static final String DATASTREAM2 = "DATASTREAM2";

    public DEDataFlowLinkTypeCodeListModel() {
        this.initAnnotation(DEDataFlowLinkTypeCodeListModel.class);
        this.setUserData2("DEDataFlowLinkType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowLinkTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowLinkTypeCodeListModel");
    }
}


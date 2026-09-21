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

@CodeList(id="CCEE095D-7787-418F-8A3E-EFC5CFF8F23B", name="\u5b9e\u4f53\u6570\u636e\u6d41\u8fde\u63a5\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="11", text="\u6570\u636e\u6d41", realtext="\u6570\u636e\u6d41", userdata="\u6570\u636e\u6d411"), @CodeItem(value="12", text="\u6570\u636e\u6d412", realtext="\u6570\u636e\u6d412", userdata="\u6570\u636e\u6d412")})
public class DEDataFlowLinkModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DATASTREAM = 11;
    public static final int INT_DATASTREAM = 11;
    public static final Integer DATASTREAM2 = 12;
    public static final int INT_DATASTREAM2 = 12;

    public DEDataFlowLinkModeCodeListModel() {
        this.initAnnotation(DEDataFlowLinkModeCodeListModel.class);
        this.setUserData2("DEDataFlowLinkMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowLinkModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowLinkModeCodeListModel");
    }
}


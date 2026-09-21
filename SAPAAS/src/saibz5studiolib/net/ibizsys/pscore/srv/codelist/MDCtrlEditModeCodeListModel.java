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

@CodeList(id="29D169B4-8B21-4990-AE7A-D021769E3190", name="\u591a\u6570\u636e\u90e8\u4ef6\u5373\u65f6\u7f16\u8f91\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="256", text="\u6b21\u5e8f\u8c03\u6574", realtext="\u6b21\u5e8f\u8c03\u6574"), @CodeItem(value="512", text="\u5206\u7ec4\u8c03\u6574", realtext="\u5206\u7ec4\u8c03\u6574")})
public class MDCtrlEditModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_256 = 256;
    public static final int INT_ITEM_256 = 256;
    public static final Integer ITEM_512 = 512;
    public static final int INT_ITEM_512 = 512;

    public MDCtrlEditModeCodeListModel() {
        this.initAnnotation(MDCtrlEditModeCodeListModel.class);
        this.setUserData2("MDCtrlEditMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MDCtrlEditModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MDCtrlEditModeCodeListModel");
    }
}


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

@CodeList(id="9805757A-04B7-4746-A10D-133A3006305C", name="\u89c6\u56fe\u6d88\u606f\u542f\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="ALL", text="\u5168\u90e8\u542f\u7528", realtext="\u5168\u90e8\u542f\u7528"), @CodeItem(value="DEOPPRIV", text="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", realtext="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", userdata="\u89c6\u56fe\u6d88\u606f\u5728\u5bf9\u5f53\u524d\u6570\u636e\u5177\u5907\u6307\u5b9a\u64cd\u4f5c\u6807\u8bc6\u65f6\u542f\u7528"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u903b\u8f91", realtext="\u5b9e\u4f53\u903b\u8f91"), @CodeItem(value="SCRIPT", text="\u811a\u672c", realtext="\u811a\u672c")})
public class ViewMsgEnableModeCodeListModel
extends StaticCodeListModelBase {
    public static final String ALL = "ALL";
    public static final String DEOPPRIV = "DEOPPRIV";
    public static final String DELOGIC = "DELOGIC";
    public static final String SCRIPT = "SCRIPT";

    public ViewMsgEnableModeCodeListModel() {
        this.initAnnotation(ViewMsgEnableModeCodeListModel.class);
        this.setUserData2("ViewMsgEnableMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgEnableModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgEnableModeCodeListModel");
    }
}


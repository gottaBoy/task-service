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

@CodeList(id="1b3c7587e064a5bb7690cdfc334c5127", name="\u89c6\u56fe\u6d88\u606f\u52a8\u6001\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9759\u6001\u5185\u5bb9", realtext="\u9759\u6001\u5185\u5bb9"), @CodeItem(value="1", text="\u5b9e\u4f53\u6570\u636e\u96c6", realtext="\u5b9e\u4f53\u6570\u636e\u96c6", userdata="\u4ece\u5b9e\u4f53\u6570\u636e\u96c6\u83b7\u53d6\u89c6\u56fe\u6d88\u606f")})
public class ViewMsgDynamicModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer STATIC = 0;
    public static final int INT_STATIC = 0;
    public static final Integer DEDATASET = 1;
    public static final int INT_DEDATASET = 1;

    public ViewMsgDynamicModeCodeListModel() {
        this.initAnnotation(ViewMsgDynamicModeCodeListModel.class);
        this.setUserData2("ViewMsgDynamicMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgDynamicModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgDynamicModeCodeListModel");
    }
}


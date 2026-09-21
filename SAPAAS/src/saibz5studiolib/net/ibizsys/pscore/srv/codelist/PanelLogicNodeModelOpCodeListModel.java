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

@CodeList(id="83c23a4feb0699b7b2534c04b80b90d6", name="\u7cfb\u7edf\u9762\u677f\u903b\u8f91\u53c2\u6570\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SETMODEL", text="\u8bbe\u7f6e\u53c2\u6570", realtext="\u8bbe\u7f6e\u53c2\u6570"), @CodeItem(value="RESETMODEL", text="\u91cd\u7f6e\u53c2\u6570", realtext="\u91cd\u7f6e\u53c2\u6570"), @CodeItem(value="COPYMODEL", text="\u62f7\u8d1d\u53c2\u6570", realtext="\u62f7\u8d1d\u53c2\u6570"), @CodeItem(value="PUSHARRAY", text="\u9644\u52a0\u5230\u6570\u7ec4", realtext="\u9644\u52a0\u5230\u6570\u7ec4")})
public class PanelLogicNodeModelOpCodeListModel
extends StaticCodeListModelBase {
    public static final String SETMODEL = "SETMODEL";
    public static final String RESETMODEL = "RESETMODEL";
    public static final String COPYMODEL = "COPYMODEL";
    public static final String PUSHARRAY = "PUSHARRAY";

    public PanelLogicNodeModelOpCodeListModel() {
        this.initAnnotation(PanelLogicNodeModelOpCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicNodeModelOpCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicNodeModelOpCodeListModel");
    }
}


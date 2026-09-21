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

@CodeList(id="21a7b41ba5d7bfd2124e96f198eb64b6", name="\u7cfb\u7edf\u9762\u677f\u903b\u8f91\u53d8\u91cf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INPUT", text="\u4f20\u5165\u53d8\u91cf", realtext="\u4f20\u5165\u53d8\u91cf"), @CodeItem(value="TEMP", text="\u4e34\u65f6\u53d8\u91cf", realtext="\u4e34\u65f6\u53d8\u91cf"), @CodeItem(value="PANELMODEL", text="\u9762\u677f\u6a21\u578b", realtext="\u9762\u677f\u6a21\u578b")})
public class PanelLogicParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INPUT = "INPUT";
    public static final String TEMP = "TEMP";
    public static final String PANELMODEL = "PANELMODEL";

    public PanelLogicParamTypeCodeListModel() {
        this.initAnnotation(PanelLogicParamTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicParamTypeCodeListModel");
    }
}


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

@CodeList(id="26a7dd6e0fb0e313be6c991e489d66bf", name="\u9762\u677f\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6e90\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SRCMODEL", text="\u6e90\u6a21\u578b", realtext="\u6e90\u6a21\u578b"), @CodeItem(value="WEBCONTEXT", text="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587", realtext="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587"), @CodeItem(value="NONEVALUE", text="\u65e0\u503c\uff08NONE\uff09", realtext="\u65e0\u503c\uff08NONE\uff09"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c\uff08NULL\uff09", realtext="\u7a7a\u503c\uff08NULL\uff09"), @CodeItem(value="SRCVALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c")})
public class PanelLogicNodeSrcTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SRCMODEL = "SRCMODEL";
    public static final String WEBCONTEXT = "WEBCONTEXT";
    public static final String NONEVALUE = "NONEVALUE";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String SRCVALUE = "SRCVALUE";

    public PanelLogicNodeSrcTypeCodeListModel() {
        this.initAnnotation(PanelLogicNodeSrcTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicNodeSrcTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicNodeSrcTypeCodeListModel");
    }
}


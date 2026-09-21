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

@CodeList(id="3ea1d8803ed8900acd7bf53bd8186b28", name="\u89c6\u56fe\u5e03\u5c40\u9762\u677f\u5e94\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9ed8\u8ba4\u5e03\u5c40\u9762\u677f", realtext="\u9ed8\u8ba4\u5e03\u5c40\u9762\u677f"), @CodeItem(value="1", text="\u6307\u5b9a\u5e03\u5c40\u9762\u677f", realtext="\u6307\u5b9a\u5e03\u5c40\u9762\u677f"), @CodeItem(value="2", text="\u6307\u5b9a\u5e03\u5c40\u9762\u677f\uff08\u7ba1\u7406\uff09", realtext="\u6307\u5b9a\u5e03\u5c40\u9762\u677f\uff08\u7ba1\u7406\uff09", userdata="\u89c6\u56fe\u6307\u5b9a\u5e03\u5c40\u9762\u677f\uff0c\u53e6\u5916\u89c6\u56fe\u5c06\u4f5c\u4e3a\u5e03\u5c40\u9762\u677f\u7684\u8bbe\u8ba1\u5bb9\u5668\uff0c\u4e5f\u5c31\u662f\u8bf4\u5728\u8bbe\u8ba1\u5668\u5bf9\u89c6\u56fe\u8fdb\u884c\u5e03\u5c40\u8c03\u6574\u540e\u4f1a\u5c06\u8bbe\u8ba1\u4fe1\u606f\u66f4\u65b0\u81f3\u6307\u5b9a\u7684\u5e03\u5c40\u9762\u677f\uff08\u5e03\u5c40\u9762\u677f\u7ba1\u7406\uff09")})
public class ViewLayoutPanelModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DEFAULT = 0;
    public static final int INT_DEFAULT = 0;
    public static final Integer REF = 1;
    public static final int INT_REF = 1;
    public static final Integer REFANDADMIN = 2;
    public static final int INT_REFANDADMIN = 2;

    public ViewLayoutPanelModeCodeListModel() {
        this.initAnnotation(ViewLayoutPanelModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("LayoutPanelMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewLayoutPanelModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewLayoutPanelModeCodeListModel");
    }
}


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

@CodeList(id="aa702438862b732adb8ee4b5e8f0b19a", name="\u7f16\u8f91\u9879\u542f\u7528\u6761\u4ef6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0", userdata="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u5efa\u7acb", realtext="\u5efa\u7acb", userdata="\u5efa\u7acb\u6570\u636e\u65f6\u542f\u7528"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0", userdata="\u66f4\u65b0\u6570\u636e\u65f6\u542f\u7528"), @CodeItem(value="3", text="\u5168\u90e8", realtext="\u5168\u90e8", userdata="\u5efa\u7acb\u53ca\u66f4\u65b0\u6570\u636e\u65f6\u542f\u7528")})
public class FormItemEnableCondCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer ALL = 3;
    public static final int INT_ALL = 3;

    public FormItemEnableCondCodeListModel() {
        this.initAnnotation(FormItemEnableCondCodeListModel.class);
        this.setUserData2("EditItemEnableCond");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel");
    }
}


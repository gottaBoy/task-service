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

@CodeList(id="4a9a148e5d3749f8043058f3a692774d", name="\u4e91\u5b9e\u4f53\u89c6\u56fe\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEUILOGIC", text="\u5b9e\u4f53\u89c6\u56fe\u903b\u8f91", realtext="\u5b9e\u4f53\u89c6\u56fe\u903b\u8f91"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u89c6\u56fe\u903b\u8f91", realtext="\u5b9e\u4f53\u89c6\u56fe\u903b\u8f91"), @CodeItem(value="SYSVIEWLOGIC", text="\u7cfb\u7edf\u89c6\u56fe\u903b\u8f91", realtext="\u7cfb\u7edf\u89c6\u56fe\u903b\u8f91"), @CodeItem(value="APPVIEWLOGIC", text="\u5f53\u524d\u89c6\u56fe\u903b\u8f91", realtext="\u5f53\u524d\u89c6\u56fe\u903b\u8f91"), @CodeItem(value="DEUIACTION", text="\u754c\u9762\u884c\u4e3a", realtext="\u754c\u9762\u884c\u4e3a", userdata="\u4e8b\u4ef6\u89e6\u53d1\u754c\u9762\u884c\u4e3a\u5904\u7406"), @CodeItem(value="PFPLUGIN", text="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", realtext="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", userdata="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u5b9a\u4e49\u7684\u76f4\u63a5\u4ee3\u7801\u903b\u8f91"), @CodeItem(value="SCRIPT", text="\u811a\u672c\u4ee3\u7801", realtext="\u811a\u672c\u4ee3\u7801", userdata="\u8fd0\u884c\u65f6\u89e3\u91ca\u6267\u884c\u7684\u811a\u672c\u4ee3\u7801")})
public class ViewLogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEUILOGIC = "DEUILOGIC";
    public static final String DELOGIC = "DELOGIC";
    public static final String SYSVIEWLOGIC = "SYSVIEWLOGIC";
    public static final String APPVIEWLOGIC = "APPVIEWLOGIC";
    public static final String DEUIACTION = "DEUIACTION";
    public static final String PFPLUGIN = "PFPLUGIN";
    public static final String SCRIPT = "SCRIPT";

    public ViewLogicTypeCodeListModel() {
        this.initAnnotation(ViewLogicTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewLogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewLogicTypeCodeListModel");
    }
}


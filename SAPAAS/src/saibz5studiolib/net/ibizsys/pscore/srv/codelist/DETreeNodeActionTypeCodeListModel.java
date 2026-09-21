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

@CodeList(id="50313b046fb10a23da82dbc4a4204674", name="\u6811\u89c6\u56fe\u8282\u70b9\u9009\u4e2d\u5904\u7406\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PAGELINK", text="\u9875\u9762\u94fe\u63a5", realtext="\u9875\u9762\u94fe\u63a5"), @CodeItem(value="JAVASCRIPT", text="\u811a\u672c\u6267\u884c", realtext="\u811a\u672c\u6267\u884c")})
public class DETreeNodeActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PAGELINK = "PAGELINK";
    public static final String JAVASCRIPT = "JAVASCRIPT";

    public DETreeNodeActionTypeCodeListModel() {
        this.initAnnotation(DETreeNodeActionTypeCodeListModel.class);
        this.setUserData2("TreeNodeActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeActionTypeCodeListModel");
    }
}


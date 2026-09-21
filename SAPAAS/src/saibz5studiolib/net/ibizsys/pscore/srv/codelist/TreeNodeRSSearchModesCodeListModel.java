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

@CodeList(id="4BB3CB39-921A-472E-A517-A34B93067C97", name="\u6811\u8282\u70b9\u5173\u7cfb\u641c\u7d22\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u5168\u90e8\u542f\u7528\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u6709\u641c\u7d22\u65f6\u542f\u7528", realtext="\u6709\u641c\u7d22\u65f6\u542f\u7528", userdata="\u6811\u8282\u70b9\u5173\u7cfb\u5728\u5b58\u5728\u8fc7\u6ee4\u6761\u4ef6\u65f6\u542f\u7528"), @CodeItem(value="2", text="\u65e0\u641c\u7d22\u65f6\u542f\u7528", realtext="\u65e0\u641c\u7d22\u65f6\u542f\u7528", userdata="\u6811\u8282\u70b9\u5173\u7cfb\u5728\u4e0d\u5b58\u5728\u8fc7\u6ee4\u6761\u4ef6\u65f6\u542f\u7528"), @CodeItem(value="3", text="\u5168\u90e8\u542f\u7528", realtext="\u5168\u90e8\u542f\u7528", userdata="\u6811\u8282\u70b9\u5173\u7cfb\u5168\u90e8\u542f\u7528")})
public class TreeNodeRSSearchModesCodeListModel
extends StaticCodeListModelBase {
    public static final Integer SEARCH = 1;
    public static final int INT_SEARCH = 1;
    public static final Integer NOSEARCH = 2;
    public static final int INT_NOSEARCH = 2;
    public static final Integer ALL = 3;
    public static final int INT_ALL = 3;

    public TreeNodeRSSearchModesCodeListModel() {
        this.initAnnotation(TreeNodeRSSearchModesCodeListModel.class);
        this.setUserData2("TreeNodeRSSearchMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TreeNodeRSSearchModesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TreeNodeRSSearchModesCodeListModel");
    }
}


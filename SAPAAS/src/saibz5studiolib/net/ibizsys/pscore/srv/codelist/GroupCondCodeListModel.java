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

@CodeList(id="c25c6ff6bc136acb551bb429196ac813", name="\u7ec4\u5408\u6761\u4ef6\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AND", text="\u4e0e(AND)", realtext="\u4e0e(AND)"), @CodeItem(value="OR", text="\u6216(OR)", realtext="\u6216(OR)")})
public class GroupCondCodeListModel
extends StaticCodeListModelBase {
    public static final String AND = "AND";
    public static final String OR = "OR";

    public GroupCondCodeListModel() {
        this.initAnnotation(GroupCondCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("GroupCondOP");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel");
    }
}


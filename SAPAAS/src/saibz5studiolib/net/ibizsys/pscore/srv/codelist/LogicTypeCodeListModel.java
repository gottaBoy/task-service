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

@CodeList(id="31efa54cc136cd8fb76a8679b3dc26c5", name="\u6761\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GROUP", text="\u7ec4\u5408\u6761\u4ef6", realtext="\u7ec4\u5408\u6761\u4ef6", userdata="\u7ec4\u6761\u4ef6\uff0c\u4f7f\u7528\u4e0e\uff08AND\uff09\u3001\u6216\uff08OR\uff09\u903b\u8f91\u8ba1\u7b97\u6210\u5458\u6761\u4ef6"), @CodeItem(value="SINGLE", text="\u5c5e\u6027\u6761\u4ef6", realtext="\u5c5e\u6027\u6761\u4ef6", userdata="\u9762\u5411\u5c5e\u6027\u7684\u5355\u9879\u6761\u4ef6"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u6761\u4ef6", realtext="\u81ea\u5b9a\u4e49\u6761\u4ef6"), @CodeItem(value="PREDEFINED", text="\u9884\u7f6e\u6761\u4ef6", realtext="\u9884\u7f6e\u6761\u4ef6")})
public class LogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String GROUP = "GROUP";
    public static final String SINGLE = "SINGLE";
    public static final String CUSTOM = "CUSTOM";
    public static final String PREDEFINED = "PREDEFINED";

    public LogicTypeCodeListModel() {
        this.initAnnotation(LogicTypeCodeListModel.class);
        this.setUserData2("CondType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.LogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.LogicTypeCodeListModel");
    }
}


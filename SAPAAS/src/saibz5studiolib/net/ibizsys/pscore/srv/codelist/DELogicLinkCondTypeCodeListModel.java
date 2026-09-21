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

@CodeList(id="8438952416ce4449d0b210c44fa62d65", name="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GROUP", text="\u7ec4\u903b\u8f91", realtext="\u7ec4\u903b\u8f91", userdata="\u7ec4\u5408\u6761\u4ef6\uff0c\u63d0\u4f9b\u4e0e\uff08AND\uff09\u3001\u6216\uff08OR\uff09\u64cd\u4f5c"), @CodeItem(value="SINGLE", text="\u5355\u9879\u903b\u8f91", realtext="\u5355\u9879\u903b\u8f91", userdata="\u5355\u9879\u6761\u4ef6")})
public class DELogicLinkCondTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String GROUP = "GROUP";
    public static final String SINGLE = "SINGLE";

    public DELogicLinkCondTypeCodeListModel() {
        this.initAnnotation(DELogicLinkCondTypeCodeListModel.class);
        this.setUserData2("LogicLinkCondType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicLinkCondTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicLinkCondTypeCodeListModel");
    }
}


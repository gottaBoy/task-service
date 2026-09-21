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

@CodeList(id="a129a1043647d933c43e6f1cca6e19f9", name="\u8868\u5355\u6210\u5458\u903b\u8f91\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GROUP", text="\u7ec4\u903b\u8f91", realtext="\u7ec4\u903b\u8f91", userdata="\u7ec4\u5408\u6761\u4ef6\uff0c\u63d0\u4f9b\u4e0e\uff08AND\uff09\u3001\u6216\uff08OR\uff09\u64cd\u4f5c"), @CodeItem(value="SINGLE", text="\u5355\u9879\u903b\u8f91", realtext="\u5355\u9879\u903b\u8f91", userdata="\u8868\u5355\u9879\u7684\u5355\u9879\u903b\u8f91\u5224\u65ad")})
public class FDLogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String GROUP = "GROUP";
    public static final String SINGLE = "SINGLE";

    public FDLogicTypeCodeListModel() {
        this.initAnnotation(FDLogicTypeCodeListModel.class);
        this.setUserData2("FormDetailLogicType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FDLogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FDLogicTypeCodeListModel");
    }
}


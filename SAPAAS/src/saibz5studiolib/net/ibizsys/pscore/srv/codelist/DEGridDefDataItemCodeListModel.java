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

@CodeList(id="951869f3e54e2c58b1740edbf10965b0", name="\u4e91\u5b9e\u4f53\u9ed8\u8ba4\u6570\u636e\u9879", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5916\u952e\u5c5e\u6027", realtext="\u5916\u952e\u5c5e\u6027", userdata="\u5b9e\u4f53\u4e2d\u7684\u5916\u952e\u5c5e\u6027\uff0c\u65b9\u4fbf\u5916\u90e8\u529f\u80fd\u76f4\u63a5\u4f7f\u7528"), @CodeItem(value="1024", text="\u884c\u6570\u636e\u64cd\u4f5c\u6807\u8bc6", realtext="\u884c\u6570\u636e\u64cd\u4f5c\u6807\u8bc6", userdata="\u5f53\u524d\u7528\u6237\u5bf9\u884c\u6570\u636e\u5177\u5907\u7684\u64cd\u4f5c\u80fd\u529b\u6e05\u5355\uff0c\u4e3a\u754c\u9762\u884c\u4e3a\u63d0\u4f9b\u754c\u9762\u63a7\u5236\u652f\u6301")})
public class DEGridDefDataItemCodeListModel
extends StaticCodeListModelBase {
    public static final Integer PICKUP = 1;
    public static final int INT_PICKUP = 1;
    public static final Integer ACCESSACTION = 1024;
    public static final int INT_ACCESSACTION = 1024;

    public DEGridDefDataItemCodeListModel() {
        this.initAnnotation(DEGridDefDataItemCodeListModel.class);
        this.setUserData2("GridDefDataItem");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridDefDataItemCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridDefDataItemCodeListModel");
    }
}


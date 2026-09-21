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

@CodeList(id="19E3319D-BC3A-4FD8-95B4-4FD6F0D1D56E", name="\u901a\u77e5\u5b50\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u65e0\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="EVENTHOOK", text="\u4e8b\u4ef6\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u4e8b\u4ef6\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09"), @CodeItem(value="FIELDCHANGEHOOK", text="\u5c5e\u6027\u503c\u53d8\u5316\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09", realtext="\u5c5e\u6027\u503c\u53d8\u5316\u5904\u7406\uff08\u8fd0\u884c\u65f6\u652f\u6301\uff09"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DENotifySubTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String EVENTHOOK = "EVENTHOOK";
    public static final String FIELDCHANGEHOOK = "FIELDCHANGEHOOK";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DENotifySubTypeCodeListModel() {
        this.initAnnotation(DENotifySubTypeCodeListModel.class);
        this.setUserData2("NotifySubType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DENotifySubTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DENotifySubTypeCodeListModel");
    }
}


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

@CodeList(id="ea9d29f4f860c10b62793ba49a6f5062", name="\u5b9e\u4f53\u8868\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MAIN", text="\u4e3b\u8868", realtext="\u4e3b\u8868"), @CodeItem(value="USER", text="\u7528\u6237\u6269\u5c55\u8868", realtext="\u7528\u6237\u6269\u5c55\u8868"), @CodeItem(value="USER2", text="\u7528\u6237\u6269\u5c55\u88682", realtext="\u7528\u6237\u6269\u5c55\u88682")})
public class DETableTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MAIN = "MAIN";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DETableTypeCodeListModel() {
        this.initAnnotation(DETableTypeCodeListModel.class);
        this.setUserData2("DEDBTableType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETableTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETableTypeCodeListModel");
    }
}


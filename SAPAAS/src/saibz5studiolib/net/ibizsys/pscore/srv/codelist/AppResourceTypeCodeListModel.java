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

@CodeList(id="481ba14d46e6504fac0c8b76243398ba", name="\u5e94\u7528\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IMAGE", text="\u56fe\u7247", realtext="\u56fe\u7247"), @CodeItem(value="STRING", text="\u5b57\u7b26\u4e32", realtext="\u5b57\u7b26\u4e32"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494"), @CodeItem(value="USER5", text="\u7528\u6237\u81ea\u5b9a\u4e495", realtext="\u7528\u6237\u81ea\u5b9a\u4e495"), @CodeItem(value="USER6", text="\u7528\u6237\u81ea\u5b9a\u4e496", realtext="\u7528\u6237\u81ea\u5b9a\u4e496"), @CodeItem(value="USER7", text="\u7528\u6237\u81ea\u5b9a\u4e497", realtext="\u7528\u6237\u81ea\u5b9a\u4e497"), @CodeItem(value="USER8", text="\u7528\u6237\u81ea\u5b9a\u4e498", realtext="\u7528\u6237\u81ea\u5b9a\u4e498"), @CodeItem(value="USER9", text="\u7528\u6237\u81ea\u5b9a\u4e499", realtext="\u7528\u6237\u81ea\u5b9a\u4e499")})
public class AppResourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String IMAGE = "IMAGE";
    public static final String STRING = "STRING";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";
    public static final String USER5 = "USER5";
    public static final String USER6 = "USER6";
    public static final String USER7 = "USER7";
    public static final String USER8 = "USER8";
    public static final String USER9 = "USER9";

    public AppResourceTypeCodeListModel() {
        this.initAnnotation(AppResourceTypeCodeListModel.class);
        this.setUserData2("AppResourceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppResourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppResourceTypeCodeListModel");
    }
}


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

@CodeList(id="d76138978063363c36305360ca31cb88", name="\u89c6\u56fe\u8bbf\u95ee\u7528\u6237", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u6307\u5b9a", realtext="\u672a\u6307\u5b9a"), @CodeItem(value="1", text="\u672a\u767b\u5f55\u7528\u6237", realtext="\u672a\u767b\u5f55\u7528\u6237", userdata="\u533f\u540d\u7528\u6237"), @CodeItem(value="2", text="\u767b\u5f55\u7528\u6237", realtext="\u767b\u5f55\u7528\u6237", userdata="\u8bbf\u95ee\u7528\u6237\u5fc5\u987b\u5df2\u7ecf\u767b\u5f55\uff0c\u5177\u5907\u7528\u6237\u8eab\u4efd"), @CodeItem(value="3", text="\u672a\u767b\u5f55\u7528\u6237\u53ca\u767b\u5f55\u7528\u6237", realtext="\u672a\u767b\u5f55\u7528\u6237\u53ca\u767b\u5f55\u7528\u6237", userdata="\u5168\u90e8\u7528\u6237"), @CodeItem(value="4", text="\u767b\u5f55\u7528\u6237\u4e14\u62e5\u6709\u6307\u5b9a\u8d44\u6e90\u80fd\u529b", realtext="\u767b\u5f55\u7528\u6237\u4e14\u62e5\u6709\u6307\u5b9a\u8d44\u6e90\u80fd\u529b", userdata="\u8bbf\u95ee\u7528\u6237\u5fc5\u987b\u5df2\u7ecf\u767b\u5f55\uff0c\u4e14\u5bf9\u6307\u5b9a\u7684\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u5177\u5907\u80fd\u529b")})
public class ViewAccessUsersCodeListModel
extends StaticCodeListModelBase {
    public static final String UNKNOWN = "0";
    public static final String UNLOGINUSER = "1";
    public static final String LOGINUSER = "2";
    public static final String ALLUSER = "3";
    public static final String LOGINUSERWITHKEY = "4";

    public ViewAccessUsersCodeListModel() {
        this.initAnnotation(ViewAccessUsersCodeListModel.class);
        this.setUserData2("AccessUserMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel");
    }
}


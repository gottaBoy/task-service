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

@CodeList(id="f2c206e88cc8d112aba03a701a622206", name="\u7cfb\u7edf\u5e94\u7528\u529f\u80fd\u9875\u9762", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DOWNLOADTMPFILE", text="\u4e0b\u8f7d\u4e34\u65f6\u6587\u4ef6", realtext="\u4e0b\u8f7d\u4e34\u65f6\u6587\u4ef6"), @CodeItem(value="LOGIN", text="\u767b\u5f55\u9875\u9762", realtext="\u767b\u5f55\u9875\u9762"), @CodeItem(value="LOGOUT", text="\u6ce8\u9500\u9875\u9762", realtext="\u6ce8\u9500\u9875\u9762"), @CodeItem(value="START", text="\u542f\u52a8\u89c6\u56fe", realtext="\u542f\u52a8\u89c6\u56fe"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class AppUtilPageCodeListModel
extends StaticCodeListModelBase {
    public static final String DOWNLOADTMPFILE = "DOWNLOADTMPFILE";
    public static final String LOGIN = "LOGIN";
    public static final String LOGOUT = "LOGOUT";
    public static final String START = "START";
    public static final String USER = "USER";

    public AppUtilPageCodeListModel() {
        this.initAnnotation(AppUtilPageCodeListModel.class);
        this.setUserData2("AppUtilPage");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilPageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilPageCodeListModel");
    }
}


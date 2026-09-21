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

@CodeList(id="bfb7f6418bf69c49ff6de771520f1526", name="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u8ba4\u8bc1\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u65e0\u8ba4\u8bc1\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u8ba4\u8bc1", realtext="\u65e0\u8ba4\u8bc1"), @CodeItem(value="AUTHORIZATION_CODE", text="\u6388\u6743\u7801\u6a21\u5f0f", realtext="\u6388\u6743\u7801\u6a21\u5f0f"), @CodeItem(value="PASSWORD", text="\u5bc6\u7801\u6a21\u5f0f", realtext="\u5bc6\u7801\u6a21\u5f0f"), @CodeItem(value="CLIENT_CREDENTIALS", text="\u5ba2\u6237\u7aef\u6a21\u5f0f", realtext="\u5ba2\u6237\u7aef\u6a21\u5f0f"), @CodeItem(value="IMPLICIT", text="\u7b80\u5316\u6a21\u5f0f", realtext="\u7b80\u5316\u6a21\u5f0f"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class APIAuthModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String AUTHORIZATION_CODE = "AUTHORIZATION_CODE";
    public static final String PASSWORD = "PASSWORD";
    public static final String CLIENT_CREDENTIALS = "CLIENT_CREDENTIALS";
    public static final String IMPLICIT = "IMPLICIT";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public APIAuthModeCodeListModel() {
        this.initAnnotation(APIAuthModeCodeListModel.class);
        this.setUserData2("APIAuthMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.APIAuthModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.APIAuthModeCodeListModel");
    }
}


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

@CodeList(id="88364237-0EF8-4DB0-A854-947611E0A2F4", name="\u51ed\u8bc1\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="USERNAME_PASSWORD", text="\u7528\u6237\u540d\u548c\u5bc6\u7801", realtext="\u7528\u6237\u540d\u548c\u5bc6\u7801"), @CodeItem(value="SSH_USERNAME_PRIVATEKEY", text="SSH\u7528\u6237\u540d\u548c\u79c1\u94a5", realtext="SSH\u7528\u6237\u540d\u548c\u79c1\u94a5"), @CodeItem(value="SECRETTEXT", text="\u79d8\u5bc6\u6587\u672c", realtext="\u79d8\u5bc6\u6587\u672c"), @CodeItem(value="CERTIFICATE", text="\u8bc1\u4e66", realtext="\u8bc1\u4e66"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class CredentialTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String USERNAME_PASSWORD = "USERNAME_PASSWORD";
    public static final String SSH_USERNAME_PRIVATEKEY = "SSH_USERNAME_PRIVATEKEY";
    public static final String SECRETTEXT = "SECRETTEXT";
    public static final String CERTIFICATE = "CERTIFICATE";
    public static final String USER = "USER";

    public CredentialTypeCodeListModel() {
        this.initAnnotation(CredentialTypeCodeListModel.class);
        this.setUserData2("CredentialType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CredentialTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CredentialTypeCodeListModel");
    }
}


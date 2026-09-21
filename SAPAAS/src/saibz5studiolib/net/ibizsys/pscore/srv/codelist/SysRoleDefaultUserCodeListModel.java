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

@CodeList(id="f9dd90d2db90a66e7efb67040c06834a", name="\u7cfb\u7edf\u89d2\u8272\u9ed8\u8ba4\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="ACCESSUSER", text="\u6388\u6743\u8bbf\u95ee\u7528\u6237", realtext="\u6388\u6743\u8bbf\u95ee\u7528\u6237", userdata="\u89d2\u8272\u4e2d\u7684\u7528\u6237\u5c06\u88ab\u6388\u6743\u8bbf\u95ee\u7cfb\u7edf"), @CodeItem(value="ACCESSADMIN", text="\u6388\u6743\u8bbf\u95ee\u7528\u6237\uff08\u7ba1\u7406\u5458\uff09", realtext="\u6388\u6743\u8bbf\u95ee\u7528\u6237\uff08\u7ba1\u7406\u5458\uff09", userdata="\u89d2\u8272\u4e2d\u7684\u7528\u6237\u5c06\u88ab\u6388\u6743\u4ee5\u7ba1\u7406\u5458\u7684\u8eab\u4efd\u8bbf\u95ee\u7cfb\u7edf"), @CodeItem(value="USER", text="\u7528\u6237\u9ed8\u8ba4", realtext="\u7528\u6237\u9ed8\u8ba4", userdata="\u7528\u6237\u5c06\u9ed8\u8ba4\u5177\u5907\u8be5\u89d2\u8272\u8eab\u4efd"), @CodeItem(value="ADMIN", text="\u7ba1\u7406\u5458\u9ed8\u8ba4", realtext="\u7ba1\u7406\u5458\u9ed8\u8ba4", userdata="\u7ba1\u7406\u5458\u5c06\u9ed8\u8ba4\u5177\u5907\u8be5\u89d2\u8272\u8eab\u4efd")})
public class SysRoleDefaultUserCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String ACCESSUSER = "ACCESSUSER";
    public static final String ACCESSADMIN = "ACCESSADMIN";
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";

    public SysRoleDefaultUserCodeListModel() {
        this.initAnnotation(SysRoleDefaultUserCodeListModel.class);
        this.setUserData2("SysRoleDefaultUser");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRoleDefaultUserCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRoleDefaultUserCodeListModel");
    }
}


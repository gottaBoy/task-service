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

@CodeList(id="6fe2217dcea007ffb78c51df0bad0bfc", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u7528\u6237\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="USER", text="\u7528\u6237", realtext="\u7528\u6237", iconpath="default/psdevuserobj/icon_psdevuserobjtype_user.png", iconpathx="default/psdevuserobj/icon_psdevuserobjtype_user@{0}x.png"), @CodeItem(value="USERGROUP", text="\u7528\u6237\u7ec4", realtext="\u7528\u6237\u7ec4", iconpath="default/psdevuserobj/icon_psdevuserobjtype_usergroup.png", iconpathx="default/psdevuserobj/icon_psdevuserobjtype_usergroup@{0}x.png")})
public class DevUserObjectTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String USER = "USER";
    public static final String USERGROUP = "USERGROUP";

    public DevUserObjectTypeCodeListModel() {
        this.initAnnotation(DevUserObjectTypeCodeListModel.class);
        this.setUserData2("DevUserObjectType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevUserObjectTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevUserObjectTypeCodeListModel");
    }
}


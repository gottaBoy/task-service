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

@CodeList(id="101bf4cdf986647dc8d34412478c017f", name="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u89d2\u8272\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSROLE", text="\u7cfb\u7edf\u89d2\u8272", realtext="\u7cfb\u7edf\u89d2\u8272", userdata="\u7cfb\u7edf\u7684\u64cd\u4f5c\u7528\u6237\u89d2\u8272"), @CodeItem(value="DEROLE", text="\u5b9e\u4f53\u89d2\u8272", realtext="\u5b9e\u4f53\u89d2\u8272", userdata="\u5f53\u524d\u5b9e\u4f53\u7684\u64cd\u4f5c\u7528\u6237\u89d2\u8272")})
public class DEOPPrivRoleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSROLE = "SYSROLE";
    public static final String DEROLE = "DEROLE";

    public DEOPPrivRoleTypeCodeListModel() {
        this.initAnnotation(DEOPPrivRoleTypeCodeListModel.class);
        this.setUserData2("DEOPPrivRoleType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEOPPrivRoleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEOPPrivRoleTypeCodeListModel");
    }
}


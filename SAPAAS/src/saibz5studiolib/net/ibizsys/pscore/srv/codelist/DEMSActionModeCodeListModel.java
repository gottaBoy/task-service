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

@CodeList(id="97d2d55bb665e987a46c11d0c09f6ccb", name="\u5b9e\u4f53\u4e3b\u72b6\u6001\u884c\u4e3a\u5141\u8bb8\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ALLOW", text="\u5141\u8bb8", realtext="\u5141\u8bb8", userdata="\u5141\u8bb8\u6a21\u5f0f"), @CodeItem(value="DENY", text="\u62d2\u7edd", realtext="\u62d2\u7edd", userdata="\u62d2\u7edd\u6a21\u5f0f")})
public class DEMSActionModeCodeListModel
extends StaticCodeListModelBase {
    public static final String ALLOW = "ALLOW";
    public static final String DENY = "DENY";

    public DEMSActionModeCodeListModel() {
        this.initAnnotation(DEMSActionModeCodeListModel.class);
        this.setUserData2("DEMSActionMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSActionModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSActionModeCodeListModel");
    }
}


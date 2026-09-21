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

@CodeList(id="d97f21b2652d9c5e6ca4b775006cefaf", name="\u8868\u5355\u529f\u80fd\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="WFACTION", text="\u6d41\u7a0b\u64cd\u4f5c", realtext="\u6d41\u7a0b\u64cd\u4f5c", userdata="\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u8868\u5355"), @CodeItem(value="WIZARDFORM", text="\u5411\u5bfc\u8868\u5355", realtext="\u5411\u5bfc\u8868\u5355", userdata="\u5411\u5bfc\u8868\u5355")})
public class FormFuncModeCodeListModel
extends StaticCodeListModelBase {
    public static final String WFACTION = "WFACTION";
    public static final String WIZARDFORM = "WIZARDFORM";

    public FormFuncModeCodeListModel() {
        this.initAnnotation(FormFuncModeCodeListModel.class);
        this.setUserData2("FormFuncMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormFuncModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormFuncModeCodeListModel");
    }
}


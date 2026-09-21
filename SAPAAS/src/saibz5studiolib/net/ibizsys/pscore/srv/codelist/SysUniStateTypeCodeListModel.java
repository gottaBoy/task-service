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

@CodeList(id="0d91374f3b9768d59d66acd09f3cf016", name="\u7cfb\u7edf\u72b6\u6001\u534f\u540c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DE", text="\u5b9e\u4f53", realtext="\u5b9e\u4f53")})
public class SysUniStateTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DE = "DE";

    public SysUniStateTypeCodeListModel() {
        this.initAnnotation(SysUniStateTypeCodeListModel.class);
        this.setUserData2("UniStateType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUniStateTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUniStateTypeCodeListModel");
    }
}


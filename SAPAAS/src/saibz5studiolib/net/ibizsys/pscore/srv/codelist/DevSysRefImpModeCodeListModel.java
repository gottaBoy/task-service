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

@CodeList(id="ef5374ed69c5b38ccc8c838938b54616", name="\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528\u6a21\u578b\u5bfc\u5165\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="V2", text="\u7248\u672c2\uff08\u57fa\u4e8e\u6a21\u578b\u6587\u4ef6\uff09", realtext="\u7248\u672c2\uff08\u57fa\u4e8e\u6a21\u578b\u6587\u4ef6\uff09")})
public class DevSysRefImpModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String V2 = "V2";

    public DevSysRefImpModeCodeListModel() {
        this.initAnnotation(DevSysRefImpModeCodeListModel.class);
        this.setUserData2("DevSysRefImpMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefImpModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefImpModeCodeListModel");
    }
}


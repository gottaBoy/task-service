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

@CodeList(id="443f31e89f1e3a3a2fc602134e0dac40", name="\u5f00\u53d1\u6a21\u677f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSPF", text="\u524d\u7aef\u6a21\u677f", realtext="\u524d\u7aef\u6a21\u677f"), @CodeItem(value="PSSF", text="\u540e\u53f0\u6a21\u677f", realtext="\u540e\u53f0\u6a21\u677f")})
public class DevSlnTemplTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSPF = "PSPF";
    public static final String PSSF = "PSSF";

    public DevSlnTemplTypeCodeListModel() {
        this.initAnnotation(DevSlnTemplTypeCodeListModel.class);
        this.setUserData2("DevSlnTemplType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnTemplTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnTemplTypeCodeListModel");
    }
}


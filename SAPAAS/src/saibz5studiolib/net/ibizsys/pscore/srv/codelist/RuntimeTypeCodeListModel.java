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

@CodeList(id="4B28D4F8-8F3C-40AA-964C-AA2B60EEB642", name="\u8fd0\u884c\u65f6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="R8", text="R8", realtext="R8"), @CodeItem(value="LITE", text="LITE", realtext="LITE")})
public class RuntimeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String R8 = "R8";
    public static final String LITE = "LITE";

    public RuntimeTypeCodeListModel() {
        this.initAnnotation(RuntimeTypeCodeListModel.class);
        this.setUserData2("RuntimeType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.RuntimeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.RuntimeTypeCodeListModel");
    }
}


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

@CodeList(id="b143176b900d2dd625b72071c0d5af9a", name="\u4e2d\u5fc3\u7edf\u4e00\u7cfb\u7edf\u6a21\u5757\u5b9e\u4f8b\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="USMODULEINST", text="\u4e91\u5e73\u53f0\u6a21\u5757\u5b9e\u4f8b", realtext="\u4e91\u5e73\u53f0\u6a21\u5757\u5b9e\u4f8b"), @CodeItem(value="USDCMODULE", text="\u4e2d\u5fc3\u6a21\u5757\u81ea\u5efa", realtext="\u4e2d\u5fc3\u6a21\u5757\u81ea\u5efa")})
public class USDCModuleInstTypesCodeListModel
extends StaticCodeListModelBase {
    public static final String USMODULEINST = "USMODULEINST";
    public static final String USDCMODULE = "USDCMODULE";

    public USDCModuleInstTypesCodeListModel() {
        this.initAnnotation(USDCModuleInstTypesCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.USDCModuleInstTypesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.USDCModuleInstTypesCodeListModel");
    }
}


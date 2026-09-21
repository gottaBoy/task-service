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

@CodeList(id="c7461c0e686ac4baa20f0f5e1db0753a", name="\u4e91\u90e8\u7f72\u65b9\u6848\u4ea7\u54c1\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEVSLNSYSVER", text="\u5f00\u53d1\u7cfb\u7edf\u7248\u672c", realtext="\u5f00\u53d1\u7cfb\u7edf\u7248\u672c"), @CodeItem(value="DCSYSRES", text="\u5e94\u7528\u4e2d\u5fc3\u7cfb\u7edf\u8d44\u6e90", realtext="\u5e94\u7528\u4e2d\u5fc3\u7cfb\u7edf\u8d44\u6e90")})
public class DepSlnPrdTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVSLNSYSVER = "DEVSLNSYSVER";
    public static final String DCSYSRES = "DCSYSRES";

    public DepSlnPrdTypeCodeListModel() {
        this.initAnnotation(DepSlnPrdTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSlnPrdTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSlnPrdTypeCodeListModel");
    }
}


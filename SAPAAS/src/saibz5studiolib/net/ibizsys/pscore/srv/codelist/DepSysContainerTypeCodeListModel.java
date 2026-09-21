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

@CodeList(id="f304579fdac95853d4401df9ced45911", name="\u90e8\u7f72\u65b9\u6848\u7cfb\u7edf\u5e94\u7528\u5bb9\u5668\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AS", text="\u5e94\u7528\u5bb9\u5668", realtext="\u5e94\u7528\u5bb9\u5668"), @CodeItem(value="ASGROUP", text="\u5e94\u7528\u5bb9\u5668\u7ec4", realtext="\u5e94\u7528\u5bb9\u5668\u7ec4")})
public class DepSysContainerTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String AS = "AS";
    public static final String ASGROUP = "ASGROUP";

    public DepSysContainerTypeCodeListModel() {
        this.initAnnotation(DepSysContainerTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSysContainerTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSysContainerTypeCodeListModel");
    }
}


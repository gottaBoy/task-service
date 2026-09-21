/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;

@CodeList(id="c154a0be23aae5d623a0ad7fae98d443", name="\u5168\u90e8\u4e91\u7cfb\u7edf", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class AllSystemCodeListModel
extends PSDynamicCodeListModelBase {
    public AllSystemCodeListModel() {
        this.initAnnotation(AllSystemCodeListModel.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AllSystemCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AllSystemCodeListModel");
    }
}


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

@CodeList(id="10b268ad4313740eb67e8085db414c40", name="\u52a8\u6001\u6d41\u7a0b\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DYNADETEMPL", text="\u52a8\u6001\u5b9e\u4f53\u6a21\u677f", realtext="\u52a8\u6001\u5b9e\u4f53\u6a21\u677f"), @CodeItem(value="DYNAWORKFLOW", text="\u52a8\u6001\u6d41\u7a0b", realtext="\u52a8\u6001\u6d41\u7a0b")})
public class DynaWorkflowSrcTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DYNADETEMPL = "DYNADETEMPL";
    public static final String DYNAWORKFLOW = "DYNAWORKFLOW";

    public DynaWorkflowSrcTypeCodeListModel() {
        this.initAnnotation(DynaWorkflowSrcTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaWorkflowSrcTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaWorkflowSrcTypeCodeListModel");
    }
}


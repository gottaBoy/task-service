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

@CodeList(id="0e5da120853dc8a4bd8648daff942a60", name="\u5e94\u7528\u4e2d\u5fc3\u80fd\u529b\u5206\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSSTUDIO", text="\u5de5\u5177\u80fd\u529b", realtext="\u5de5\u5177\u80fd\u529b"), @CodeItem(value="PSPF", text="\u524d\u7aef\u5e94\u7528\u6a21\u677f", realtext="\u524d\u7aef\u5e94\u7528\u6a21\u677f"), @CodeItem(value="PSSF", text="\u540e\u53f0\u670d\u52a1\u6a21\u677f", realtext="\u540e\u53f0\u670d\u52a1\u6a21\u677f"), @CodeItem(value="PSDB", text="\u6570\u636e\u5e93", realtext="\u6570\u636e\u5e93")})
public class DCAbilityCatCodeListModel
extends StaticCodeListModelBase {
    public static final String PSSTUDIO = "PSSTUDIO";
    public static final String PSPF = "PSPF";
    public static final String PSSF = "PSSF";
    public static final String PSDB = "PSDB";

    public DCAbilityCatCodeListModel() {
        this.initAnnotation(DCAbilityCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCAbilityCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCAbilityCatCodeListModel");
    }
}


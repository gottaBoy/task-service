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

@CodeList(id="99CA21C9-8871-4D70-9077-A4B5AA4C8F1C", name="\u9879\u76ee\u5411\u5bfc\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="QUICKSYS", text="\u5feb\u901f\u7cfb\u7edf", realtext="\u5feb\u901f\u7cfb\u7edf"), @CodeItem(value="ADVANCESYS", text="\u9ad8\u7ea7\u7cfb\u7edf", realtext="\u9ad8\u7ea7\u7cfb\u7edf"), @CodeItem(value="QUICKSF", text="\u5feb\u901f\u540e\u53f0\u6a21\u677f", realtext="\u5feb\u901f\u540e\u53f0\u6a21\u677f"), @CodeItem(value="QUICKPF", text="\u5feb\u901f\u524d\u7aef\u6a21\u677f", realtext="\u5feb\u901f\u524d\u7aef\u6a21\u677f"), @CodeItem(value="QUICKDYNAINST", text="\u5feb\u901f\u52a8\u6001\u5b9e\u4f8b\uff08\u81ea\u8eab\uff09", realtext="\u5feb\u901f\u52a8\u6001\u5b9e\u4f8b\uff08\u81ea\u8eab\uff09"), @CodeItem(value="APPLYDYNAMODELRES", text="\u5e94\u7528\u52a8\u6001\u6a21\u578b\u8d44\u6e90", realtext="\u5e94\u7528\u52a8\u6001\u6a21\u578b\u8d44\u6e90"), @CodeItem(value="APPLYDYNAINST", text="\u5e94\u7528\u52a8\u6001\u5b9e\u4f8b", realtext="\u5e94\u7528\u52a8\u6001\u5b9e\u4f8b"), @CodeItem(value="RECOMMANDINSTTEMPL", text="\u5e94\u7528\u5b9e\u4f8b\u6a21\u677f", realtext="\u5e94\u7528\u5b9e\u4f8b\u6a21\u677f")})
public class UWProjectModeCodeListModel
extends StaticCodeListModelBase {
    public static final String QUICKSYS = "QUICKSYS";
    public static final String ADVANCESYS = "ADVANCESYS";
    public static final String QUICKSF = "QUICKSF";
    public static final String QUICKPF = "QUICKPF";
    public static final String QUICKDYNAINST = "QUICKDYNAINST";
    public static final String APPLYDYNAMODELRES = "APPLYDYNAMODELRES";
    public static final String APPLYDYNAINST = "APPLYDYNAINST";
    public static final String RECOMMANDINSTTEMPL = "RECOMMANDINSTTEMPL";

    public UWProjectModeCodeListModel() {
        this.initAnnotation(UWProjectModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UWProjectModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UWProjectModeCodeListModel");
    }
}


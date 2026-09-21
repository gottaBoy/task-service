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

@CodeList(id="63d11c6de51cbc7a5a0b15477992841a", name="\u7cfb\u7edf\u4ee3\u7801\u7247\u6bb5\uff08\u6a21\u677f\u7c7b\u578b\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PF", text="\u524d\u7aef\u5e94\u7528\u6a21\u677f", realtext="\u524d\u7aef\u5e94\u7528\u6a21\u677f"), @CodeItem(value="SF", text="\u540e\u53f0\u670d\u52a1\u6a21\u677f", realtext="\u540e\u53f0\u670d\u52a1\u6a21\u677f")})
public class SysSnippetTempTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PF = "PF";
    public static final String SF = "SF";

    public SysSnippetTempTypeCodeListModel() {
        this.initAnnotation(SysSnippetTempTypeCodeListModel.class);
        this.setUserData2("SnippetTemplType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSnippetTempTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSnippetTempTypeCodeListModel");
    }
}


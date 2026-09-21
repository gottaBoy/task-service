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

@CodeList(id="362B043E-6BA7-4AA1-AFD0-87E964ABB585", name="\u955c\u50cf\u9879\u7c7b\u578b\uff08\u955c\u50cf\u5de5\u5177\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="psmodeltool", text="\u6a21\u578b\u5de5\u5177", realtext="\u6a21\u578b\u5de5\u5177"), @CodeItem(value="codegen", text="\u4ee3\u7801\u4ea7\u751f", realtext="\u4ee3\u7801\u4ea7\u751f")})
public class RegistryItemType2CodeListModel
extends StaticCodeListModelBase {
    public static final String PSMODELTOOL = "psmodeltool";
    public static final String CODEGEN = "codegen";

    public RegistryItemType2CodeListModel() {
        this.initAnnotation(RegistryItemType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.RegistryItemType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.RegistryItemType2CodeListModel");
    }
}


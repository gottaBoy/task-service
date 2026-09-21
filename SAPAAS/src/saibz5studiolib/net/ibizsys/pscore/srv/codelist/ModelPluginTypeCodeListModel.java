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

@CodeList(id="00412c62527a14b6711c2e9c15d255f6", name="\u5e73\u53f0\u6a21\u578b\u63d2\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DIFF", text="\u5dee\u5f02\u5bf9\u6bd4", realtext="\u5dee\u5f02\u5bf9\u6bd4"), @CodeItem(value="CHECK", text="\u6a21\u578b\u68c0\u67e5", realtext="\u6a21\u578b\u68c0\u67e5")})
public class ModelPluginTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DIFF = "DIFF";
    public static final String CHECK = "CHECK";

    public ModelPluginTypeCodeListModel() {
        this.initAnnotation(ModelPluginTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelPluginTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelPluginTypeCodeListModel");
    }
}


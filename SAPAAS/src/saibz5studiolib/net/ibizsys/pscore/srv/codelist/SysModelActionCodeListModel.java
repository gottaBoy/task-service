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

@CodeList(id="f632e03e104a7c1f08582c44f4d974f8", name="\u4e91\u5e73\u53f0\u6a21\u578b\u5b9e\u4f8b\u64cd\u4f5c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INIT", text="\u521d\u59cb\u5316\u7ed3\u6784", realtext="\u521d\u59cb\u5316\u7ed3\u6784"), @CodeItem(value="COPY", text="\u590d\u5236\u6a21\u578b", realtext="\u590d\u5236\u6a21\u578b")})
public class SysModelActionCodeListModel
extends StaticCodeListModelBase {
    public static final String INIT = "INIT";
    public static final String COPY = "COPY";

    public SysModelActionCodeListModel() {
        this.initAnnotation(SysModelActionCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelActionCodeListModel");
    }
}


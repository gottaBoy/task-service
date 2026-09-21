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

@CodeList(id="EEF17150-DF57-4126-A468-B84770E7ED7B", name="\u5de5\u5177\u63d2\u4ef6\u7c7b\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CENTRAL", text="\u4e2d\u53f0", realtext="\u4e2d\u53f0"), @CodeItem(value="MODELING", text="\u5efa\u6a21", realtext="\u5efa\u6a21")})
public class StudioPluginCatCodeListModel
extends StaticCodeListModelBase {
    public static final String CENTRAL = "CENTRAL";
    public static final String MODELING = "MODELING";

    public StudioPluginCatCodeListModel() {
        this.initAnnotation(StudioPluginCatCodeListModel.class);
        this.setUserData2("StudioPluginCat");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioPluginCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioPluginCatCodeListModel");
    }
}


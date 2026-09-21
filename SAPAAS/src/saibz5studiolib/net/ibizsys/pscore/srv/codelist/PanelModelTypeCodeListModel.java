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

@CodeList(id="74e965443448296f4f03bd1057e37745", name="\u7cfb\u7edf\u9762\u677f\u6a21\u578b\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PANELMODEL", text="\u9762\u677f\u5b9a\u4e49\u6a21\u578b", realtext="\u9762\u677f\u5b9a\u4e49\u6a21\u578b"), @CodeItem(value="VIEWMODEL", text="\u89c6\u56fe\u5b9a\u4e49\u6a21\u578b", realtext="\u89c6\u56fe\u5b9a\u4e49\u6a21\u578b"), @CodeItem(value="CTRLMODEL", text="\u90e8\u4ef6\u5b9a\u4e49\u6a21\u578b", realtext="\u90e8\u4ef6\u5b9a\u4e49\u6a21\u578b")})
public class PanelModelTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PANELMODEL = "PANELMODEL";
    public static final String VIEWMODEL = "VIEWMODEL";
    public static final String CTRLMODEL = "CTRLMODEL";

    public PanelModelTypeCodeListModel() {
        this.initAnnotation(PanelModelTypeCodeListModel.class);
        this.setUserData2("PanelModelType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelModelTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelModelTypeCodeListModel");
    }
}


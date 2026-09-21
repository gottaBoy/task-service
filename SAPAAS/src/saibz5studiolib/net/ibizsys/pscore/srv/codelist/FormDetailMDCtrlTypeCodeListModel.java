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

@CodeList(id="8175efa1d81945448bad4c3946b5c562", name="\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u6210\u5458\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LIST", text="\u5217\u8868", realtext="\u5217\u8868"), @CodeItem(value="FORM", text="\u8868\u5355", realtext="\u8868\u5355", userdata="\u4f7f\u7528\u8868\u5355\u5faa\u73af\u7ed8\u5236"), @CodeItem(value="GRID", text="\u8868\u683c", realtext="\u8868\u683c"), @CodeItem(value="DATAVIEW", text="\u5361\u7247\u89c6\u56fe", realtext="\u5361\u7247\u89c6\u56fe"), @CodeItem(value="REPEATER", text="\u91cd\u590d\u5668", realtext="\u91cd\u590d\u5668", userdata="\u52a8\u6001\u751f\u6210\u91cd\u590d\u7ed3\u6784\u5316\u8868\u5355\u9879\u6210\u5458")})
public class FormDetailMDCtrlTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String LIST = "LIST";
    public static final String FORM = "FORM";
    public static final String GRID = "GRID";
    public static final String DATAVIEW = "DATAVIEW";
    public static final String REPEATER = "REPEATER";

    public FormDetailMDCtrlTypeCodeListModel() {
        this.initAnnotation(FormDetailMDCtrlTypeCodeListModel.class);
        this.setUserData2("FormDetailMDCtrlType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailMDCtrlTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailMDCtrlTypeCodeListModel");
    }
}


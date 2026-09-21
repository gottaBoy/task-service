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

@CodeList(id="DC83F336-42E7-4C68-A602-322A52FFDCCB", name="\u8868\u5355\u591a\u6570\u636e\u6210\u5458\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u65b0\u5efa", realtext="\u65b0\u5efa", userdata="\u652f\u6301\u5efa\u7acb\u6570\u636e\u64cd\u4f5c"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0", userdata="\u652f\u6301\u66f4\u65b0\u6570\u636e\u64cd\u4f5c"), @CodeItem(value="4", text="\u5220\u9664", realtext="\u5220\u9664", userdata="\u652f\u6301\u5220\u9664\u6570\u636e\u64cd\u4f5c")})
public class FormMDCtrlActionCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer REMOVE = 4;
    public static final int INT_REMOVE = 4;

    public FormMDCtrlActionCodeListModel() {
        this.initAnnotation(FormMDCtrlActionCodeListModel.class);
        this.setUserData2("FormMDCtrlAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormMDCtrlActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormMDCtrlActionCodeListModel");
    }
}


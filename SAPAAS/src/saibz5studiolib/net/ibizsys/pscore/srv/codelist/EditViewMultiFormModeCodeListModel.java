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

@CodeList(id="E54A9F2A-EC0A-4C31-AE10-A53F70DB1FB8", name="\u7f16\u8f91\u89c6\u56fe\u591a\u8868\u5355\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u65e0\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u6570\u636e\u7c7b\u578b\u591a\u8868\u5355", realtext="\u6570\u636e\u7c7b\u578b\u591a\u8868\u5355"), @CodeItem(value="2", text="\u4e3b\u72b6\u6001\u591a\u8868\u5355", realtext="\u4e3b\u72b6\u6001\u591a\u8868\u5355")})
public class EditViewMultiFormModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer DATATYPE = 1;
    public static final int INT_DATATYPE = 1;
    public static final Integer MAINSTATE = 2;
    public static final int INT_MAINSTATE = 2;

    public EditViewMultiFormModeCodeListModel() {
        this.initAnnotation(EditViewMultiFormModeCodeListModel.class);
        this.setUserData2("EditViewMultiFormMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel");
    }
}


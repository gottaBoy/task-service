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

@CodeList(id="48D4440B-1FE3-4F9C-842E-5FD347066402", name="\u5b9e\u4f53\u591a\u8868\u5355\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="2", text="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5757\u526f\u672c", realtext="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5757\u526f\u672c")})
public class DEMultiFormModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NO = 0;
    public static final int INT_NO = 0;
    public static final Integer DEFAULT = 1;
    public static final int INT_DEFAULT = 1;
    public static final Integer MODULEINST = 2;
    public static final int INT_MODULEINST = 2;

    public DEMultiFormModeCodeListModel() {
        this.initAnnotation(DEMultiFormModeCodeListModel.class);
        this.setUserData2("DEMultiFormMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMultiFormModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMultiFormModeCodeListModel");
    }
}


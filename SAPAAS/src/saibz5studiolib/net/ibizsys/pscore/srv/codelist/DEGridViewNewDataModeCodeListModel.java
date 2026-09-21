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

@CodeList(id="8033d526c00757ad6aafb320eafb3836", name="\u4e91\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\u65b0\u5efa\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WIZARD", text="\u5411\u5bfc", realtext="\u5411\u5bfc"), @CodeItem(value="MULTIFORM", text="\u591a\u8868\u5355", realtext="\u591a\u8868\u5355"), @CodeItem(value="INDEXDE", text="\u7d22\u5f15\u5b9e\u4f53", realtext="\u7d22\u5f15\u5b9e\u4f53"), @CodeItem(value="NORMAL", text="\u5e38\u89c4", realtext="\u5e38\u89c4")})
public class DEGridViewNewDataModeCodeListModel
extends StaticCodeListModelBase {
    public static final String WIZARD = "WIZARD";
    public static final String MULTIFORM = "MULTIFORM";
    public static final String INDEXDE = "INDEXDE";
    public static final String NORMAL = "NORMAL";

    public DEGridViewNewDataModeCodeListModel() {
        this.initAnnotation(DEGridViewNewDataModeCodeListModel.class);
        this.setUserData2("NewDataMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
    }
}


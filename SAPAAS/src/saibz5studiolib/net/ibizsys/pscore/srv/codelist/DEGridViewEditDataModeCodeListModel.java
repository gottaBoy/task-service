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

@CodeList(id="4dcb7ec17fedf7ce579e30b602521206", name="\u4e91\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\u7f16\u8f91\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MULTIFORM", text="\u591a\u8868\u5355", realtext="\u591a\u8868\u5355"), @CodeItem(value="INDEXDE", text="\u7d22\u5f15\u5b9e\u4f53", realtext="\u7d22\u5f15\u5b9e\u4f53"), @CodeItem(value="NORMAL", text="\u5e38\u89c4", realtext="\u5e38\u89c4")})
public class DEGridViewEditDataModeCodeListModel
extends StaticCodeListModelBase {
    public static final String MULTIFORM = "MULTIFORM";
    public static final String INDEXDE = "INDEXDE";
    public static final String NORMAL = "NORMAL";

    public DEGridViewEditDataModeCodeListModel() {
        this.initAnnotation(DEGridViewEditDataModeCodeListModel.class);
        this.setUserData2("EditDataMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
    }
}


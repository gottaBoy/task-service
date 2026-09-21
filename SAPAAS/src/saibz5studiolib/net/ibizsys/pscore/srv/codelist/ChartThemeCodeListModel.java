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

@CodeList(id="7c96e16f8745379a18261ce496b41532", name="\u4e91\u5b9e\u4f53\u56fe\u8868\u4e3b\u9898", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="THEME1", text="\u4e3b\u98981", realtext="\u4e3b\u98981"), @CodeItem(value="THEME2", text="\u4e3b\u98982", realtext="\u4e3b\u98982"), @CodeItem(value="THEME3", text="\u4e3b\u98983", realtext="\u4e3b\u98983"), @CodeItem(value="THEME4", text="\u4e3b\u98984", realtext="\u4e3b\u98984"), @CodeItem(value="THEME5", text="\u4e3b\u98985", realtext="\u4e3b\u98985")})
public class ChartThemeCodeListModel
extends StaticCodeListModelBase {
    public static final String THEME1 = "THEME1";
    public static final String THEME2 = "THEME2";
    public static final String THEME3 = "THEME3";
    public static final String THEME4 = "THEME4";
    public static final String THEME5 = "THEME5";

    public ChartThemeCodeListModel() {
        this.initAnnotation(ChartThemeCodeListModel.class);
        this.setUserData2("ChartTheme");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartThemeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartThemeCodeListModel");
    }
}


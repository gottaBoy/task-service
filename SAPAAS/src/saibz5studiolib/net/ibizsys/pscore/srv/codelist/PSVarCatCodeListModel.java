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

@CodeList(id="9b1d308d2c749da9346f5a12e7fc74e2", name="\u4e91\u5e73\u53f0\u53d8\u91cf\u793a\u4f8b\u503c\uff08\u53d8\u91cf\u5f52\u7c7b\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FORM", text="\u8868\u5355", realtext="\u8868\u5355"), @CodeItem(value="SYS", text="\u7cfb\u7edf", realtext="\u7cfb\u7edf"), @CodeItem(value="FMT_JAVA", text="\u503c\u683c\u5f0f\u5316\uff08java\uff09", realtext="\u503c\u683c\u5f0f\u5316\uff08java\uff09"), @CodeItem(value="FMT_DOTNET", text="\u503c\u683c\u5f0f\u5316\uff08.NET)", realtext="\u503c\u683c\u5f0f\u5316\uff08.NET)"), @CodeItem(value="LAYOUT_TABLE", text="\u8868\u683c\u5e03\u5c40\u5217\u6a21\u578b", realtext="\u8868\u683c\u5e03\u5c40\u5217\u6a21\u578b"), @CodeItem(value="FONTFAMILY", text="\u5b57\u4f53", realtext="\u5b57\u4f53"), @CodeItem(value="FONTSIZE", text="\u5b57\u4f53\u5927\u5c0f", realtext="\u5b57\u4f53\u5927\u5c0f"), @CodeItem(value="FORMITEM", text="\u7cfb\u7edf\u8868\u5355\u9879", realtext="\u7cfb\u7edf\u8868\u5355\u9879"), @CodeItem(value="GRIDITEM", text="\u7cfb\u7edf\u8868\u683c\u9879", realtext="\u7cfb\u7edf\u8868\u683c\u9879"), @CodeItem(value="VIEWFIELD", text="\u7cfb\u7edf\u89c6\u56fe\u5c5e\u6027", realtext="\u7cfb\u7edf\u89c6\u56fe\u5c5e\u6027"), @CodeItem(value="LISTITEM", text="\u7cfb\u7edf\u5217\u8868\u9879", realtext="\u7cfb\u7edf\u5217\u8868\u9879"), @CodeItem(value="DATAVIEWITEM", text="\u7cfb\u7edf\u6570\u636e\u89c6\u56fe\u9879", realtext="\u7cfb\u7edf\u6570\u636e\u89c6\u56fe\u9879")})
public class PSVarCatCodeListModel
extends StaticCodeListModelBase {
    public static final String FORM = "FORM";
    public static final String SYS = "SYS";
    public static final String FMT_JAVA = "FMT_JAVA";
    public static final String FMT_DOTNET = "FMT_DOTNET";
    public static final String LAYOUT_TABLE = "LAYOUT_TABLE";
    public static final String FONTFAMILY = "FONTFAMILY";
    public static final String FONTSIZE = "FONTSIZE";
    public static final String FORMITEM = "FORMITEM";
    public static final String GRIDITEM = "GRIDITEM";
    public static final String VIEWFIELD = "VIEWFIELD";
    public static final String LISTITEM = "LISTITEM";
    public static final String DATAVIEWITEM = "DATAVIEWITEM";

    public PSVarCatCodeListModel() {
        this.initAnnotation(PSVarCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSVarCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSVarCatCodeListModel");
    }
}


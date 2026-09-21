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

@CodeList(id="bf63b21f198b1be76fbd3d5e8da65ca4", name="\u4e91\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u7c7b\u578b\uff08\u9759\u6001\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEXT", text="\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6", realtext="\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6"), @CodeItem(value="LONGTEXT_1000", text="\u957f\u6587\u672c\uff0c\u957f\u5ea61000", realtext="\u957f\u6587\u672c\uff0c\u957f\u5ea61000"), @CodeItem(value="LONGTEXT", text="\u957f\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236", realtext="\u957f\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236"), @CodeItem(value="HTMLTEXT", text="HTML\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236", realtext="HTML\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236"), @CodeItem(value="INT", text="\u6574\u578b", realtext="\u6574\u578b"), @CodeItem(value="FLOAT", text="\u6d6e\u70b9", realtext="\u6d6e\u70b9"), @CodeItem(value="DECIMAL", text="\u6570\u503c", realtext="\u6570\u503c"), @CodeItem(value="DATETIME", text="\u65e5\u671f\u65f6\u95f4\u578b", realtext="\u65e5\u671f\u65f6\u95f4\u578b"), @CodeItem(value="DATE", text="\u65e5\u671f\u578b", realtext="\u65e5\u671f\u578b"), @CodeItem(value="TIME", text="\u65f6\u95f4\u578b", realtext="\u65f6\u95f4\u578b"), @CodeItem(value="YESNO", text="\u662f\u5426\u903b\u8f91", realtext="\u662f\u5426\u903b\u8f91"), @CodeItem(value="TRUEFALSE", text="\u771f\u5047\u903b\u8f91", realtext="\u771f\u5047\u903b\u8f91"), @CodeItem(value="NSCODELIST", text="\u5355\u9879\u9009\u62e9(\u6570\u503c)", realtext="\u5355\u9879\u9009\u62e9(\u6570\u503c)"), @CodeItem(value="SSCODELIST", text="\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)", realtext="\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)"), @CodeItem(value="NMCODELIST", text="\u591a\u9879\u9009\u62e9(\u6570\u503c)", realtext="\u591a\u9879\u9009\u62e9(\u6570\u503c)"), @CodeItem(value="SMCODELIST", text="\u591a\u9879\u9009\u62e9(\u6587\u672c\u503c)", realtext="\u591a\u9879\u9009\u62e9(\u6587\u672c\u503c)")})
public class DEFDataTypes2CodeListModel
extends StaticCodeListModelBase {
    public static final String TEXT = "TEXT";
    public static final String LONGTEXT_1000 = "LONGTEXT_1000";
    public static final String LONGTEXT = "LONGTEXT";
    public static final String HTMLTEXT = "HTMLTEXT";
    public static final String INT = "INT";
    public static final String FLOAT = "FLOAT";
    public static final String DECIMAL = "DECIMAL";
    public static final String DATETIME = "DATETIME";
    public static final String DATE = "DATE";
    public static final String TIME = "TIME";
    public static final String YESNO = "YESNO";
    public static final String TRUEFALSE = "TRUEFALSE";
    public static final String NSCODELIST = "NSCODELIST";
    public static final String SSCODELIST = "SSCODELIST";
    public static final String NMCODELIST = "NMCODELIST";
    public static final String SMCODELIST = "SMCODELIST";

    public DEFDataTypes2CodeListModel() {
        this.initAnnotation(DEFDataTypes2CodeListModel.class);
        this.setUserData2("SimpleDEFDataType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDataTypes2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDataTypes2CodeListModel");
    }
}


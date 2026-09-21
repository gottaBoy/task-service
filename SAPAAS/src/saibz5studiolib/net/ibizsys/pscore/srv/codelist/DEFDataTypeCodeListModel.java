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

@CodeList(id="BC064569-DEC0-4571-8CE0-92097152E7AD", name="\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ACID", text="\u81ea\u589e\u6807\u8bc6\uff0c\u6574\u6570\u7c7b\u578b\uff0c\u7528\u6237\u4e0d\u53ef\u89c1", realtext="\u81ea\u589e\u6807\u8bc6\uff0c\u6574\u6570\u7c7b\u578b\uff0c\u7528\u6237\u4e0d\u53ef\u89c1"), @CodeItem(value="BIGINT", text="\u5927\u6574\u578b", realtext="\u5927\u6574\u578b"), @CodeItem(value="CODELISTTEXT", text="\u9009\u62e9\u9879\u6587\u672c", realtext="\u9009\u62e9\u9879\u6587\u672c"), @CodeItem(value="CURRENCY", text="\u8d27\u5e01", realtext="\u8d27\u5e01"), @CodeItem(value="CURRENCYUNIT", text="\u8d27\u5e01\u5355\u4f4d", realtext="\u8d27\u5e01\u5355\u4f4d"), @CodeItem(value="DATE", text="\u65e5\u671f\u578b", realtext="\u65e5\u671f\u578b"), @CodeItem(value="DATETIME", text="\u65e5\u671f\u65f6\u95f4\u578b", realtext="\u65e5\u671f\u65f6\u95f4\u578b"), @CodeItem(value="DATETIME_BIRTHDAY", text="\u51fa\u751f\u65e5\u671f", realtext="\u51fa\u751f\u65e5\u671f"), @CodeItem(value="DECIMAL", text="\u6570\u503c", realtext="\u6570\u503c"), @CodeItem(value="BIGDECIMAL", text="\u5927\u6570\u503c", realtext="\u5927\u6570\u503c"), @CodeItem(value="FLOAT", text="\u6d6e\u70b9", realtext="\u6d6e\u70b9"), @CodeItem(value="GUID", text="\u5168\u5c40\u552f\u4e00\u6807\u8bc6\uff0c\u6587\u672c\u7c7b\u578b\uff0c\u7528\u6237\u4e0d\u53ef\u89c1", realtext="\u5168\u5c40\u552f\u4e00\u6807\u8bc6\uff0c\u6587\u672c\u7c7b\u578b\uff0c\u7528\u6237\u4e0d\u53ef\u89c1"), @CodeItem(value="HTMLTEXT", text="HTML\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236", realtext="HTML\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236"), @CodeItem(value="INHERIT", text="\u7ee7\u627f\u5c5e\u6027", realtext="\u7ee7\u627f\u5c5e\u6027"), @CodeItem(value="INT", text="\u6574\u578b", realtext="\u6574\u578b"), @CodeItem(value="LONGTEXT", text="\u957f\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236", realtext="\u957f\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236"), @CodeItem(value="LONGTEXT_1000", text="\u957f\u6587\u672c\uff0c\u957f\u5ea61000", realtext="\u957f\u6587\u672c\uff0c\u957f\u5ea61000"), @CodeItem(value="NBID", text="\u6570\u5b57\u4e32\u4e1a\u52a1\u6807\u8bc6\uff0c\u6570\u5b57\u7c7b\u578b\uff0c\u7528\u6237\u53ef\u89c1", realtext="\u6570\u5b57\u4e32\u4e1a\u52a1\u6807\u8bc6\uff0c\u6570\u5b57\u7c7b\u578b\uff0c\u7528\u6237\u53ef\u89c1"), @CodeItem(value="NMCODELIST", text="\u591a\u9879\u9009\u62e9(\u6570\u503c)", realtext="\u591a\u9879\u9009\u62e9(\u6570\u503c)"), @CodeItem(value="NSCODELIST", text="\u5355\u9879\u9009\u62e9(\u6570\u503c)", realtext="\u5355\u9879\u9009\u62e9(\u6570\u503c)"), @CodeItem(value="PICKUP", text="\u5916\u952e\u503c", realtext="\u5916\u952e\u503c"), @CodeItem(value="PICKUPDATA", text="\u5916\u952e\u503c\u9644\u52a0\u6570\u636e", realtext="\u5916\u952e\u503c\u9644\u52a0\u6570\u636e"), @CodeItem(value="PICKUPTEXT", text="\u5916\u952e\u503c\u6587\u672c", realtext="\u5916\u952e\u503c\u6587\u672c"), @CodeItem(value="SBID", text="\u5b57\u7b26\u4e32\u4e1a\u52a1\u6807\u8bc6\uff0c\u6587\u672c\u7c7b\u578b\uff0c\u7528\u6237\u53ef\u89c1", realtext="\u5b57\u7b26\u4e32\u4e1a\u52a1\u6807\u8bc6\uff0c\u6587\u672c\u7c7b\u578b\uff0c\u7528\u6237\u53ef\u89c1"), @CodeItem(value="SMCODELIST", text="\u591a\u9879\u9009\u62e9(\u6587\u672c\u503c)", realtext="\u591a\u9879\u9009\u62e9(\u6587\u672c\u503c)"), @CodeItem(value="SSCODELIST", text="\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)", realtext="\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)"), @CodeItem(value="TEXT", text="\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6", realtext="\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6"), @CodeItem(value="TEXT_EMAIL", text="\u7535\u5b50\u90ae\u4ef6", realtext="\u7535\u5b50\u90ae\u4ef6"), @CodeItem(value="TIME", text="\u65f6\u95f4\u578b", realtext="\u65f6\u95f4\u578b"), @CodeItem(value="TRUEFALSE", text="\u771f\u5047\u903b\u8f91", realtext="\u771f\u5047\u903b\u8f91"), @CodeItem(value="VARBINARY", text="\u4e8c\u8fdb\u5236\u6d41\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236", realtext="\u4e8c\u8fdb\u5236\u6d41\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236"), @CodeItem(value="WFSTATE", text="\u5de5\u4f5c\u6d41\u5904\u7406\u72b6\u6001", realtext="\u5de5\u4f5c\u6d41\u5904\u7406\u72b6\u6001"), @CodeItem(value="YESNO", text="\u662f\u5426\u903b\u8f91", realtext="\u662f\u5426\u903b\u8f91"), @CodeItem(value="ONE2MANYDATA", text="\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u96c6\u5408", realtext="\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u96c6\u5408"), @CodeItem(value="ONE2MANYDATA_MAP", text="\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u96c6\u5408\uff08MAP\uff09", realtext="\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u96c6\u5408\uff08MAP\uff09"), @CodeItem(value="PICKUPOBJECT", text="\u5916\u952e\u503c\u5bf9\u8c61", realtext="\u5916\u952e\u503c\u5bf9\u8c61"), @CodeItem(value="ONE2ONEDATA", text="\u4e00\u5bf9\u4e00\u5173\u7cfb\u6570\u636e\u5bf9\u8c61", realtext="\u4e00\u5bf9\u4e00\u5173\u7cfb\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="FILE", text="\u6587\u4ef6", realtext="\u6587\u4ef6"), @CodeItem(value="ONE2MANYOBJ", text="\u4e00\u5bf9\u591a\u52a8\u6001\u5bf9\u8c61", realtext="\u4e00\u5bf9\u591a\u52a8\u6001\u5bf9\u8c61"), @CodeItem(value="ONE2MANYOBJ_MAP", text="\u4e00\u5bf9\u591a\u52a8\u6001\u5bf9\u8c61\uff08MAP\uff09", realtext="\u4e00\u5bf9\u591a\u52a8\u6001\u5bf9\u8c61\uff08MAP\uff09"), @CodeItem(value="ONE2ONEOBJ", text="\u4e00\u5bf9\u4e00\u52a8\u6001\u5bf9\u8c61", realtext="\u4e00\u5bf9\u4e00\u52a8\u6001\u5bf9\u8c61"), @CodeItem(value="FILELIST", text="\u6587\u4ef6\u5217\u8868", realtext="\u6587\u4ef6\u5217\u8868"), @CodeItem(value="LONGFILELIST", text="\u6587\u4ef6\u5217\u8868\uff0c\u6ca1\u6709\u6570\u91cf\u9650\u5236", realtext="\u6587\u4ef6\u5217\u8868\uff0c\u6ca1\u6709\u6570\u91cf\u9650\u5236"), @CodeItem(value="PICTURE", text="\u56fe\u7247", realtext="\u56fe\u7247"), @CodeItem(value="PICTURELIST", text="\u56fe\u7247\u5217\u8868", realtext="\u56fe\u7247\u5217\u8868"), @CodeItem(value="LONGPICTURELIST", text="\u56fe\u7247\u5217\u8868\uff0c\u6ca1\u6709\u6570\u91cf\u9650\u5236", realtext="\u56fe\u7247\u5217\u8868\uff0c\u6ca1\u6709\u6570\u91cf\u9650\u5236"), @CodeItem(value="TEXTARRAY", text="\u6587\u672c\u6570\u7ec4", realtext="\u6587\u672c\u6570\u7ec4"), @CodeItem(value="TEXTARRAY2", text="\u6587\u672c\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09", realtext="\u6587\u672c\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09"), @CodeItem(value="INTARRAY", text="\u6574\u5f62\u6570\u7ec4", realtext="\u6574\u5f62\u6570\u7ec4"), @CodeItem(value="INTARRAY2", text="\u6574\u5f62\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09", realtext="\u6574\u5f62\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09"), @CodeItem(value="BIGINTARRAY", text="\u5927\u6574\u5f62\u6570\u7ec4", realtext="\u5927\u6574\u5f62\u6570\u7ec4"), @CodeItem(value="BIGINTARRAY2", text="\u5927\u6574\u5f62\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09", realtext="\u5927\u6574\u5f62\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09"), @CodeItem(value="FLOATARRAY", text="\u6d6e\u70b9\u6570\u7ec4", realtext="\u6d6e\u70b9\u6570\u7ec4"), @CodeItem(value="FLOATARRAY2", text="\u6d6e\u70b9\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09", realtext="\u6d6e\u70b9\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09"), @CodeItem(value="DECIMALARRAY", text="\u6570\u503c\u6570\u7ec4", realtext="\u6570\u503c\u6570\u7ec4"), @CodeItem(value="DECIMALARRAY2", text="\u6570\u503c\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09", realtext="\u6570\u503c\u6570\u7ec4\uff08\u6ca1\u6709\u957f\u5ea6\u9650\u5236\uff09")})
public class DEFDataTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ACID = "ACID";
    public static final String BIGINT = "BIGINT";
    public static final String CODELISTTEXT = "CODELISTTEXT";
    public static final String CURRENCY = "CURRENCY";
    public static final String CURRENCYUNIT = "CURRENCYUNIT";
    public static final String DATE = "DATE";
    public static final String DATETIME = "DATETIME";
    public static final String DATETIME_BIRTHDAY = "DATETIME_BIRTHDAY";
    public static final String DECIMAL = "DECIMAL";
    public static final String BIGDECIMAL = "BIGDECIMAL";
    public static final String FLOAT = "FLOAT";
    public static final String GUID = "GUID";
    public static final String HTMLTEXT = "HTMLTEXT";
    public static final String INHERIT = "INHERIT";
    public static final String INT = "INT";
    public static final String LONGTEXT = "LONGTEXT";
    public static final String LONGTEXT_1000 = "LONGTEXT_1000";
    public static final String NBID = "NBID";
    public static final String NMCODELIST = "NMCODELIST";
    public static final String NSCODELIST = "NSCODELIST";
    public static final String PICKUP = "PICKUP";
    public static final String PICKUPDATA = "PICKUPDATA";
    public static final String PICKUPTEXT = "PICKUPTEXT";
    public static final String SBID = "SBID";
    public static final String SMCODELIST = "SMCODELIST";
    public static final String SSCODELIST = "SSCODELIST";
    public static final String TEXT = "TEXT";
    public static final String TEXT_EMAIL = "TEXT_EMAIL";
    public static final String TIME = "TIME";
    public static final String TRUEFALSE = "TRUEFALSE";
    public static final String VARBINARY = "VARBINARY";
    public static final String WFSTATE = "WFSTATE";
    public static final String YESNO = "YESNO";
    public static final String ONE2MANYDATA = "ONE2MANYDATA";
    public static final String ONE2MANYDATA_MAP = "ONE2MANYDATA_MAP";
    public static final String PICKUPOBJECT = "PICKUPOBJECT";
    public static final String ONE2ONEDATA = "ONE2ONEDATA";
    public static final String FILE = "FILE";
    public static final String ONE2MANYOBJ = "ONE2MANYOBJ";
    public static final String ONE2MANYOBJ_MAP = "ONE2MANYOBJ_MAP";
    public static final String ONE2ONEOBJ = "ONE2ONEOBJ";
    public static final String FILELIST = "FILELIST";
    public static final String LONGFILELIST = "LONGFILELIST";
    public static final String PICTURE = "PICTURE";
    public static final String PICTURELIST = "PICTURELIST";
    public static final String LONGPICTURELIST = "LONGPICTURELIST";
    public static final String TEXTARRAY = "TEXTARRAY";
    public static final String TEXTARRAY2 = "TEXTARRAY2";
    public static final String INTARRAY = "INTARRAY";
    public static final String INTARRAY2 = "INTARRAY2";
    public static final String BIGINTARRAY = "BIGINTARRAY";
    public static final String BIGINTARRAY2 = "BIGINTARRAY2";
    public static final String FLOATARRAY = "FLOATARRAY";
    public static final String FLOATARRAY2 = "FLOATARRAY2";
    public static final String DECIMALARRAY = "DECIMALARRAY";
    public static final String DECIMALARRAY2 = "DECIMALARRAY2";

    public DEFDataTypeCodeListModel() {
        this.initAnnotation(DEFDataTypeCodeListModel.class);
        this.setUserData2("DEFDataType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDataTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDataTypeCodeListModel");
    }
}


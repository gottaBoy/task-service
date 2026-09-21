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

@CodeList(id="75BB768E-7F01-4E3A-A39C-7CF72186F93A", name="\u6761\u4ef6\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="EQ", text="\u7b49\u4e8e(=)", realtext="\u7b49\u4e8e(=)"), @CodeItem(value="NOTEQ", text="\u4e0d\u7b49\u4e8e(<>)", realtext="\u4e0d\u7b49\u4e8e(<>)"), @CodeItem(value="GT", text="\u5927\u4e8e(>)", realtext="\u5927\u4e8e(>)"), @CodeItem(value="GTANDEQ", text="\u5927\u4e8e\u7b49\u4e8e(>=)", realtext="\u5927\u4e8e\u7b49\u4e8e(>=)"), @CodeItem(value="LT", text="\u5c0f\u4e8e(<)", realtext="\u5c0f\u4e8e(<)"), @CodeItem(value="LTANDEQ", text="\u5c0f\u4e8e\u7b49\u4e8e(<=)", realtext="\u5c0f\u4e8e\u7b49\u4e8e(<=)"), @CodeItem(value="ISNULL", text="\u503c\u4e3a\u7a7a(Nil)", realtext="\u503c\u4e3a\u7a7a(Nil)"), @CodeItem(value="ISNOTNULL", text="\u503c\u4e0d\u4e3a\u7a7a(NotNil)", realtext="\u503c\u4e0d\u4e3a\u7a7a(NotNil)"), @CodeItem(value="TESTNULL", text="\u7a7a\u503c\u5224\u65ad(TestNil)", realtext="\u7a7a\u503c\u5224\u65ad(TestNil)"), @CodeItem(value="LIKE", text="\u6587\u672c\u5305\u542b(%)", realtext="\u6587\u672c\u5305\u542b(%)"), @CodeItem(value="LEFTLIKE", text="\u6587\u672c\u5de6\u5305\u542b(%#)", realtext="\u6587\u672c\u5de6\u5305\u542b(%#)"), @CodeItem(value="RIGHTLIKE", text="\u6587\u672c\u53f3\u5305\u542b(#%)", realtext="\u6587\u672c\u53f3\u5305\u542b(#%)"), @CodeItem(value="USERLIKE", text="\u81ea\u5b9a\u4e49\u6587\u672c\u5305\u542b(%)", realtext="\u81ea\u5b9a\u4e49\u6587\u672c\u5305\u542b(%)"), @CodeItem(value="IN", text="\u503c\u5728\u8303\u56f4\u4e2d(In)", realtext="\u503c\u5728\u8303\u56f4\u4e2d(In)"), @CodeItem(value="NOTIN", text="\u503c\u4e0d\u5728\u8303\u56f4\u4e2d(NotIn)", realtext="\u503c\u4e0d\u5728\u8303\u56f4\u4e2d(NotIn)"), @CodeItem(value="EXISTS", text="\u5b58\u5728\u5f15\u7528\u6570\u636e(Exists)", realtext="\u5b58\u5728\u5f15\u7528\u6570\u636e(Exists)"), @CodeItem(value="EXISTSX", text="\u5b58\u5728\u5f15\u7528\u6570\u636e(ExistsX)\uff08\u6761\u4ef6\uff09", realtext="\u5b58\u5728\u5f15\u7528\u6570\u636e(ExistsX)\uff08\u6761\u4ef6\uff09"), @CodeItem(value="BITAND", text="\u4f4d\u4e0e\u64cd\u4f5c\uff08BitAnd\uff09(\u4ec5\u9650\u6574\u6570\u5f62\uff09", realtext="\u4f4d\u4e0e\u64cd\u4f5c\uff08BitAnd\uff09(\u4ec5\u9650\u6574\u6570\u5f62\uff09"), @CodeItem(value="CHILDOF", text="\u5b50\u6570\u636e\uff08\u9012\u5f52\uff09", realtext="\u5b50\u6570\u636e\uff08\u9012\u5f52\uff09")})
public class DBValueOP2CodeListModel
extends StaticCodeListModelBase {
    public static final String EQ = "EQ";
    public static final String NOTEQ = "NOTEQ";
    public static final String GT = "GT";
    public static final String GTANDEQ = "GTANDEQ";
    public static final String LT = "LT";
    public static final String LTANDEQ = "LTANDEQ";
    public static final String ISNULL = "ISNULL";
    public static final String ISNOTNULL = "ISNOTNULL";
    public static final String TESTNULL = "TESTNULL";
    public static final String LIKE = "LIKE";
    public static final String LEFTLIKE = "LEFTLIKE";
    public static final String RIGHTLIKE = "RIGHTLIKE";
    public static final String USERLIKE = "USERLIKE";
    public static final String IN = "IN";
    public static final String NOTIN = "NOTIN";
    public static final String EXISTS = "EXISTS";
    public static final String EXISTSX = "EXISTSX";
    public static final String BITAND = "BITAND";
    public static final String CHILDOF = "CHILDOF";

    public DBValueOP2CodeListModel() {
        this.initAnnotation(DBValueOP2CodeListModel.class);
        this.setUserData2("DBValueOP");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBValueOP2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBValueOP2CodeListModel");
    }
}


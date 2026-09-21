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

@CodeList(id="97D5465A-8016-477B-B5A3-A8BD776201E6", name="PQL\u51fd\u6570", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="COUNTIF", text="COUNTIF", realtext="COUNTIF", userdata="\u6709\u6761\u4ef6\u8ba1\u6570\uff0cCOUNTIF(cond)\uff0c\u7b26\u5408\u6761\u4ef6\u8fd4\u56de1\uff0c\u5426\u5219\u7a7a"), @CodeItem(value="AVGIF", text="AVGIF", realtext="AVGIF", userdata="\u6709\u6761\u4ef6\u5e73\u5747\u8ba1\u7b97\uff0cAVGIF(value, cond)\uff0c\u7b26\u5408\u6761\u4ef6\u8fd4\u56devalue\uff0c\u5426\u5219\u7a7a"), @CodeItem(value="IF", text="IF", realtext="IF", userdata="\u8fd4\u56de\u7b2c\u4e00\u4e2a\u7b26\u5408\u6761\u4ef6\u7684\u503c\uff0cIF(cond, value, cond2, value2...,default)\uff0c\u6761\u4ef6\u4e0e\u503c\u6210\u5bf9\u51fa\u73b0\uff0c\u6700\u540e\u4e00\u4e2a\u5355\u9879\u4f5c\u4e3a\u7f3a\u7701\u503c"), @CodeItem(value="SUMIF", text="SUMIF", realtext="SUMIF", userdata="\u6709\u6761\u4ef6\u5408\u8ba1\u8ba1\u7b97\uff0cSUMIF(value, cond)\uff0c\u7b26\u5408\u6761\u4ef6\u8fd4\u56devalue\uff0c\u5426\u5219\u7a7a"), @CodeItem(value="MULTIIF", text="MULTIIF", realtext="MULTIIF", userdata="\u591a\u7ef4\u5224\u65ad\uff0c\u8fd4\u56de\u7b2c\u4e00\u4e2a\u7b26\u5408\u6761\u4ef6\u7684\u503c\uff0cIF(cond, value, cond2, value2...,default)\uff0c\u6761\u4ef6\u4e0e\u503c\u6210\u5bf9\u51fa\u73b0\uff0c\u6700\u540e\u4e00\u4e2a\u5355\u9879\u4f5c\u4e3a\u7f3a\u7701\u503c"), @CodeItem(value="PARAM", text="PARAM", realtext="PARAM", userdata="\u83b7\u53d6\u6307\u5b9a\u53c2\u6570\u7684\u503c\uff0cPARAM(name, default)\uff0c\u672a\u5b58\u5728\u8fd4\u56de\u9ed8\u8ba4\u503c"), @CodeItem(value="PARAMS", text="PARAMS", realtext="PARAMS", userdata="\u83b7\u53d6\u6307\u5b9a\u53c2\u6570\u7684\u6570\u7ec4\u503c\uff0cPARAMS(name, default)\uff0c\u672a\u5b58\u5728\u8fd4\u56de\u9ed8\u8ba4\u503c"), @CodeItem(value="CURUSERID", text="CURUSERID", realtext="CURUSERID", userdata="\u5f53\u524d\u7528\u6237\u6807\u8bc6"), @CodeItem(value="CURRENTUSER", text="CURRENTUSER", realtext="CURRENTUSER", userdata="\u5f53\u524d\u7528\u6237\u6807\u8bc6"), @CodeItem(value="CURDEPTID", text="CURDEPTID", realtext="CURDEPTID", userdata="\u5f53\u524d\u90e8\u95e8\u6807\u8bc6"), @CodeItem(value="CURORGID", text="CURORGID", realtext="CURORGID", userdata="\u5f53\u524d\u7ec4\u7ec7\u6807\u8bc6"), @CodeItem(value="STARTOFDAY", text="STARTOFDAY", realtext="STARTOFDAY", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u5f53\u5929\u7684\u8d77\u59cb\u65f6\u523b\u200b"), @CodeItem(value="ENDOFDAY", text="ENDOFDAY", realtext="ENDOFDAY", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u5f53\u5929\u7684\u6700\u540e\u4e00\u523b"), @CodeItem(value="STARTOFWEEK", text="STARTOFWEEK", realtext="STARTOFWEEK", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u5468\u7684\u8d77\u59cb\u65f6\u523b\u200b"), @CodeItem(value="ENDOFWEEK", text="ENDOFWEEK", realtext="ENDOFWEEK", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u5468\u7684\u6700\u540e\u4e00\u523b"), @CodeItem(value="STARTOFMONTH", text="STARTOFMONTH", realtext="STARTOFMONTH", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u6708\u7684\u8d77\u59cb\u65f6\u523b\u200b"), @CodeItem(value="ENDOFMONTH", text="ENDOFMONTH", realtext="ENDOFMONTH", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u6708\u7684\u6700\u540e\u4e00\u523b"), @CodeItem(value="STARTOFQUARTER", text="STARTOFQUARTER", realtext="STARTOFQUARTER", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u5b63\u5ea6\u7684\u8d77\u59cb\u65f6\u523b\u200b"), @CodeItem(value="ENDOFQUARTER", text="ENDOFQUARTER", realtext="ENDOFQUARTER", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u5b63\u5ea6\u7684\u6700\u540e\u4e00\u523b"), @CodeItem(value="STARTOFYEAR", text="STARTOFYEAR", realtext="STARTOFYEAR", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u5e74\u4efd\u7684\u8d77\u59cb\u65f6\u523b\u200b"), @CodeItem(value="ENDOFYEAR", text="ENDOFYEAR", realtext="ENDOFYEAR", userdata="\u8ba1\u7b97\u4f20\u5165\u65f6\u95f4\u6240\u5728\u5e74\u4efd\u7684\u6700\u540e\u4e00\u523b"), @CodeItem(value="DATEDIFF", text="DATEDIFF", realtext="DATEDIFF"), @CodeItem(value="DATEFORMAT", text="DATEFORMAT", realtext="DATEFORMAT"), @CodeItem(value="DATE_FORMAT", text="DATE_FORMAT", realtext="DATE_FORMAT"), @CodeItem(value="YEARWEEKCHAR", text="YEARWEEKCHAR", realtext="YEARWEEKCHAR"), @CodeItem(value="YEARQUARTERCHAR", text="YEARQUARTERCHAR", realtext="YEARQUARTERCHAR")})
public class PQLFunctionCodeListModel
extends StaticCodeListModelBase {
    public static final String COUNTIF = "COUNTIF";
    public static final String AVGIF = "AVGIF";
    public static final String IF = "IF";
    public static final String SUMIF = "SUMIF";
    public static final String MULTIIF = "MULTIIF";
    public static final String PARAM = "PARAM";
    public static final String PARAMS = "PARAMS";
    public static final String CURUSERID = "CURUSERID";
    public static final String CURRENTUSER = "CURRENTUSER";
    public static final String CURDEPTID = "CURDEPTID";
    public static final String CURORGID = "CURORGID";
    public static final String STARTOFDAY = "STARTOFDAY";
    public static final String ENDOFDAY = "ENDOFDAY";
    public static final String STARTOFWEEK = "STARTOFWEEK";
    public static final String ENDOFWEEK = "ENDOFWEEK";
    public static final String STARTOFMONTH = "STARTOFMONTH";
    public static final String ENDOFMONTH = "ENDOFMONTH";
    public static final String STARTOFQUARTER = "STARTOFQUARTER";
    public static final String ENDOFQUARTER = "ENDOFQUARTER";
    public static final String STARTOFYEAR = "STARTOFYEAR";
    public static final String ENDOFYEAR = "ENDOFYEAR";
    public static final String DATEDIFF = "DATEDIFF";
    public static final String DATEFORMAT = "DATEFORMAT";
    public static final String DATE_FORMAT = "DATE_FORMAT";
    public static final String YEARWEEKCHAR = "YEARWEEKCHAR";
    public static final String YEARQUARTERCHAR = "YEARQUARTERCHAR";

    public PQLFunctionCodeListModel() {
        this.initAnnotation(PQLFunctionCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("PQLFunction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PQLFunctionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PQLFunctionCodeListModel");
    }
}


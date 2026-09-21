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

@CodeList(id="422c22e78b1113301858fdcf82284889", name="\u90e8\u4ef6\u6a21\u578b\u53d8\u91cf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="OBJECT", text="\u5bf9\u8c61", realtext="\u5bf9\u8c61"), @CodeItem(value="OBJECTARRAY", text="\u5bf9\u8c61\u96c6\u5408", realtext="\u5bf9\u8c61\u96c6\u5408"), @CodeItem(value="STRING", text="\u5b57\u7b26\u4e32", realtext="\u5b57\u7b26\u4e32"), @CodeItem(value="STRINGARRAY", text="\u5b57\u7b26\u4e32\u6570\u7ec4", realtext="\u5b57\u7b26\u4e32\u6570\u7ec4"), @CodeItem(value="INT", text="\u6574\u5f62", realtext="\u6574\u5f62"), @CodeItem(value="INTARRAY", text="\u6574\u5f62\u6570\u7ec4", realtext="\u6574\u5f62\u6570\u7ec4"), @CodeItem(value="NUMBER", text="\u6570\u503c", realtext="\u6570\u503c"), @CodeItem(value="NUMBERARRAY", text="\u6570\u503c\u6570\u7ec4", realtext="\u6570\u503c\u6570\u7ec4"), @CodeItem(value="BOOL", text="\u5e03\u5c14\u503c", realtext="\u5e03\u5c14\u503c")})
public class CtrlModelDataTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String OBJECT = "OBJECT";
    public static final String OBJECTARRAY = "OBJECTARRAY";
    public static final String STRING = "STRING";
    public static final String STRINGARRAY = "STRINGARRAY";
    public static final String INT = "INT";
    public static final String INTARRAY = "INTARRAY";
    public static final String NUMBER = "NUMBER";
    public static final String NUMBERARRAY = "NUMBERARRAY";
    public static final String BOOL = "BOOL";

    public CtrlModelDataTypeCodeListModel() {
        this.initAnnotation(CtrlModelDataTypeCodeListModel.class);
        this.setUserData2("CtrlModelDataType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlModelDataTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CtrlModelDataTypeCodeListModel");
    }
}


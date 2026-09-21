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

@CodeList(id="4D57711D-8DAD-460A-B95E-7C700DD85373", name="\u5b9e\u4f53\u6570\u636e\u6d41\u6761\u4ef6\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATASTREAM", text="\u6570\u636e\u6e90\u5c5e\u6027", realtext="\u6570\u636e\u6e90\u5c5e\u6027", userdata="\u6307\u5b9a\u6570\u636e\u6e90\u5c5e\u6027"), @CodeItem(value="DATASTREAM2", text="\u6570\u636e\u6e902\u5c5e\u6027", realtext="\u6570\u636e\u6e902\u5c5e\u6027", userdata="\u6307\u5b9a\u6570\u636e\u6e902\u5c5e\u6027"), @CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="DATACONTEXT", text="\u6570\u636e\u4e0a\u4e0b\u6587", realtext="\u6570\u636e\u4e0a\u4e0b\u6587"), @CodeItem(value="ENVPARAM", text="\u5f53\u524d\u73af\u5883\u53c2\u6570", realtext="\u5f53\u524d\u73af\u5883\u53c2\u6570"), @CodeItem(value="NONEVALUE", text="\u65e0\u503c\uff08NONE\uff09", realtext="\u65e0\u503c\uff08NONE\uff09"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c\uff08NULL\uff09", realtext="\u7a7a\u503c\uff08NULL\uff09"), @CodeItem(value="SRCVALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c"), @CodeItem(value="EXPRESSION", text="\u8ba1\u7b97\u5f0f", realtext="\u8ba1\u7b97\u5f0f")})
public class DEDataFlowCondValueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATASTREAM = "DATASTREAM";
    public static final String DATASTREAM2 = "DATASTREAM2";
    public static final String SESSION = "SESSION";
    public static final String DATACONTEXT = "DATACONTEXT";
    public static final String ENVPARAM = "ENVPARAM";
    public static final String NONEVALUE = "NONEVALUE";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String SRCVALUE = "SRCVALUE";
    public static final String EXPRESSION = "EXPRESSION";

    public DEDataFlowCondValueTypeCodeListModel() {
        this.initAnnotation(DEDataFlowCondValueTypeCodeListModel.class);
        this.setUserData2("DEDataFlowCondValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowCondValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowCondValueTypeCodeListModel");
    }
}


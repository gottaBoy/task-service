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

@CodeList(id="9868E53C-110C-4D1F-BAD7-20198C91D5C6", name="\u6570\u636e\u6d41\u8fde\u63a5\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INNER", text="\u5185\u8fde\u63a5", realtext="\u5185\u8fde\u63a5", userdata="\u8fd4\u56de\u4e24\u4e2a\u6570\u636e\u6e90\u4e2d\u6ee1\u8db3\u8fde\u63a5\u6761\u4ef6\u7684\u5339\u914d\u884c\u3002\u53ea\u6709\u5728\u8fde\u63a5\u5217\u4e0a\u5b58\u5728\u5339\u914d\u7684\u503c\u65f6\uff0c\u624d\u4f1a\u8fd4\u56de\u7ed3\u679c\u3002\u8fde\u63a5\u6761\u4ef6\u901a\u5e38\u4f7f\u7528 ON \u5173\u952e\u5b57\u6307\u5b9a"), @CodeItem(value="LEFT", text="\u5de6\u8fde\u63a5", realtext="\u5de6\u8fde\u63a5", userdata="\u8fd4\u56de\u6570\u636e\u6e901\u7684\u6240\u6709\u884c\uff0c\u4ee5\u53ca\u6570\u636e\u6e902\u4e2d\u6ee1\u8db3\u8fde\u63a5\u6761\u4ef6\u7684\u5339\u914d\u884c\u3002\u5982\u679c\u6570\u636e\u6e902\u4e2d\u6ca1\u6709\u5339\u914d\u7684\u884c\uff0c\u5219\u8fd4\u56de NULL \u503c"), @CodeItem(value="RIGHT", text="\u53f3\u8fde\u63a5", realtext="\u53f3\u8fde\u63a5", userdata="\u8fd4\u56de\u6570\u636e\u6e902\u7684\u6240\u6709\u884c\uff0c\u4ee5\u53ca\u6570\u636e\u6e901\u4e2d\u6ee1\u8db3\u8fde\u63a5\u6761\u4ef6\u7684\u5339\u914d\u884c\u3002\u5982\u679c\u6570\u636e\u6e901\u4e2d\u6ca1\u6709\u5339\u914d\u7684\u884c\uff0c\u5219\u8fd4\u56de NULL \u503c"), @CodeItem(value="FULL", text="\u5168\u8fde\u63a5", realtext="\u5168\u8fde\u63a5", userdata="\u8fd4\u56de\u6570\u636e\u6e901\u548c\u6570\u636e\u6e902\u4e2d\u7684\u6240\u6709\u884c\uff0c\u65e0\u8bba\u662f\u5426\u6ee1\u8db3\u8fde\u63a5\u6761\u4ef6\u3002\u5982\u679c\u67d0\u4e2a\u6570\u636e\u6e90\u4e2d\u6ca1\u6709\u5339\u914d\u7684\u884c\uff0c\u5219\u53e6\u4e00\u4e2a\u6570\u636e\u6e90\u4e2d\u7684\u5217\u5c06\u4e3a NULL \u503c")})
public class DEDataFlowJoinTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INNER = "INNER";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final String FULL = "FULL";

    public DEDataFlowJoinTypeCodeListModel() {
        this.initAnnotation(DEDataFlowJoinTypeCodeListModel.class);
        this.setUserData2("DEDataFlowJoinType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowJoinTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowJoinTypeCodeListModel");
    }
}


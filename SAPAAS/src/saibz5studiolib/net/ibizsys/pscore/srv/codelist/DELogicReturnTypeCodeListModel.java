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

@CodeList(id="E3A82E2C-F892-4591-83A2-EC39F0BE6B40", name="\u5b9e\u4f53\u5904\u7406\u5904\u7406\u8fd4\u56de\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONEVALUE", text="\u65e0\u503c\uff08NONE\uff09", realtext="\u65e0\u503c\uff08NONE\uff09"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c\uff08NULL\uff09", realtext="\u7a7a\u503c\uff08NULL\uff09"), @CodeItem(value="SRCVALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c"), @CodeItem(value="LOGICPARAM", text="\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", realtext="\u903b\u8f91\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="LOGICPARAMFIELD", text="\u903b\u8f91\u53c2\u6570\u5c5e\u6027", realtext="\u903b\u8f91\u53c2\u6570\u5c5e\u6027"), @CodeItem(value="BREAK", text="\u8df3\u51fa\u5faa\u73af\uff08BREAK\uff09", realtext="\u8df3\u51fa\u5faa\u73af\uff08BREAK\uff09")})
public class DELogicReturnTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONEVALUE = "NONEVALUE";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String SRCVALUE = "SRCVALUE";
    public static final String LOGICPARAM = "LOGICPARAM";
    public static final String LOGICPARAMFIELD = "LOGICPARAMFIELD";
    public static final String BREAK = "BREAK";

    public DELogicReturnTypeCodeListModel() {
        this.initAnnotation(DELogicReturnTypeCodeListModel.class);
        this.setUserData2("LogicReturnType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicReturnTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicReturnTypeCodeListModel");
    }
}


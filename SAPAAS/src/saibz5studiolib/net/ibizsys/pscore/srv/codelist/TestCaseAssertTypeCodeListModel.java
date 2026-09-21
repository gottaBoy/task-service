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

@CodeList(id="9f43b374c9bb47d9106191bfedde2bb7", name="\u6d4b\u8bd5\u65ad\u8a00\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RESULT", text="\u9884\u671f\u7ed3\u679c", realtext="\u9884\u671f\u7ed3\u679c", userdata="\u6d4b\u8bd5\u5355\u5143\u6267\u884c\u7ed3\u679c\u4e0e\u9884\u671f\u7ed3\u679c\u4e00\u81f4"), @CodeItem(value="EXCEPTION", text="\u9884\u671f\u5f02\u5e38", realtext="\u9884\u671f\u5f02\u5e38", userdata="\u6d4b\u8bd5\u5355\u5143\u6267\u884c\u53d1\u751f\u7684\u5f02\u5e38\u4e0e\u9884\u671f\u5f02\u5e38\u4e00\u81f4"), @CodeItem(value="DATAEXISTS", text="\u9884\u671f\u6570\u636e\u5b58\u5728", realtext="\u9884\u671f\u6570\u636e\u5b58\u5728"), @CodeItem(value="NOEXCEPTION", text="\u9884\u671f\u65e0\u5f02\u5e38", realtext="\u9884\u671f\u65e0\u5f02\u5e38", userdata="\u6d4b\u8bd5\u5355\u5143\u6267\u884c\u65e0\u4efb\u4f55\u5f02\u5e38"), @CodeItem(value="CUSTOMCODE", text="\u81ea\u5b9a\u4e49\u4ee3\u7801", realtext="\u81ea\u5b9a\u4e49\u4ee3\u7801"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class TestCaseAssertTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RESULT = "RESULT";
    public static final String EXCEPTION = "EXCEPTION";
    public static final String DATAEXISTS = "DATAEXISTS";
    public static final String NOEXCEPTION = "NOEXCEPTION";
    public static final String CUSTOMCODE = "CUSTOMCODE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public TestCaseAssertTypeCodeListModel() {
        this.initAnnotation(TestCaseAssertTypeCodeListModel.class);
        this.setUserData2("TestCaseAssertType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseAssertTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseAssertTypeCodeListModel");
    }
}


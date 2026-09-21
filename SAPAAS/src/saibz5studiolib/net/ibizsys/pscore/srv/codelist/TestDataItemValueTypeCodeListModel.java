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

@CodeList(id="0722ed40fd03baeb2e7679696b60ffcc", name="\u6d4b\u8bd5\u6570\u636e\u9879\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c"), @CodeItem(value="VALUERANGE", text="\u503c\u8303\u56f4", realtext="\u503c\u8303\u56f4", userdata="\u4ece\u503c\u8303\u56f4\u4e2d\u968f\u673a\u9009\u53d6\u4e00\u4e2a"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c", realtext="\u7a7a\u503c"), @CodeItem(value="PICKUPVALUE", text="\u5916\u952e\u968f\u673a\u503c", realtext="\u5916\u952e\u968f\u673a\u503c", userdata="\u4ece\u5f15\u7528\u5b9e\u4f53\u7684\u6d4b\u8bd5\u6570\u636e\u4e2d\u968f\u673a\u9009\u53d6\u4e00\u4e2a"), @CodeItem(value="CODELISTVALUE", text="\u4ee3\u7801\u8868\u968f\u673a\u503c", realtext="\u4ee3\u7801\u8868\u968f\u673a\u503c", userdata="\u4ece\u6307\u5b9a\u7684\u4ee3\u7801\u8868\u9879\u4e2d\u968f\u673a\u9009\u53d6\u4e00\u4e2a")})
public class TestDataItemValueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String VALUE = "VALUE";
    public static final String VALUERANGE = "VALUERANGE";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String PICKUPVALUE = "PICKUPVALUE";
    public static final String CODELISTVALUE = "CODELISTVALUE";

    public TestDataItemValueTypeCodeListModel() {
        this.initAnnotation(TestDataItemValueTypeCodeListModel.class);
        this.setUserData2("TestDataItemValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TestDataItemValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TestDataItemValueTypeCodeListModel");
    }
}


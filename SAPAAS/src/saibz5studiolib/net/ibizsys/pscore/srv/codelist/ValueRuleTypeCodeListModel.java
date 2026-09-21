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

@CodeList(id="c369119de8a9b107100530f10aaf7a3a", name="\u5e73\u53f0\u503c\u89c4\u5219\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SCRIPT", text="\u811a\u672c", realtext="\u811a\u672c", userdata="\u4f7f\u7528javascript\u811a\u672c\u8fdb\u884c\u503c\u6821\u9a8c"), @CodeItem(value="REG", text="\u6b63\u5219\u5f0f\uff08\u5e9f\u5f03\uff09", realtext="\u6b63\u5219\u5f0f\uff08\u5e9f\u5f03\uff09", userdata="\u4f7f\u7528\u6b63\u5219\u5f0f\u8fdb\u884c\u503c\u6821\u9a8c\uff0c\u6b64\u4ee3\u7801\u503cREG\u540e\u7eed\u5c06\u8c03\u6574\u4e3aREGEX"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49", userdata="\u81ea\u5b9a\u4e49"), @CodeItem(value="REGEX", text="\u6b63\u5219\u5f0f", realtext="\u6b63\u5219\u5f0f", userdata="\u4f7f\u7528\u6b63\u5219\u5f0f\u8fdb\u884c\u503c\u6821\u9a8c")})
public class ValueRuleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SCRIPT = "SCRIPT";
    public static final String REG = "REG";
    public static final String CUSTOM = "CUSTOM";
    public static final String REGEX = "REGEX";

    public ValueRuleTypeCodeListModel() {
        this.initAnnotation(ValueRuleTypeCodeListModel.class);
        this.setUserData2("ValueRuleType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ValueRuleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ValueRuleTypeCodeListModel");
    }
}


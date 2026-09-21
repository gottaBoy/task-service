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

@CodeList(id="E4A7E335-1D68-4217-AB83-614AF73A7096", name="\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NORMAL", text="\u5e38\u89c4", realtext="\u5e38\u89c4", userdata="\u6307\u5b9a\u5177\u4f53\u7684\u5c5e\u6027\u6e05\u5355"), @CodeItem(value="FORMITEMS", text="\u8868\u5355\u9879", realtext="\u8868\u5355\u9879", userdata="\u6307\u5b9a\u7f16\u8f91\u8868\u5355\uff0c\u4ece\u8868\u5355\u9879\u63d0\u53d6\u975e\u7a7a\u89c4\u5219\u6784\u5efa\u5c5e\u6027\u503c\u89c4\u5219"), @CodeItem(value="SCRIPT", text="\u811a\u672c\u4ee3\u7801", realtext="\u811a\u672c\u4ee3\u7801")})
public class DEFValueRuleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NORMAL = "NORMAL";
    public static final String FORMITEMS = "FORMITEMS";
    public static final String SCRIPT = "SCRIPT";

    public DEFValueRuleTypeCodeListModel() {
        this.initAnnotation(DEFValueRuleTypeCodeListModel.class);
        this.setUserData2("DEFValueRuleType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFValueRuleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFValueRuleTypeCodeListModel");
    }
}


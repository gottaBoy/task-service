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

@CodeList(id="03510ed0752ea8d9ddce5ce1607a8294", name="\u4ee3\u7801\u8868\u6216\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u975e\u6216\u6a21\u5f0f\uff09")
@CodeItems(value={@CodeItem(value="NUMBERORMODE", text="\u6570\u5b57\u6216\u5904\u7406", realtext="\u6570\u5b57\u6216\u5904\u7406", userdata="\u591a\u9879\u503c\u6309\u4f4d\u6216\u5904\u7406\uff0c\u4e00\u822c\u4ee3\u7801\u9879\u7684\u503c\u5bf9\u5e94\u5b57\u8282\u7684\u4f4d\uff1a1\u30012\u30014\u30018\u7b49"), @CodeItem(value="STRINGORMODE", text="\u6587\u672c\u6216\u6a21\u5f0f", realtext="\u6587\u672c\u6216\u6a21\u5f0f", userdata="\u4ee3\u7801\u9879\u7684\u503c\u4f7f\u7528\u5206\u9694\u7b26\u53f7\u62fc\u63a5")})
public class CodeListOrModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NUMBERORMODE = "NUMBERORMODE";
    public static final String STRINGORMODE = "STRINGORMODE";

    public CodeListOrModeCodeListModel() {
        this.initAnnotation(CodeListOrModeCodeListModel.class);
        this.setUserData2("DesignCodeListOrMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeListOrModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeListOrModeCodeListModel");
    }
}


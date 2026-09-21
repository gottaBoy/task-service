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

@CodeList(id="78348FE9-9621-4BDE-B2C6-BCF92B156D72", name="AI\u4ea4\u8c08\u4ee3\u7406\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="DE", text="\u5b9e\u4f53\u903b\u8f91", realtext="\u5b9e\u4f53\u903b\u8f91")})
public class AIChatAgentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String DE = "DE";

    public AIChatAgentTypeCodeListModel() {
        this.initAnnotation(AIChatAgentTypeCodeListModel.class);
        this.setUserData2("AIChatAgentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AIChatAgentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AIChatAgentTypeCodeListModel");
    }
}


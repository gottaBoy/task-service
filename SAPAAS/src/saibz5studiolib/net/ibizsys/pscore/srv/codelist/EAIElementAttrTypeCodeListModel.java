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

@CodeList(id="a17bb180eb9f3bce91bfcae113eb8647", name="\u96c6\u6210\u5143\u7d20\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SIMPLE", text="\u7b80\u5355\u5c5e\u6027", realtext="\u7b80\u5355\u5c5e\u6027"), @CodeItem(value="GROUP", text="\u5c5e\u6027\u7ec4", realtext="\u5c5e\u6027\u7ec4")})
public class EAIElementAttrTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SIMPLE = "SIMPLE";
    public static final String GROUP = "GROUP";

    public EAIElementAttrTypeCodeListModel() {
        this.initAnnotation(EAIElementAttrTypeCodeListModel.class);
        this.setUserData2("EAIElementAttrType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementAttrTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementAttrTypeCodeListModel");
    }
}


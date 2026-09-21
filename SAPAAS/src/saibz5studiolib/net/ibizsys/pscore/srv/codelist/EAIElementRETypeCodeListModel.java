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

@CodeList(id="74ba3f6a6fb3f15256d63d6740ade0a7", name="\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SIMPLE", text="\u7b80\u5355\u5143\u7d20", realtext="\u7b80\u5355\u5143\u7d20"), @CodeItem(value="COMPLEX", text="\u590d\u5408\u5143\u7d20", realtext="\u590d\u5408\u5143\u7d20"), @CodeItem(value="GROUP", text="\u5143\u7d20\u7ec4", realtext="\u5143\u7d20\u7ec4")})
public class EAIElementRETypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SIMPLE = "SIMPLE";
    public static final String COMPLEX = "COMPLEX";
    public static final String GROUP = "GROUP";

    public EAIElementRETypeCodeListModel() {
        this.initAnnotation(EAIElementRETypeCodeListModel.class);
        this.setUserData2("EAIElementREType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementRETypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementRETypeCodeListModel");
    }
}


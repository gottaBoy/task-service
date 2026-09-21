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

@CodeList(id="f2f90f310424cda4120b3a1017811a34", name="\u4e91\u5e73\u53f0\u5411\u5bfc\u6b65\u9aa4\u884c\u4e3a", type="STATIC", userscope=false, emptytext="", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="PREV", text="\u4e0a\u4e00\u6b65", realtext="\u4e0a\u4e00\u6b65"), @CodeItem(value="NEXT", text="\u4e0b\u4e00\u6b65", realtext="\u4e0b\u4e00\u6b65"), @CodeItem(value="FINISH", text="\u5b8c\u6210", realtext="\u5b8c\u6210")})
public class DEWizardStepActionsCodeListModel
extends StaticCodeListModelBase {
    public static final String PREV = "PREV";
    public static final String NEXT = "NEXT";
    public static final String FINISH = "FINISH";

    public DEWizardStepActionsCodeListModel() {
        this.initAnnotation(DEWizardStepActionsCodeListModel.class);
        this.setUserData2("WizardStepAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEWizardStepActionsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEWizardStepActionsCodeListModel");
    }
}


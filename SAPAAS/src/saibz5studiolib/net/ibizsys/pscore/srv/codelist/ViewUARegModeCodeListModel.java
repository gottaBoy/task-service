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

@CodeList(id="3312088902d8512d1f2bd655dc2bcf29", name="\u89c6\u56fe\u754c\u9762\u884c\u4e3a\u6ce8\u518c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u59cb\u7ec8\u6ce8\u518c", realtext="\u59cb\u7ec8\u6ce8\u518c"), @CodeItem(value="1", text="\u6709\u6548\u65f6\u6ce8\u518c", realtext="\u6709\u6548\u65f6\u6ce8\u518c")})
public class ViewUARegModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ALWAYS = 0;
    public static final int INT_ALWAYS = 0;
    public static final Integer VALID = 1;
    public static final int INT_VALID = 1;

    public ViewUARegModeCodeListModel() {
        this.initAnnotation(ViewUARegModeCodeListModel.class);
        this.setUserData2("ViewUARegMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewUARegModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewUARegModeCodeListModel");
    }
}


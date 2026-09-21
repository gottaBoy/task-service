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

@CodeList(id="CE3CBA77-4CD7-4663-83F3-7E63CBC6359B", name="\u6d41\u7a0b\u5904\u7406\u7f16\u8f91\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u652f\u6301", realtext="\u4e0d\u652f\u6301"), @CodeItem(value="1", text="\u652f\u6301\uff08\u6392\u9664\u6307\u5b9a\u5c5e\u6027\uff09", realtext="\u652f\u6301\uff08\u6392\u9664\u6307\u5b9a\u5c5e\u6027\uff09"), @CodeItem(value="2", text="\u652f\u6301\uff08\u4ec5\u6307\u5b9a\u5c5e\u6027\uff09", realtext="\u652f\u6301\uff08\u4ec5\u6307\u5b9a\u5c5e\u6027\uff09")})
public class WFProcessEditModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer EXCLUDE = 1;
    public static final int INT_EXCLUDE = 1;
    public static final Integer INCLUDE = 2;
    public static final int INT_INCLUDE = 2;

    public WFProcessEditModeCodeListModel() {
        this.initAnnotation(WFProcessEditModeCodeListModel.class);
        this.setUserData2("WFProcessEditMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcessEditModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcessEditModeCodeListModel");
    }
}


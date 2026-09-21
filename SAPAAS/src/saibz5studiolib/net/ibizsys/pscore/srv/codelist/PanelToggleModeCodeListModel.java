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

@CodeList(id="4F4DE59E-A90B-45ED-8F57-DD4A1C5E23BD", name="\u9762\u677f\u5207\u6362\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="PUSHASIDE", text="\u9760\u8fb9\u663e\u793a", realtext="\u9760\u8fb9\u663e\u793a"), @CodeItem(value="SLIDEOVER", text="\u6d6e\u51fa", realtext="\u6d6e\u51fa"), @CodeItem(value="SHRINK_OPEN", text="\u4f38\u7f29\uff08\u9ed8\u8ba4\u6253\u5f00\uff09", realtext="\u4f38\u7f29\uff08\u9ed8\u8ba4\u6253\u5f00\uff09"), @CodeItem(value="SHRINK_CLOSED", text="\u4f38\u7f29\uff08\u9ed8\u8ba4\u6536\u8d77\uff09", realtext="\u4f38\u7f29\uff08\u9ed8\u8ba4\u6536\u8d77\uff09")})
public class PanelToggleModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String PUSHASIDE = "PUSHASIDE";
    public static final String SLIDEOVER = "SLIDEOVER";
    public static final String SHRINK_OPEN = "SHRINK_OPEN";
    public static final String SHRINK_CLOSED = "SHRINK_CLOSED";

    public PanelToggleModeCodeListModel() {
        this.initAnnotation(PanelToggleModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelToggleModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelToggleModeCodeListModel");
    }
}


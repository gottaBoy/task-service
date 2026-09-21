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

@CodeList(id="a5f9398da9585f877972871712bafe11", name="\u9762\u677f\u6298\u53e0\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u652f\u6301", realtext="\u4e0d\u652f\u6301", userdata="\u56fa\u5b9a\u663e\u793a\uff0c\u4e0d\u652f\u6301\u6298\u53e0"), @CodeItem(value="1", text="\u652f\u6301\uff08\u9ed8\u8ba4\u663e\u793a\uff09", realtext="\u652f\u6301\uff08\u9ed8\u8ba4\u663e\u793a\uff09", userdata="\u652f\u6301\u6298\u53e0\uff0c\u9ed8\u8ba4\u663e\u793a"), @CodeItem(value="2", text="\u652f\u6301\uff08\u9ed8\u8ba4\u9690\u85cf\uff09", realtext="\u652f\u6301\uff08\u9ed8\u8ba4\u9690\u85cf\uff09", userdata="\u652f\u6301\u6298\u53e0\uff0c\u9ed8\u8ba4\u4e0d\u663e\u793a")})
public class PanelCollapsibleModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTSUPPORTED = 0;
    public static final int INT_NOTSUPPORTED = 0;
    public static final Integer SUPPORTED = 1;
    public static final int INT_SUPPORTED = 1;
    public static final Integer SUPPORTEDANDHIDE = 2;
    public static final int INT_SUPPORTEDANDHIDE = 2;

    public PanelCollapsibleModeCodeListModel() {
        this.initAnnotation(PanelCollapsibleModeCodeListModel.class);
        this.setUserData2("PanelCollapsibleMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelCollapsibleModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelCollapsibleModeCodeListModel");
    }
}


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

@CodeList(id="F22DEE2A-D658-4BB5-8D7B-E9FEA4558171", name="\u6309\u94ae\u7ed8\u5236\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BUTTON", text="\u6309\u94ae", realtext="\u6309\u94ae"), @CodeItem(value="LINK", text="\u94fe\u63a5", realtext="\u94fe\u63a5")})
public class ButtonRenderModeCodeListModel
extends StaticCodeListModelBase {
    public static final String BUTTON = "BUTTON";
    public static final String LINK = "LINK";

    public ButtonRenderModeCodeListModel() {
        this.initAnnotation(ButtonRenderModeCodeListModel.class);
        this.setUserData2("ButtonRenderMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ButtonRenderModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ButtonRenderModeCodeListModel");
    }
}


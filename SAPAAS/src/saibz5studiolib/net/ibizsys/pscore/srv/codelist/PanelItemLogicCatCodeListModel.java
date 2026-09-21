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

@CodeList(id="A20BA9F4-B8EE-499A-968D-3E8B5F70FEC1", name="\u9762\u677f\u6210\u5458\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PANELVISIBLE", text="\u9762\u677f\u663e\u793a", realtext="\u9762\u677f\u663e\u793a", userdata="\u8868\u5355\u6210\u5458\u5bb9\u5668\u7684\u52a8\u6001\u663e\u793a\u903b\u8f91\uff0c\u63a7\u5236\u6210\u5458\u662f\u5426\u663e\u793a"), @CodeItem(value="ITEMENABLE", text="\u5c5e\u6027\u9879\u542f\u7528", realtext="\u5c5e\u6027\u9879\u542f\u7528", userdata="\u5c5e\u6027\u9879\u7684\u52a8\u6001\u542f\u7528\u903b\u8f91\uff0c\u63a7\u5236\u5c5e\u6027\u9879\u53ca\u5176\u7f16\u8f91\u5668\u7684\u542f\u7528\u7981\u7528\u72b6\u6001"), @CodeItem(value="ITEMBLANK", text="\u5c5e\u6027\u9879\u7a7a\u8f93\u5165", realtext="\u5c5e\u6027\u9879\u7a7a\u8f93\u5165", userdata="\u5c5e\u6027\u9879\u7684\u52a8\u6001\u7a7a\u8f93\u5165\u903b\u8f91\uff0c\u63a7\u5236\u5c5e\u6027\u9879\u53ca\u5176\u7f16\u8f91\u5668\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165")})
public class PanelItemLogicCatCodeListModel
extends StaticCodeListModelBase {
    public static final String PANELVISIBLE = "PANELVISIBLE";
    public static final String ITEMENABLE = "ITEMENABLE";
    public static final String ITEMBLANK = "ITEMBLANK";

    public PanelItemLogicCatCodeListModel() {
        this.initAnnotation(PanelItemLogicCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelItemLogicCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelItemLogicCatCodeListModel");
    }
}


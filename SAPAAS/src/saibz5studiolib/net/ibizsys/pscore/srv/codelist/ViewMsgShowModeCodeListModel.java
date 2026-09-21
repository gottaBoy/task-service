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

@CodeList(id="ddb0553d9585740de216987ac86d9355", name="\u89c6\u56fe\u6d88\u606f\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LIST", text="\u5217\u8868\u663e\u793a", realtext="\u5217\u8868\u663e\u793a"), @CodeItem(value="MARQUEE", text="\u6a2a\u5411\u6eda\u52a8\u663e\u793a", realtext="\u6a2a\u5411\u6eda\u52a8\u663e\u793a"), @CodeItem(value="MARQUEE2", text="\u7eb5\u5411\u6eda\u52a8\u663e\u793a", realtext="\u7eb5\u5411\u6eda\u52a8\u663e\u793a"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class ViewMsgShowModeCodeListModel
extends StaticCodeListModelBase {
    public static final String LIST = "LIST";
    public static final String MARQUEE = "MARQUEE";
    public static final String MARQUEE2 = "MARQUEE2";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public ViewMsgShowModeCodeListModel() {
        this.initAnnotation(ViewMsgShowModeCodeListModel.class);
        this.setUserData2("ViewMsgShowMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgShowModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgShowModeCodeListModel");
    }
}


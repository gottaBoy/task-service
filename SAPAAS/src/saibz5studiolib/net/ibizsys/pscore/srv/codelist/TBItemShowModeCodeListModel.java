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

@CodeList(id="722e69a2cc9b02d964e36066bc9cf1b1", name="\u5de5\u5177\u680f\u9879\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ICONANDSHORTWORD", text="\u56fe\u6807+\u77ed\u8bcd", realtext="\u56fe\u6807+\u77ed\u8bcd", userdata="\u540c\u65f6\u663e\u793a\u56fe\u6807\u53ca\u6807\u9898"), @CodeItem(value="ICON", text="\u56fe\u6807", realtext="\u56fe\u6807", userdata="\u4ec5\u663e\u793a\u56fe\u6807"), @CodeItem(value="SHORTWORD", text="\u77ed\u8bcd", realtext="\u77ed\u8bcd", userdata="\u4ec5\u663e\u793a\u6807\u9898")})
public class TBItemShowModeCodeListModel
extends StaticCodeListModelBase {
    public static final String ICONANDSHORTWORD = "ICONANDSHORTWORD";
    public static final String ICON = "ICON";
    public static final String SHORTWORD = "SHORTWORD";

    public TBItemShowModeCodeListModel() {
        this.initAnnotation(TBItemShowModeCodeListModel.class);
        this.setUserData2("TBItemShowMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TBItemShowModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TBItemShowModeCodeListModel");
    }
}


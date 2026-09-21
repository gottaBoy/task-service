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

@CodeList(id="42E447C9-9716-44CE-A378-A05EEB4CBF29", name="\u667a\u80fd\u62a5\u8868\u62a5\u8868\u9879\u653e\u7f6e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="VISIBLE", text="\u9ed8\u8ba4\u663e\u793a", realtext="\u9ed8\u8ba4\u663e\u793a"), @CodeItem(value="INVISIBLE", text="\u9ed8\u8ba4\u9690\u85cf", realtext="\u9ed8\u8ba4\u9690\u85cf"), @CodeItem(value="FROZEN", text="\u56fa\u5b9a", realtext="\u56fa\u5b9a")})
public class BIReportItemPlaceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String VISIBLE = "VISIBLE";
    public static final String INVISIBLE = "INVISIBLE";
    public static final String FROZEN = "FROZEN";

    public BIReportItemPlaceTypeCodeListModel() {
        this.initAnnotation(BIReportItemPlaceTypeCodeListModel.class);
        this.setUserData2("BIReportItemPlaceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BIReportItemPlaceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BIReportItemPlaceTypeCodeListModel");
    }
}


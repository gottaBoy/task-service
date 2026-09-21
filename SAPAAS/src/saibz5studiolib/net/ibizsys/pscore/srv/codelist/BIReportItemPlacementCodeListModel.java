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

@CodeList(id="548792A7-1232-40EC-B6FB-D7121FB484CA", name="\u667a\u80fd\u62a5\u8868\u62a5\u8868\u9879\u653e\u7f6e\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="ROWHEADER", text="\u884c\u5934", realtext="\u884c\u5934"), @CodeItem(value="COLHEADER", text="\u5217\u5934", realtext="\u5217\u5934")})
public class BIReportItemPlacementCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String ROWHEADER = "ROWHEADER";
    public static final String COLHEADER = "COLHEADER";

    public BIReportItemPlacementCodeListModel() {
        this.initAnnotation(BIReportItemPlacementCodeListModel.class);
        this.setUserData2("BIReportItemPlacement");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BIReportItemPlacementCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BIReportItemPlacementCodeListModel");
    }
}


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

@CodeList(id="38d970c3995ef90ea396add9baa931ac", name="\u4e91\u5b9e\u4f53\u56fe\u8868\u81ea\u52a8\u65f6\u95f4\u5206\u7ec4", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="YEAR", text="\u5e74", realtext="\u5e74"), @CodeItem(value="QUARTER", text="\u5b63\u5ea6", realtext="\u5b63\u5ea6"), @CodeItem(value="MONTH", text="\u6708\u4efd", realtext="\u6708\u4efd"), @CodeItem(value="YEARWEEK", text="\u5e74\u5468", realtext="\u5e74\u5468"), @CodeItem(value="DAY", text="\u65e5", realtext="\u65e5")})
public class ChartTimeGroupModeCodeListModel
extends StaticCodeListModelBase {
    public static final String YEAR = "YEAR";
    public static final String QUARTER = "QUARTER";
    public static final String MONTH = "MONTH";
    public static final String YEARWEEK = "YEARWEEK";
    public static final String DAY = "DAY";

    public ChartTimeGroupModeCodeListModel() {
        this.initAnnotation(ChartTimeGroupModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartTimeGroupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartTimeGroupModeCodeListModel");
    }
}


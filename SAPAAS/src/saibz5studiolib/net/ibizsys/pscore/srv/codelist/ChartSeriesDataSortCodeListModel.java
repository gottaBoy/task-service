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

@CodeList(id="10925b347ae8aacc6cb8320a2cfe3a56", name="\u5e8f\u5217\u6570\u636e\u6392\u5e8f\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ascending", text="\u5347\u5e8f\uff08Ascending\uff09", realtext="\u5347\u5e8f\uff08Ascending\uff09"), @CodeItem(value="descending", text="\u964d\u5e8f\uff08Descending\uff09", realtext="\u964d\u5e8f\uff08Descending\uff09"), @CodeItem(value="none", text="\u65e0\uff08None\uff09", realtext="\u65e0\uff08None\uff09")})
public class ChartSeriesDataSortCodeListModel
extends StaticCodeListModelBase {
    public static final String ASCENDING = "ascending";
    public static final String DESCENDING = "descending";
    public static final String NONE = "none";

    public ChartSeriesDataSortCodeListModel() {
        this.initAnnotation(ChartSeriesDataSortCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartSeriesDataSortCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartSeriesDataSortCodeListModel");
    }
}


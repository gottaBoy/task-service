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

@CodeList(id="9eecf0e85940859a8a7eeeff996fe306", name="\u5e8f\u5217\u5e94\u7528\u7ed3\u679c\u96c6\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="column", text="\u5217\uff08Column\uff09", realtext="\u5217\uff08Column\uff09"), @CodeItem(value="row", text="\u884c\uff08Row\uff09", realtext="\u884c\uff08Row\uff09")})
public class ChartSeriesLayoutByCodeListModel
extends StaticCodeListModelBase {
    public static final String COLUMN = "column";
    public static final String ROW = "row";

    public ChartSeriesLayoutByCodeListModel() {
        this.initAnnotation(ChartSeriesLayoutByCodeListModel.class);
        this.setUserData2("ChartSeriesLayoutBy");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartSeriesLayoutByCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartSeriesLayoutByCodeListModel");
    }
}


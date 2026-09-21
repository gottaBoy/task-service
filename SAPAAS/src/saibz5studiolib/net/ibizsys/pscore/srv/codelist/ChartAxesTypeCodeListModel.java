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

@CodeList(id="f6e680062238aefbc11487f30003f9fe", name="\u56fe\u8868\u5750\u6807\u8f74\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="numeric", text="\u6570\u503c", realtext="\u6570\u503c", userdata="\u5750\u6807\u8f74\u7528\u4e8e\u6807\u6ce8\u6570\u5b57\u503c"), @CodeItem(value="time", text="\u65f6\u95f4", realtext="\u65f6\u95f4", userdata="\u5750\u6807\u8f74\u7528\u4e8e\u6807\u6ce8\u65f6\u95f4\u503c"), @CodeItem(value="category", text="\u5206\u7c7b", realtext="\u5206\u7c7b", userdata="\u5750\u6807\u8f74\u7528\u4e8e\u6807\u6ce8\u5206\u7c7b\u503c"), @CodeItem(value="log", text="\u5bf9\u6570\u8f74", realtext="\u5bf9\u6570\u8f74", userdata="\u5750\u6807\u8f74\u7528\u4e8e\u6807\u6ce8\u5bf9\u6570\u503c")})
public class ChartAxesTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NUMERIC = "numeric";
    public static final String TIME = "time";
    public static final String CATEGORY = "category";
    public static final String LOG = "log";

    public ChartAxesTypeCodeListModel() {
        this.initAnnotation(ChartAxesTypeCodeListModel.class);
        this.setUserData2("ChartAxisType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartAxesTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartAxesTypeCodeListModel");
    }
}


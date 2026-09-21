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

@CodeList(id="4e1c6f7a945d85d1cb60399c9d482c24", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u7cfb\u7edf\u4ea7\u54c1\u7248\u672c\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u53d1\u5e03", realtext="\u672a\u53d1\u5e03"), @CodeItem(value="11", text="\u7533\u8bf7\u53d1\u5e03", realtext="\u7533\u8bf7\u53d1\u5e03"), @CodeItem(value="12", text="\u7533\u8bf7\u53d1\u5e03\u88ab\u62d2\u7edd", realtext="\u7533\u8bf7\u53d1\u5e03\u88ab\u62d2\u7edd"), @CodeItem(value="20", text="\u5df2\u53d1\u5e03", realtext="\u5df2\u53d1\u5e03"), @CodeItem(value="30", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88")})
public class DCSysPrdVerStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_11 = "11";
    public static final String ITEM_12 = "12";
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";

    public DCSysPrdVerStateCodeListModel() {
        this.initAnnotation(DCSysPrdVerStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCSysPrdVerStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCSysPrdVerStateCodeListModel");
    }
}


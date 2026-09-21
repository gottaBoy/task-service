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

@CodeList(id="9c7be4c58378cbf547c6d4bf01815196", name="\u6a21\u578b\u5206\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYS", text="\u7cfb\u7edf\u6a21\u578b", realtext="\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="PAAS", text="\u4e91\u5e73\u53f0", realtext="\u4e91\u5e73\u53f0"), @CodeItem(value="DC", text="\u5e94\u7528\u4e2d\u5fc3", realtext="\u5e94\u7528\u4e2d\u5fc3")})
public class ModelCatCodeListModel
extends StaticCodeListModelBase {
    public static final String SYS = "SYS";
    public static final String PAAS = "PAAS";
    public static final String DC = "DC";

    public ModelCatCodeListModel() {
        this.initAnnotation(ModelCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelCatCodeListModel");
    }
}


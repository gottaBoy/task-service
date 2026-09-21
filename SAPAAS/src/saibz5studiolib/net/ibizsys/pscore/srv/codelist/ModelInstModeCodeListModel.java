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

@CodeList(id="2bde8df4e8412390fd17bd5a8f55b06e", name="\u6a21\u578b\u5e93\u5f52\u5c5e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u6a21\u578b\u5e93", realtext="\u65e0\u6a21\u578b\u5e93"), @CodeItem(value="1", text="\u7cfb\u7edf\u6a21\u578b\u5e93", realtext="\u7cfb\u7edf\u6a21\u578b\u5e93"), @CodeItem(value="2", text="\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b\u5e93", realtext="\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b\u5e93"), @CodeItem(value="3", text="\u7cfb\u7edf\u53ca\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b\u5e93", realtext="\u7cfb\u7edf\u53ca\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b\u5e93")})
public class ModelInstModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SYS = 1;
    public static final int INT_SYS = 1;
    public static final Integer DC = 2;
    public static final int INT_DC = 2;
    public static final Integer SYSANDDC = 3;
    public static final int INT_SYSANDDC = 3;

    public ModelInstModeCodeListModel() {
        this.initAnnotation(ModelInstModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelInstModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelInstModeCodeListModel");
    }
}


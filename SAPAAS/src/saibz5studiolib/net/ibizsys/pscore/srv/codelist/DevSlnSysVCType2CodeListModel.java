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

@CodeList(id="6925D08B-AF1C-4D37-BD73-90D0DC04E369", name="\u4e91\u5e94\u7528\u65b9\u6848\u7cfb\u7edf\u7248\u672c\u5206\u652f\u7c7b\u578b\uff08\u5206\u652f\u53ca\u6807\u8bb0\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BRANCH", text="\u5206\u652f", realtext="\u5206\u652f"), @CodeItem(value="TAG", text="\u6807\u8bb0", realtext="\u6807\u8bb0")})
public class DevSlnSysVCType2CodeListModel
extends StaticCodeListModelBase {
    public static final String BRANCH = "BRANCH";
    public static final String TAG = "TAG";

    public DevSlnSysVCType2CodeListModel() {
        this.initAnnotation(DevSlnSysVCType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysVCType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysVCType2CodeListModel");
    }
}


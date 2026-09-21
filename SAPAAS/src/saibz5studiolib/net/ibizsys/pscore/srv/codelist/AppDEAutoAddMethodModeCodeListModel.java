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

@CodeList(id="8ebd0fbc73e30a3a68dd76835c02f8b4", name="\u81ea\u52a8\u6dfb\u52a0\u5e94\u7528\u65b9\u6cd5\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u6dfb\u52a0", realtext="\u4e0d\u6dfb\u52a0"), @CodeItem(value="1", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a"), @CodeItem(value="2", text="\u5b9e\u4f53\u6570\u636e\u96c6", realtext="\u5b9e\u4f53\u6570\u636e\u96c6"), @CodeItem(value="3", text="\u5b9e\u4f53\u884c\u4e3a\u53ca\u6570\u636e\u96c6", realtext="\u5b9e\u4f53\u884c\u4e3a\u53ca\u6570\u636e\u96c6")})
public class AppDEAutoAddMethodModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOT = 0;
    public static final int INT_NOT = 0;
    public static final Integer DEACTION = 1;
    public static final int INT_DEACTION = 1;
    public static final Integer DEDATASET = 2;
    public static final int INT_DEDATASET = 2;
    public static final Integer DEACTIONANDDEDATASET = 3;
    public static final int INT_DEACTIONANDDEDATASET = 3;

    public AppDEAutoAddMethodModeCodeListModel() {
        this.initAnnotation(AppDEAutoAddMethodModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDEAutoAddMethodModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDEAutoAddMethodModeCodeListModel");
    }
}


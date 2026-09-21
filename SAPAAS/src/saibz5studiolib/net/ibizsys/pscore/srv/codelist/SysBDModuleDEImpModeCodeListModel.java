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

@CodeList(id="fae3547b1f5795ecfbec0cbf14cb4ff8", name="\u5927\u6570\u636e\u67b6\u6784\u6a21\u5757\u5bfc\u5165\u5b9e\u4f53\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u6392\u9664\u6307\u5b9a", realtext="\u6392\u9664\u6307\u5b9a"), @CodeItem(value="2", text="\u9009\u62e9\u6307\u5b9a", realtext="\u9009\u62e9\u6307\u5b9a")})
public class SysBDModuleDEImpModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer EXCLUDE = 1;
    public static final int INT_EXCLUDE = 1;
    public static final Integer INCLUDE = 2;
    public static final int INT_INCLUDE = 2;

    public SysBDModuleDEImpModeCodeListModel() {
        this.initAnnotation(SysBDModuleDEImpModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBDModuleDEImpModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBDModuleDEImpModeCodeListModel");
    }
}


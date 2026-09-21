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

@CodeList(id="2295ddeb6c42337f968f87547ae06e67", name="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u5bfc\u51fa\u80fd\u529b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u5bfc\u51fa", realtext="\u5bfc\u51fa"), @CodeItem(value="2", text="\u5bfc\u5165", realtext="\u5bfc\u5165"), @CodeItem(value="3", text="\u5bfc\u5165\u53ca\u5bfc\u51fa", realtext="\u5bfc\u5165\u53ca\u5bfc\u51fa")})
public class DEDataImpExpModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer EXPORT = 1;
    public static final int INT_EXPORT = 1;
    public static final Integer IMPORT = 2;
    public static final int INT_IMPORT = 2;
    public static final Integer ALL = 3;
    public static final int INT_ALL = 3;

    public DEDataImpExpModeCodeListModel() {
        this.initAnnotation(DEDataImpExpModeCodeListModel.class);
        this.setUserData2("DEDataImpExpMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataImpExpModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataImpExpModeCodeListModel");
    }
}


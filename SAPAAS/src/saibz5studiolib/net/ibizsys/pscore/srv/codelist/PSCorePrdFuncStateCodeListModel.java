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

@CodeList(id="508bb751c1149fa78f78ab8c6cf19bd8", name="\u4e91\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u529f\u80fd\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u5b89\u88c5", realtext="\u672a\u5b89\u88c5"), @CodeItem(value="1", text="\u5df2\u5b89\u88c5", realtext="\u5df2\u5b89\u88c5"), @CodeItem(value="2", text="\u5df2\u7981\u7528", realtext="\u5df2\u7981\u7528")})
public class PSCorePrdFuncStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTINSTALL = 0;
    public static final int INT_NOTINSTALL = 0;
    public static final Integer INSTALLED = 1;
    public static final int INT_INSTALLED = 1;
    public static final Integer DISABLED = 2;
    public static final int INT_DISABLED = 2;

    public PSCorePrdFuncStateCodeListModel() {
        this.initAnnotation(PSCorePrdFuncStateCodeListModel.class);
        this.setUserData2("ProductFuncState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCorePrdFuncStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCorePrdFuncStateCodeListModel");
    }
}


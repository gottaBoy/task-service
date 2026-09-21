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

@CodeList(id="05cc3e67c6057a7dc2c0be25b983e5d0", name="\u4e91\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u7248\u672c\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u6784\u5efa", realtext="\u672a\u6784\u5efa"), @CodeItem(value="1", text="\u6784\u5efa\u4e2d", realtext="\u6784\u5efa\u4e2d"), @CodeItem(value="2", text="\u5df2\u6784\u5efa", realtext="\u5df2\u6784\u5efa"), @CodeItem(value="3", text="\u6784\u5efa\u5931\u8d25", realtext="\u6784\u5efa\u5931\u8d25")})
public class PSCorePrdVerStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTBUILD = 0;
    public static final int INT_NOTBUILD = 0;
    public static final Integer BUILDING = 1;
    public static final int INT_BUILDING = 1;
    public static final Integer BUILDED = 2;
    public static final int INT_BUILDED = 2;
    public static final Integer BUILDFAILED = 3;
    public static final int INT_BUILDFAILED = 3;

    public PSCorePrdVerStateCodeListModel() {
        this.initAnnotation(PSCorePrdVerStateCodeListModel.class);
        this.setUserData2("ProductVerState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCorePrdVerStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCorePrdVerStateCodeListModel");
    }
}


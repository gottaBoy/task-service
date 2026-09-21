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

@CodeList(id="c9c7fe5b7d93480dbe144a7cc4976a95", name="\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u5df2\u5efa\u7acb", realtext="\u5df2\u5efa\u7acb"), @CodeItem(value="20", text="\u6267\u884c\u4e2d", realtext="\u6267\u884c\u4e2d"), @CodeItem(value="30", text="\u5df2\u5b8c\u6210", realtext="\u5df2\u5b8c\u6210"), @CodeItem(value="40", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88")})
public class SysDevBKTaskStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATED = 10;
    public static final int INT_CREATED = 10;
    public static final Integer EXECUTING = 20;
    public static final int INT_EXECUTING = 20;
    public static final Integer FINISHED = 30;
    public static final int INT_FINISHED = 30;
    public static final Integer CANCELLED = 40;
    public static final int INT_CANCELLED = 40;

    public SysDevBKTaskStateCodeListModel() {
        this.initAnnotation(SysDevBKTaskStateCodeListModel.class);
        this.setUserData2("SysDevBKTaskState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel");
    }
}


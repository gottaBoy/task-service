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

@CodeList(id="53d3b39440f493b75d6995cddd97a72d", name="\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INSERT", text="\u6570\u636e\u63d2\u5165\uff08INSERT\uff09", realtext="\u6570\u636e\u63d2\u5165\uff08INSERT\uff09"), @CodeItem(value="UPDATE", text="\u6570\u636e\u66f4\u65b0\uff08UPDATE\uff09", realtext="\u6570\u636e\u66f4\u65b0\uff08UPDATE\uff09"), @CodeItem(value="DELETE", text="\u6570\u636e\u5220\u9664\uff08DELETE\uff09", realtext="\u6570\u636e\u5220\u9664\uff08DELETE\uff09"), @CodeItem(value="GET", text="\u6570\u636e\u83b7\u53d6\uff08GET\uff09", realtext="\u6570\u636e\u83b7\u53d6\uff08GET\uff09")})
public class SysDBProcTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String GET = "GET";

    public SysDBProcTypeCodeListModel() {
        this.initAnnotation(SysDBProcTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBProcTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBProcTypeCodeListModel");
    }
}


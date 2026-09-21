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

@CodeList(id="76c63f62fdccd65a7cd414dbdee8d922", name="REST\u8bf7\u6c42\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GET", text="GET", realtext="GET"), @CodeItem(value="HEAD", text="HEAD", realtext="HEAD"), @CodeItem(value="POST", text="POST", realtext="POST"), @CodeItem(value="PUT", text="PUT", realtext="PUT"), @CodeItem(value="PATCH", text="PATCH", realtext="PATCH"), @CodeItem(value="DELETE", text="DELETE", realtext="DELETE"), @CodeItem(value="OPTIONS", text="OPTIONS", realtext="OPTIONS"), @CodeItem(value="TRACE", text="TRACE", realtext="TRACE")})
public class RequestMethodCodeListModel
extends StaticCodeListModelBase {
    public static final String GET = "GET";
    public static final String HEAD = "HEAD";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String PATCH = "PATCH";
    public static final String DELETE = "DELETE";
    public static final String OPTIONS = "OPTIONS";
    public static final String TRACE = "TRACE";

    public RequestMethodCodeListModel() {
        this.initAnnotation(RequestMethodCodeListModel.class);
        this.setUserData2("RequestMethod");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
    }
}


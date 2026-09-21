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

@CodeList(id="7ECF5E6C-D14E-4FC8-B9A9-33830CB7090C", name="\u670d\u52a1\u8bf7\u6c42\u53c2\u6570\u7c7b\u578b\uff08\u5916\u90e8\u63a5\u53e3\u4f7f\u7528\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u53c2\u6570", realtext="\u65e0\u53c2\u6570"), @CodeItem(value="FIELD", text="\u6307\u5b9a\u5c5e\u6027", realtext="\u6307\u5b9a\u5c5e\u6027"), @CodeItem(value="FIELDS", text="\u6307\u5b9a\u5c5e\u6027\u6570\u7ec4", realtext="\u6307\u5b9a\u5c5e\u6027\u6570\u7ec4"), @CodeItem(value="ENTITY", text="\u6570\u636e\u5bf9\u8c61", realtext="\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="ENTITIES", text="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4", realtext="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4")})
public class ServiceReqParamType2CodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String FIELD = "FIELD";
    public static final String FIELDS = "FIELDS";
    public static final String ENTITY = "ENTITY";
    public static final String ENTITIES = "ENTITIES";

    public ServiceReqParamType2CodeListModel() {
        this.initAnnotation(ServiceReqParamType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceReqParamType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceReqParamType2CodeListModel");
    }
}


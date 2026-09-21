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

@CodeList(id="ab89538afa6a5310d94929f13c412a8c", name="\u670d\u52a1\u8bf7\u6c42\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u53c2\u6570", realtext="\u65e0\u53c2\u6570"), @CodeItem(value="FIELD", text="\u6307\u5b9a\u5c5e\u6027", realtext="\u6307\u5b9a\u5c5e\u6027"), @CodeItem(value="FIELDS", text="\u6307\u5b9a\u5c5e\u6027\u6570\u7ec4", realtext="\u6307\u5b9a\u5c5e\u6027\u6570\u7ec4"), @CodeItem(value="ENTITY", text="\u6570\u636e\u5bf9\u8c61", realtext="\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="ENTITIES", text="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4", realtext="\u6570\u636e\u5bf9\u8c61\u6570\u7ec4"), @CodeItem(value="OBJECT", text="\u5176\u5b83\u5bf9\u8c61", realtext="\u5176\u5b83\u5bf9\u8c61"), @CodeItem(value="OBJECTS", text="\u5176\u5b83\u5bf9\u8c61\u6570\u7ec4", realtext="\u5176\u5b83\u5bf9\u8c61\u6570\u7ec4")})
public class ServiceReqParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String FIELD = "FIELD";
    public static final String FIELDS = "FIELDS";
    public static final String ENTITY = "ENTITY";
    public static final String ENTITIES = "ENTITIES";
    public static final String OBJECT = "OBJECT";
    public static final String OBJECTS = "OBJECTS";

    public ServiceReqParamTypeCodeListModel() {
        this.initAnnotation(ServiceReqParamTypeCodeListModel.class);
        this.setUserData2("ServiceReqParamType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceReqParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceReqParamTypeCodeListModel");
    }
}


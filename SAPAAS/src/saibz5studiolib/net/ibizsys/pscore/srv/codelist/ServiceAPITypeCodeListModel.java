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

@CodeList(id="1e9b833d55b677d7086c23be7cf5cbdd", name="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08RESTful API\uff09")
@CodeItems(value={@CodeItem(value="RESTFUL", text="RESTful API", realtext="RESTful API"), @CodeItem(value="JAXRS", text="RESTful WebService", realtext="RESTful WebService"), @CodeItem(value="WEBSERVICE", text="WebService", realtext="WebService"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class ServiceAPITypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RESTFUL = "RESTFUL";
    public static final String JAXRS = "JAXRS";
    public static final String WEBSERVICE = "WEBSERVICE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public ServiceAPITypeCodeListModel() {
        this.initAnnotation(ServiceAPITypeCodeListModel.class);
        this.setUserData2("ServiceAPIType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceAPITypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceAPITypeCodeListModel");
    }
}


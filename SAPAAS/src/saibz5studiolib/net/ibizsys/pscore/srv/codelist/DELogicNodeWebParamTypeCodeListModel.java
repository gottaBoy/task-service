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

@CodeList(id="C80C1EEC-A201-4546-827A-0F44CFD1EC97", name="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9Web\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WEBURIPARAM", text="\u8bf7\u6c42Uri\u53c2\u6570", realtext="\u8bf7\u6c42Uri\u53c2\u6570"), @CodeItem(value="WEBHEADERPARAM", text="\u8bf7\u6c42Header\u53c2\u6570", realtext="\u8bf7\u6c42Header\u53c2\u6570")})
public class DELogicNodeWebParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String WEBURIPARAM = "WEBURIPARAM";
    public static final String WEBHEADERPARAM = "WEBHEADERPARAM";

    public DELogicNodeWebParamTypeCodeListModel() {
        this.initAnnotation(DELogicNodeWebParamTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeWebParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicNodeWebParamTypeCodeListModel");
    }
}


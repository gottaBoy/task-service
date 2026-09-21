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

@CodeList(id="6DB520C9-A09C-4D35-B6EE-51DE99E6495E", name="\u670d\u52a1\u63a5\u53e3DTO\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SIMPLE", text="\u7b80\u5355\u503c", realtext="\u7b80\u5355\u503c"), @CodeItem(value="SIMPLES", text="\u7b80\u5355\u503c\u6570\u7ec4", realtext="\u7b80\u5355\u503c\u6570\u7ec4"), @CodeItem(value="DTO", text="DTO\u5bf9\u8c61", realtext="DTO\u5bf9\u8c61"), @CodeItem(value="DTOS", text="DTO\u5bf9\u8c61\u6570\u7ec4", realtext="DTO\u5bf9\u8c61\u6570\u7ec4")})
public class ServiceAPIDTOFieldTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SIMPLE = "SIMPLE";
    public static final String SIMPLES = "SIMPLES";
    public static final String DTO = "DTO";
    public static final String DTOS = "DTOS";

    public ServiceAPIDTOFieldTypeCodeListModel() {
        this.initAnnotation(ServiceAPIDTOFieldTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceAPIDTOFieldTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceAPIDTOFieldTypeCodeListModel");
    }
}


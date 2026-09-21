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

@CodeList(id="d51ce373febedb259583704da9d0fe59", name="\u52a8\u6001\u6a21\u578b\u4f7f\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATA", text="\u6570\u636e", realtext="\u6570\u636e"), @CodeItem(value="STRUCT", text="\u7ed3\u6784", realtext="\u7ed3\u6784"), @CodeItem(value="JSONSCHEMA", text="JsonSchema", realtext="JsonSchema"), @CodeItem(value="OPENAPI3SCHEMA", text="OpenAPI3Schema", realtext="OpenAPI3Schema"), @CodeItem(value="LIQUIBASECHANGELOG", text="LiquibaseChangeLog", realtext="LiquibaseChangeLog"), @CodeItem(value="IM_JSONSCHEMA", text="\u5bfc\u5165\u6a21\u578b\uff08JsonSchema\uff09", realtext="\u5bfc\u5165\u6a21\u578b\uff08JsonSchema\uff09")})
public class DynaModelUsageCodeListModel
extends StaticCodeListModelBase {
    public static final String DATA = "DATA";
    public static final String STRUCT = "STRUCT";
    public static final String JSONSCHEMA = "JSONSCHEMA";
    public static final String OPENAPI3SCHEMA = "OPENAPI3SCHEMA";
    public static final String LIQUIBASECHANGELOG = "LIQUIBASECHANGELOG";
    public static final String IM_JSONSCHEMA = "IM_JSONSCHEMA";

    public DynaModelUsageCodeListModel() {
        this.initAnnotation(DynaModelUsageCodeListModel.class);
        this.setUserData2("DynaModelUsage");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelUsageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelUsageCodeListModel");
    }
}


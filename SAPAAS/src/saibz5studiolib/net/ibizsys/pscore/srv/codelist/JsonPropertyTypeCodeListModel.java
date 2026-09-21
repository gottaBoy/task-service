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

@CodeList(id="610FFAD9-2901-4F97-B95A-4249FB242D0A", name="Json\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="null", text="\u7a7a\u503c", realtext="\u7a7a\u503c"), @CodeItem(value="boolean", text="\u5e03\u5c14\u503c", realtext="\u5e03\u5c14\u503c"), @CodeItem(value="object", text="\u5bf9\u8c61", realtext="\u5bf9\u8c61"), @CodeItem(value="array", text="\u6570\u7ec4", realtext="\u6570\u7ec4"), @CodeItem(value="number", text="\u6570\u503c", realtext="\u6570\u503c"), @CodeItem(value="string", text="\u5b57\u7b26\u4e32", realtext="\u5b57\u7b26\u4e32"), @CodeItem(value="integer", text="\u6574\u6570", realtext="\u6574\u6570")})
public class JsonPropertyTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NULL = "null";
    public static final String BOOLEAN = "boolean";
    public static final String OBJECT = "object";
    public static final String ARRAY = "array";
    public static final String NUMBER = "number";
    public static final String STRING = "string";
    public static final String INTEGER = "integer";

    public JsonPropertyTypeCodeListModel() {
        this.initAnnotation(JsonPropertyTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.JsonPropertyTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.JsonPropertyTypeCodeListModel");
    }
}


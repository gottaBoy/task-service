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

@CodeList(id="E1431BB3-81B9-417B-9E28-8AE1B44DF4CE", name="\u5b9e\u4f53\u63a5\u53e3\u65b9\u6cd5\u8fd4\u56de\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VOID", text="\u6ca1\u6709\u8f93\u5165", realtext="\u6ca1\u6709\u8f93\u5165"), @CodeItem(value="SIMPLE", text="\u7b80\u5355\u503c", realtext="\u7b80\u5355\u503c"), @CodeItem(value="SIMPLES", text="\u7b80\u5355\u503c\u6570\u7ec4", realtext="\u7b80\u5355\u503c\u6570\u7ec4"), @CodeItem(value="DTO", text="\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\uff08DTO\uff09", realtext="\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\uff08DTO\uff09"), @CodeItem(value="DTOS", text="\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\u96c6\u5408\uff08DTOS\uff09", realtext="\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\u96c6\u5408\uff08DTOS\uff09"), @CodeItem(value="PAGE", text="\u641c\u7d22\u5206\u9875", realtext="\u641c\u7d22\u5206\u9875"), @CodeItem(value="UNKNOWN", text="\u672a\u77e5", realtext="\u672a\u77e5"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class DEServiceAPIMethodReturnTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String VOID = "VOID";
    public static final String SIMPLE = "SIMPLE";
    public static final String SIMPLES = "SIMPLES";
    public static final String DTO = "DTO";
    public static final String DTOS = "DTOS";
    public static final String PAGE = "PAGE";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DEServiceAPIMethodReturnTypeCodeListModel() {
        this.initAnnotation(DEServiceAPIMethodReturnTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEServiceAPIMethodReturnTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEServiceAPIMethodReturnTypeCodeListModel");
    }
}


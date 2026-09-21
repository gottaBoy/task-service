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

@CodeList(id="c722922dacebed367e60eb24a121481f", name="\u5b9e\u4f53\u6a21\u578b\u7c7b\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="APP", text="\u5e94\u7528\u5b9e\u4f53", realtext="\u5e94\u7528\u5b9e\u4f53"), @CodeItem(value="API", text="\u63a5\u53e3\u5b9e\u4f53", realtext="\u63a5\u53e3\u5b9e\u4f53"), @CodeItem(value="SVR", text="\u670d\u52a1\u5b9e\u4f53", realtext="\u670d\u52a1\u5b9e\u4f53"), @CodeItem(value="CLIENT", text="\u5ba2\u6237\u7aef\u5b9e\u4f53", realtext="\u5ba2\u6237\u7aef\u5b9e\u4f53")})
public class DECatalogCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String APP = "APP";
    public static final String API = "API";
    public static final String SVR = "SVR";
    public static final String CLIENT = "CLIENT";

    public DECatalogCodeListModel() {
        this.initAnnotation(DECatalogCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DECatalogCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DECatalogCodeListModel");
    }
}


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

@CodeList(id="2ddefe924f039ca4bf0bbcd96c3e25bf", name="\u5e94\u7528\u529f\u80fd\u914d\u7f6e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FILTERSTORAGE", text="\u641c\u7d22\u6761\u4ef6\u5b58\u50a8", realtext="\u641c\u7d22\u6761\u4ef6\u5b58\u50a8"), @CodeItem(value="DYNADASHBOARD", text="\u52a8\u6001\u6570\u636e\u770b\u677f", realtext="\u52a8\u6001\u6570\u636e\u770b\u677f"), @CodeItem(value="DYNACHART", text="\u52a8\u6001\u56fe\u8868", realtext="\u52a8\u6001\u56fe\u8868"), @CodeItem(value="DYNAREPORT", text="\u52a8\u6001\u62a5\u8868", realtext="\u52a8\u6001\u62a5\u8868"), @CodeItem(value="DRAFTSTORAGE", text="\u8868\u5355\u8349\u7a3f\u5b58\u50a8", realtext="\u8868\u5355\u8349\u7a3f\u5b58\u50a8"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class AppUtilTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String FILTERSTORAGE = "FILTERSTORAGE";
    public static final String DYNADASHBOARD = "DYNADASHBOARD";
    public static final String DYNACHART = "DYNACHART";
    public static final String DYNAREPORT = "DYNAREPORT";
    public static final String DRAFTSTORAGE = "DRAFTSTORAGE";
    public static final String USER = "USER";

    public AppUtilTypeCodeListModel() {
        this.initAnnotation(AppUtilTypeCodeListModel.class);
        this.setUserData2("AppUtilType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilTypeCodeListModel");
    }
}


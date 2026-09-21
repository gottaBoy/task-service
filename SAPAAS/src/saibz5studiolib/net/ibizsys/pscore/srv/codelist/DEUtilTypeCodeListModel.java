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

@CodeList(id="AC338258-C894-484C-948A-6ACB0966567C", name="\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATAAUDIT", text="\u6570\u636e\u5ba1\u8ba1", realtext="\u6570\u636e\u5ba1\u8ba1", iconpath="default/psdeutilde/icon_utiltype_dataaudit.png", iconpathx="default/psdeutilde/icon_utiltype_dataaudit@{0}x.png"), @CodeItem(value="DYNASTORAGE", text="\u52a8\u6001\u5b58\u50a8", realtext="\u52a8\u6001\u5b58\u50a8", iconpath="deutiltype/icon_dynastorage.png", iconpathx="deutiltype/icon_dynastorage@{0}x.png"), @CodeItem(value="EXTENSION", text="\u5b9e\u4f53\u6269\u5c55", realtext="\u5b9e\u4f53\u6269\u5c55"), @CodeItem(value="NOTIFYSETTING", text="\u901a\u77e5\u8bbe\u7f6e", realtext="\u901a\u77e5\u8bbe\u7f6e"), @CodeItem(value="VERSIONCONTROL", text="\u7248\u672c\u63a7\u5236", realtext="\u7248\u672c\u63a7\u5236"), @CodeItem(value="VERSIONSTORAGE", text="\u7248\u672c\u6570\u636e\u5b58\u50a8", realtext="\u7248\u672c\u6570\u636e\u5b58\u50a8"), @CodeItem(value="CACHE", text="\u7f13\u5b58", realtext="\u7f13\u5b58"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class DEUtilTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATAAUDIT = "DATAAUDIT";
    public static final String DYNASTORAGE = "DYNASTORAGE";
    public static final String EXTENSION = "EXTENSION";
    public static final String NOTIFYSETTING = "NOTIFYSETTING";
    public static final String VERSIONCONTROL = "VERSIONCONTROL";
    public static final String VERSIONSTORAGE = "VERSIONSTORAGE";
    public static final String CACHE = "CACHE";
    public static final String USER = "USER";

    public DEUtilTypeCodeListModel() {
        this.initAnnotation(DEUtilTypeCodeListModel.class);
        this.setUserData2("DEUtilType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUtilTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUtilTypeCodeListModel");
    }
}


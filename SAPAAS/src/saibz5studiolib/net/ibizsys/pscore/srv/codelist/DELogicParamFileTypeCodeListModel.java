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

@CodeList(id="14286A2A-D0E9-48F2-A440-A8C229F8EC51", name="\u5b9e\u4f53\u903b\u8f91\u53c2\u6570\u6587\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEMP", text="\u672c\u5730\u4e34\u65f6\u6587\u4ef6", realtext="\u672c\u5730\u4e34\u65f6\u6587\u4ef6"), @CodeItem(value="URL", text="\u8fdc\u7a0b\u6587\u4ef6\uff08Url\uff09", realtext="\u8fdc\u7a0b\u6587\u4ef6\uff08Url\uff09"), @CodeItem(value="STORAGESERVICE", text="\u5b58\u50a8\u670d\u52a1", realtext="\u5b58\u50a8\u670d\u52a1", userdata="\u672c\u5730\u5b58\u50a8\u6216\u4f7f\u7528\u8fdc\u7a0b\u5b58\u50a8\u670d\u52a1\u5b58\u50a8")})
public class DELogicParamFileTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TEMP = "TEMP";
    public static final String URL = "URL";
    public static final String STORAGESERVICE = "STORAGESERVICE";

    public DELogicParamFileTypeCodeListModel() {
        this.initAnnotation(DELogicParamFileTypeCodeListModel.class);
        this.setUserData2("DELogicParamFileType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamFileTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamFileTypeCodeListModel");
    }
}


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

@CodeList(id="116e7d35761a8e3185ce2a2b17789c44", name="\u90e8\u7f72\u5185\u5bb9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APP", text="\u7cfb\u7edf\u5e94\u7528", realtext="\u7cfb\u7edf\u5e94\u7528"), @CodeItem(value="API", text="\u670d\u52a1\u63a5\u53e3", realtext="\u670d\u52a1\u63a5\u53e3")})
public class DepSysContentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String APP = "APP";
    public static final String API = "API";

    public DepSysContentTypeCodeListModel() {
        this.initAnnotation(DepSysContentTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSysContentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSysContentTypeCodeListModel");
    }
}


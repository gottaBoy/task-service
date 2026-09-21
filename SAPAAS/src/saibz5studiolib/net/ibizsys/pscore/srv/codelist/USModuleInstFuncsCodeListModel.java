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

@CodeList(id="120fbb842a1a52d1d7819d72ea18eb72", name="\u5e73\u53f0\u7edf\u4e00\u7cfb\u7edf\u6a21\u5757\u5b9e\u4f8b\u529f\u80fd\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APP", text="\u524d\u7aef\u5e94\u7528", realtext="\u524d\u7aef\u5e94\u7528"), @CodeItem(value="API", text="\u670d\u52a1\u63a5\u53e3", realtext="\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="ENGINE", text="\u5f15\u64ce\u7cfb\u7edf", realtext="\u5f15\u64ce\u7cfb\u7edf"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class USModuleInstFuncsCodeListModel
extends StaticCodeListModelBase {
    public static final String APP = "APP";
    public static final String API = "API";
    public static final String ENGINE = "ENGINE";
    public static final String CUSTOM = "CUSTOM";

    public USModuleInstFuncsCodeListModel() {
        this.initAnnotation(USModuleInstFuncsCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.USModuleInstFuncsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.USModuleInstFuncsCodeListModel");
    }
}


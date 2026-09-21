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

@CodeList(id="c2432d82c59631650895fcd821739ce4", name="\u903b\u8f91\u5904\u7406\u53c2\u6570\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RESET", text="\u91cd\u7f6e", realtext="\u91cd\u7f6e", userdata="\u91cd\u7f6e\u6570\u636e\u5bf9\u8c61"), @CodeItem(value="COPY", text="\u62f7\u8d1d", realtext="\u62f7\u8d1d", userdata="\u5c06\u6e90\u6570\u636e\u5bf9\u8c61\u62f7\u8d1d\u81f3\u76ee\u6807\u5bf9\u8c61"), @CodeItem(value="RESETANDCOPY", text="\u91cd\u7f6e\u5e76\u62f7\u8d1d", realtext="\u91cd\u7f6e\u5e76\u62f7\u8d1d", userdata="\u5c06\u6e90\u6570\u636e\u5bf9\u8c61\u62f7\u8d1d\u81f3\u76ee\u6807\u5bf9\u8c61\uff08\u76ee\u6807\u5bf9\u8c61\u5148\u91cd\u7f6e\uff09")})
public class DELogicParamAction2CodeListModel
extends StaticCodeListModelBase {
    public static final String RESET = "RESET";
    public static final String COPY = "COPY";
    public static final String RESETANDCOPY = "RESETANDCOPY";

    public DELogicParamAction2CodeListModel() {
        this.initAnnotation(DELogicParamAction2CodeListModel.class);
        this.setUserData2("DELogicParamAction2");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamAction2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamAction2CodeListModel");
    }
}


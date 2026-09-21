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

@CodeList(id="f7da26db374b94fc0f732d4778b98a27", name="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SETPARAMVALUE", text="\u8bbe\u7f6e\u53d8\u91cf", realtext="\u8bbe\u7f6e\u53d8\u91cf"), @CodeItem(value="RESETPARAM", text="\u91cd\u7f6e\u53d8\u91cf", realtext="\u91cd\u7f6e\u53d8\u91cf"), @CodeItem(value="COPYPARAM", text="\u62f7\u8d1d\u53d8\u91cf", realtext="\u62f7\u8d1d\u53d8\u91cf"), @CodeItem(value="BINDPARAM", text="\u7ed1\u5b9a\u53d8\u91cf", realtext="\u7ed1\u5b9a\u53d8\u91cf"), @CodeItem(value="APPENDPARAM", text="\u9644\u52a0\u5230\u6570\u7ec4\u53d8\u91cf", realtext="\u9644\u52a0\u5230\u6570\u7ec4\u53d8\u91cf"), @CodeItem(value="SORTPARAM", text="\u6392\u5e8f\u6570\u7ec4\u53d8\u91cf", realtext="\u6392\u5e8f\u6570\u7ec4\u53d8\u91cf"), @CodeItem(value="RENEWPARAM", text="\u91cd\u65b0\u5efa\u7acb\u53d8\u91cf", realtext="\u91cd\u65b0\u5efa\u7acb\u53d8\u91cf")})
public class DELogicParamActionCodeListModel
extends StaticCodeListModelBase {
    public static final String SETPARAMVALUE = "SETPARAMVALUE";
    public static final String RESETPARAM = "RESETPARAM";
    public static final String COPYPARAM = "COPYPARAM";
    public static final String BINDPARAM = "BINDPARAM";
    public static final String APPENDPARAM = "APPENDPARAM";
    public static final String SORTPARAM = "SORTPARAM";
    public static final String RENEWPARAM = "RENEWPARAM";

    public DELogicParamActionCodeListModel() {
        this.initAnnotation(DELogicParamActionCodeListModel.class);
        this.setUserData2("DELogicParamAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamActionCodeListModel");
    }
}


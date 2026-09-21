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

@CodeList(id="c67b7dad433006f7134a78bdf1935c7e", name="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SETPARAMVALUE", text="\u8bbe\u7f6e\u53d8\u91cf", realtext="\u8bbe\u7f6e\u53d8\u91cf", userdata="\u5c06\u6e90\u53c2\u6570\u6307\u5b9a\u503c\u8bbe\u7f6e\u5230\u76ee\u6807\u53c2\u6570\u7684\u6307\u5b9a\u5c5e\u6027"), @CodeItem(value="RESETPARAM", text="\u91cd\u7f6e\u53d8\u91cf", realtext="\u91cd\u7f6e\u53d8\u91cf", userdata="\u91cd\u7f6e\u76ee\u6807\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="COPYPARAM", text="\u62f7\u8d1d\u53d8\u91cf", realtext="\u62f7\u8d1d\u53d8\u91cf", userdata="\u5c06\u6e90\u53c2\u6570\u5bf9\u8c61\u62f7\u8d1d\u81f3\u76ee\u6807\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="SQLPARAM", text="\u6570\u636e\u5e93\u8c03\u7528\u53c2\u6570", realtext="\u6570\u636e\u5e93\u8c03\u7528\u53c2\u6570", userdata="\u5c06\u6e90\u53c2\u6570\u6307\u5b9a\u503c\u4f5c\u4e3a\u6570\u636e\u5e93\u8c03\u7528\u53c2\u6570"), @CodeItem(value="SFPLUGINPARAM", text="\u540e\u53f0\u670d\u52a1\u63d2\u4ef6\u53c2\u6570", realtext="\u540e\u53f0\u670d\u52a1\u63d2\u4ef6\u53c2\u6570", userdata="\u5c06\u6e90\u53c2\u6570\u6307\u5b9a\u503c\u4f5c\u4e3a\u540e\u53f0\u6a21\u677f\u63d2\u4ef6\u8c03\u7528\u53c2\u6570"), @CodeItem(value="BINDPARAM", text="\u7ed1\u5b9a\u53c2\u6570", realtext="\u7ed1\u5b9a\u53c2\u6570", userdata="\u5904\u7406\u903b\u8f91\u53d8\u91cf\u7ed1\u5b9a\u6307\u5b9a\u53d8\u91cf"), @CodeItem(value="APPENDPARAM", text="\u9644\u52a0\u5230\u6570\u7ec4\u53d8\u91cf", realtext="\u9644\u52a0\u5230\u6570\u7ec4\u53d8\u91cf"), @CodeItem(value="SORTPARAM", text="\u6392\u5e8f\u6570\u7ec4\u53d8\u91cf", realtext="\u6392\u5e8f\u6570\u7ec4\u53d8\u91cf"), @CodeItem(value="RENEWPARAM", text="\u91cd\u65b0\u5efa\u7acb\u53d8\u91cf", realtext="\u91cd\u65b0\u5efa\u7acb\u53d8\u91cf"), @CodeItem(value="WEBURIPARAM", text="\u8bf7\u6c42Uri\u53c2\u6570", realtext="\u8bf7\u6c42Uri\u53c2\u6570"), @CodeItem(value="WEBHEADERPARAM", text="\u8bf7\u6c42Header\u53c2\u6570", realtext="\u8bf7\u6c42Header\u53c2\u6570"), @CodeItem(value="MERGEMAPPARAM", text="\u5408\u5e76\u6620\u5c04\u53c2\u6570", realtext="\u5408\u5e76\u6620\u5c04\u53c2\u6570", userdata="\u6307\u5b9a\u6e90\u53c2\u6570\u548c\u76ee\u6807\u53c2\u6570\u5408\u5e76\u7684\u6620\u5c04\u53c2\u6570\uff0c\u914d\u7f6e\u6e90\u9879\u5c5e\u6027\u4e0e\u76ee\u6807\u9879\u5c5e\u6027"), @CodeItem(value="AGGREGATEMAPPARAM", text="\u805a\u5408\u6620\u5c04\u53c2\u6570", realtext="\u805a\u5408\u6620\u5c04\u53c2\u6570", userdata="\u6307\u5b9a\u6e90\u53c2\u6570\u805a\u5408\u81f3\u76ee\u6807\u53c2\u6570\u7684\u6620\u5c04\u53c2\u6570\uff0c\u914d\u7f6e\u805a\u5408\u6a21\u5f0f")})
public class DELogicParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SETPARAMVALUE = "SETPARAMVALUE";
    public static final String RESETPARAM = "RESETPARAM";
    public static final String COPYPARAM = "COPYPARAM";
    public static final String SQLPARAM = "SQLPARAM";
    public static final String SFPLUGINPARAM = "SFPLUGINPARAM";
    public static final String BINDPARAM = "BINDPARAM";
    public static final String APPENDPARAM = "APPENDPARAM";
    public static final String SORTPARAM = "SORTPARAM";
    public static final String RENEWPARAM = "RENEWPARAM";
    public static final String WEBURIPARAM = "WEBURIPARAM";
    public static final String WEBHEADERPARAM = "WEBHEADERPARAM";
    public static final String MERGEMAPPARAM = "MERGEMAPPARAM";
    public static final String AGGREGATEMAPPARAM = "AGGREGATEMAPPARAM";

    public DELogicParamTypeCodeListModel() {
        this.initAnnotation(DELogicParamTypeCodeListModel.class);
        this.setUserData2("DELogicNodeParamType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamTypeCodeListModel");
    }
}


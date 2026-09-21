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

@CodeList(id="F17396A1-C4B3-4C49-BBFD-87E0D8F840CE", name="\u5b9e\u4f53\u903b\u8f91\u5408\u5e76\u6570\u636e\u53c2\u6570\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\uff08\u5408\u5e76\u5230\u76ee\u6807\u53c2\u6570\uff0c\u4e0d\u5b58\u5728\u65f6\u5ffd\u7565\uff09", realtext="\u9ed8\u8ba4\uff08\u5408\u5e76\u5230\u76ee\u6807\u53c2\u6570\uff0c\u4e0d\u5b58\u5728\u65f6\u5ffd\u7565\uff09", userdata="\u5408\u5e76\u81f3\u76ee\u6807\u6570\u7ec4\u53c2\u6570\uff0c\u5ffd\u7565\u76ee\u6807\u4e0d\u5b58\u5728\u7684\u6570\u636e"), @CodeItem(value="UNION", text="\u5168\u96c6\uff08\u5408\u5e76\u5230\u76ee\u6807\u53c2\u6570\uff0c\u4e0d\u5b58\u5728\u65f6\u65b0\u5efa\uff09", realtext="\u5168\u96c6\uff08\u5408\u5e76\u5230\u76ee\u6807\u53c2\u6570\uff0c\u4e0d\u5b58\u5728\u65f6\u65b0\u5efa\uff09", userdata="\u6e90\u6570\u636e\u53c2\u6570\u548c\u76ee\u6807\u6570\u7ec4\u53c2\u6570\u8fdb\u884c\u6392\u91cd\u5408\u5e76"), @CodeItem(value="INTERSECTION", text="\u4ea4\u96c6\uff08\u5408\u5e76\u6e90\u548c\u76ee\u6807\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", realtext="\u4ea4\u96c6\uff08\u5408\u5e76\u6e90\u548c\u76ee\u6807\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", userdata="\u6e90\u6570\u636e\u53c2\u6570\u548c\u76ee\u6807\u6570\u7ec4\u53c2\u6570\u8fdb\u884c\u4ea4\u96c6\u5408\u5e76\uff0c\u5373\u5408\u5e76\u4e24\u4e2a\u6570\u7ec4\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e"), @CodeItem(value="DEFFERENCE", text="\u5dee\u96c6\uff08\u5408\u5e76\u6e90\u548c\u76ee\u6807\u6ca1\u6709\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", realtext="\u5dee\u96c6\uff08\u5408\u5e76\u6e90\u548c\u76ee\u6807\u6ca1\u6709\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", userdata="\u6e90\u6570\u636e\u53c2\u6570\u548c\u76ee\u6807\u6570\u7ec4\u53c2\u6570\u8fdb\u884c\u5dee\u96c6\u5408\u5e76\uff0c\u5373\u5408\u5e76\u4e24\u4e2a\u6570\u7ec4\u6ca1\u6709\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e")})
public class DELNMergeParamModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String UNION = "UNION";
    public static final String INTERSECTION = "INTERSECTION";
    public static final String DEFFERENCE = "DEFFERENCE";

    public DELNMergeParamModeCodeListModel() {
        this.initAnnotation(DELNMergeParamModeCodeListModel.class);
        this.setUserData2("DELNMergeParamMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNMergeParamModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNMergeParamModeCodeListModel");
    }
}


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

@CodeList(id="B5CC176B-7640-433A-9012-5EDC9BC9EDEC", name="\u6570\u636e\u6d41\u5408\u5e76\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4", userdata="\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u5408\u5e76\u65b0\u7684\u6570\u636e\u6e90\uff0c\u5982\u6570\u636e\u6e902\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u6570\u636e\u6e90\uff0c\u5219\u5ffd\u7565"), @CodeItem(value="UNION", text="\u6392\u91cd\u5408\u5e76", realtext="\u6392\u91cd\u5408\u5e76", userdata="\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u6392\u91cd\u5408\u5e76\u5f62\u6210\u65b0\u7684\u6570\u636e\u6e90"), @CodeItem(value="UNIONALL", text="\u5168\u90e8\u5408\u5e76", realtext="\u5168\u90e8\u5408\u5e76", userdata="\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u5168\u90e8\u5408\u5e76\u5f62\u6210\u65b0\u7684\u6570\u636e\u6e90"), @CodeItem(value="INTERSECTION", text="\u4ea4\u96c6\uff08\u5408\u5e76\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", realtext="\u4ea4\u96c6\uff08\u5408\u5e76\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", userdata="\u5408\u5e76\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\u5230\u65b0\u6570\u636e\u6e90"), @CodeItem(value="DEFFERENCE", text="\u5dee\u96c6\uff08\u5408\u5e76\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u6ca1\u6709\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", realtext="\u5dee\u96c6\uff08\u5408\u5e76\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u6ca1\u6709\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\uff09", userdata="\u5408\u5e76\u6570\u636e\u6e90\u548c\u6570\u636e\u6e902\u6ca1\u6709\u91cd\u590d\u51fa\u73b0\u7684\u6570\u636e\u5230\u65b0\u6570\u636e\u6e90"), @CodeItem(value="MERGEINTOFIELD", text="\u5408\u5e76\u5230\u5c5e\u6027\uff08\u5355\u9879\uff09", realtext="\u5408\u5e76\u5230\u5c5e\u6027\uff08\u5355\u9879\uff09", userdata="\u5c06\u6570\u636e\u6e902\u5408\u5e76\u81f3\u6570\u636e\u6e90\u6307\u5b9a\u5c5e\u6027\uff0c\u5355\u9879\u6a21\u5f0f"), @CodeItem(value="MERGEINTOFIELD2", text="\u5408\u5e76\u5230\u5c5e\u6027\uff08\u5217\u8868\uff09", realtext="\u5408\u5e76\u5230\u5c5e\u6027\uff08\u5217\u8868\uff09", userdata="\u5c06\u6570\u636e\u6e902\u5408\u5e76\u81f3\u6570\u636e\u6e90\u6307\u5b9a\u5c5e\u6027\uff0c\u591a\u9879\u6a21\u5f0f")})
public class DEDataFlowMergeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String UNION = "UNION";
    public static final String UNIONALL = "UNIONALL";
    public static final String INTERSECTION = "INTERSECTION";
    public static final String DEFFERENCE = "DEFFERENCE";
    public static final String MERGEINTOFIELD = "MERGEINTOFIELD";
    public static final String MERGEINTOFIELD2 = "MERGEINTOFIELD2";

    public DEDataFlowMergeTypeCodeListModel() {
        this.initAnnotation(DEDataFlowMergeTypeCodeListModel.class);
        this.setUserData2("DEDataFlowMergeType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowMergeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowMergeTypeCodeListModel");
    }
}


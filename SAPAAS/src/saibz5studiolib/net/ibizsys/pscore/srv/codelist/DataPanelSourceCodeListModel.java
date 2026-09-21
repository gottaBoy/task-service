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

@CodeList(id="8182E423-86DC-434B-892E-A3E8316999ED", name="\u6570\u636e\u9762\u677f\u6e90\uff08\u5168\u90e8\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u96c6\u5408", realtext="\u5b9e\u4f53\u96c6\u5408"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u903b\u8f91", realtext="\u5b9e\u4f53\u903b\u8f91"), @CodeItem(value="ACTIVEDATAPARAM", text="\u7ed1\u5b9a\u5f53\u524d\u6570\u636e\u53d8\u91cf", realtext="\u7ed1\u5b9a\u5f53\u524d\u6570\u636e\u53d8\u91cf"), @CodeItem(value="APPGLOBALPARAM", text="\u7ed1\u5b9a\u5e94\u7528\u5168\u5c40\u53d8\u91cf", realtext="\u7ed1\u5b9a\u5e94\u7528\u5168\u5c40\u53d8\u91cf"), @CodeItem(value="TOPVIEWSESSIONPARAM", text="\u7ed1\u5b9a\u9876\u7ea7\u89c6\u56fe\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf", realtext="\u7ed1\u5b9a\u9876\u7ea7\u89c6\u56fe\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf"), @CodeItem(value="VIEWSESSIONPARAM", text="\u7ed1\u5b9a\u5f53\u524d\u89c6\u56fe\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf", realtext="\u7ed1\u5b9a\u5f53\u524d\u89c6\u56fe\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u4ee3\u7801", realtext="\u81ea\u5b9a\u4e49\u4ee3\u7801")})
public class DataPanelSourceCodeListModel
extends StaticCodeListModelBase {
    public static final String DEACTION = "DEACTION";
    public static final String DEDATASET = "DEDATASET";
    public static final String DELOGIC = "DELOGIC";
    public static final String ACTIVEDATAPARAM = "ACTIVEDATAPARAM";
    public static final String APPGLOBALPARAM = "APPGLOBALPARAM";
    public static final String TOPVIEWSESSIONPARAM = "TOPVIEWSESSIONPARAM";
    public static final String VIEWSESSIONPARAM = "VIEWSESSIONPARAM";
    public static final String CUSTOM = "CUSTOM";

    public DataPanelSourceCodeListModel() {
        this.initAnnotation(DataPanelSourceCodeListModel.class);
        this.setUserData2("DataPanelSource");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DataPanelSourceCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DataPanelSourceCodeListModel");
    }
}


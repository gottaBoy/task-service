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

@CodeList(id="28f9509f33560a3870ed1f9f6b6d456b", name="\u5c5e\u6027\u903b\u8f91\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="COMPUTE", text="\u8ba1\u7b97\u503c", realtext="\u8ba1\u7b97\u503c", userdata="\u903b\u8f91\u5728\u83b7\u53d6\u5c5e\u6027\u503c\u65f6\u89e6\u53d1\uff0c\u8ba1\u7b97\u5c5e\u6027\u503c"), @CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\u503c", realtext="\u9ed8\u8ba4\u503c", userdata="\u903b\u8f91\u5728\u83b7\u53d6\u5c5e\u6027\u9ed8\u8ba4\u503c\u65f6\u89e6\u53d1"), @CodeItem(value="ONCHANGE", text="\u53d8\u66f4\u89e6\u53d1", realtext="\u53d8\u66f4\u89e6\u53d1", userdata="\u903b\u8f91\u5728\u5c5e\u6027\u503c\u53d8\u5316\u65f6\u89e6\u53d1"), @CodeItem(value="CHECK", text="\u68c0\u67e5\u503c", realtext="\u68c0\u67e5\u503c", userdata="\u903b\u8f91\u5728\u68c0\u67e5\u5c5e\u6027\u503c\u65f6\u89e6\u53d1"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DEFLogicModeCodeListModel
extends StaticCodeListModelBase {
    public static final String COMPUTE = "COMPUTE";
    public static final String DEFAULT = "DEFAULT";
    public static final String ONCHANGE = "ONCHANGE";
    public static final String CHECK = "CHECK";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DEFLogicModeCodeListModel() {
        this.initAnnotation(DEFLogicModeCodeListModel.class);
        this.setUserData2("DEFLogicMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFLogicModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFLogicModeCodeListModel");
    }
}


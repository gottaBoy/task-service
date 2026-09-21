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

@CodeList(id="C9CEBF75-7557-4568-B745-67BF27BB6494", name="\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u6570\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\u53c2\u6570\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u9ed8\u8ba4\u53c2\u6570\uff08\u8bbe\u7f6e\u6307\u5b9a\u53c2\u6570\u9879\u503c\uff09", realtext="\u9ed8\u8ba4\u53c2\u6570\uff08\u8bbe\u7f6e\u6307\u5b9a\u53c2\u6570\u9879\u503c\uff09"), @CodeItem(value="2", text="\u6307\u5b9a\u53c2\u6570", realtext="\u6307\u5b9a\u53c2\u6570", userdata="\u975e\u542f\u7528\u8fd0\u884c\u65f6\u7cfb\u7edf\u6a21\u578b\u4e3b\u952e\u5c06\u9ed8\u8ba4\u4f20\u5165\uff0c\u5426\u5219\u9700\u8981\u624b\u52a8\u6307\u5b9a\u4e3b\u952e\uff08\u5982\u9700\u8981\uff09")})
public class DEDataSetParamModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ALL = 1;
    public static final int INT_ALL = 1;
    public static final Integer SOME = 2;
    public static final int INT_SOME = 2;

    public DEDataSetParamModeCodeListModel() {
        this.initAnnotation(DEDataSetParamModeCodeListModel.class);
        this.setUserData2("DEDataSetParamMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetParamModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetParamModeCodeListModel");
    }
}


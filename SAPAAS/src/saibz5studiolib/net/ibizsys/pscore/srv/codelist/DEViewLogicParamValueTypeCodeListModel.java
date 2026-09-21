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

@CodeList(id="9AF83ED1-0544-4326-8CF4-126D9389DF64", name="\u4e91\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u5904\u7406\u53c2\u6570\u6e90\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SRCDLPARAM", text="\u6e90\u903b\u8f91\u53c2\u6570", realtext="\u6e90\u903b\u8f91\u53c2\u6570"), @CodeItem(value="NONEVALUE", text="\u65e0\u503c\uff08NONE\uff09", realtext="\u65e0\u503c\uff08NONE\uff09"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c\uff08NULL\uff09", realtext="\u7a7a\u503c\uff08NULL\uff09"), @CodeItem(value="SRCVALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c"), @CodeItem(value="JSOBJECT", text="JS\u5bf9\u8c61", realtext="JS\u5bf9\u8c61")})
public class DEViewLogicParamValueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SRCDLPARAM = "SRCDLPARAM";
    public static final String NONEVALUE = "NONEVALUE";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String SRCVALUE = "SRCVALUE";
    public static final String JSOBJECT = "JSOBJECT";

    public DEViewLogicParamValueTypeCodeListModel() {
        this.initAnnotation(DEViewLogicParamValueTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewLogicParamValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewLogicParamValueTypeCodeListModel");
    }
}


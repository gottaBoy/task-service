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

@CodeList(id="f2f876686ee5f157a2e2ee826ac1b980", name="\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATA", text="\u6570\u636e", realtext="\u6570\u636e"), @CodeItem(value="CUSTOMCODE", text="\u81ea\u5b9a\u4e49\u4ee3\u7801", realtext="\u81ea\u5b9a\u4e49\u4ee3\u7801", userdata="\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165\u4e3a\u81ea\u5b9a\u4e49\u4ee3\u7801\uff0c\u5bf9\u5b9a\u4e49\u7684\u6570\u636e\u8fdb\u884c\u8fdb\u4e00\u6b65\u7684\u52a0\u5de5"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class TestCaseInputTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATA = "DATA";
    public static final String CUSTOMCODE = "CUSTOMCODE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public TestCaseInputTypeCodeListModel() {
        this.initAnnotation(TestCaseInputTypeCodeListModel.class);
        this.setUserData2("TestCaseInputType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseInputTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TestCaseInputTypeCodeListModel");
    }
}


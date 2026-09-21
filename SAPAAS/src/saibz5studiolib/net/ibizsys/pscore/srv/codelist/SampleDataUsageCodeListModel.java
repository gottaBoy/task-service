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

@CodeList(id="A29655FA-E445-42A2-A45B-B1ACE71184FE", name="\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u7528\u9014", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INITDATA", text="\u521d\u59cb\u6570\u636e", realtext="\u521d\u59cb\u6570\u636e")})
public class SampleDataUsageCodeListModel
extends StaticCodeListModelBase {
    public static final String INITDATA = "INITDATA";

    public SampleDataUsageCodeListModel() {
        this.initAnnotation(SampleDataUsageCodeListModel.class);
        this.setUserData2("SampleDataUsage");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SampleDataUsageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SampleDataUsageCodeListModel");
    }
}


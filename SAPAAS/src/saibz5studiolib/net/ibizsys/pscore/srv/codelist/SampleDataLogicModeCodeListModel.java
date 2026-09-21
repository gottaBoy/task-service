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

@CodeList(id="c1e6b6f2bb1b87e0f33a1bef8570924d", name="\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u903b\u8f91\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INSTALLDATA", text="\u521d\u59cb\u5316\u6570\u636e", realtext="\u521d\u59cb\u5316\u6570\u636e")})
public class SampleDataLogicModeCodeListModel
extends StaticCodeListModelBase {
    public static final String INSTALLDATA = "INSTALLDATA";

    public SampleDataLogicModeCodeListModel() {
        this.initAnnotation(SampleDataLogicModeCodeListModel.class);
        this.setUserData2("SampleDataLogicMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SampleDataLogicModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SampleDataLogicModeCodeListModel");
    }
}


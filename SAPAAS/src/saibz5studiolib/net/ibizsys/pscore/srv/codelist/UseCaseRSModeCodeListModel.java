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

@CodeList(id="85d7e84d05527eb7df81dac88baf9d37", name="\u7cfb\u7edf\u7528\u4f8b\u5173\u7cfb\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ACTOR2USECASE", text="\u64cd\u4f5c\u8005\u5230\u7528\u4f8b", realtext="\u64cd\u4f5c\u8005\u5230\u7528\u4f8b"), @CodeItem(value="USECASE2USECASE", text="\u7528\u4f8b\u5230\u7528\u4f8b", realtext="\u7528\u4f8b\u5230\u7528\u4f8b"), @CodeItem(value="ACTOR2ACTOR", text="\u64cd\u4f5c\u8005\u5230\u64cd\u4f5c\u8005", realtext="\u64cd\u4f5c\u8005\u5230\u64cd\u4f5c\u8005"), @CodeItem(value="USECASE2ACTOR", text="\u7528\u4f8b\u5230\u64cd\u4f5c\u8005", realtext="\u7528\u4f8b\u5230\u64cd\u4f5c\u8005")})
public class UseCaseRSModeCodeListModel
extends StaticCodeListModelBase {
    public static final String ACTOR2USECASE = "ACTOR2USECASE";
    public static final String USECASE2USECASE = "USECASE2USECASE";
    public static final String ACTOR2ACTOR = "ACTOR2ACTOR";
    public static final String USECASE2ACTOR = "USECASE2ACTOR";

    public UseCaseRSModeCodeListModel() {
        this.initAnnotation(UseCaseRSModeCodeListModel.class);
        this.setUserData2("UseCaseRSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UseCaseRSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UseCaseRSModeCodeListModel");
    }
}


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

@CodeList(id="1b5367053bb2ccb159f8535abff9c7c0", name="\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MODE1", text="\u6a21\u5f0f1", realtext="\u6a21\u5f0f1"), @CodeItem(value="MODE2", text="\u6a21\u5f0f2", realtext="\u6a21\u5f0f2"), @CodeItem(value="MODE3", text="\u6a21\u5f0f3", realtext="\u6a21\u5f0f3"), @CodeItem(value="MODE4", text="\u6a21\u5f0f4", realtext="\u6a21\u5f0f4"), @CodeItem(value="MODE5", text="\u6a21\u5f0f5", realtext="\u6a21\u5f0f5"), @CodeItem(value="MODE6", text="\u6a21\u5f0f6", realtext="\u6a21\u5f0f6"), @CodeItem(value="MODE7", text="\u6a21\u5f0f7", realtext="\u6a21\u5f0f7"), @CodeItem(value="MODE8", text="\u6a21\u5f0f8", realtext="\u6a21\u5f0f8"), @CodeItem(value="MODE9", text="\u6a21\u5f0f9", realtext="\u6a21\u5f0f9")})
public class DEFInputTipModeCodeListModel
extends StaticCodeListModelBase {
    public static final String MODE1 = "MODE1";
    public static final String MODE2 = "MODE2";
    public static final String MODE3 = "MODE3";
    public static final String MODE4 = "MODE4";
    public static final String MODE5 = "MODE5";
    public static final String MODE6 = "MODE6";
    public static final String MODE7 = "MODE7";
    public static final String MODE8 = "MODE8";
    public static final String MODE9 = "MODE9";

    public DEFInputTipModeCodeListModel() {
        this.initAnnotation(DEFInputTipModeCodeListModel.class);
        this.setUserData2("DEFInputTipMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFInputTipModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFInputTipModeCodeListModel");
    }
}


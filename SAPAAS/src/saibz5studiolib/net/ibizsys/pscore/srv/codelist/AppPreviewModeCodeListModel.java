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

@CodeList(id="84B85A04-21F5-4431-B662-872B73E55CD4", name="\u5e94\u7528\u9884\u89c8\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FULL", text="PC\u5168\u5c4f", realtext="PC\u5168\u5c4f"), @CodeItem(value=" 411_731", text="Pixel 2", realtext="Pixel 2"), @CodeItem(value=" 411_823", text="Pixel 2 XL", realtext="Pixel 2 XL"), @CodeItem(value="373_667", text="iPhone 6/7/8", realtext="iPhone 6/7/8"), @CodeItem(value="414_736", text="iPhone 6/7/8 Plus", realtext="iPhone 6/7/8 Plus"), @CodeItem(value="375_812", text="iPhoneX", realtext="iPhoneX")})
public class AppPreviewModeCodeListModel
extends StaticCodeListModelBase {
    public static final String FULL = "FULL";
    public static final String _411_731 = " 411_731";
    public static final String _411_823 = " 411_823";
    public static final String ITEM_4 = "373_667";
    public static final String ITEM_5 = "414_736";
    public static final String ITEM_6 = "375_812";

    public AppPreviewModeCodeListModel() {
        this.initAnnotation(AppPreviewModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppPreviewModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppPreviewModeCodeListModel");
    }
}


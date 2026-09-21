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

@CodeList(id="e9bf7ab7422547fe82c8f702161fe93c", name="\u89c6\u56fe\u6253\u5f00\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="INDEXVIEWTAB", text="\u9876\u7ea7\u5bb9\u5668\u5206\u9875", realtext="\u9876\u7ea7\u5bb9\u5668\u5206\u9875"), @CodeItem(value="INDEXVIEWTAB_POPUP", text="\u9876\u7ea7\u5bb9\u5668\u5206\u9875\uff08\u975e\u6a21\u6001\u5f39\u51fa\uff09", realtext="\u9876\u7ea7\u5bb9\u5668\u5206\u9875\uff08\u975e\u6a21\u6001\u5f39\u51fa\uff09"), @CodeItem(value="INDEXVIEWTAB_POPUPMODAL", text="\u9876\u7ea7\u5bb9\u5668\u5206\u9875\uff08\u6a21\u6001\u5f39\u51fa\uff09", realtext="\u9876\u7ea7\u5bb9\u5668\u5206\u9875\uff08\u6a21\u6001\u5f39\u51fa\uff09"), @CodeItem(value="POPUP", text="\u975e\u6a21\u6001\u5f39\u51fa", realtext="\u975e\u6a21\u6001\u5f39\u51fa"), @CodeItem(value="POPUPMODAL", text="\u6a21\u6001\u5f39\u51fa", realtext="\u6a21\u6001\u5f39\u51fa"), @CodeItem(value="POPUPAPP", text="\u72ec\u7acb\u7a0b\u5e8f\u5f39\u51fa", realtext="\u72ec\u7acb\u7a0b\u5e8f\u5f39\u51fa"), @CodeItem(value="DRAWER_LEFT", text="\u6a21\u6001\u5de6\u4fa7\u62bd\u5c49\u5f39\u51fa", realtext="\u6a21\u6001\u5de6\u4fa7\u62bd\u5c49\u5f39\u51fa"), @CodeItem(value="DRAWER_RIGHT", text="\u6a21\u6001\u53f3\u4fa7\u62bd\u5c49\u5f39\u51fa", realtext="\u6a21\u6001\u53f3\u4fa7\u62bd\u5c49\u5f39\u51fa"), @CodeItem(value="DRAWER_TOP", text="\u6a21\u6001\u4e0a\u65b9\u62bd\u5c49\u5f39\u51fa", realtext="\u6a21\u6001\u4e0a\u65b9\u62bd\u5c49\u5f39\u51fa"), @CodeItem(value="DRAWER_BOTTOM", text="\u6a21\u6001\u4e0b\u65b9\u62bd\u5c49\u5f39\u51fa", realtext="\u6a21\u6001\u4e0b\u65b9\u62bd\u5c49\u5f39\u51fa"), @CodeItem(value="POPOVER", text="\u6c14\u6ce1\u5361\u7247", realtext="\u6c14\u6ce1\u5361\u7247"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DEViewOpenModeCodeListModel
extends StaticCodeListModelBase {
    public static final String INDEXVIEWTAB = "INDEXVIEWTAB";
    public static final String INDEXVIEWTAB_POPUP = "INDEXVIEWTAB_POPUP";
    public static final String INDEXVIEWTAB_POPUPMODAL = "INDEXVIEWTAB_POPUPMODAL";
    public static final String POPUP = "POPUP";
    public static final String POPUPMODAL = "POPUPMODAL";
    public static final String POPUPAPP = "POPUPAPP";
    public static final String DRAWER_LEFT = "DRAWER_LEFT";
    public static final String DRAWER_RIGHT = "DRAWER_RIGHT";
    public static final String DRAWER_TOP = "DRAWER_TOP";
    public static final String DRAWER_BOTTOM = "DRAWER_BOTTOM";
    public static final String POPOVER = "POPOVER";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DEViewOpenModeCodeListModel() {
        this.initAnnotation(DEViewOpenModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("OpenViewMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewOpenModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewOpenModeCodeListModel");
    }
}


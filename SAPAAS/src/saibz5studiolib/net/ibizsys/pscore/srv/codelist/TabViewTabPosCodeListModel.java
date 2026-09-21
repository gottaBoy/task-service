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

@CodeList(id="58E20CC6-422B-4ED9-BF65-7F8C1E463BAB", name="\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOP", text="\u4e0a\u65b9\uff08\u9ed8\u8ba4\uff09", realtext="\u4e0a\u65b9\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="TOP_EMBEDDED", text="\u4e0a\u65b9\uff08\u5d4c\u5165\uff09", realtext="\u4e0a\u65b9\uff08\u5d4c\u5165\uff09"), @CodeItem(value="TOP_DROPDOWNLIST", text="\u4e0a\u65b9\uff08\u4e0b\u62c9\u5217\u8868\uff09", realtext="\u4e0a\u65b9\uff08\u4e0b\u62c9\u5217\u8868\uff09"), @CodeItem(value="LEFT", text="\u5de6\u4fa7", realtext="\u5de6\u4fa7"), @CodeItem(value="BOTTOM", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9"), @CodeItem(value="RIGHT", text="\u53f3\u4fa7", realtext="\u53f3\u4fa7"), @CodeItem(value="FLOW", text="\u6d41\u5e03\u5c40", realtext="\u6d41\u5e03\u5c40"), @CodeItem(value="FLOW_NOHEADER", text="\u6d41\u5e03\u5c40\uff08\u65e0\u6807\u9898\uff09", realtext="\u6d41\u5e03\u5c40\uff08\u65e0\u6807\u9898\uff09"), @CodeItem(value="NOHAEDER", text="\u65e0\u5206\u9875\u680f", realtext="\u65e0\u5206\u9875\u680f"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class TabViewTabPosCodeListModel
extends StaticCodeListModelBase {
    public static final String TOP = "TOP";
    public static final String TOP_EMBEDDED = "TOP_EMBEDDED";
    public static final String TOP_DROPDOWNLIST = "TOP_DROPDOWNLIST";
    public static final String LEFT = "LEFT";
    public static final String BOTTOM = "BOTTOM";
    public static final String RIGHT = "RIGHT";
    public static final String FLOW = "FLOW";
    public static final String FLOW_NOHEADER = "FLOW_NOHEADER";
    public static final String NOHAEDER = "NOHAEDER";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public TabViewTabPosCodeListModel() {
        this.initAnnotation(TabViewTabPosCodeListModel.class);
        this.setUserData2("TabPanelLayout");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
    }
}


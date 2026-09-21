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

@CodeList(id="839471f3de67d0d76d449c77f7e4934b", name="\u56fe\u8868\u5750\u6807\u8f74\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="left", text="\u5de6\u4fa7", realtext="\u5de6\u4fa7"), @CodeItem(value="bottom", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9"), @CodeItem(value="right", text="\u53f3\u4fa7", realtext="\u53f3\u4fa7"), @CodeItem(value="top", text="\u4e0a\u65b9", realtext="\u4e0a\u65b9"), @CodeItem(value="radial", text="\u5f84\u5411\u8f74(Radial)", realtext="\u5f84\u5411\u8f74(Radial)"), @CodeItem(value="angular", text="\u89d2\u5ea6\u8f74(Angular)", realtext="\u89d2\u5ea6\u8f74(Angular)")})
public class ChartAxesPosCodeListModel
extends StaticCodeListModelBase {
    public static final String LEFT = "left";
    public static final String BOTTOM = "bottom";
    public static final String RIGHT = "right";
    public static final String TOP = "top";
    public static final String RADIAL = "radial";
    public static final String ANGULAR = "angular";

    public ChartAxesPosCodeListModel() {
        this.initAnnotation(ChartAxesPosCodeListModel.class);
        this.setUserData2("ChartAxisPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartAxesPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartAxesPosCodeListModel");
    }
}


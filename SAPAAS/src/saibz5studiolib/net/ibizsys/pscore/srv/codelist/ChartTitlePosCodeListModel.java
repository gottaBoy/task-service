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

@CodeList(id="8ccee656ed03684b0dbd6c5328ec30ff", name="\u56fe\u8868\u6807\u9898\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOP", text="\u4e0a", realtext="\u4e0a"), @CodeItem(value="BOTTOM", text="\u4e0b", realtext="\u4e0b"), @CodeItem(value="LEFT", text="\u5de6", realtext="\u5de6"), @CodeItem(value="RIGHT", text="\u53f3", realtext="\u53f3")})
public class ChartTitlePosCodeListModel
extends StaticCodeListModelBase {
    public static final String TOP = "TOP";
    public static final String BOTTOM = "BOTTOM";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";

    public ChartTitlePosCodeListModel() {
        this.initAnnotation(ChartTitlePosCodeListModel.class);
        this.setUserData2("ChartTitlePos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartTitlePosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartTitlePosCodeListModel");
    }
}


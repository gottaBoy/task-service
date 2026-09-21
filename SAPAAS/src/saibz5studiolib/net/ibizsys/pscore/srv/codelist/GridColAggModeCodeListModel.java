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

@CodeList(id="CA5DEFAA-A2C3-4A90-BE20-76D527951340", name="\u8868\u683c\u5217\u805a\u5408\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u805a\u5408", realtext="\u65e0\u805a\u5408"), @CodeItem(value="SUM", text="\u5408\u8ba1", realtext="\u5408\u8ba1", userdata="\u5408\u8ba1\u5217\u503c"), @CodeItem(value="AVG", text="\u5e73\u5747", realtext="\u5e73\u5747", userdata="\u8bc4\u4ef7\u5217\u503c"), @CodeItem(value="MAX", text="\u6700\u5927\u503c", realtext="\u6700\u5927\u503c", userdata="\u6700\u5927\u5217\u503c"), @CodeItem(value="MIN", text="\u6700\u5c0f\u503c", realtext="\u6700\u5c0f\u503c", userdata="\u6700\u5c0f\u5217\u503c"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class GridColAggModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String SUM = "SUM";
    public static final String AVG = "AVG";
    public static final String MAX = "MAX";
    public static final String MIN = "MIN";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public GridColAggModeCodeListModel() {
        this.initAnnotation(GridColAggModeCodeListModel.class);
        this.setUserData2("GridColAggMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GridColAggModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GridColAggModeCodeListModel");
    }
}


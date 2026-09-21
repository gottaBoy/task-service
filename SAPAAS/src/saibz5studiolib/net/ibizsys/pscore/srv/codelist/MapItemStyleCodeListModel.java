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

@CodeList(id="d9bab994a98e2d6cb71af4175609ac24", name="\u5730\u56fe\u9879\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="POINT", text="\u70b9", realtext="\u70b9"), @CodeItem(value="POINT2", text="\u70b92", realtext="\u70b92"), @CodeItem(value="POINT3", text="\u70b93", realtext="\u70b93"), @CodeItem(value="POINT4", text="\u70b94", realtext="\u70b94"), @CodeItem(value="LINE", text="\u8fde\u7ebf", realtext="\u8fde\u7ebf"), @CodeItem(value="LINE2", text="\u8fde\u7ebf2", realtext="\u8fde\u7ebf2"), @CodeItem(value="LINE3", text="\u8fde\u7ebf3", realtext="\u8fde\u7ebf3"), @CodeItem(value="LINE4", text="\u8fde\u7ebf4", realtext="\u8fde\u7ebf4"), @CodeItem(value="REGION", text="\u533a\u57df", realtext="\u533a\u57df"), @CodeItem(value="REGION2", text="\u533a\u57df2", realtext="\u533a\u57df2"), @CodeItem(value="REGION3", text="\u533a\u57df3", realtext="\u533a\u57df3"), @CodeItem(value="REGION4", text="\u533a\u57df4", realtext="\u533a\u57df4"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class MapItemStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String POINT = "POINT";
    public static final String POINT2 = "POINT2";
    public static final String POINT3 = "POINT3";
    public static final String POINT4 = "POINT4";
    public static final String LINE = "LINE";
    public static final String LINE2 = "LINE2";
    public static final String LINE3 = "LINE3";
    public static final String LINE4 = "LINE4";
    public static final String REGION = "REGION";
    public static final String REGION2 = "REGION2";
    public static final String REGION3 = "REGION3";
    public static final String REGION4 = "REGION4";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public MapItemStyleCodeListModel() {
        this.initAnnotation(MapItemStyleCodeListModel.class);
        this.setUserData2("MapItemStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MapItemStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MapItemStyleCodeListModel");
    }
}


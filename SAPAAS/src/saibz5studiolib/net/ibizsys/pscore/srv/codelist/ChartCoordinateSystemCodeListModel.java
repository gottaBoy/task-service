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

@CodeList(id="b03c076aea389227e7fd0108f84674e7", name="\u5b9e\u4f53\u56fe\u8868\u5750\u6807\u7cfb\u7edf", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="XY", text="\u76f4\u89d2\u5750\u6807\u7cfb", realtext="\u76f4\u89d2\u5750\u6807\u7cfb"), @CodeItem(value="POLAR", text="\u6781\u5750\u6807\u7cfb", realtext="\u6781\u5750\u6807\u7cfb"), @CodeItem(value="RADAR", text="\u96f7\u8fbe\u5750\u6807\u7cfb", realtext="\u96f7\u8fbe\u5750\u6807\u7cfb"), @CodeItem(value="PARALLEL", text="\u5e73\u884c\u5750\u6807\u7cfb", realtext="\u5e73\u884c\u5750\u6807\u7cfb"), @CodeItem(value="SINGLE", text="\u5355\u8f74\u5750\u6807\u7cfb", realtext="\u5355\u8f74\u5750\u6807\u7cfb"), @CodeItem(value="CALENDAR", text="\u65e5\u5386\u5750\u6807\u7cfb", realtext="\u65e5\u5386\u5750\u6807\u7cfb"), @CodeItem(value="MAP", text="\u5730\u56fe\u5750\u6807\u7cfb", realtext="\u5730\u56fe\u5750\u6807\u7cfb"), @CodeItem(value="NONE", text="\u65e0\u5750\u6807\u7cfb", realtext="\u65e0\u5750\u6807\u7cfb")})
public class ChartCoordinateSystemCodeListModel
extends StaticCodeListModelBase {
    public static final String XY = "XY";
    public static final String POLAR = "POLAR";
    public static final String RADAR = "RADAR";
    public static final String PARALLEL = "PARALLEL";
    public static final String SINGLE = "SINGLE";
    public static final String CALENDAR = "CALENDAR";
    public static final String MAP = "MAP";
    public static final String NONE = "NONE";

    public ChartCoordinateSystemCodeListModel() {
        this.initAnnotation(ChartCoordinateSystemCodeListModel.class);
        this.setUserData2("ChartCoordinateSystem");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartCoordinateSystemCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartCoordinateSystemCodeListModel");
    }
}


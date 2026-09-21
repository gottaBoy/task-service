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

@CodeList(id="ccd15d6ef1d70dae47ea27d323a72d44", name="\u56fe\u8868\u5750\u6807\u7cfb\u7edf\u7d22\u5f15", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="-1", text="\u81ea\u52a8", realtext="\u81ea\u52a8"), @CodeItem(value="0", text="0", realtext="0"), @CodeItem(value="1", text="1", realtext="1"), @CodeItem(value="2", text="2", realtext="2"), @CodeItem(value="3", text="3", realtext="3"), @CodeItem(value="4", text="4", realtext="4"), @CodeItem(value="5", text="5", realtext="5"), @CodeItem(value="6", text="6", realtext="6"), @CodeItem(value="7", text="7", realtext="7")})
public class ChartCSIndexCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = -1;
    public static final int INT_NONE = -1;
    public static final Integer INDEX_0 = 0;
    public static final int INT_INDEX_0 = 0;
    public static final Integer INDEX_1 = 1;
    public static final int INT_INDEX_1 = 1;
    public static final Integer INDEX_2 = 2;
    public static final int INT_INDEX_2 = 2;
    public static final Integer INDEX_3 = 3;
    public static final int INT_INDEX_3 = 3;
    public static final Integer INDEX_4 = 4;
    public static final int INT_INDEX_4 = 4;
    public static final Integer INDEX_5 = 5;
    public static final int INT_INDEX_5 = 5;
    public static final Integer INDEX_6 = 6;
    public static final int INT_INDEX_6 = 6;
    public static final Integer INDEX_7 = 7;
    public static final int INT_INDEX_7 = 7;

    public ChartCSIndexCodeListModel() {
        this.initAnnotation(ChartCSIndexCodeListModel.class);
        this.setUserData("RESERVEMODELV2");
        this.setUserData2("ChartCSIndex");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartCSIndexCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartCSIndexCodeListModel");
    }
}


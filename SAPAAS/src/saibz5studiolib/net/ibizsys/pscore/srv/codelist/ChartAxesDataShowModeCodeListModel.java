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

@CodeList(id="97dfdc6a251bedcddce7bfbadfaca8a9", name="\u56fe\u8868\u5750\u6807\u8f74\u6570\u636e\u663e\u793a\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u5b9a\u4e49", realtext="\u672a\u5b9a\u4e49"), @CodeItem(value="1", text="\u7eb5", realtext="\u7eb5"), @CodeItem(value="2", text="\u6a2a", realtext="\u6a2a"), @CodeItem(value="3", text="\u659c", realtext="\u659c")})
public class ChartAxesDataShowModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer UNDEFINED = 0;
    public static final int INT_UNDEFINED = 0;
    public static final Integer LONGITUDINAL = 1;
    public static final int INT_LONGITUDINAL = 1;
    public static final Integer HORIZONTAL = 2;
    public static final int INT_HORIZONTAL = 2;
    public static final Integer OBLIQUE = 3;
    public static final int INT_OBLIQUE = 3;

    public ChartAxesDataShowModeCodeListModel() {
        this.initAnnotation(ChartAxesDataShowModeCodeListModel.class);
        this.setUserData2("ChartAxisDataShowMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartAxesDataShowModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartAxesDataShowModeCodeListModel");
    }
}


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

@CodeList(id="FF191E4E-ED05-4D3F-A88B-E79E4EF20B8B", name="\u8868\u683c\u90e8\u4ef6\u5373\u65f6\u7f16\u8f91\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u884c\u7f16\u8f91", realtext="\u884c\u7f16\u8f91"), @CodeItem(value="128", text="\u65e0\u65b0\u5efa", realtext="\u65e0\u65b0\u5efa"), @CodeItem(value="256", text="\u6b21\u5e8f\u8c03\u6574", realtext="\u6b21\u5e8f\u8c03\u6574"), @CodeItem(value="2048", text="\u63d0\u4ea4\u53d8\u5316", realtext="\u63d0\u4ea4\u53d8\u5316", userdata="\u4ec5\u63d0\u4ea4\u53d8\u5316\u503c")})
public class GridEditModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ROW = 1;
    public static final int INT_ROW = 1;
    public static final Integer NOTCREATE = 128;
    public static final int INT_NOTCREATE = 128;
    public static final Integer ORDER = 256;
    public static final int INT_ORDER = 256;
    public static final Integer CHANGEDONLY = 2048;
    public static final int INT_CHANGEDONLY = 2048;

    public GridEditModeCodeListModel() {
        this.initAnnotation(GridEditModeCodeListModel.class);
        this.setUserData2("GridEditMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GridEditModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GridEditModeCodeListModel");
    }
}


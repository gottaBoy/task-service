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

@CodeList(id="8f5768704c2e2b68963760f3f8cad574", name="\u5e94\u7528\u8868\u683c\u6570\u636e\u6fc0\u6d3b\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u5355\u51fb", realtext="\u5355\u51fb"), @CodeItem(value="2", text="\u53cc\u51fb", realtext="\u53cc\u51fb")})
public class GridRowActiveModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SINGLECLICK = 1;
    public static final int INT_SINGLECLICK = 1;
    public static final Integer DOUBLECLICK = 2;
    public static final int INT_DOUBLECLICK = 2;

    public GridRowActiveModeCodeListModel() {
        this.initAnnotation(GridRowActiveModeCodeListModel.class);
        this.setUserData2("GridRowActiveMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GridRowActiveModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GridRowActiveModeCodeListModel");
    }
}


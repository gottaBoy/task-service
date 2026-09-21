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

@CodeList(id="474515B5-253D-4107-9AFD-0B6C8F5D8348", name="\u8868\u683c\u89c6\u56fe\u6570\u636e\u6fc0\u6d3b\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0", userdata="\u65e0\u5185\u90e8\u6fc0\u6d3b\u65b9\u5f0f"), @CodeItem(value="2", text="\u5355\u51fb", realtext="\u5355\u51fb"), @CodeItem(value="1", text="\u53cc\u51fb", realtext="\u53cc\u51fb")})
public class GridViewRowActiveModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SINGLECLICK = 2;
    public static final int INT_SINGLECLICK = 2;
    public static final Integer DOUBLECLICK = 1;
    public static final int INT_DOUBLECLICK = 1;

    public GridViewRowActiveModeCodeListModel() {
        this.initAnnotation(GridViewRowActiveModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
    }
}


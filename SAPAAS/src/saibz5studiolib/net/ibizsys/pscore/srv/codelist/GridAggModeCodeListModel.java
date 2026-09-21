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

@CodeList(id="97b542c40c1b09a7ff6205b382edd03b", name="\u8868\u683c\u805a\u5408\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u805a\u5408", realtext="\u65e0\u805a\u5408"), @CodeItem(value="PAGE", text="\u5f53\u524d\u9875\u672c\u5730", realtext="\u5f53\u524d\u9875\u672c\u5730", userdata="\u4ec5\u805a\u5408\u5f53\u524d\u5206\u9875\u663e\u793a\u6570\u636e\uff0c\u672c\u5730\u5904\u7406"), @CodeItem(value="ALL", text="\u5168\u90e8\u8fdc\u7a0b", realtext="\u5168\u90e8\u8fdc\u7a0b", userdata="\u805a\u5408\u7b26\u5408\u6761\u4ef6\u7684\u5168\u90e8\u6570\u636e\uff0c\u8fdc\u7aef\u5904\u7406")})
public class GridAggModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String PAGE = "PAGE";
    public static final String ALL = "ALL";

    public GridAggModeCodeListModel() {
        this.initAnnotation(GridAggModeCodeListModel.class);
        this.setUserData2("GridAggMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.GridAggModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.GridAggModeCodeListModel");
    }
}


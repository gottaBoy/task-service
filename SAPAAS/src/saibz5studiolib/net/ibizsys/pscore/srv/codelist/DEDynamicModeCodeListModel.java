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

@CodeList(id="8cb4fa972305f55365002221ea0b1a60", name="\u4e91\u5b9e\u4f53\u52a8\u6001\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u975e\u52a8\u6001\u5b9e\u4f53", realtext="\u975e\u52a8\u6001\u5b9e\u4f53"), @CodeItem(value="1", text="\u52a8\u6001\u5b9e\u4f53", realtext="\u52a8\u6001\u5b9e\u4f53"), @CodeItem(value="2", text="\u6269\u5c55\u5b9e\u4f53", realtext="\u6269\u5c55\u5b9e\u4f53")})
public class DEDynamicModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer STATIC = 0;
    public static final int INT_STATIC = 0;
    public static final Integer DYNAMIC = 1;
    public static final int INT_DYNAMIC = 1;
    public static final Integer EXTEND = 2;
    public static final int INT_EXTEND = 2;

    public DEDynamicModeCodeListModel() {
        this.initAnnotation(DEDynamicModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDynamicModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDynamicModeCodeListModel");
    }
}


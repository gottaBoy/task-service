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

@CodeList(id="40CD2D78-B5F9-4600-80B3-85DA549AE9AB", name="\u4e91\u5b9e\u4f53\u52a8\u6001\u6a21\u5f0f\uff08\u81ea\u52a8\u53ca\u5168\u52a8\u6001\uff09", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="3", text="\u81ea\u52a8\u5224\u65ad", realtext="\u81ea\u52a8\u5224\u65ad"), @CodeItem(value="1", text="\u5168\u52a8\u6001", realtext="\u5168\u52a8\u6001")})
public class DEDynamicMode2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer AUTO = 3;
    public static final int INT_AUTO = 3;
    public static final Integer DYNAMIC = 1;
    public static final int INT_DYNAMIC = 1;

    public DEDynamicMode2CodeListModel() {
        this.initAnnotation(DEDynamicMode2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDynamicMode2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDynamicMode2CodeListModel");
    }
}


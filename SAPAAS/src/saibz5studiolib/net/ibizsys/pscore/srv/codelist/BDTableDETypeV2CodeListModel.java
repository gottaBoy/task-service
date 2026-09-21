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

@CodeList(id="A3C6F175-70F1-4112-B2D3-FEB83B41F265", name="\u5927\u6570\u636e\u8868\u5b9e\u4f53\u7c7b\u578b\uff08V2\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u9ed8\u8ba4\u5b9e\u4f53", realtext="\u9ed8\u8ba4\u5b9e\u4f53"), @CodeItem(value="0", text="\u9644\u5c5e\u5b9e\u4f53", realtext="\u9644\u5c5e\u5b9e\u4f53")})
public class BDTableDETypeV2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer DEFAULT = 1;
    public static final int INT_DEFAULT = 1;
    public static final Integer RELATED = 0;
    public static final int INT_RELATED = 0;

    public BDTableDETypeV2CodeListModel() {
        this.initAnnotation(BDTableDETypeV2CodeListModel.class);
        this.setUserData2("DEBDTableType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableDETypeV2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableDETypeV2CodeListModel");
    }
}


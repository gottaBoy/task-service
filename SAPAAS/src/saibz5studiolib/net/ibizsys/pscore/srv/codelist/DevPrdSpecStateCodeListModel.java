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

@CodeList(id="1a4604f6d405a7a3fe7307bd2bff2a6b", name="\u4ea7\u54c1\u89c4\u8303\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u8349\u7a3f", realtext="\u8349\u7a3f"), @CodeItem(value="20", text="\u5df2\u786e\u8ba4", realtext="\u5df2\u786e\u8ba4"), @CodeItem(value="30", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88")})
public class DevPrdSpecStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DRAFT = 10;
    public static final int INT_DRAFT = 10;
    public static final Integer PUBLISH = 20;
    public static final int INT_PUBLISH = 20;
    public static final Integer CANCEL = 30;
    public static final int INT_CANCEL = 30;

    public DevPrdSpecStateCodeListModel() {
        this.initAnnotation(DevPrdSpecStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSpecStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSpecStateCodeListModel");
    }
}


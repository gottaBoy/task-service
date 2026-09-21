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

@CodeList(id="0d9571481e6f51364a8ed37c27300fae", name="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f\uff08\u652f\u6301\u526f\u672c\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528"), @CodeItem(value="2", text="\u542f\u7528\u526f\u672c", realtext="\u542f\u7528\u526f\u672c")})
public class DynaInstMode3CodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_0 = 0;
    public static final int INT_ITEM_0 = 0;
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;

    public DynaInstMode3CodeListModel() {
        this.initAnnotation(DynaInstMode3CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaInstMode3CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaInstMode3CodeListModel");
    }
}


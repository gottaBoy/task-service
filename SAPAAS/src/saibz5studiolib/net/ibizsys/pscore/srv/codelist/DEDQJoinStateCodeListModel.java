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

@CodeList(id="768587eec9ac5e0af39fede5f8d5617d", name="\u5b9e\u4f53\u67e5\u8be2\u8fde\u63a5\u6a21\u578b\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u6709\u8b66\u544a", realtext="\u6709\u8b66\u544a"), @CodeItem(value="2", text="\u6709\u9519\u8bef", realtext="\u6709\u9519\u8bef"), @CodeItem(value="1024", text="\u6709\u6761\u4ef6", realtext="\u6709\u6761\u4ef6")})
public class DEDQJoinStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer WARNING = 1;
    public static final int INT_WARNING = 1;
    public static final Integer ERROR = 2;
    public static final int INT_ERROR = 2;
    public static final Integer HASCOND = 1024;
    public static final int INT_HASCOND = 1024;

    public DEDQJoinStateCodeListModel() {
        this.initAnnotation(DEDQJoinStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDQJoinStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDQJoinStateCodeListModel");
    }
}


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

@CodeList(id="C2839292-C934-43BF-BDE3-8AC0CC360DB4", name="\u5b9e\u4f53\u4e3b\u72b6\u6001\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="1", text="\u5b9e\u4f53\u9ed8\u8ba4", realtext="\u5b9e\u4f53\u9ed8\u8ba4"), @CodeItem(value="2", text="\u9501\u5b9a\u63a7\u5236", realtext="\u9501\u5b9a\u63a7\u5236"), @CodeItem(value="3", text="\u5173\u95ed\u63a7\u5236", realtext="\u5173\u95ed\u63a7\u5236")})
public class DEMainStateTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NORMAL = 0;
    public static final int INT_NORMAL = 0;
    public static final Integer DEFAULT = 1;
    public static final int INT_DEFAULT = 1;
    public static final Integer LOCK = 2;
    public static final int INT_LOCK = 2;
    public static final Integer CLOSE = 3;
    public static final int INT_CLOSE = 3;

    public DEMainStateTypeCodeListModel() {
        this.initAnnotation(DEMainStateTypeCodeListModel.class);
        this.setUserData2("DEMainStateType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMainStateTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMainStateTypeCodeListModel");
    }
}


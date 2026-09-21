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

@CodeList(id="DC6B9C08-EDD1-41A2-ACD1-355B0E703FF0", name="\u5b9e\u4f53\u754c\u9762\u64cd\u4f5c\u884c\u4e3a", type="STATIC", userscope=false, emptytext="\uff08\u5168\u90e8\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5efa\u7acb", realtext="\u5efa\u7acb"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="4", text="\u5220\u9664", realtext="\u5220\u9664")})
public class DEUserUIAbility2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer REMOVE = 4;
    public static final int INT_REMOVE = 4;

    public DEUserUIAbility2CodeListModel() {
        this.initAnnotation(DEUserUIAbility2CodeListModel.class);
        this.setUserData2("DEActionAbility");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUserUIAbility2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUserUIAbility2CodeListModel");
    }
}


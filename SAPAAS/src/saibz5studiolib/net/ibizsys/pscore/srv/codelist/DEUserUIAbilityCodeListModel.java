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

@CodeList(id="f412322fed1a2423cdefd01dbd353f1f", name="\u5b9e\u4f53\u7528\u6237\u754c\u9762\u884c\u4e3a\uff08\u5173\u95ed\u80fd\u529b\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u65e0\u5efa\u7acb", realtext="\u65e0\u5efa\u7acb"), @CodeItem(value="2", text="\u65e0\u66f4\u65b0", realtext="\u65e0\u66f4\u65b0"), @CodeItem(value="4", text="\u65e0\u5220\u9664", realtext="\u65e0\u5220\u9664")})
public class DEUserUIAbilityCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOCREATE = 1;
    public static final int INT_NOCREATE = 1;
    public static final Integer NOUPDATE = 2;
    public static final int INT_NOUPDATE = 2;
    public static final Integer NOREMOVE = 4;
    public static final int INT_NOREMOVE = 4;

    public DEUserUIAbilityCodeListModel() {
        this.initAnnotation(DEUserUIAbilityCodeListModel.class);
        this.setUserData2("DEUserUIAbility");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUserUIAbilityCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUserUIAbilityCodeListModel");
    }
}


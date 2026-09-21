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

@CodeList(id="b4adc9b2ca561295bda16ef0664cd56c", name="\u5c5e\u6027\u53ea\u8bfb\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u65e0\u5efa\u7acb", realtext="\u65e0\u5efa\u7acb"), @CodeItem(value="2", text="\u65e0\u66f4\u65b0", realtext="\u65e0\u66f4\u65b0")})
public class DEFReadOnlyModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOCREATE = 1;
    public static final int INT_NOCREATE = 1;
    public static final Integer NOUPDATE = 2;
    public static final int INT_NOUPDATE = 2;

    public DEFReadOnlyModeCodeListModel() {
        this.initAnnotation(DEFReadOnlyModeCodeListModel.class);
        this.setUserData2("DEFReadOnlyMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFReadOnlyModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFReadOnlyModeCodeListModel");
    }
}


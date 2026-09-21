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

@CodeList(id="9A8CFEE7-4CF3-4CF3-A9F0-08029612588D", name="\u662f\u5426\uff08\u84dd\u3001\u7ea2\uff09\uff08\u6570\u636e\u5e93\u8bbe\u7f6e\uff09", type="STATIC", userscope=false, emptytext="\uff08\u6570\u636e\u5e93\u8bbe\u7f6e\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u662f", realtext="\u662f"), @CodeItem(value="0", text="\u5426", realtext="\u5426")})
public class YesNoColor10CodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_0 = "0";

    public YesNoColor10CodeListModel() {
        this.initAnnotation(YesNoColor10CodeListModel.class);
        this.setUserData("RESERVEMODELV2");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.YesNoColor10CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.YesNoColor10CodeListModel");
    }
}


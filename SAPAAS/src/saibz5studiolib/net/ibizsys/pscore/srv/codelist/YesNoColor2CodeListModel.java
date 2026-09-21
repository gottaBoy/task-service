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

@CodeList(id="B2139CF5-6BDE-41B9-82D2-3AD34FD89DC5", name="\u662f\u5426\uff08\u7ea2\uff0c\u84dd\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u662f", realtext="\u662f"), @CodeItem(value="0", text="\u5426", realtext="\u5426")})
public class YesNoColor2CodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_0 = "0";

    public YesNoColor2CodeListModel() {
        this.initAnnotation(YesNoColor2CodeListModel.class);
        this.setUserData("RESERVEMODELV2");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.YesNoColor2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.YesNoColor2CodeListModel");
    }
}


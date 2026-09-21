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

@CodeList(id="a5ff2297352d87ded41f3227f533c031", name="\u5b9e\u4f53\u5c5e\u6027\u67e5\u8be2\u6269\u5c55\u9009\u9879", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="LIKE", text="LIKE\u5927\u5c0f\u5199\u654f\u611f", realtext="LIKE\u5927\u5c0f\u5199\u654f\u611f"), @CodeItem(value="=", text="=\uff08\u542b\u5176\u5b83\uff09\u5927\u5c0f\u5199\u654f\u611f", realtext="=\uff08\u542b\u5176\u5b83\uff09\u5927\u5c0f\u5199\u654f\u611f"), @CodeItem(value="LIKESPLIT", text="LIKE\u5206\u89e3", realtext="LIKE\u5206\u89e3")})
public class DEFQueryCSModeCodeListModel
extends StaticCodeListModelBase {
    public static final String LIKE = "LIKE";
    public static final String EQ = "=";
    public static final String LIKESPLIT = "LIKESPLIT";

    public DEFQueryCSModeCodeListModel() {
        this.initAnnotation(DEFQueryCSModeCodeListModel.class);
        this.setUserData2("DEFQueryCSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFQueryCSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFQueryCSModeCodeListModel");
    }
}


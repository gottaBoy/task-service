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

@CodeList(id="8cd77c2d66d556b6193305a6df388681", name="\u66f4\u65b0\u65e7\u503c\u56de\u586b\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ALWAYS", text="\u59cb\u7ec8\u56de\u586b", realtext="\u59cb\u7ec8\u56de\u586b"), @CodeItem(value="NOTEXISTS", text="\u65e0\u503c\u65f6\u56de\u586b", realtext="\u65e0\u503c\u65f6\u56de\u586b")})
public class OldValueUpdateModeCodeListModel
extends StaticCodeListModelBase {
    public static final String ALWAYS = "ALWAYS";
    public static final String NOTEXISTS = "NOTEXISTS";

    public OldValueUpdateModeCodeListModel() {
        this.initAnnotation(OldValueUpdateModeCodeListModel.class);
        this.setUserData2("OldValueUpdateMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.OldValueUpdateModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.OldValueUpdateModeCodeListModel");
    }
}


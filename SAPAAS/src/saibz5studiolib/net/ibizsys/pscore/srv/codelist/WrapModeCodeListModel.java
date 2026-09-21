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

@CodeList(id="4F65E475-C1F3-45DA-A022-63FD596613C2", name="\u6587\u672c\u6362\u884c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WRAP", text="\u6362\u884c", realtext="\u6362\u884c"), @CodeItem(value="NOWRAP", text="\u4e0d\u6362\u884c", realtext="\u4e0d\u6362\u884c")})
public class WrapModeCodeListModel
extends StaticCodeListModelBase {
    public static final String WRAP = "WRAP";
    public static final String NOWRAP = "NOWRAP";

    public WrapModeCodeListModel() {
        this.initAnnotation(WrapModeCodeListModel.class);
        this.setUserData2("WrapMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WrapModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WrapModeCodeListModel");
    }
}


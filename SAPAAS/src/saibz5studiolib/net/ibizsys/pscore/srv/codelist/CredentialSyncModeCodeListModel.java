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

@CodeList(id="5A01D695-9D16-4676-BE81-9F258E248FDE", name="\u51ed\u8bc1\u540c\u6b65\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u540c\u6b65", realtext="\u4e0d\u540c\u6b65"), @CodeItem(value="1", text="\u540c\u6b65", realtext="\u540c\u6b65"), @CodeItem(value="2", text="\u4ec5\u65b0\u5efa", realtext="\u4ec5\u65b0\u5efa")})
public class CredentialSyncModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOT = 0;
    public static final int INT_NOT = 0;
    public static final Integer ALWAYS = 1;
    public static final int INT_ALWAYS = 1;
    public static final Integer CREATEONLY = 2;
    public static final int INT_CREATEONLY = 2;

    public CredentialSyncModeCodeListModel() {
        this.initAnnotation(CredentialSyncModeCodeListModel.class);
        this.setUserData2("CredentialSyncMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CredentialSyncModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CredentialSyncModeCodeListModel");
    }
}


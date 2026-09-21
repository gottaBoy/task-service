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

@CodeList(id="dcc05a2b34752363dcf2337b87a18d47", name="\u7cfb\u7edf\u5de5\u7a0b\u9879\u76ee\u76f8\u5173\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSSYSSFPUB", text="\u540e\u53f0\u670d\u52a1", realtext="\u540e\u53f0\u670d\u52a1", iconpath="default/pssysproject/icon_psobjtype_pssyssfpub.png", iconpathx="default/pssysproject/icon_psobjtype_pssyssfpub@{0}x.png"), @CodeItem(value="PSSYSAPP", text="\u524d\u7aef\u5e94\u7528", realtext="\u524d\u7aef\u5e94\u7528", iconpath="default/pssysproject/icon_psobjtype_pssysapp.png", iconpathx="default/pssysproject/icon_psobjtype_pssysapp@{0}x.png")})
public class SysProjectOwnerTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSSYSSFPUB = "PSSYSSFPUB";
    public static final String PSSYSAPP = "PSSYSAPP";

    public SysProjectOwnerTypeCodeListModel() {
        this.initAnnotation(SysProjectOwnerTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysProjectOwnerTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysProjectOwnerTypeCodeListModel");
    }
}


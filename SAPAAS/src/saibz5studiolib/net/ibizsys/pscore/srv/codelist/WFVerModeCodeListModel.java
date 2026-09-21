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

@CodeList(id="96641d191fb2409c56db26e1b8ce23a7", name="\u6d41\u7a0b\u7248\u672c\u5e94\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="PART", text="\u6d41\u7a0b\u7247\u6bb5", realtext="\u6d41\u7a0b\u7247\u6bb5")})
public class WFVerModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String PART = "PART";

    public WFVerModeCodeListModel() {
        this.initAnnotation(WFVerModeCodeListModel.class);
        this.setUserData2("WFVerMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFVerModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFVerModeCodeListModel");
    }
}


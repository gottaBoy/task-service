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

@CodeList(id="0aea833b565bfed16c5f6003be8a9dba", name="\u524d\u7aef\u5e94\u7528\u6837\u5f0f\u516c\u5f00\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5b8c\u5168\u516c\u5f00", realtext="\u5b8c\u5168\u516c\u5f00"), @CodeItem(value="2", text="\u9009\u62e9\u516c\u5f00", realtext="\u9009\u62e9\u516c\u5f00")})
public class PSPFPubModesCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;

    public PSPFPubModesCodeListModel() {
        this.initAnnotation(PSPFPubModesCodeListModel.class);
        this.setUserData2("PublicMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSPFPubModesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSPFPubModesCodeListModel");
    }
}


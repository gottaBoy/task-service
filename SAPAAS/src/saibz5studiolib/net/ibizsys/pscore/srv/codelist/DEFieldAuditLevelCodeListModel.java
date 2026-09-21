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

@CodeList(id="DED22420-166F-439F-8767-ECB1C6BB2FE0", name="\u5b9e\u4f53\u5c5e\u6027\u5ba1\u8ba1\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u5ba1\u8ba1", realtext="\u4e0d\u5ba1\u8ba1"), @CodeItem(value="1", text="1\u7ea7", realtext="1\u7ea7"), @CodeItem(value="2", text="2\u7ea7\uff08\u5173\u952e\u6570\u636e\uff09", realtext="2\u7ea7\uff08\u5173\u952e\u6570\u636e\uff09", userdata="\u4e00\u822c\u6307\u5b9e\u4f53\u7684\u4e3b\u8981\u5c5e\u6027"), @CodeItem(value="3", text="3\u7ea7\uff08\u4e2a\u522b\u5b57\u6bb5\uff09", realtext="3\u7ea7\uff08\u4e2a\u522b\u5b57\u6bb5\uff09")})
public class DEFieldAuditLevelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer LEVEL1 = 1;
    public static final int INT_LEVEL1 = 1;
    public static final Integer LEVEL2 = 2;
    public static final int INT_LEVEL2 = 2;
    public static final Integer LEVEL3 = 3;
    public static final int INT_LEVEL3 = 3;

    public DEFieldAuditLevelCodeListModel() {
        this.initAnnotation(DEFieldAuditLevelCodeListModel.class);
        this.setUserData2("DEFieldAuditLevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFieldAuditLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFieldAuditLevelCodeListModel");
    }
}


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

@CodeList(id="85e125e4c9f8c9ffc863deb124893387", name="\u5b9e\u4f53\u63a5\u53e3\u884c\u4e3a\u5173\u7cfb\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u884c\u4e3a", realtext="\u65e0\u884c\u4e3a", userdata="\u4e0d\u63d0\u4f9b\u4efb\u4f55\u5b9e\u4f53\u884c\u4e3a\u65b9\u6cd5"), @CodeItem(value="1", text="\u7ee7\u627f\u884c\u4e3a", realtext="\u7ee7\u627f\u884c\u4e3a", userdata="\u7ee7\u627f\u5173\u7cfb\u4ece\u5b9e\u4f53\u63a5\u53e3\u7684\u884c\u4e3a\u65b9\u6cd5"), @CodeItem(value="2", text="\u6307\u5b9a\u884c\u4e3a", realtext="\u6307\u5b9a\u884c\u4e3a", userdata="\u91cd\u65b0\u6307\u5b9a\u4ece\u5b9e\u4f53\u63a5\u53e3\u7684\u884c\u4e3a\u65b9\u6cd5")})
public class DESAActionRSModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_0 = 0;
    public static final int INT_ITEM_0 = 0;
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;

    public DESAActionRSModeCodeListModel() {
        this.initAnnotation(DESAActionRSModeCodeListModel.class);
        this.setUserData2("SADEActionRSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESAActionRSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESAActionRSModeCodeListModel");
    }
}


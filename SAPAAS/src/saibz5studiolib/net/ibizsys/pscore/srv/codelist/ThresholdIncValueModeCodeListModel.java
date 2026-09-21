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

@CodeList(id="787b0ed0495a2caa9e97b3f7e1ced95f", name="\u9608\u503c\u7ec4\u5305\u542b\u503c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u5305\u542b", realtext="\u4e0d\u5305\u542b"), @CodeItem(value="1", text="\u5305\u542b", realtext="\u5305\u542b"), @CodeItem(value="2", text="\u9996\u9879\u5305\u542b", realtext="\u9996\u9879\u5305\u542b"), @CodeItem(value="3", text="\u5c3e\u9879\u5305\u542b", realtext="\u5c3e\u9879\u5305\u542b")})
public class ThresholdIncValueModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NO = 0;
    public static final int INT_NO = 0;
    public static final Integer YES = 1;
    public static final int INT_YES = 1;
    public static final Integer FIRST = 2;
    public static final int INT_FIRST = 2;
    public static final Integer LAST = 3;
    public static final int INT_LAST = 3;

    public ThresholdIncValueModeCodeListModel() {
        this.initAnnotation(ThresholdIncValueModeCodeListModel.class);
        this.setUserData2("ThresholdIncValueMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ThresholdIncValueModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ThresholdIncValueModeCodeListModel");
    }
}


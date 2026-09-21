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

@CodeList(id="15AC123A-981D-47DB-A393-4602A705EED2", name="\u5e94\u7528\u89c6\u56fe\u4f18\u5148\u6743", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="-1", text="\u672a\u5b9a\u4e49", realtext="\u672a\u5b9a\u4e49"), @CodeItem(value="10", text="\u4e00\u7ea7", realtext="\u4e00\u7ea7"), @CodeItem(value="20", text="\u4e8c\u7ea7", realtext="\u4e8c\u7ea7"), @CodeItem(value="30", text="\u4e09\u7ea7", realtext="\u4e09\u7ea7"), @CodeItem(value="40", text="\u56db\u7ea7", realtext="\u56db\u7ea7"), @CodeItem(value="50", text="\u4e94\u7ea7", realtext="\u4e94\u7ea7"), @CodeItem(value="60", text="\u516d\u7ea7", realtext="\u516d\u7ea7"), @CodeItem(value="70", text="\u4e03\u7ea7", realtext="\u4e03\u7ea7"), @CodeItem(value="80", text="\u516b\u7ea7", realtext="\u516b\u7ea7"), @CodeItem(value="90", text="\u4e5d\u7ea7", realtext="\u4e5d\u7ea7"), @CodeItem(value="100", text="\u5341\u7ea7", realtext="\u5341\u7ea7")})
public class AppViewPriorityCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DEFAULT = -1;
    public static final int INT_DEFAULT = -1;
    public static final Integer LEVEL_10 = 10;
    public static final int INT_LEVEL_10 = 10;
    public static final Integer LEVEL_20 = 20;
    public static final int INT_LEVEL_20 = 20;
    public static final Integer LEVEL_30 = 30;
    public static final int INT_LEVEL_30 = 30;
    public static final Integer LEVEL_40 = 40;
    public static final int INT_LEVEL_40 = 40;
    public static final Integer LEVEL_50 = 50;
    public static final int INT_LEVEL_50 = 50;
    public static final Integer LEVEL_60 = 60;
    public static final int INT_LEVEL_60 = 60;
    public static final Integer LEVEL_70 = 70;
    public static final int INT_LEVEL_70 = 70;
    public static final Integer LEVEL_80 = 80;
    public static final int INT_LEVEL_80 = 80;
    public static final Integer LEVEL_90 = 90;
    public static final int INT_LEVEL_90 = 90;
    public static final Integer LEVEL_100 = 100;
    public static final int INT_LEVEL_100 = 100;

    public AppViewPriorityCodeListModel() {
        this.initAnnotation(AppViewPriorityCodeListModel.class);
        this.setUserData2("AppViewPriority");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
    }
}


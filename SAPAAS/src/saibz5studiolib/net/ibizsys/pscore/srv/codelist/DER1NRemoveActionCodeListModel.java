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

@CodeList(id="a47242080e90d1c3e84584598fb7971f", name="\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u5bfc\u51fa\u7ea7\u522b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="-1", text="\u65e0\u5173\u7cfb", realtext="\u65e0\u5173\u7cfb"), @CodeItem(value="0", text="\u6709\u5173\u7cfb\uff0c\u65e0\u9ed8\u8ba4\u5904\u7406", realtext="\u6709\u5173\u7cfb\uff0c\u65e0\u9ed8\u8ba4\u5904\u7406", userdata="\u5b58\u5728\u64cd\u4f5c\u5173\u7cfb\uff0c\u4f46\u65e0\u9700\u8fdb\u884c\u76f8\u5173\u7684\u5904\u7406\uff0c\u4e00\u822c\u4f1a\u7531\u5176\u5b83\u903b\u8f91\u5b8c\u6210\u76f8\u5e94\u7684\u5904\u7406"), @CodeItem(value="10", text="\u4e00\u7ea7", realtext="\u4e00\u7ea7"), @CodeItem(value="20", text="\u4e8c\u7ea7", realtext="\u4e8c\u7ea7"), @CodeItem(value="30", text="\u4e09\u7ea7", realtext="\u4e09\u7ea7"), @CodeItem(value="40", text="\u56db\u7ea7", realtext="\u56db\u7ea7"), @CodeItem(value="50", text="\u4e94\u7ea7", realtext="\u4e94\u7ea7"), @CodeItem(value="60", text="\u516d\u7ea7", realtext="\u516d\u7ea7"), @CodeItem(value="70", text="\u4e03\u7ea7", realtext="\u4e03\u7ea7"), @CodeItem(value="80", text="\u516b\u7ea7", realtext="\u516b\u7ea7"), @CodeItem(value="90", text="\u4e5d\u7ea7", realtext="\u4e5d\u7ea7"), @CodeItem(value="100", text="\u5341\u7ea7", realtext="\u5341\u7ea7")})
public class DER1NRemoveActionCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = -1;
    public static final int INT_NONE = -1;
    public static final Integer CUSTOM = 0;
    public static final int INT_CUSTOM = 0;
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

    public DER1NRemoveActionCodeListModel() {
        this.initAnnotation(DER1NRemoveActionCodeListModel.class);
        this.setUserData2("DERExportLevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
    }
}


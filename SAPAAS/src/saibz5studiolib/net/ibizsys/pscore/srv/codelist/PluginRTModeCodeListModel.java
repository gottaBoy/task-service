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

@CodeList(id="4d661e57201216edeee349ee33f56d5b", name="\u8fd0\u884c\u65f6\u63d2\u4ef6\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u975e\u8fd0\u884c\u65f6\u63d2\u4ef6", realtext="\u975e\u8fd0\u884c\u65f6\u63d2\u4ef6"), @CodeItem(value="1", text="\u672c\u5730\u8fd0\u884c\u65f6\u63d2\u4ef6", realtext="\u672c\u5730\u8fd0\u884c\u65f6\u63d2\u4ef6"), @CodeItem(value="2", text="\u8fdc\u7a0b\u8fd0\u884c\u65f6\u63d2\u4ef6", realtext="\u8fdc\u7a0b\u8fd0\u884c\u65f6\u63d2\u4ef6")})
public class PluginRTModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NO = 0;
    public static final int INT_NO = 0;
    public static final Integer LOCAL = 1;
    public static final int INT_LOCAL = 1;
    public static final Integer REMOTE = 2;
    public static final int INT_REMOTE = 2;

    public PluginRTModeCodeListModel() {
        this.initAnnotation(PluginRTModeCodeListModel.class);
        this.setUserData2("PluginRTMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PluginRTModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PluginRTModeCodeListModel");
    }
}


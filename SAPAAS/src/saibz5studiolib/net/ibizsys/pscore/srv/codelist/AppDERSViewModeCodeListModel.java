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

@CodeList(id="c8acf486c8d21294270b0d41d121c585", name="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u89c6\u56fe\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5b9e\u4f53\u5168\u90e8\uff08\u5ffd\u7565\u6307\u5b9a\uff09", realtext="\u5b9e\u4f53\u5168\u90e8\uff08\u5ffd\u7565\u6307\u5b9a\uff09"), @CodeItem(value="2", text="\u6307\u5b9a\u89c6\u56fe", realtext="\u6307\u5b9a\u89c6\u56fe")})
public class AppDERSViewModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer EXCLUDE = 1;
    public static final int INT_EXCLUDE = 1;
    public static final Integer INCLUDE = 2;
    public static final int INT_INCLUDE = 2;

    public AppDERSViewModeCodeListModel() {
        this.initAnnotation(AppDERSViewModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDERSViewModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDERSViewModeCodeListModel");
    }
}


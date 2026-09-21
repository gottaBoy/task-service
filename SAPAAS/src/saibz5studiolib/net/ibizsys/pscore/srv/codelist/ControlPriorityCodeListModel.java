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

@CodeList(id="51A8ACCF-10E5-4087-88CA-712BBB7E0D1D", name="\u90e8\u4ef6\u4f18\u5148\u6743", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="-1", text="\u672a\u5b9a\u4e49", realtext="\u672a\u5b9a\u4e49"), @CodeItem(value="10", text="\u5bb9\u5668\u90e8\u4ef6\uff08\u652f\u6301\u5408\u5165\uff09", realtext="\u5bb9\u5668\u90e8\u4ef6\uff08\u652f\u6301\u5408\u5165\uff09"), @CodeItem(value="100", text="\u63d2\u4ef6\u90e8\u4ef6\uff08\u7528\u4e8e\u5408\u5165\uff09", realtext="\u63d2\u4ef6\u90e8\u4ef6\uff08\u7528\u4e8e\u5408\u5165\uff09")})
public class ControlPriorityCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DEFAULT = -1;
    public static final int INT_DEFAULT = -1;
    public static final Integer LEVEL_10 = 10;
    public static final int INT_LEVEL_10 = 10;
    public static final Integer LEVEL_100 = 100;
    public static final int INT_LEVEL_100 = 100;

    public ControlPriorityCodeListModel() {
        this.initAnnotation(ControlPriorityCodeListModel.class);
        this.setUserData2("ControlPriority");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlPriorityCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlPriorityCodeListModel");
    }
}


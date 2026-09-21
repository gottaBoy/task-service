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

@CodeList(id="830fbf5fc9c376e49244d6e5f40d7fd6", name="\u89c6\u56fe\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INFO", text="\u5e38\u89c4\u4fe1\u606f", realtext="\u5e38\u89c4\u4fe1\u606f"), @CodeItem(value="WARN", text="\u8b66\u544a\u4fe1\u606f", realtext="\u8b66\u544a\u4fe1\u606f"), @CodeItem(value="ERROR", text="\u9519\u8bef\u4fe1\u606f", realtext="\u9519\u8bef\u4fe1\u606f"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u4fe1\u606f", realtext="\u81ea\u5b9a\u4e49\u4fe1\u606f")})
public class ViewMsgTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INFO = "INFO";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";
    public static final String CUSTOM = "CUSTOM";

    public ViewMsgTypeCodeListModel() {
        this.initAnnotation(ViewMsgTypeCodeListModel.class);
        this.setUserData2("ViewMsgType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgTypeCodeListModel");
    }
}


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

@CodeList(id="ddf714ec16b63022e95fba4c8272c2d6", name="\u7cfb\u7edf\u6a21\u578b\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INFO", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="TIPS", text="\u63d0\u793a", realtext="\u63d0\u793a"), @CodeItem(value="WARN", text="\u8b66\u544a", realtext="\u8b66\u544a"), @CodeItem(value="ERROR", text="\u9519\u8bef", realtext="\u9519\u8bef")})
public class SysModelMsgTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INFO = "INFO";
    public static final String TIPS = "TIPS";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";

    public SysModelMsgTypeCodeListModel() {
        this.initAnnotation(SysModelMsgTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelMsgTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelMsgTypeCodeListModel");
    }
}


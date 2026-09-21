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

@CodeList(id="e3422bcbd019f4efec6a9615a29112b4", name="\u7cfb\u7edf\u6a21\u578b\u52a0\u8f7d\u65e5\u5fd7\u65e5\u5fd7\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="OK", text="\u6b63\u5e38", realtext="\u6b63\u5e38"), @CodeItem(value="WARN", text="\u8b66\u544a", realtext="\u8b66\u544a"), @CodeItem(value="ERROR", text="\u9519\u8bef", realtext="\u9519\u8bef")})
public class ModelLoadLogLevelCodeListModel
extends StaticCodeListModelBase {
    public static final String OK = "OK";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";

    public ModelLoadLogLevelCodeListModel() {
        this.initAnnotation(ModelLoadLogLevelCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelLoadLogLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelLoadLogLevelCodeListModel");
    }
}


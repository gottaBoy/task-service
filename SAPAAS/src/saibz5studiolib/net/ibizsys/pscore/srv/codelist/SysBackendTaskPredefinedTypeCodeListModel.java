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

@CodeList(id="68da4b6d0abdf17c50ef04771841b3b6", name="\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1\u4f5c\u4e1a\u9884\u7f6e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DENOTIFY", text="\u5b9e\u4f53\u901a\u77e5", realtext="\u5b9e\u4f53\u901a\u77e5"), @CodeItem(value="SYSDATASYNCAGENT", text="\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\uff08\u8f93\u5165\uff09", realtext="\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\uff08\u8f93\u5165\uff09"), @CodeItem(value="WFCALLBACK", text="\u5de5\u4f5c\u6d41\u56de\u8c03", realtext="\u5de5\u4f5c\u6d41\u56de\u8c03"), @CodeItem(value="SYSADMIN", text="\u7cfb\u7edf\u7ba1\u7406", realtext="\u7cfb\u7edf\u7ba1\u7406"), @CodeItem(value="SYSDTSQUEUE", text="\u7cfb\u7edf\u5f02\u6b65\u5904\u7406\u961f\u5217\uff08\u53d6\u6d88\uff09", realtext="\u7cfb\u7edf\u5f02\u6b65\u5904\u7406\u961f\u5217\uff08\u53d6\u6d88\uff09"), @CodeItem(value="USER", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class SysBackendTaskPredefinedTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DENOTIFY = "DENOTIFY";
    public static final String SYSDATASYNCAGENT = "SYSDATASYNCAGENT";
    public static final String WFCALLBACK = "WFCALLBACK";
    public static final String SYSADMIN = "SYSADMIN";
    public static final String SYSDTSQUEUE = "SYSDTSQUEUE";
    public static final String USER = "USER";

    public SysBackendTaskPredefinedTypeCodeListModel() {
        this.initAnnotation(SysBackendTaskPredefinedTypeCodeListModel.class);
        this.setUserData2("PredefinedBackendTaskType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackendTaskPredefinedTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackendTaskPredefinedTypeCodeListModel");
    }
}


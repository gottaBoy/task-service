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

@CodeList(id="D57F9438-3DB7-4584-8F8F-DE8052CD72A1", name="\u4e91\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1\u5b9a\u65f6\u4efb\u52a1\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u7981\u7528", realtext="\u7981\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528"), @CodeItem(value="2", text="\u542f\u7528\uff08\u672c\u5730\uff09", realtext="\u542f\u7528\uff08\u672c\u5730\uff09", userdata="\u5728\u672c\u5730\u5bb9\u5668\u542f\u52a8\u5b9a\u65f6\u5668"), @CodeItem(value="3", text="\u542f\u7528\uff08\u672c\u5730\u975e\u5206\u5e03\u5f0f\uff09", realtext="\u542f\u7528\uff08\u672c\u5730\u975e\u5206\u5e03\u5f0f\uff09", userdata="\u5728\u672c\u5730\u5bb9\u5668\u542f\u52a8\u5b9a\u65f6\u5668\uff0c\u65e0\u5206\u5e03\u5f0f\u534f\u540c")})
public class SysBackServiceTimerModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer ENABLED = 1;
    public static final int INT_ENABLED = 1;
    public static final Integer LOCAL = 2;
    public static final int INT_LOCAL = 2;
    public static final Integer STANDALONE = 3;
    public static final int INT_STANDALONE = 3;

    public SysBackServiceTimerModeCodeListModel() {
        this.initAnnotation(SysBackServiceTimerModeCodeListModel.class);
        this.setUserData2("BackendTaskTimerMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackServiceTimerModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackServiceTimerModeCodeListModel");
    }
}


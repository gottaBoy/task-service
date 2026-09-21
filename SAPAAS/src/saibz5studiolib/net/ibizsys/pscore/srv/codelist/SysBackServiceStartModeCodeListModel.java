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

@CodeList(id="80f4c492cdb0983de73172877a18fb5a", name="\u4e91\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1\u542f\u52a8\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AUTO", text="\u81ea\u52a8", realtext="\u81ea\u52a8"), @CodeItem(value="MANUAL", text="\u624b\u52a8", realtext="\u624b\u52a8")})
public class SysBackServiceStartModeCodeListModel
extends StaticCodeListModelBase {
    public static final String AUTO = "AUTO";
    public static final String MANUAL = "MANUAL";

    public SysBackServiceStartModeCodeListModel() {
        this.initAnnotation(SysBackServiceStartModeCodeListModel.class);
        this.setUserData2("BackendTaskStartMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackServiceStartModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackServiceStartModeCodeListModel");
    }
}


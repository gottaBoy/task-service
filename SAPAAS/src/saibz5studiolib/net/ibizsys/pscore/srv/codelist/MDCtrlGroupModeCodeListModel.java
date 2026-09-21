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

@CodeList(id="882bdf688435483f3748ca7b66dbc460", name="\u591a\u6570\u636e\u90e8\u4ef6\u5206\u7ec4\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u5206\u7ec4", realtext="\u65e0\u5206\u7ec4"), @CodeItem(value="AUTO", text="\u81ea\u52a8\u5206\u7ec4", realtext="\u81ea\u52a8\u5206\u7ec4", userdata="\u6839\u636e\u6570\u636e\u96c6\u4e2d\u7684\u5206\u7ec4\u6570\u636e\u81ea\u52a8\u51fa\u5206\u7ec4"), @CodeItem(value="CODELIST", text="\u5206\u7ec4\u4ee3\u7801\u8868", realtext="\u5206\u7ec4\u4ee3\u7801\u8868", userdata="\u6839\u636e\u5206\u7ec4\u4ee3\u7801\u8868\u9884\u5148\u5206\u7ec4\uff0c\u6570\u636e\u96c6\u7684\u6570\u636e\u518d\u653e\u5165\u76f8\u5e94\u7684\u5206\u7ec4\u4e2d")})
public class MDCtrlGroupModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String AUTO = "AUTO";
    public static final String CODELIST = "CODELIST";

    public MDCtrlGroupModeCodeListModel() {
        this.initAnnotation(MDCtrlGroupModeCodeListModel.class);
        this.setUserData2("MDCtrlGroupMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MDCtrlGroupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MDCtrlGroupModeCodeListModel");
    }
}


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

@CodeList(id="06A2AF29-0080-4710-8FF2-D4D804503FF2", name="AI\u6784\u5efa\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u6784\u5efa", realtext="\u4e0d\u6784\u5efa"), @CodeItem(value="1", text="\u6784\u5efa\u5e76\u7b49\u5f85\u7528\u6237\u786e\u8ba4", realtext="\u6784\u5efa\u5e76\u7b49\u5f85\u7528\u6237\u786e\u8ba4"), @CodeItem(value="2", text="\u6784\u5efa\u5e76\u81ea\u52a8\u786e\u8ba4", realtext="\u6784\u5efa\u5e76\u81ea\u52a8\u786e\u8ba4")})
public class AIBuildModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOT = 0;
    public static final int INT_NOT = 0;
    public static final Integer USERCONFIRM = 1;
    public static final int INT_USERCONFIRM = 1;
    public static final Integer AUTOCONFIRM = 2;
    public static final int INT_AUTOCONFIRM = 2;

    public AIBuildModeCodeListModel() {
        this.initAnnotation(AIBuildModeCodeListModel.class);
        this.setUserData2("AIBuildMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AIBuildModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AIBuildModeCodeListModel");
    }
}


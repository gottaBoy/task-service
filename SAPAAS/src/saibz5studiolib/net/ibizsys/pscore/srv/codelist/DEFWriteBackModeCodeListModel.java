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

@CodeList(id="E9DADF4C-E687-46CC-83ED-A4BF9346B4A0", name="\u5b9e\u4f53\u5916\u952e\u9644\u52a0\u5c5e\u6027\u5199\u56de\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u542f\u7528", realtext="\u672a\u542f\u7528"), @CodeItem(value="1", text="\u56de\u5199", realtext="\u56de\u5199", userdata="\u5199\u56de\u81f3\u5f15\u7528\u5c5e\u6027"), @CodeItem(value="2", text="\u5ffd\u7565\u5237\u65b0", realtext="\u5ffd\u7565\u5237\u65b0", userdata="\u7269\u7406\u5c5e\u6027\u5ffd\u7565\u4ece\u4ece\u5f15\u7528\u5c5e\u6027\u540c\u6b65\u65b0\u503c")})
public class DEFWriteBackModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer WRITEBACK = 1;
    public static final int INT_WRITEBACK = 1;
    public static final Integer IGNOREREFRESH = 2;
    public static final int INT_IGNOREREFRESH = 2;

    public DEFWriteBackModeCodeListModel() {
        this.initAnnotation(DEFWriteBackModeCodeListModel.class);
        this.setUserData2("DEFWriteBackMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFWriteBackModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFWriteBackModeCodeListModel");
    }
}


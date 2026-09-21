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

@CodeList(id="8ebba6e9deeec831fb9300bc87667527", name="\u5b9e\u4f53\u901a\u77e5\u4efb\u52a1\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u4efb\u52a1", realtext="\u65e0\u4efb\u52a1"), @CodeItem(value="1", text="\u5f85\u529e\u4efb\u52a1", realtext="\u5f85\u529e\u4efb\u52a1", userdata="\u540c\u65f6\u5efa\u7acb\u901a\u77e5\u7528\u6237\u7684\u5f85\u529e\u4e8b\u9879")})
public class DENotifyTaskModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer TODO = 1;
    public static final int INT_TODO = 1;

    public DENotifyTaskModeCodeListModel() {
        this.initAnnotation(DENotifyTaskModeCodeListModel.class);
        this.setUserData2("DENotifyTaskMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DENotifyTaskModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DENotifyTaskModeCodeListModel");
    }
}


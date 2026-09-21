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

@CodeList(id="f6521c215effc6c2013c2c8b38ed88b4", name="\u8ba1\u6570\u5668\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="1", text="0 \u503c\u65f6\u9690\u85cf", realtext="0 \u503c\u65f6\u9690\u85cf", userdata="\u5f53\u8ba1\u6570\u503c\u4e3a0\u65f6\u9690\u85cf\u6240\u5728\u8282\u70b9")})
public class DETreeNodeCounterModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DEFAULT = 0;
    public static final int INT_DEFAULT = 0;
    public static final Integer HIDEZERO = 1;
    public static final int INT_HIDEZERO = 1;

    public DETreeNodeCounterModeCodeListModel() {
        this.initAnnotation(DETreeNodeCounterModeCodeListModel.class);
        this.setUserData2("TreeNodeCounterMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeCounterModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeCounterModeCodeListModel");
    }
}


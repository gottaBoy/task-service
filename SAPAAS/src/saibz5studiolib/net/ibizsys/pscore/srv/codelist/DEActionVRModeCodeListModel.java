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

@CodeList(id="da2dfd2fa9fc921e73f3eb7c4bdcefd9", name="\u5b9e\u4f53\u884c\u4e3a\u503c\u89c4\u5219\u4e3a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u9ed8\u8ba4", realtext="\u65e0\u9ed8\u8ba4"), @CodeItem(value="1", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4")})
public class DEActionVRModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NODEFAULT = 0;
    public static final int INT_NODEFAULT = 0;
    public static final Integer DEFAULT = 1;
    public static final int INT_DEFAULT = 1;

    public DEActionVRModeCodeListModel() {
        this.initAnnotation(DEActionVRModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionVRModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionVRModeCodeListModel");
    }
}


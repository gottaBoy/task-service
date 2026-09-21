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

@CodeList(id="0de2176fd789415083633232ba4d523e", name="\u670d\u52a1API\u63d0\u4f9b\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9ed8\u8ba4\u4e0d\u63d0\u4f9b", realtext="\u9ed8\u8ba4\u4e0d\u63d0\u4f9b"), @CodeItem(value="1", text="\u9ed8\u8ba4\u63d0\u4f9b", realtext="\u9ed8\u8ba4\u63d0\u4f9b")})
public class SysServiceApiModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTSUPPORTED = 0;
    public static final int INT_NOTSUPPORTED = 0;
    public static final Integer SUPPORTED = 1;
    public static final int INT_SUPPORTED = 1;

    public SysServiceApiModeCodeListModel() {
        this.initAnnotation(SysServiceApiModeCodeListModel.class);
        this.setUserData2("DEServiceAPIMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysServiceApiModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysServiceApiModeCodeListModel");
    }
}


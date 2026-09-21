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

@CodeList(id="5AC31F6C-DB71-4854-A223-CA983CEF4424", name="\u5907\u4efd\u94fe\u63a5\u72b6\u6001\uff082\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="30", text="\u5df2\u94fe\u63a5", realtext="\u5df2\u94fe\u63a5"), @CodeItem(value="40", text="\u94fe\u63a5\u672a\u6388\u6743", realtext="\u94fe\u63a5\u672a\u6388\u6743")})
public class DevSlnSysBakLinkState2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer LINKED = 30;
    public static final int INT_LINKED = 30;
    public static final Integer UNAUTHORIZED = 40;
    public static final int INT_UNAUTHORIZED = 40;

    public DevSlnSysBakLinkState2CodeListModel() {
        this.initAnnotation(DevSlnSysBakLinkState2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysBakLinkState2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysBakLinkState2CodeListModel");
    }
}


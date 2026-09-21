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

@CodeList(id="9d7a04212a4a33be8920cda6d5f665e3", name="\u8d44\u6e90\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e91\u5e73\u53f0", realtext="\u4e91\u5e73\u53f0"), @CodeItem(value="2", text="\u7528\u6237\u81ea\u5efa", realtext="\u7528\u6237\u81ea\u5efa"), @CodeItem(value="5", text="\u4e91\u5e73\u53f0\u5206\u65f6\u8d44\u6e90", realtext="\u4e91\u5e73\u53f0\u5206\u65f6\u8d44\u6e90"), @CodeItem(value="10", text="\u7528\u6237\u96c6\u7fa4\u81ea\u5efa", realtext="\u7528\u6237\u96c6\u7fa4\u81ea\u5efa")})
public class DevCenterResPosCodeListModel
extends StaticCodeListModelBase {
    public static final Integer PAAS = 1;
    public static final int INT_PAAS = 1;
    public static final Integer USER = 2;
    public static final int INT_USER = 2;
    public static final Integer PAAS_TIMESHARE = 5;
    public static final int INT_PAAS_TIMESHARE = 5;
    public static final Integer USER_CLUSTER = 10;
    public static final int INT_USER_CLUSTER = 10;

    public DevCenterResPosCodeListModel() {
        this.initAnnotation(DevCenterResPosCodeListModel.class);
        this.setUserData2("DCResPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterResPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterResPosCodeListModel");
    }
}


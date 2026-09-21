/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="fe90f31851408af694c448d7582736d2", name="\u5de5\u4f5c\u6d41\u4ee3\u529e\u7b56\u7565\u72b6\u6001", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u672a\u5e94\u7528", realtext="\u672a\u5e94\u7528"), @CodeItem(value="2", text="\u5df2\u5e94\u7528", realtext="\u5df2\u5e94\u7528"), @CodeItem(value="3", text="\u5df2\u8fc7\u671f", realtext="\u5df2\u8fc7\u671f"), @CodeItem(value="4", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88")})
public abstract class WFUCPolicyStateCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer NOTAPPLIED = 1;
    public static final int INT_NOTAPPLIED = 1;
    public static final Integer APPLIED = 2;
    public static final int INT_APPLIED = 2;
    public static final Integer EXPIRED = 3;
    public static final int INT_EXPIRED = 3;
    public static final Integer CANCELED = 4;
    public static final int INT_CANCELED = 4;

    public WFUCPolicyStateCodeListModelBase() {
        this.initAnnotation(WFUCPolicyStateCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel");
    }
}


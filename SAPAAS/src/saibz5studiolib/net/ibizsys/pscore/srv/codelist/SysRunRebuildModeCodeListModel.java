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

@CodeList(id="d3e08e76e23e8f390069e6e30afb66e6", name="\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd\u91cd\u6784\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u64cd\u4f5c", realtext="\u65e0\u64cd\u4f5c"), @CodeItem(value="4", text="\u6a21\u578b\u4fee\u590d", realtext="\u6a21\u578b\u4fee\u590d"), @CodeItem(value="1", text="\u5feb\u901f\uff08\u5220\u9664\u672c\u5730\u9879\u76ee\u4e0e\u4ee3\u7801\u4ed3\u5e93\u591a\u4f59\u6587\u4ef6\uff09", realtext="\u5feb\u901f\uff08\u5220\u9664\u672c\u5730\u9879\u76ee\u4e0e\u4ee3\u7801\u4ed3\u5e93\u591a\u4f59\u6587\u4ef6\uff09"), @CodeItem(value="2", text="\u5b8c\u6574\uff08\u5b8c\u5168\u91cd\u5efa\u672c\u5730\u9879\u76ee\u53ca\u4ee3\u7801\u4ed3\u5e93\uff09", realtext="\u5b8c\u6574\uff08\u5b8c\u5168\u91cd\u5efa\u672c\u5730\u9879\u76ee\u53ca\u4ee3\u7801\u4ed3\u5e93\uff09")})
public class SysRunRebuildModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer FIXMODEL = 4;
    public static final int INT_FIXMODEL = 4;
    public static final Integer QUICK = 1;
    public static final int INT_QUICK = 1;
    public static final Integer FULL = 2;
    public static final int INT_FULL = 2;

    public SysRunRebuildModeCodeListModel() {
        this.initAnnotation(SysRunRebuildModeCodeListModel.class);
        this.setUserData2("SysRunRebuildMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunRebuildModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunRebuildModeCodeListModel");
    }
}


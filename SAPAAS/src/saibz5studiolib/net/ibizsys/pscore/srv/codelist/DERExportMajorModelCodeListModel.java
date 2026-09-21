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

@CodeList(id="e788b6d0f62989442dc7e09fc5b1b046", name="\u5b9e\u4f53\u5173\u7cfb\u5bfc\u51fa\u5f15\u7528\u6570\u636e\u5173\u7cfb", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5bfc\u51fa\u57fa\u672c\u6570\u636e\uff08\u53ea\u5efa\u7acb\u4e0d\u66f4\u65b0\uff09", realtext="\u5bfc\u51fa\u57fa\u672c\u6570\u636e\uff08\u53ea\u5efa\u7acb\u4e0d\u66f4\u65b0\uff09")})
public class DERExportMajorModelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer SIMPLE = 1;
    public static final int INT_SIMPLE = 1;

    public DERExportMajorModelCodeListModel() {
        this.initAnnotation(DERExportMajorModelCodeListModel.class);
        this.setUserData2("DERExportMajorModel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERExportMajorModelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERExportMajorModelCodeListModel");
    }
}


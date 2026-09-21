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

@CodeList(id="f879fbb281dba065bfbe45e42f8d15d3", name="\u5e94\u7528\u4e2d\u5fc3\u8d44\u6e90\u9501\u5b9a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u9501\u5b9a", realtext="\u672a\u9501\u5b9a"), @CodeItem(value="1", text="\u5171\u4eab\u9501\u5b9a", realtext="\u5171\u4eab\u9501\u5b9a"), @CodeItem(value="2", text="\u72ec\u5360\u9501\u5b9a", realtext="\u72ec\u5360\u9501\u5b9a")})
public class DCResLockModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "0";
    public static final String SHARE = "1";
    public static final String SINGLE = "2";

    public DCResLockModeCodeListModel() {
        this.initAnnotation(DCResLockModeCodeListModel.class);
        this.setUserData2("DCResLockMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCResLockModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCResLockModeCodeListModel");
    }
}


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

@CodeList(id="5c31e02ebd78e6b5c8f0b1ef72711483", name="\u52a8\u6001\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u652f\u6301", realtext="\u4e0d\u652f\u6301"), @CodeItem(value="1", text="\u652f\u6301\uff08\u6807\u51c6\u52a8\u6001\u5b9e\u4f8b\uff09", realtext="\u652f\u6301\uff08\u6807\u51c6\u52a8\u6001\u5b9e\u4f8b\uff09"), @CodeItem(value="2", text="\u652f\u6301\uff08\u9ad8\u7ea7\u52a8\u6001\u7cfb\u7edf\uff09", realtext="\u652f\u6301\uff08\u9ad8\u7ea7\u52a8\u6001\u7cfb\u7edf\uff09")})
public class DynaSysTypesCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTSUPPORTED = 0;
    public static final int INT_NOTSUPPORTED = 0;
    public static final Integer DYNAINST = 1;
    public static final int INT_DYNAINST = 1;
    public static final Integer DYNASYS = 2;
    public static final int INT_DYNASYS = 2;

    public DynaSysTypesCodeListModel() {
        this.initAnnotation(DynaSysTypesCodeListModel.class);
        this.setUserData2("DynaSysType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaSysTypesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaSysTypesCodeListModel");
    }
}


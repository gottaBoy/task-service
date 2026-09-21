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

@CodeList(id="39b0f99001c3a8bd6182104b8afff1e8", name="\u6838\u5fc3\u4ea7\u54c1\u5b89\u88c5\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u5b89\u88c5", realtext="\u672a\u5b89\u88c5"), @CodeItem(value="20", text="\u6b63\u5728\u5b89\u88c5", realtext="\u6b63\u5728\u5b89\u88c5"), @CodeItem(value="30", text="\u6210\u529f\u5b89\u88c5", realtext="\u6210\u529f\u5b89\u88c5"), @CodeItem(value="40", text="\u5b89\u88c5\u5931\u8d25", realtext="\u5b89\u88c5\u5931\u8d25")})
public class CorePrdInstStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTINSTALL = 10;
    public static final int INT_NOTINSTALL = 10;
    public static final Integer INSTALLING = 20;
    public static final int INT_INSTALLING = 20;
    public static final Integer INSTALLED = 30;
    public static final int INT_INSTALLED = 30;
    public static final Integer INSTALLFAILED = 40;
    public static final int INT_INSTALLFAILED = 40;

    public CorePrdInstStateCodeListModel() {
        this.initAnnotation(CorePrdInstStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CorePrdInstStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CorePrdInstStateCodeListModel");
    }
}


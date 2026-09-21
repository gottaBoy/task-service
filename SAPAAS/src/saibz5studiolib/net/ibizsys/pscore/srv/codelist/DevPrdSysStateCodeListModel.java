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

@CodeList(id="0094989dce075f0d4cceccc74461967a", name="\u5f00\u53d1\u4ea7\u54c1\u7cfb\u7edf\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u7ed1\u5b9a", realtext="\u672a\u7ed1\u5b9a"), @CodeItem(value="11", text="\u521b\u5efa\u4e2d", realtext="\u521b\u5efa\u4e2d"), @CodeItem(value="20", text="\u6b63\u5e38", realtext="\u6b63\u5e38"), @CodeItem(value="30", text="\u521b\u5efa\u5931\u8d25", realtext="\u521b\u5efa\u5931\u8d25")})
public class DevPrdSysStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer UNBIND = 10;
    public static final int INT_UNBIND = 10;
    public static final Integer CREATING = 11;
    public static final int INT_CREATING = 11;
    public static final Integer OK = 20;
    public static final int INT_OK = 20;
    public static final Integer FAILED = 30;
    public static final int INT_FAILED = 30;

    public DevPrdSysStateCodeListModel() {
        this.initAnnotation(DevPrdSysStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSysStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSysStateCodeListModel");
    }
}


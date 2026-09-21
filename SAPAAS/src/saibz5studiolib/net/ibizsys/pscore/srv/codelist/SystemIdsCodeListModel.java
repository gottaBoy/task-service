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

@CodeList(id="6A5FD9FE-40F3-4BB6-980A-9EAA085A19CB", name="\u9884\u7f6e\u7cfb\u7edf\u6807\u8bc6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="2C40DFCD-0DF5-47BF-91A5-C45F810B0001", text="\u9ed8\u8ba4\u6807\u8bc6", realtext="\u9ed8\u8ba4\u6807\u8bc6"), @CodeItem(value="86E2A266-4D1E-49F0-A12D-D636905457A3", text="\u6d4b\u8bd5\u7cfb\u7edf\u6807\u8bc6\uff08\u5916\u90e8\u4e0d\u8981\u4f7f\u7528\uff09", realtext="\u6d4b\u8bd5\u7cfb\u7edf\u6807\u8bc6\uff08\u5916\u90e8\u4e0d\u8981\u4f7f\u7528\uff09")})
public class SystemIdsCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
    public static final String ITEM_2 = "86E2A266-4D1E-49F0-A12D-D636905457A3";

    public SystemIdsCodeListModel() {
        this.initAnnotation(SystemIdsCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemIdsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemIdsCodeListModel");
    }
}


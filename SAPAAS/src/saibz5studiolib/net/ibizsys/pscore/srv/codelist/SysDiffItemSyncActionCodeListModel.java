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

@CodeList(id="a952122c507480eecbe3c27176dfcc61", name="\u5dee\u5f02\u540c\u6b65\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u64cd\u4f5c", realtext="\u65e0\u64cd\u4f5c"), @CodeItem(value="UPDATESRC", text="\u66f4\u65b0\u6e90\u7cfb\u7edf", realtext="\u66f4\u65b0\u6e90\u7cfb\u7edf"), @CodeItem(value="UPDATEDST", text="\u66f4\u65b0\u5bf9\u6bd4\u7cfb\u7edf", realtext="\u66f4\u65b0\u5bf9\u6bd4\u7cfb\u7edf")})
public class SysDiffItemSyncActionCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String UPDATESRC = "UPDATESRC";
    public static final String UPDATEDST = "UPDATEDST";

    public SysDiffItemSyncActionCodeListModel() {
        this.initAnnotation(SysDiffItemSyncActionCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffItemSyncActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffItemSyncActionCodeListModel");
    }
}


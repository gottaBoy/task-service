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

@CodeList(id="86e417b332bff57745a4844314d27ce9", name="\u5dee\u5f02\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NOTMATCH", text="\u6e90\u7cfb\u7edf\u4e0e\u76ee\u6807\u7cfb\u7edf\u4e0d\u5339\u914d", realtext="\u6e90\u7cfb\u7edf\u4e0e\u76ee\u6807\u7cfb\u7edf\u4e0d\u5339\u914d"), @CodeItem(value="SRCNOTEXISTS", text="\u6e90\u7cfb\u7edf\u4e0d\u5b58\u5728", realtext="\u6e90\u7cfb\u7edf\u4e0d\u5b58\u5728"), @CodeItem(value="DSTNOTEXISTS", text="\u76ee\u6807\u7cfb\u7edf\u4e0d\u5b58\u5728", realtext="\u76ee\u6807\u7cfb\u7edf\u4e0d\u5b58\u5728")})
public class SysDiffItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NOTMATCH = "NOTMATCH";
    public static final String SRCNOTEXISTS = "SRCNOTEXISTS";
    public static final String DSTNOTEXISTS = "DSTNOTEXISTS";

    public SysDiffItemTypeCodeListModel() {
        this.initAnnotation(SysDiffItemTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffItemTypeCodeListModel");
    }
}


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

@CodeList(id="A49D72E8-9FFD-46BA-850D-A49119493E80", name="\u5b9e\u4f53\u8fc7\u6ee4\u5668\u6765\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DE", text="\u5b9e\u4f53", realtext="\u5b9e\u4f53", userdata="\u6765\u6e90\u4e8e\u5f53\u524d\u5b9e\u4f53\uff0c\u652f\u6301\u8fdb\u4e00\u6b65\u6307\u5b9a\u5c5e\u6027\u7ec4"), @CodeItem(value="DYNAMODEL", text="\u52a8\u6001\u6a21\u578b", realtext="\u52a8\u6001\u6a21\u578b", userdata="\u4ece\u52a8\u6001\u6a21\u578b\u4e2d\u6784\u5efa\u7684\u57df\u5bf9\u8c61")})
public class DEFilterSourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DE = "DE";
    public static final String DYNAMODEL = "DYNAMODEL";

    public DEFilterSourceTypeCodeListModel() {
        this.initAnnotation(DEFilterSourceTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFilterSourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFilterSourceTypeCodeListModel");
    }
}


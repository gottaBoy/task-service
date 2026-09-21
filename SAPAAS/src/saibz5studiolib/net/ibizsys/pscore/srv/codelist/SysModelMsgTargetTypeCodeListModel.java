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

@CodeList(id="3cde32dc409ebfca9350b9367c097852", name="\u7cfb\u7edf\u6a21\u578b\u6d88\u606f\u76ee\u6807\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5168\u90e8\u7528\u6237", realtext="\u5168\u90e8\u7528\u6237"), @CodeItem(value="0", text="\u6307\u5b9a\u7528\u6237", realtext="\u6307\u5b9a\u7528\u6237"), @CodeItem(value="2", text="\u6392\u9664\u7528\u6237", realtext="\u6392\u9664\u7528\u6237")})
public class SysModelMsgTargetTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_0 = 0;
    public static final int INT_ITEM_0 = 0;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;

    public SysModelMsgTargetTypeCodeListModel() {
        this.initAnnotation(SysModelMsgTargetTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelMsgTargetTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysModelMsgTargetTypeCodeListModel");
    }
}


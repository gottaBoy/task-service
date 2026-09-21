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

@CodeList(id="3d6c329a0a8f7a166ebe33dc63cdc643", name="\u5b9e\u4f53\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", realtext="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", userdata="\u9762\u5411\u4e1a\u52a1\u7684\u5904\u7406\u903b\u8f91"), @CodeItem(value="VIEWLOGIC", text="\u89c6\u56fe\u5904\u7406\u903b\u8f91", realtext="\u89c6\u56fe\u5904\u7406\u903b\u8f91", userdata="\u9762\u5411\u754c\u9762\u7684\u4ea4\u4e92\u5904\u7406\u903b\u8f91"), @CodeItem(value="MAINSTATELOGIC", text="\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91", realtext="\u4e3b\u72b6\u6001\u8fc1\u79fb\u903b\u8f91", userdata="\u4e3b\u72b6\u6001\u5207\u6362\u8def\u7531\u903b\u8f91"), @CodeItem(value="DATAFLOWLOGIC", text="\u6570\u636e\u6d41\u903b\u8f91", realtext="\u6570\u636e\u6d41\u903b\u8f91")})
public class PSDELogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DELOGIC = "DELOGIC";
    public static final String VIEWLOGIC = "VIEWLOGIC";
    public static final String MAINSTATELOGIC = "MAINSTATELOGIC";
    public static final String DATAFLOWLOGIC = "DATAFLOWLOGIC";

    public PSDELogicTypeCodeListModel() {
        this.initAnnotation(PSDELogicTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("LogicType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSDELogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSDELogicTypeCodeListModel");
    }
}


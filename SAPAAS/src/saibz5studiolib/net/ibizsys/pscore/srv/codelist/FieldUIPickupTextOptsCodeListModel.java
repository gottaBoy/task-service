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

@CodeList(id="da5769b6f55217737418a1ae96864aaf", name="\u4e91\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e\u5916\u952e\u6587\u672c\u8bbe\u7f6e", type="STATIC", userscope=false, emptytext="", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5ffd\u7565\u9644\u52a0\u503c\u7ea6\u675f", realtext="\u5ffd\u7565\u9644\u52a0\u503c\u7ea6\u675f", userdata="\u5ffd\u7565\u5b9e\u4f53\u5173\u7cfb\u4e2d\u5b9a\u4e49\u7684\u9644\u52a0\u7ea6\u675f\u6761\u4ef6"), @CodeItem(value="2", text="\u5ffd\u7565\u4e34\u65f6\u6570\u636e\u5173\u7cfb", realtext="\u5ffd\u7565\u4e34\u65f6\u6570\u636e\u5173\u7cfb", userdata="\u5ffd\u7565\u5b9e\u4f53\u5173\u7cfb\u4e2d\u5b9a\u4e49\u7684\u4e34\u65f6\u6570\u636e\u5173\u7cfb")})
public class FieldUIPickupTextOptsCodeListModel
extends StaticCodeListModelBase {
    public static final Integer IGNOREEXTRESTRICT = 1;
    public static final int INT_IGNOREEXTRESTRICT = 1;
    public static final Integer IGNORETEMPDATA = 2;
    public static final int INT_IGNORETEMPDATA = 2;

    public FieldUIPickupTextOptsCodeListModel() {
        this.initAnnotation(FieldUIPickupTextOptsCodeListModel.class);
        this.setUserData2("FieldUIPickupTextOpt");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldUIPickupTextOptsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldUIPickupTextOptsCodeListModel");
    }
}


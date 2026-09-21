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

@CodeList(id="72a6b76e6039110ec2fa512662553ee7", name="\u5fae\u4fe1\u516c\u4f17\u53f7\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u8ba2\u9605\u53f7", realtext="\u8ba2\u9605\u53f7"), @CodeItem(value="20", text="\u670d\u52a1\u53f7", realtext="\u670d\u52a1\u53f7"), @CodeItem(value="30", text="\u4f01\u4e1a\u53f7", realtext="\u4f01\u4e1a\u53f7")})
public class WXAccountTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";

    public WXAccountTypeCodeListModel() {
        this.initAnnotation(WXAccountTypeCodeListModel.class);
        this.setUserData2("WXAccountType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WXAccountTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WXAccountTypeCodeListModel");
    }
}


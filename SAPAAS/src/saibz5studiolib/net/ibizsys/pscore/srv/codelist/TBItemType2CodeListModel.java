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

@CodeList(id="053b7cceb689f8be7ef7140a10c42e0d", name="\u4e91\u5e73\u53f0\u5de5\u5177\u680f\u9879\u7c7b\u578b\uff08\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\uff09", type="STATIC", userscope=false, emptytext="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a")
@CodeItems(value={@CodeItem(value="DEUIACTION", text="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", realtext="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", userdata="\u754c\u9762\u884c\u4e3a")})
public class TBItemType2CodeListModel
extends StaticCodeListModelBase {
    public static final String DEUIACTION = "DEUIACTION";

    public TBItemType2CodeListModel() {
        this.initAnnotation(TBItemType2CodeListModel.class);
        this.setUserData2("UAGroupDetailType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TBItemType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TBItemType2CodeListModel");
    }
}


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

@CodeList(id="b215074e83d9d44a5773443b66de34db", name="\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9759\u6001", realtext="\u9759\u6001"), @CodeItem(value="1", text="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u5408")})
public class DEAWDynamicModeCodeListModel
extends StaticCodeListModelBase {
    public static final String STATIC = "0";
    public static final String DEDATASET = "1";

    public DEAWDynamicModeCodeListModel() {
        this.initAnnotation(DEAWDynamicModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEAWDynamicModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEAWDynamicModeCodeListModel");
    }
}


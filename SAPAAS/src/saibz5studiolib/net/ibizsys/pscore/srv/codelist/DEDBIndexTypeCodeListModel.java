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

@CodeList(id="3a790994d163196a44ca42e99eacb9b4", name="\u5b9e\u4f53\u6570\u636e\u5e93\u7d22\u5f15", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NORMAL", text="\u5e38\u89c4\u7d22\u5f15", realtext="\u5e38\u89c4\u7d22\u5f15"), @CodeItem(value="UNIQUE", text="\u552f\u4e00\u7d22\u5f15", realtext="\u552f\u4e00\u7d22\u5f15")})
public class DEDBIndexTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NORMAL = "NORMAL";
    public static final String UNIQUE = "UNIQUE";

    public DEDBIndexTypeCodeListModel() {
        this.initAnnotation(DEDBIndexTypeCodeListModel.class);
        this.setUserData2("DBIndexType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDBIndexTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDBIndexTypeCodeListModel");
    }
}


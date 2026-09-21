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

@CodeList(id="782de5789f366ef3a856bdc508ded90d", name="\u53d1\u5e03\u5bf9\u8c61\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="OBJECT", text="\u5bf9\u8c61", realtext="\u5bf9\u8c61"), @CodeItem(value="ARRAYLIST", text="\u6570\u7ec4\u5217\u8868", realtext="\u6570\u7ec4\u5217\u8868")})
public class CODELIST_DE1635_001CodeListModel
extends StaticCodeListModelBase {
    public static final String OBJECT = "OBJECT";
    public static final String ARRAYLIST = "ARRAYLIST";

    public CODELIST_DE1635_001CodeListModel() {
        this.initAnnotation(CODELIST_DE1635_001CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CODELIST_DE1635_001CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CODELIST_DE1635_001CodeListModel");
    }
}


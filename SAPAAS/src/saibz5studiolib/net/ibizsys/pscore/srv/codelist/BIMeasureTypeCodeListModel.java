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

@CodeList(id="e6a39d386ca90eeefdb19421d55d8204", name="\u591a\u7ef4\u5206\u6790\u6307\u6807\u7c7b\u522b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="COMMON", text="\u5e38\u89c4", realtext="\u5e38\u89c4"), @CodeItem(value="CALCULATED", text="\u52a8\u6001\u8ba1\u7b97", realtext="\u52a8\u6001\u8ba1\u7b97")})
public class BIMeasureTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String COMMON = "COMMON";
    public static final String CALCULATED = "CALCULATED";

    public BIMeasureTypeCodeListModel() {
        this.initAnnotation(BIMeasureTypeCodeListModel.class);
        this.setUserData2("BIMeasureType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BIMeasureTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BIMeasureTypeCodeListModel");
    }
}


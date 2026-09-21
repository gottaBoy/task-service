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

@CodeList(id="961d012f28d8369c594948df2a486f45", name="\u805a\u5408\u5217\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="MEASURE", text="\u6307\u6807", realtext="\u6307\u6807"), @CodeItem(value="DIMENSION", text="\u7ef4\u5ea6", realtext="\u7ef4\u5ea6"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class BIAggColumnTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MEASURE = "MEASURE";
    public static final String DIMENSION = "DIMENSION";
    public static final String USER = "USER";

    public BIAggColumnTypeCodeListModel() {
        this.initAnnotation(BIAggColumnTypeCodeListModel.class);
        this.setUserData2("BIAggColumnType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BIAggColumnTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BIAggColumnTypeCodeListModel");
    }
}


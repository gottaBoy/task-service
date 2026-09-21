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

@CodeList(id="1b14016cea8c9168011c0092ac3dbf83", name="\u5916\u90e8\u63a5\u53e3\u5bf9\u8c61\u5c5e\u6027\u9884\u5b9a\u4e49\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RETCODE", text="\u8fd4\u56de\u4ee3\u7801", realtext="\u8fd4\u56de\u4ee3\u7801"), @CodeItem(value="RETDATA", text="\u8fd4\u56de\u6570\u636e", realtext="\u8fd4\u56de\u6570\u636e"), @CodeItem(value="RETINFO", text="\u8fd4\u56de\u4fe1\u606f", realtext="\u8fd4\u56de\u4fe1\u606f"), @CodeItem(value="RETSUCCESS", text="\u8fd4\u56de\u6210\u529f\u6807\u5fd7", realtext="\u8fd4\u56de\u6210\u529f\u6807\u5fd7"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class SubSysSADEFieldPredefinedTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RETCODE = "RETCODE";
    public static final String RETDATA = "RETDATA";
    public static final String RETINFO = "RETINFO";
    public static final String RETSUCCESS = "RETSUCCESS";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public SubSysSADEFieldPredefinedTypeCodeListModel() {
        this.initAnnotation(SubSysSADEFieldPredefinedTypeCodeListModel.class);
        this.setUserData2("SubSysSADEFieldPredefinedType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEFieldPredefinedTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEFieldPredefinedTypeCodeListModel");
    }
}


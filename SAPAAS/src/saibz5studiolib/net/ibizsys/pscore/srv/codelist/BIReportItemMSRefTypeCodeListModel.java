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

@CodeList(id="5607e1b0207997a303f16e80f54be9d4", name="\u667a\u80fd\u62a5\u8868\u62a5\u8868\u6307\u6807\u5f15\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0", realtext="\u65e0"), @CodeItem(value="YEARERLIER", text="\u540c\u6bd4", realtext="\u540c\u6bd4"), @CodeItem(value="PERIODEARLIER", text="\u73af\u6bd4", realtext="\u73af\u6bd4"), @CodeItem(value="RATIO", text="\u5360\u6bd4", realtext="\u5360\u6bd4")})
public class BIReportItemMSRefTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String YEARERLIER = "YEARERLIER";
    public static final String PERIODEARLIER = "PERIODEARLIER";
    public static final String RATIO = "RATIO";

    public BIReportItemMSRefTypeCodeListModel() {
        this.initAnnotation(BIReportItemMSRefTypeCodeListModel.class);
        this.setUserData2("BIReportItemRefType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BIReportItemMSRefTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BIReportItemMSRefTypeCodeListModel");
    }
}


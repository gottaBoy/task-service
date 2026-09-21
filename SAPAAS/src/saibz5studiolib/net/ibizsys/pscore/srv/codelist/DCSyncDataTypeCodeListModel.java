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

@CodeList(id="7942b88f23f48f60a71e917406ed2f56", name="\u540c\u6b65\u6570\u636e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSDEVSLNSYS", text="\u5f00\u53d1\u7cfb\u7edf", realtext="\u5f00\u53d1\u7cfb\u7edf", iconpath="default/psdcsyncdata/icon_psobjtype_psdevslnsys.png", iconpathx="default/psdcsyncdata/icon_psobjtype_psdevslnsys@{0}x.png"), @CodeItem(value="PSDEVCENTERDBINST", text="\u6570\u636e\u5e93\u5b9e\u4f8b", realtext="\u6570\u636e\u5e93\u5b9e\u4f8b", iconpath="default/psdcsyncdata/icon_psobjtype_psdevcenterdbinst.png", iconpathx="default/psdcsyncdata/icon_psobjtype_psdevcenterdbinst@{0}x.png")})
public class DCSyncDataTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSDEVSLNSYS = "PSDEVSLNSYS";
    public static final String PSDEVCENTERDBINST = "PSDEVCENTERDBINST";

    public DCSyncDataTypeCodeListModel() {
        this.initAnnotation(DCSyncDataTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCSyncDataTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCSyncDataTypeCodeListModel");
    }
}


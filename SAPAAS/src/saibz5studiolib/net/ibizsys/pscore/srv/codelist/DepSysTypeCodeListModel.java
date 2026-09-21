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

@CodeList(id="63b93b4d0547452c3718f366074c3d43", name="\u5e94\u7528\u4e2d\u5fc3\u90e8\u7f72\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEVSLNSYS", text="\u5f00\u53d1\u7cfb\u7edf", realtext="\u5f00\u53d1\u7cfb\u7edf", iconpath="default/psdepsysapp/icon_psdepsysapptype_devslnsys.png", iconpathx="default/psdepsysapp/icon_psdepsysapptype_devslnsys@{0}x.png"), @CodeItem(value="SAASSYS", text="SaaS\u7cfb\u7edf", realtext="SaaS\u7cfb\u7edf", iconpath="default/psdepsysapp/icon_psdepsysapptype_saassys.png", iconpathx="default/psdepsysapp/icon_psdepsysapptype_saassys@{0}x.png")})
public class DepSysTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVSLNSYS = "DEVSLNSYS";
    public static final String SAASSYS = "SAASSYS";

    public DepSysTypeCodeListModel() {
        this.initAnnotation(DepSysTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSysTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DepSysTypeCodeListModel");
    }
}


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

@CodeList(id="7dd4b08c05367060870f51b29bbbfc5e", name="\u8bbf\u95ee\u5185\u5bb9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSTEM", text="\u4e91\u7cfb\u7edf", realtext="\u4e91\u7cfb\u7edf"), @CodeItem(value="DEVSLNSYS", text="\u5f00\u53d1\u65b9\u6848\u7cfb\u7edf", realtext="\u5f00\u53d1\u65b9\u6848\u7cfb\u7edf"), @CodeItem(value="DEPSLNSYS", text="\u90e8\u7f72\u65b9\u6848\u7cfb\u7edf", realtext="\u90e8\u7f72\u65b9\u6848\u7cfb\u7edf")})
public class DevUserRecentObjTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSTEM = "SYSTEM";
    public static final String DEVSLNSYS = "DEVSLNSYS";
    public static final String DEPSLNSYS = "DEPSLNSYS";

    public DevUserRecentObjTypeCodeListModel() {
        this.initAnnotation(DevUserRecentObjTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevUserRecentObjTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevUserRecentObjTypeCodeListModel");
    }
}


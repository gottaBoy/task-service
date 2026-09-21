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

@CodeList(id="A5D5CD59-ECB0-46C7-AFBB-D061D6EEB670", name="\u6e90\u5e94\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSREFAPP", text="\u5f15\u7528\u7cfb\u7edf\u5e94\u7528", realtext="\u5f15\u7528\u7cfb\u7edf\u5e94\u7528"), @CodeItem(value="SYSAPP", text="\u5f53\u524d\u7cfb\u7edf\u5e94\u7528", realtext="\u5f53\u524d\u7cfb\u7edf\u5e94\u7528")})
public class UZW2SrcAppTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSREFAPP = "SYSREFAPP";
    public static final String SYSAPP = "SYSAPP";

    public UZW2SrcAppTypeCodeListModel() {
        this.initAnnotation(UZW2SrcAppTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UZW2SrcAppTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UZW2SrcAppTypeCodeListModel");
    }
}


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

@CodeList(id="10854DE5-BF7A-47B2-AAD1-96179B2B43C9", name="\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEVSYS", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="DEVSYS_APP", text="\u5e94\u7528\u5f00\u53d1\u7cfb\u7edf", realtext="\u5e94\u7528\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="DEVSYS_SVR", text="\u670d\u52a1\u5f00\u53d1\u7cfb\u7edf", realtext="\u670d\u52a1\u5f00\u53d1\u7cfb\u7edf")})
public class SysTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVSYS = "DEVSYS";
    public static final String DEVSYS_APP = "DEVSYS_APP";
    public static final String DEVSYS_SVR = "DEVSYS_SVR";

    public SysTypeCodeListModel() {
        this.initAnnotation(SysTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysTypeCodeListModel");
    }
}


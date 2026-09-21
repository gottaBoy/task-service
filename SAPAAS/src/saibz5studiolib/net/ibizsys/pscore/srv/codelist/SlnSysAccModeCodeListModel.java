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

@CodeList(id="3220d95ddbb212b7476a761f31d90a39", name="\u4e91\u5e94\u7528\u65b9\u6848\u8bbf\u95ee\u80fd\u529b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u8bfb", realtext="\u8bfb"), @CodeItem(value="3", text="\u8bfb\u5199", realtext="\u8bfb\u5199")})
public class SlnSysAccModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer READ = 1;
    public static final int INT_READ = 1;
    public static final Integer READWRITE = 3;
    public static final int INT_READWRITE = 3;

    public SlnSysAccModeCodeListModel() {
        this.initAnnotation(SlnSysAccModeCodeListModel.class);
        this.setUserData2("DevSlnAccMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SlnSysAccModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SlnSysAccModeCodeListModel");
    }
}


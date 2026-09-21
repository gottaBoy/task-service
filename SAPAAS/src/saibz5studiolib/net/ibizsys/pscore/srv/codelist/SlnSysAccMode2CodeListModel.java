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

@CodeList(id="325DEE5B-B586-4CA6-A32B-A39586B7A226", name="\u5e94\u7528\u65b9\u6848\u8bbf\u95ee\u80fd\u529b\uff08\u6709\u6240\u6709\u8005\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u8bfb", realtext="\u8bfb"), @CodeItem(value="3", text="\u8bfb\u5199", realtext="\u8bfb\u5199"), @CodeItem(value="19", text="\u6240\u6709\u8005", realtext="\u6240\u6709\u8005")})
public class SlnSysAccMode2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer READ = 1;
    public static final int INT_READ = 1;
    public static final Integer READWRITE = 3;
    public static final int INT_READWRITE = 3;
    public static final Integer OWNER = 19;
    public static final int INT_OWNER = 19;

    public SlnSysAccMode2CodeListModel() {
        this.initAnnotation(SlnSysAccMode2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SlnSysAccMode2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SlnSysAccMode2CodeListModel");
    }
}


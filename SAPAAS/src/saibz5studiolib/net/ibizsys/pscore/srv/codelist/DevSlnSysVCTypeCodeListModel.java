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

@CodeList(id="6f5285a5328f6eca782e2c23e204d93d", name="\u4e91\u5e94\u7528\u65b9\u6848\u7cfb\u7edf\u7248\u672c\u5206\u652f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TRUNK", text="\u4e3b\u5e72\u7248\u672c", realtext="\u4e3b\u5e72\u7248\u672c"), @CodeItem(value="BRANCH", text="\u5206\u652f", realtext="\u5206\u652f"), @CodeItem(value="TAG", text="\u6807\u8bb0", realtext="\u6807\u8bb0")})
public class DevSlnSysVCTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TRUNK = "TRUNK";
    public static final String BRANCH = "BRANCH";
    public static final String TAG = "TAG";

    public DevSlnSysVCTypeCodeListModel() {
        this.initAnnotation(DevSlnSysVCTypeCodeListModel.class);
        this.setUserData2("DevSlnSysVCType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysVCTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysVCTypeCodeListModel");
    }
}


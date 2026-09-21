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

@CodeList(id="1DFFB745-1BA9-45F4-826B-D46B465118F1", name="\u5f00\u53d1\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="DEVSYS", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="DEVSYS_PSMODELTOOL", text="\u6a21\u578b\u5de5\u5177\u6269\u5c55", realtext="\u6a21\u578b\u5de5\u5177\u6269\u5c55"), @CodeItem(value="DEVSYS_WORKFLOW", text="\u5de5\u4f5c\u6d41\u6269\u5c55", realtext="\u5de5\u4f5c\u6d41\u6269\u5c55"), @CodeItem(value="DEVSYS_APP", text="\u5e94\u7528\u5f00\u53d1\u7cfb\u7edf", realtext="\u5e94\u7528\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="DEVSYS_SVR", text="\u670d\u52a1\u5f00\u53d1\u7cfb\u7edf", realtext="\u670d\u52a1\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="DEVSYS_DEPLOY", text="\u8fd0\u884c\u5f00\u53d1\u7cfb\u7edf", realtext="\u8fd0\u884c\u5f00\u53d1\u7cfb\u7edf")})
public class DevSysTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVSYS = "DEVSYS";
    public static final String DEVSYS_PSMODELTOOL = "DEVSYS_PSMODELTOOL";
    public static final String DEVSYS_WORKFLOW = "DEVSYS_WORKFLOW";
    public static final String DEVSYS_APP = "DEVSYS_APP";
    public static final String DEVSYS_SVR = "DEVSYS_SVR";
    public static final String DEVSYS_DEPLOY = "DEVSYS_DEPLOY";

    public DevSysTypeCodeListModel() {
        this.initAnnotation(DevSysTypeCodeListModel.class);
        this.setUserData2("DevSysType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysTypeCodeListModel");
    }
}


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

@CodeList(id="25ea6eb1b438d79ff86923d131f9a37c", name="\u7cfb\u7edf\u5de5\u7a0b\u9879\u76ee\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SRV_PUB", text="\u540e\u53f0\u670d\u52a1\u9879\u76ee\uff08\u53d1\u5e03\uff09", realtext="\u540e\u53f0\u670d\u52a1\u9879\u76ee\uff08\u53d1\u5e03\uff09"), @CodeItem(value="SRV_USR", text="\u540e\u53f0\u670d\u52a1\u9879\u76ee\uff08\u7528\u6237\uff09", realtext="\u540e\u53f0\u670d\u52a1\u9879\u76ee\uff08\u7528\u6237\uff09"), @CodeItem(value="APP_PUB", text="\u524d\u53f0\u5e94\u7528\u9879\u76ee\uff08\u53d1\u5e03\uff09", realtext="\u524d\u53f0\u5e94\u7528\u9879\u76ee\uff08\u53d1\u5e03\uff09"), @CodeItem(value="APP_USR", text="\u524d\u53f0\u5e94\u7528\u9879\u76ee\uff08\u7528\u6237\uff09", realtext="\u524d\u53f0\u5e94\u7528\u9879\u76ee\uff08\u7528\u6237\uff09"), @CodeItem(value="WEB_PUB", text="\u7cfb\u7edf\u65b9\u6848\uff08\u53d1\u5e03\uff09", realtext="\u7cfb\u7edf\u65b9\u6848\uff08\u53d1\u5e03\uff09"), @CodeItem(value="WEB_USR", text="\u7cfb\u7edf\u65b9\u6848\uff08\u7528\u6237\uff09", realtext="\u7cfb\u7edf\u65b9\u6848\uff08\u7528\u6237\uff09")})
public class SysProjectTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SRV_PUB = "SRV_PUB";
    public static final String SRV_USR = "SRV_USR";
    public static final String APP_PUB = "APP_PUB";
    public static final String APP_USR = "APP_USR";
    public static final String WEB_PUB = "WEB_PUB";
    public static final String WEB_USR = "WEB_USR";

    public SysProjectTypeCodeListModel() {
        this.initAnnotation(SysProjectTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysProjectTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysProjectTypeCodeListModel");
    }
}


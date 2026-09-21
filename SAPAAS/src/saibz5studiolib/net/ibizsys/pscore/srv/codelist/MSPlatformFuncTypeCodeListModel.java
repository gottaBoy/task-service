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

@CodeList(id="92a7ed2b6eef353e6a52101fba183c83", name="\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd\u7ec4\u4ef6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SERVICECENTER", text="\u670d\u52a1\u6ce8\u518c\u4e2d\u5fc3", realtext="\u670d\u52a1\u6ce8\u518c\u4e2d\u5fc3", iconpath="default/psmsplatformfunc/icon_msfunctype_servicecenter.png", iconpathx="default/psmsplatformfunc/icon_msfunctype_servicecenter@{0}x.png"), @CodeItem(value="SERVICEGATEWAY", text="\u670d\u52a1\u7f51\u5173", realtext="\u670d\u52a1\u7f51\u5173", iconpath="default/psmsplatformfunc/icon_msfunctype_servicegateway.png", iconpathx="default/psmsplatformfunc/icon_msfunctype_servicegateway@{0}x.png"), @CodeItem(value="CONFIGCENTER", text="\u914d\u7f6e\u4e2d\u5fc3", realtext="\u914d\u7f6e\u4e2d\u5fc3"), @CodeItem(value="CACHECENTER", text="\u7f13\u5b58\u4e2d\u5fc3", realtext="\u7f13\u5b58\u4e2d\u5fc3"), @CodeItem(value="STATECENTER", text="\u72b6\u6001\u4e2d\u5fc3", realtext="\u72b6\u6001\u4e2d\u5fc3"), @CodeItem(value="MESSAGEBUS", text="\u6d88\u606f\u603b\u7ebf", realtext="\u6d88\u606f\u603b\u7ebf", iconpath="default/psmsplatformfunc/icon_msfunctype_messagebus.png", iconpathx="default/psmsplatformfunc/icon_msfunctype_messagebus@{0}x.png"), @CodeItem(value="LOGCENTER", text="\u65e5\u5fd7\u805a\u5408", realtext="\u65e5\u5fd7\u805a\u5408", iconpath="default/psmsplatformfunc/icon_msfunctype_logcenter.png", iconpathx="default/psmsplatformfunc/icon_msfunctype_logcenter@{0}x.png"), @CodeItem(value="CLOUDUAAUTIL", text="Cloud\u8ba4\u8bc1\u7ec4\u4ef6\uff08UAA\uff09", realtext="Cloud\u8ba4\u8bc1\u7ec4\u4ef6\uff08UAA\uff09"), @CodeItem(value="CLOUDWFUTIL", text="Cloud\u5de5\u4f5c\u6d41\u7ec4\u4ef6\uff08WF\uff09", realtext="Cloud\u5de5\u4f5c\u6d41\u7ec4\u4ef6\uff08WF\uff09"), @CodeItem(value="CLOUDTASKUTIL", text="Cloud\u4efb\u52a1\u7ec4\u4ef6\uff08Task\uff09", realtext="Cloud\u4efb\u52a1\u7ec4\u4ef6\uff08Task\uff09"), @CodeItem(value="CLOUDOUUTIL", text="Cloud\u7ec4\u7ec7\u5355\u5143\u7ec4\u4ef6\uff08OU\uff09", realtext="Cloud\u7ec4\u7ec7\u5355\u5143\u7ec4\u4ef6\uff08OU\uff09"), @CodeItem(value="CLOUDOSSUTIL", text="Cloud\u5bf9\u8c61\u5b58\u50a8\u7ec4\u4ef6\uff08OSS\uff09", realtext="Cloud\u5bf9\u8c61\u5b58\u50a8\u7ec4\u4ef6\uff08OSS\uff09"), @CodeItem(value="CLOUDOPENUTIL", text="Cloud\u5f00\u653e\u5e73\u53f0\u7ec4\u4ef6\uff08Open\uff09", realtext="Cloud\u5f00\u653e\u5e73\u53f0\u7ec4\u4ef6\uff08Open\uff09"), @CodeItem(value="CLOUDNOTIFYUTIL", text="Cloud\u901a\u77e5\u7ec4\u4ef6\uff08Notify\uff09", realtext="Cloud\u901a\u77e5\u7ec4\u4ef6\uff08Notify\uff09"), @CodeItem(value="CLOUDLOGUTIL", text="Cloud\u65e5\u5fd7\u7ec4\u4ef6\uff08Log\uff09", realtext="Cloud\u65e5\u5fd7\u7ec4\u4ef6\uff08Log\uff09"), @CodeItem(value="CLOUDDEVOPSUTIL", text="Cloud\u5f00\u53d1\u8fd0\u884c\u7ec4\u4ef6\uff08DevOps\uff09", realtext="Cloud\u5f00\u53d1\u8fd0\u884c\u7ec4\u4ef6\uff08DevOps\uff09"), @CodeItem(value="CLOUDCONFUTIL", text="Cloud\u914d\u7f6e\u7ec4\u4ef6\uff08Conf\uff09", realtext="Cloud\u914d\u7f6e\u7ec4\u4ef6\uff08Conf\uff09"), @CodeItem(value="CLOUDCONFITEM", text="Cloud\u76f4\u63a5\u914d\u7f6e\u9879", realtext="Cloud\u76f4\u63a5\u914d\u7f6e\u9879"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class MSPlatformFuncTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SERVICECENTER = "SERVICECENTER";
    public static final String SERVICEGATEWAY = "SERVICEGATEWAY";
    public static final String CONFIGCENTER = "CONFIGCENTER";
    public static final String CACHECENTER = "CACHECENTER";
    public static final String STATECENTER = "STATECENTER";
    public static final String MESSAGEBUS = "MESSAGEBUS";
    public static final String LOGCENTER = "LOGCENTER";
    public static final String CLOUDUAAUTIL = "CLOUDUAAUTIL";
    public static final String CLOUDWFUTIL = "CLOUDWFUTIL";
    public static final String CLOUDTASKUTIL = "CLOUDTASKUTIL";
    public static final String CLOUDOUUTIL = "CLOUDOUUTIL";
    public static final String CLOUDOSSUTIL = "CLOUDOSSUTIL";
    public static final String CLOUDOPENUTIL = "CLOUDOPENUTIL";
    public static final String CLOUDNOTIFYUTIL = "CLOUDNOTIFYUTIL";
    public static final String CLOUDLOGUTIL = "CLOUDLOGUTIL";
    public static final String CLOUDDEVOPSUTIL = "CLOUDDEVOPSUTIL";
    public static final String CLOUDCONFUTIL = "CLOUDCONFUTIL";
    public static final String CLOUDCONFITEM = "CLOUDCONFITEM";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public MSPlatformFuncTypeCodeListModel() {
        this.initAnnotation(MSPlatformFuncTypeCodeListModel.class);
        this.setUserData2("MSPlatformFuncType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MSPlatformFuncTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MSPlatformFuncTypeCodeListModel");
    }
}


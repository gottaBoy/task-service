/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5e94\u7528\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u5f15\u7528\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u5b9a\u4e49\u524d\u7aef\u5e94\u7528\u5bf9\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u5f15\u7528\uff0c\u6839\u636e\u4f7f\u7528\u81ea\u52a8\u8ba1\u7b97", model="PSSysPFPlugin")
public interface IPSAppPFPluginRef
extends IPSApplicationObject,
IPSModelSortable {
    public static final String REFMODE_APP = "APP";
    public static final String REFMODE_APPVIEW = "APPVIEW";
    public static final String REFMODE_CONTROL = "CONTROL";
    public static final String REFMODE_CONTROLITEM = "CONTROLITEM";
    public static final String REFMODE_UIACTION = "UIACTION";
    public static final String REFMODE_UICOUNTER = "UICOUNTER";
    public static final String REFMODE_DEMETHOD = "DEMETHOD";
    public static final String REFMODE_APPUTIL = "APPUTIL";
    public static final String REFMODE_APPUILOGIC = "APPUILOGIC";
    public static final String REFMODE_DELOGIC = "DELOGIC";
    public static final String REFMODE_DEUILOGIC = "DEUILOGIC";
    public static final String REFMODE_CODELIST = "CODELIST";
    public static final String REFMODE_DEDATAIMPORT = "DEDATAIMPORT";
    public static final String REFMODE_DEDATAEXPORT = "DEDATAEXPORT";
    public static final String REFMODE_DEACMODE = "DEACMODE";
    public static final String REFMODE_EDITORSTYPE = "EDITORSTYPE";
    public static final String REFMODE_DEUIPFPLUGIN = "DEUIPFPLUGIN";
    public static final String REFMODE_DEREPORT = "DEREPORT";
    public static final String REFMODE_DEPRINT = "DEPRINT";
    public static final String REFMODE_UIACTIONGROUPDETAIL = "UIACTIONGROUPDETAIL";
    public static final String REFMODE_DEDRGROUPHEADER = "DEDRGROUPHEADER";
    public static final String REFMODE_DEDRITEMHEADER = "DEDRITEMHEADER";
    public static final String REFMODE_CONTROLRENDER = "CONTROLRENDER";
    public static final String REFMODE_APPVIEWLOGIC = "APPVIEWLOGIC";
    public static final String REFMODE_DEFINPUTTIPSET = "DEFINPUTTIPSET";

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getRefMode();

    public String getRefTag();

    public String getRefTag2();

    public IPSPFXCodeObject getRender();

    public String getPluginType();

    public String getPluginCode();

    public boolean isExtendStyleOnly();

    public ObjectNode getPluginModel();

    public boolean isReplaceDefault();

    public boolean isRuntimeObject();

    public String getTemplCode();

    public String getTemplCode2();

    public String getTemplCode3();

    public String getTemplCode4();

    public String getRTObjectName();

    public String getRTObjectRepo();

    public Properties getPluginParams();
}


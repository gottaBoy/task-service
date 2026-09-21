/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u540e\u53f0\u6269\u5c55\u63d2\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysSFPlugin")
public interface IPSSysSFPlugin
extends IPSSystemObject {
    public static final int RTOBJECTSOURCE_UNKNOWN = 0;
    public static final int RTOBJECTSOURCE_LOCAL = 1;
    public static final int RTOBJECTSOURCE_REMOTE = 2;
    public static final String PLUGINTYPE_SYSREF = "SYSREF";
    public static final String PLUGINTYPE_MODULE = "MODULE";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysSFPlugin var3) throws Exception;

    public String getPSSFPluginId();

    public String getPluginType();

    public IPSSFPluginTempl getPSSFPluginTempl(String var1) throws Exception;

    public IPSSFPluginTempl getPSSFPluginTempl(String var1, boolean var2) throws Exception;

    public String getCode(String var1) throws Exception;

    public boolean hasCode(String var1) throws Exception;

    public String getXCode(String var1, Object var2, Map<String, Object> var3) throws Exception;

    public Iterator<IPSSysSFPluginTempl> getPSSysSFPluginTempls() throws Exception;

    @Override
    public String getCodeName();

    public boolean isRuntimeObject();

    public int getRTObjectSource();

    public String getRTObjectName();

    public String getRTObjectRepo();

    public Properties getPluginParams();

    public int getPluginParam(String var1, int var2);

    public String getPluginParam(String var1, String var2);

    public double getPluginParam(String var1, double var2);

    public boolean getPluginParam(String var1, boolean var2);

    public ObjectNode getPluginModel();

    public boolean isReplaceDefault();

    public String getPluginCode();

    public IPSSystemModule getPSSystemModule();

    public boolean isTryMode();

    public String getTemplCode();

    public String getTemplCode2();

    public String getTemplCode3();

    public String getTemplCode4();

    public boolean isLazyMode();

    public String getPluginTag();

    public String getPluginTag2();

    public boolean isSingleInstance();

    public boolean isTemplateMode();

    public String getRealCode();

    public String getTemplateFunc();
}


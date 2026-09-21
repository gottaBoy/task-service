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
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public interface IPSSysPFPlugin
extends IPSSystemObject,
IPSPFPlugin {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysPFPlugin var3) throws Exception;

    public String getPluginCode();

    public String getPluginTag();

    public String getPluginType();

    public String getPFPluginCode();

    @Override
    public IPSPFPluginType getPSPFPluginType();

    @Override
    public String getCode(String var1, String var2, String var3, Object var4, Object var5, Object var6) throws Exception;

    @Override
    public String getCode(String var1, String var2, String var3, String var4, Object var5, Object var6, Object var7) throws Exception;

    @Override
    public String getCode(String var1) throws Exception;

    @Override
    public String getCode(String var1, String var2) throws Exception;

    @Override
    public boolean hasCode(String var1) throws Exception;

    @Override
    public boolean hasCode(String var1, String var2) throws Exception;

    @Override
    public boolean hasCode(String var1, String var2, String var3, String var4) throws Exception;

    @Override
    public boolean hasCode2(String var1) throws Exception;

    @Override
    public boolean hasCode3(String var1) throws Exception;

    @Override
    public boolean hasCode4(String var1) throws Exception;

    @Override
    public String getCode2(String var1) throws Exception;

    @Override
    public String getCode3(String var1) throws Exception;

    @Override
    public String getCode4(String var1) throws Exception;

    @Override
    public String getPSPFPluginId();

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String var1) throws Exception;

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String var1, String var2, boolean var3) throws Exception;

    public String getXCode(String var1, Object var2, Object var3, Object var4, Map<String, Object> var5) throws Exception;

    @Override
    public String getPreviewHtml();

    public Iterator<IPSSysPFPluginTempl> getPSSysPFPluginTempls() throws Exception;

    @Override
    public String getCodeName();

    public boolean isExtendStyleOnly();

    public ObjectNode getPluginModel();

    public boolean isReplaceDefault();

    public IPSSystemModule getPSSystemModule();

    @Override
    public boolean isRuntimeObject();

    @Override
    public int getRTObjectSource();

    @Override
    public String getRTObjectName();

    @Override
    public String getRTObjectRepo();

    public Properties getPluginParams();
}


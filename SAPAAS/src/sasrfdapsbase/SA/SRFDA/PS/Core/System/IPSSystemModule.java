/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSSystemModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6a21\u5757\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSModule")
public interface IPSSystemModule
extends IPSSystemObject,
IPSSFCodeObject,
IPSSysSFPubObject {
    public static final String GLOBALPLUGIN_MODULERUNTIME = "GLOBAL_MODULERUNTIME";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSystemModule var3) throws Exception;

    @Override
    public String getCodeName();

    public boolean isSubSysModule();

    public IPSSysRef getPSSysRef();

    public boolean isDefaultModule();

    public IPSSysModelGroup getPSSysModelGroup();

    public String getModuleTag();

    public String getModuleTag2();

    public String getModuleTag3();

    public String getModuleTag4();

    public String getPKGCodeName();

    public Iterator<IPSDataEntity> getAllPSDataEntities() throws Exception;

    public Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception;

    public Iterator<IPSCodeList> getAllPSCodeLists() throws Exception;

    public Iterator<IPSSystemModule> getMajorPSSystemModules() throws Exception;

    public Iterator<IPSSystemModule> getMinorPSSystemModules() throws Exception;

    public String getSysRefType();

    public boolean isSubSysAsCloud();

    public String getShortTag();

    public String getLanResTag();

    public String getDEPSSysSFPluginId();

    public String getUtilType();

    public String getUtilTag();

    public Properties getUtilParams();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public String getDSLink();

    public String getModuleSN();

    public String getDTOCodeNameFormat();

    public String getAPICodeNameMode();

    public String getAPICodeName(String var1, String var2, String var3);

    public boolean isDTOUseServiceCodeName();

    public boolean isEnablePQL();

    public String getRuntimeType();
}


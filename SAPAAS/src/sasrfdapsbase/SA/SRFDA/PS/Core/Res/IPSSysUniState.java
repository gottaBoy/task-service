/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.cache.IUniState
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUniState;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.cache.IUniState;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u7edf\u4e00\u72b6\u6001\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysUniState")
public interface IPSSysUniState
extends IPSSystemObject,
IUniState,
IPSSysSFPubObject {
    public static final String UNISTATEMODE_DEFAULT = "DEFAULT";
    public static final String UNISTATEMODE_CACHE = "CACHE";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUniState var3) throws Exception;

    public String getUniqueTag();

    public String getDEName();

    public String getKeyField();

    public String getFolderField();

    public String getFolder2Field();

    public String getFolder3Field();

    public String getStateField();

    public String getState2Field();

    public String getState3Field();

    public String getState4Field();

    public String getState5Field();

    public String getState6Field();

    public String getState7Field();

    public String getState8Field();

    public String getUniStateType();

    public String getUniStateMode();

    public IPSDataEntity getPSDataEntity();

    public IPSDEField getKeyPSDEField();

    public IPSDEField getFolderPSDEField();

    public IPSDEField getFolder2PSDEField();

    public IPSDEField getFolder3PSDEField();

    public IPSDEField getFolder4PSDEField();

    public IPSDEField getFolder5PSDEField();

    public IPSDEField getFolder6PSDEField();

    public IPSDEField getFolder7PSDEField();

    public IPSDEField getFolder8PSDEField();

    public IPSDEField getStatePSDEField();

    public IPSDEField getState2PSDEField();

    public IPSDEField getState3PSDEField();

    public IPSDEField getState4PSDEField();

    public IPSDEField getState5PSDEField();

    public IPSDEField getState6PSDEField();

    public IPSDEField getState7PSDEField();

    public IPSDEField getState8PSDEField();

    public IPSSystemModule getPSSystemModule();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public String getUniStateTag();

    public String getUniStateTag2();

    public Properties getUniStateParams();

    public IPSDELogic getInitPSDELogic();

    public IPSDELogic getOnChangePSDELogic();

    public IPSDELogic getOnDeletePSDELogic();

    public IPSDEDataSet getPSDEDataSet();

    public int getReloadTimer();

    public boolean isAllData();

    public String getPathFormat();

    public String getMonitorFormat();

    public String getCacheCat();

    public int getCacheTimeout();

    public boolean isDeleteAsUpdate();
}


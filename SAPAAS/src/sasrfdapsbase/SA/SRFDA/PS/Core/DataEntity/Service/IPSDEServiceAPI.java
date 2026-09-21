/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIVR;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEServiceAPI")
public interface IPSDEServiceAPI
extends IPSDataEntityObject {
    public static final String DEFGROUPMODE_REPLACE = "REPLACE";
    public static final String DEFGROUPMODE_OVERWRITE = "OVERWRITE";
    public static final String DEFGROUPMODE_EXCLUDE = "EXCLUDE";
    public static final int APIMODE_MAJOR = 1;
    public static final int APIMODE_MINOR = 0;
    public static final int APIMODE_NESTED = 9;

    public void init(ISRFDAGlobalHelper var1, IPSSysServiceAPI var2, IPSDataEntity var3, PSDEServiceAPI var4) throws Exception;

    public Iterator<IPSDEServiceAPIMethod> getPSDEServiceAPIMethods();

    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String var1) throws Exception;

    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String var1, boolean var2) throws Exception;

    public String getLogicName();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public IPSSysServiceAPI getPSSysServiceAPI() throws Exception;

    public boolean isEnableDEAction();

    public boolean isEnableSelect();

    public boolean isEnableDEDataSet();

    public boolean isEnableTempData();

    public String getHandler();

    public Iterator<? extends IPSDEServiceAPIField> getPSDEServiceAPIFields();

    public IPSDEServiceAPIField getPSDEServiceAPIField(String var1) throws Exception;

    public IPSDEServiceAPIField getPSDEServiceAPIField(String var1, boolean var2) throws Exception;

    public IPSDEFGroup getPSDEFGroup();

    public boolean isMajor();

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSs(boolean var1);

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSs();

    public Iterator<? extends IPSDEServiceAPIRS> getMajorPSDEServiceAPIRSs();

    public Iterator<? extends IPSDEServiceAPIRS> getMinorPSDEServiceAPIRSs();

    public int getPSDEServiceAPIRSPathCount() throws Exception;

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath(int var1) throws Exception;

    public IPSDEServiceAPIRS getPSDEServiceAPIRSPathFirst(int var1) throws Exception;

    public IPSDEServiceAPIRS getPSDEServiceAPIRSPathLast(int var1) throws Exception;

    public String getDEFGroupMode();

    public Iterator<? extends IPSDEServiceAPIVR> getPSDEServiceAPIVRs();

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath0() throws Exception;

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath1() throws Exception;

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath2() throws Exception;

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath3() throws Exception;

    public Iterator<? extends IPSDEServiceAPIRS> getPSDEServiceAPIRSPath4() throws Exception;

    public int getDataAccCtrlArch();

    public int getDataAccCtrlMode();

    public IPSDEServiceAPIField getKeyPSDEServiceAPIField();

    public IPSDEServiceAPIField getMajorPSDEServiceAPIField();

    public int getAPIMode();

    public boolean isNested();

    public IPSSysSFPlugin getPSSysSFPlugin() throws Exception;

    public IPSSFXCodeObject getRender() throws Exception;

    public IPSLanguageRes getLNPSLanguageRes();

    @Override
    public IPSDataEntity getPSDataEntity();

    public boolean isEnableDataImport();

    public boolean isEnableDataExport();

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception;

    public String getServiceParam();

    public String getServiceParam2();

    public IPSSysTranslator getOutPSSysTranslator();

    public IPSSysUniRes getPSSysUniRes();
}


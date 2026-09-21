/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataSet
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggData;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetReturn;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEDataRange;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Data.PSDEDataSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.core.IDEDataSet;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataSet", description="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u6a21\u578b\u9664\u4e86\u81ea\u8eab\u903b\u8f91\u8fd8\u5305\u62ec\u4e86\u8f93\u5165{@link #getPSDEDataSetInput}\u53ca\u8fd4\u56de{@link #getPSDEDataSetReturn}\u6a21\u578b")
public interface IPSDEDataSet
extends IPSDataEntityObject,
IDEDataSet,
IPSDEDataRange {
    public static final int PARAMMODE_ALL = 1;
    public static final int PARAMMODE_SOME = 2;
    public static final String PREDEFINEDTYPE_INDEXDE = "INDEXDE";
    public static final String PREDEFINEDTYPE_MULTIFORM = "MULTIFORM";
    public static final String PREDEFINEDTYPE_CODELIST = "CODELIST";
    public static final String PREDEFINEDTYPE_DELOGIC = "DELOGIC";
    public static final String PREDEFINEDTYPE_SCRIPT = "SCRIPT";
    public static final String DATASETTYPE_DATAQUERY = "DATAQUERY";
    public static final String DATASETTYPE_INDEXDE = "INDEXDE";
    public static final String DATASETTYPE_MULTIFORM = "MULTIFORM";
    public static final String DATASETTYPE_CODELIST = "CODELIST";
    public static final String DATASETTYPE_DELOGIC = "DELOGIC";
    public static final String DATASETTYPE_SCRIPT = "SCRIPT";
    public static final String DATASETTYPE_REMOTE = "REMOTE";
    public static final String DATASETTYPE_USERCUSTOM = "USERCUSTOM";
    public static final int GROUPMODE_NONE = 0;
    public static final int GROUPMODE_PARAM = 1;
    public static final int GROUPMODE_DERAGGDATA = 2;
    public static final int SUBSYSSADEMETHODBINDINGMODE_NOT = 0;
    public static final int SUBSYSSADEMETHODBINDINGMODE_MANUAL = 1;
    public static final int SUBSYSSADEMETHODBINDINGMODE_AUTO = 2;

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDataSet var3) throws Exception;

    @Override
    public String getCodeName();

    public IPSDEDataSetCode getPSDEDataSetCode(String var1) throws Exception;

    public Iterator<IPSDEDataQuery> getPSDEDataQueries();

    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParams();

    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParamsByDBType(String var1) throws Exception;

    public boolean isDefaultMode();

    public String getDataSetType();

    @Deprecated
    public String getPredefineType();

    public String getPredefinedType();

    public IPSDEDataSetGroupParam getPSDEDataSetGroupParam(String var1, boolean var2) throws Exception;

    public IPSCodeList getPSCodeList();

    @Override
    public int getExtendMode();

    public String getLogicName();

    public IPSSysUserDR getPSSysUserDR();

    public IPSSysUserDR getPSSysUserDR2();

    public IPSDEField getMajorSortPSDEField();

    public IPSDEField getMinorSortPSDEField();

    public IPSSysUniState getPSSysUniState();

    public IPSDELogic getCacheStatePSDELogic();

    public boolean isPubServiceDefault();

    public IPSRESTfulAPI getPSRESTfulAPI();

    public IPSDELogic getActiveDataPSDELogic();

    public boolean isEnableTempData();

    public Iterator<IPSDEDQCondition> getADPSDEDQConditions();

    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception;

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public int getActionHolder();

    public String getPSSubSysServiceAPIDEMethodId();

    public IPSDEOPPriv getPSDEOPPriv();

    public boolean isValid();

    public String getMajorSortDir();

    public String getMinorSortDir();

    public int getPageSize();

    public boolean isEnableAudit();

    public String getScriptCode();

    public IPSDEFGroup getPSDEFGroup();

    public IPSDEDataSetInput getPSDEDataSetInput();

    public IPSDEDataSetReturn getPSDEDataSetReturn();

    public int getGroupMode();

    public IPSDERAggData getPSDERAggData();

    public IPSDELogic getPSDELogic() throws Exception;

    public String getBeforeCode();

    public String getAfterCode();

    public int getPOTime();

    public int getViewLevel();

    public String getDataSetTag();

    public String getDataSetTag2();

    public String getDataSetTag3();

    public String getDataSetTag4();

    public String getReturnValueType();

    public int getParamMode();

    public boolean isCustomParam();

    public Iterator<IPSDEDataSetParam> getPSDEDataSetParams();

    public IPSDEFGroup getInPSDEFGroup();

    public int getSubSysServiceAPIDEMethodBindingMode();

    public String getServiceCodeName();

    public boolean isEnableGroup();

    public int getGroupTopCount();

    public int getDataSetOption();

    public boolean isEnableCache();

    public int getCacheTimeout();

    public Properties getDataSetParams();

    public String getUnionMode();

    public int getMaxRowCount();
}


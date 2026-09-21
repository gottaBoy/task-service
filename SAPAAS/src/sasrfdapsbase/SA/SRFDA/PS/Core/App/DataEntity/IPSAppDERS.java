/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSAppDERS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppDERS")
public interface IPSAppDERS
extends IPSApplicationObject {
    public static final Integer RSMODE_LOCAL = 1;
    public static final Integer RSMODE_DESARS = 2;
    public static final Integer DATARSMODE_NONE = 0;
    public static final Integer DATARSMODE_CREATE = 1;
    public static final Integer DATARSMODE_UPDATE = 2;
    public static final Integer DATARSMODE_GET = 4;
    public static final Integer DATARSMODE_SELECT = 8;
    public static final Integer ACTIONRSMODE_NONE = 0;
    public static final Integer ACTIONRSMODE_INHERIT = 1;
    public static final Integer ACTIONRSMODE_SOME = 2;

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppDERS var3) throws Exception;

    public String getPPSAppDataEntityId();

    public String getCPSAppDataEntityId();

    public int getOrderValue();

    public IPSAppDataEntity getMajorPSAppDataEntity() throws Exception;

    public IPSAppDataEntity getMinorPSAppDataEntity() throws Exception;

    public IPSDERBase getPSDER();

    public IPSDER1N getPSDER1N();

    public String getParentFilter();

    public int getTempDataOrder();

    public boolean isEnableDEAction();

    public boolean isEnableSelect();

    public boolean isEnableDEDataSet();

    public boolean testDataRSMode(int var1);

    public int getDataRSMode();

    public int getActionRSMode();

    public boolean isEnableCreateDataRS();

    public boolean isEnableUpdateDataRS();

    public boolean isEnableGetDataRS();

    public boolean isEnableSelectDataRS();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public int getRSMode();

    public IPSAppDEField getParentPSAppDEField() throws Exception;

    public IPSAppDEField getParentTextPSAppDEField() throws Exception;

    public IPSDEServiceAPIRS getPSDEServiceAPIRS();

    public boolean isArray();

    public String getMajorDEName() throws Exception;

    public String getMajorDECodeName() throws Exception;

    public String getMajorDECodeName2() throws Exception;

    public boolean isMajorDEMajor() throws Exception;

    public String getMinorDEName() throws Exception;

    public String getMinorDECodeName() throws Exception;

    public String getMinorDECodeName2() throws Exception;

    public String getRSType();

    public int getRemoveOrder();

    public int getRemoveActionType();

    public String getRemoveRejectMsg();

    public String getRRMLanResTag();

    public IPSAppDEDataSet getNestedPSAppDEDataSet() throws Exception;
}


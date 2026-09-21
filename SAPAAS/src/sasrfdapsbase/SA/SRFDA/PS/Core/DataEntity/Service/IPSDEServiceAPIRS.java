/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSDESARS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDESARS")
public interface IPSDEServiceAPIRS
extends IPSModelObject {
    public static final Integer DATARSMODE_NONE = 0;
    public static final Integer DATARSMODE_CREATE = 1;
    public static final Integer DATARSMODE_UPDATE = 2;
    public static final Integer DATARSMODE_GET = 4;
    public static final Integer DATARSMODE_SELECT = 8;
    public static final Integer ACTIONRSMODE_NONE = 0;
    public static final Integer ACTIONRSMODE_INHERIT = 1;
    public static final Integer ACTIONRSMODE_SOME = 2;

    public void init(ISRFDAGlobalHelper var1, IPSSysServiceAPI var2, PSDESARS var3) throws Exception;

    public IPSSysServiceAPI getPSSysServiceAPI();

    public String getPPSDEServiceAPIId();

    public String getCPSDEServiceAPIId();

    public int getOrderValue();

    public IPSDEServiceAPI getMajorPSDEServiceAPI() throws Exception;

    public IPSDEServiceAPI getMinorPSDEServiceAPI() throws Exception;

    public IPSDER1N getPSDER1N();

    public IPSDERBase getPSDER();

    public String getParentFilter();

    public String getParentTypeFilter();

    @Override
    public String getCodeName();

    public String getCodeName2();

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

    public int getTempDataOrder();

    public int getDataAccCtrlMode() throws Exception;

    public Iterator<IPSDEServiceAPIMethod> getPSDEServiceAPIMethods() throws Exception;

    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String var1) throws Exception;

    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod(String var1, boolean var2) throws Exception;

    public IPSDEField getParentIdPSDEField();

    public IPSDEField getParentTypePSDEField();

    public boolean isArray();

    public boolean isEnableDataImport();

    public boolean isEnableDataExport();
}


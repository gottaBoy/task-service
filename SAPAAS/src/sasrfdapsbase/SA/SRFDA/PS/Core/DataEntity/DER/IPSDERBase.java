/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDERBase
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDERBase;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="dERType", implement="PSDERBaseImpl", model="PSDER")
public interface IPSDERBase
extends IPSSystemObject,
IDERBase {
    public static final String DERTYPE_AGGDATA = "DERAGGDATA";

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, IPSDataEntity var3, PSDER var4) throws Exception;

    public IPSDataEntity getMajorPSDataEntity();

    public IPSDataEntity getMinorPSDataEntity();

    public String getMajorPSDEId();

    public String getMinorPSDEId();

    @Override
    public String getCodeName();

    public String getMinorCodeName();

    public String getServiceCodeName();

    public String getMinorServiceCodeName();

    public String getLogicName();

    public String getMinorLogicName();

    public int getOrderValue();

    public void fillViewParentModeJO(JSONObject var1);

    public Iterator<IPSLinkDEField> getAllPSLinkDEFields() throws Exception;

    public String getDERType();

    public String getDERTag();

    public String getDERTag2();

    public IPSSysSFPlugin getPSSysSFPlugin();
}


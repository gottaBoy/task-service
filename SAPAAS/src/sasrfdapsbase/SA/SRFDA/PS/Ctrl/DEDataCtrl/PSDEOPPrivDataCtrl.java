/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEOPPriv;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEOPPrivDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEOPPrivDataCtrl.class);
    private static HashMap<String, String> defaultPSDEOPPrivMap = new HashMap();

    static {
        defaultPSDEOPPrivMap.put("CREATE", "\u5efa\u7acb");
        defaultPSDEOPPrivMap.put("UPDATE", "\u66f4\u65b0");
        defaultPSDEOPPrivMap.put("DELETE", "\u5220\u9664");
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                for (String strPSDEOPPrivId : defaultPSDEOPPrivMap.keySet()) {
                    PSDEOPPriv opsDEOPPriv = new PSDEOPPriv();
                    opsDEOPPriv.setPSDEOPPRIVID(Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)strPSDEOPPrivId));
                    callResult = this.Get(opsDEOPPriv);
                    if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) continue;
                    String strLogicName = defaultPSDEOPPrivMap.get(strPSDEOPPrivId);
                    opsDEOPPriv.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    opsDEOPPriv.setPSDENAME(psDataEntity.getPSDATAENTITYNAME());
                    opsDEOPPriv.setPSDEOPPRIVNAME(strPSDEOPPrivId);
                    opsDEOPPriv.setLOGICNAME(strLogicName);
                    callResult = this.Save(true, opsDEOPPriv);
                    if (callResult.getRetCode() == 0) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u6807\u8bc6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}


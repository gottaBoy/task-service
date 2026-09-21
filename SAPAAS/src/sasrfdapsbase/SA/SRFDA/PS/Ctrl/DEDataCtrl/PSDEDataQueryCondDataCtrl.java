/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCondDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCondDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult;
        block7: {
            callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
            if (callResult.isError()) {
                return callResult;
            }
            try {
                PSDEDataQueryCond psDEDataQueryCond = new PSDEDataQueryCond();
                psDEDataQueryCond.proxy(dataEntity);
                if (StringHelper.Compare((String)psDEDataQueryCond.getCONDTYPE(), (String)"GROUP", (boolean)true) == 0) {
                    psDEDataQueryCond.setPSDEDQCONDNAME(StringHelper.Format((String)"\u7ec4\u5408%2$s(%1$s)", (Object)psDEDataQueryCond.getGROUPOP(), (Object)(psDEDataQueryCond.getGROUPNOTFLAG() ? "(!)" : "")));
                    break block7;
                }
                if (StringHelper.Compare((String)psDEDataQueryCond.getCONDTYPE(), (String)"SINGLE", (boolean)true) == 0) {
                    psDEDataQueryCond.setPSDEDQCONDNAME(StringHelper.Format((String)"\u5c5e\u6027[%1$s](%1$s)%3$s", (Object)psDEDataQueryCond.getPSDEFNAME(), (Object)psDEDataQueryCond.getPSDBVALUEOPID(), (Object)psDEDataQueryCond.getCONDVALUE()));
                    break block7;
                }
                if (StringHelper.Compare((String)psDEDataQueryCond.getCONDTYPE(), (String)"CUSTOM", (boolean)true) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)psDEDataQueryCond.getPSDEDQCONDNAME())) {
                        psDEDataQueryCond.setPSDEDQCONDNAME(StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u6761\u4ef6"));
                    }
                    break block7;
                }
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u7c7b\u578b"));
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return callResult;
    }
}


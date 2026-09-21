/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSPFUIActionTempl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFUIActionTemplDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSPFUIActionTemplDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSPFUIActionTempl psPFUIActionTempl = new PSPFUIActionTempl();
            psPFUIActionTempl.proxy(dataEntity);
            String strPSPFCTRLTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s", (Object)psPFUIActionTempl.getPSPFNAME(), (Object)psPFUIActionTempl.getPSPFSTYLENAME(), (Object)psPFUIActionTempl.getPSSYSUIACTIONNAME(), (Object)psPFUIActionTempl.getPSPFPUBCODENAME());
            psPFUIActionTempl.setPSPFUATEMPLNAME(strPSPFCTRLTEMPLNAME);
            psPFUIActionTempl.setPSPFUATEMPLID(Helper.GenUniqueId((String)psPFUIActionTempl.getPSPFID(), (String)psPFUIActionTempl.getPSPFSTYLEID(), (String)psPFUIActionTempl.getPSSYSUIACTIONID(), (String)psPFUIActionTempl.getPSPFPUBCODEID()));
        }
        return callResult;
    }
}


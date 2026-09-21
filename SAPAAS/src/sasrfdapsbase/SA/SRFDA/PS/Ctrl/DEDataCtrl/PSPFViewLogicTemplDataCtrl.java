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

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewLogicTemplDataCtrl
extends PSPFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSPFViewLogicTemplDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSPFViewLogicTempl psPFViewLogicTempl = new PSPFViewLogicTempl();
            psPFViewLogicTempl.proxy(dataEntity);
            String strPSPFCTRLTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s", (Object)psPFViewLogicTempl.getPSPFNAME(), (Object)psPFViewLogicTempl.getPSPFSTYLENAME(), (Object)psPFViewLogicTempl.getPSVIEWLOGICTYPENAME(), (Object)psPFViewLogicTempl.getPSPFPUBCODENAME());
            psPFViewLogicTempl.setPSPFVLTEMPLNAME(strPSPFCTRLTEMPLNAME);
            psPFViewLogicTempl.setPSPFVLTEMPLID(Helper.GenUniqueId((String)psPFViewLogicTempl.getPSPFID(), (String)psPFViewLogicTempl.getPSPFSTYLEID(), (String)psPFViewLogicTempl.getPSVIEWLOGICTYPEID(), (String)psPFViewLogicTempl.getPSPFPUBCODEID()));
        }
        return callResult;
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSPFViewLogicTempl psPFViewLogicTempl = new PSPFViewLogicTempl();
        psPFViewLogicTempl.proxy(dataEntity);
        BaseDataEntity psPFStyle = this.GetRelatedData("DE1595", psPFViewLogicTempl.getPSPFSTYLEID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1595");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psPFStyle);
        return StringHelper.Format((String)"%1$s%2$sPSPFVIEWLOGICTEMPL%2$s%3$s__%4$s", (Object)strRootFolder, (Object)File.separator, (Object)psPFViewLogicTempl.getPSVIEWLOGICTYPEID(), (Object)psPFViewLogicTempl.getPSPFPUBCODENAME());
    }

    @Override
    protected HashMap<String, String> getCodeTemplMap() throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("TEMPLCODE", "");
        map.put("TEMPLCODE2", "");
        map.put("TEMPLCODE3", "");
        map.put("TEMPLCODE4", "");
        return map;
    }
}


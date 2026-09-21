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

import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDetailDataCtrl
extends PSPFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDetailDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSPFCtrlTemplDetail psPFCtrlTemplDetail = new PSPFCtrlTemplDetail();
        psPFCtrlTemplDetail.proxy(dataEntity);
        BaseDataEntity psPFCtrlTempl = this.GetRelatedData("DE1802", psPFCtrlTemplDetail.getPSPFCTRLTEMPLID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1802");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psPFCtrlTempl);
        return StringHelper.Format((String)"%1$s%2$sPSPFCTRLTEMPLDETAIL%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)psPFCtrlTemplDetail.getPSPFCTDETAILNAME());
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


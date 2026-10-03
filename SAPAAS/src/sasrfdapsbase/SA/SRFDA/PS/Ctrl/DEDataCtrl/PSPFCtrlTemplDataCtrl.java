/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDataCtrl
extends PSPFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSPFCtrlTempl psPFCtrlTempl = new PSPFCtrlTempl();
            psPFCtrlTempl.proxy(dataEntity);
            String strPSPFCTRLTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s", (Object)psPFCtrlTempl.getPSPFNAME(), (Object)psPFCtrlTempl.getPSPFSTYLENAME(), (Object)psPFCtrlTempl.getPSCTRLTYPENAME(), (Object)psPFCtrlTempl.getPSPFPUBCODENAME());
            psPFCtrlTempl.setPSPFCTRLTEMPLNAME(strPSPFCTRLTEMPLNAME);
            psPFCtrlTempl.setPSPFCTRLTEMPLID(Helper.GenUniqueId((String)psPFCtrlTempl.getPSPFID(), (String)psPFCtrlTempl.getPSPFSTYLEID(), (String)psPFCtrlTempl.getPSCTRLTYPEID(), (String)psPFCtrlTempl.getPSPFPUBCODEID()));
        }
        return callResult;
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSPFCtrlTempl psPFCtrlTempl = new PSPFCtrlTempl();
        psPFCtrlTempl.proxy(dataEntity);
        BaseDataEntity psPFStyle = this.GetRelatedData("DE1595", psPFCtrlTempl.getPSPFSTYLEID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1595");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psPFStyle);
        return StringHelper.Format((String)"%1$s%2$sPSPFCTRLTEMPL%2$s%3$s__%4$s", (Object)strRootFolder, (Object)File.separator, (Object)psPFCtrlTempl.getPSCTRLTYPEID(), (Object)psPFCtrlTempl.getPSPFPUBCODENAME());
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

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSPFCtrlTemplId = dataEntity.getParamStringValue("PSPFCTRLTEMPLID", "");
        IDEDataCtrl iPSPFCtrlTemplDetailDataCtrl = this.GetRelatedDataCtrl("DE1803");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSPFCTRLTEMPLID", (Object)strPSPFCtrlTemplId);
        Vector<BaseDataEntity> psPFCtrlTemplDetailList = new Vector<BaseDataEntity>();
        iPSPFCtrlTemplDetailDataCtrl.Select(cond, psPFCtrlTemplDetailList);
        for (BaseDataEntity baseDataEntity : psPFCtrlTemplDetailList) {
            iPSPFCtrlTemplDetailDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }
}

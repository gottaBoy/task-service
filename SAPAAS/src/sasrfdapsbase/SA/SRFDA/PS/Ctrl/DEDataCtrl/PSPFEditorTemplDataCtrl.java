/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListConfig
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
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFEditorTemplDataCtrl
extends PSPFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSPFEditorTemplDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSPFEditorTempl psPFEditorTempl = new PSPFEditorTempl();
            psPFEditorTempl.proxy(dataEntity);
            CodeListConfig codeListConfig = this.getGlobalHelper().getCodeListMgr().GetCodeListConfig("CODELIST_DE1804_001");
            String strContainerType = psPFEditorTempl.getCONTAINERTYPE();
            if (StringHelper.IsNullOrEmpty((String)psPFEditorTempl.getPSPFSTYLEID())) {
                String strPSPFEDITORTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s", (Object)psPFEditorTempl.getPSPFNAME(), (Object)psPFEditorTempl.getPSEDITORTYPENAME(), (Object)codeListConfig.GetCodeListValue(strContainerType, true), (Object)psPFEditorTempl.getPSPFPUBCODENAME());
                psPFEditorTempl.setPSPFEDITORTEMPLNAME(strPSPFEDITORTEMPLNAME);
                psPFEditorTempl.setPSPFEDITORTEMPLID(Helper.GenUniqueId((String)psPFEditorTempl.getPSPFID(), (String)psPFEditorTempl.getPSEDITORTYPEID(), (String)strContainerType, (String)psPFEditorTempl.getPSPFPUBCODEID()));
            } else {
                String strPSPFEDITORTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s/%5$s", (Object)psPFEditorTempl.getPSPFNAME(), (Object)psPFEditorTempl.getPSPFSTYLENAME(), (Object)psPFEditorTempl.getPSEDITORTYPENAME(), (Object)codeListConfig.GetCodeListValue(strContainerType, true), (Object)psPFEditorTempl.getPSPFPUBCODENAME());
                psPFEditorTempl.setPSPFEDITORTEMPLNAME(strPSPFEDITORTEMPLNAME);
                psPFEditorTempl.setPSPFEDITORTEMPLID(Helper.GenUniqueId((String)psPFEditorTempl.getPSPFID(), (String)psPFEditorTempl.getPSPFSTYLEID(), (String)psPFEditorTempl.getPSEDITORTYPEID(), (String)strContainerType, (String)psPFEditorTempl.getPSPFPUBCODEID()));
            }
        }
        return callResult;
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSPFEditorTempl psPFEditorTempl = new PSPFEditorTempl();
        psPFEditorTempl.proxy(dataEntity);
        if (!StringHelper.IsNullOrEmpty((String)psPFEditorTempl.getPSPFSTYLEID())) {
            BaseDataEntity psPFStyle = this.GetRelatedData("DE1595", psPFEditorTempl.getPSPFSTYLEID(), false);
            IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1595");
            strRootFolder = iPSTemplDataCtrl.getTemplFolder(psPFStyle);
        } else {
            BaseDataEntity psPF = this.GetRelatedData("DE1503", psPFEditorTempl.getPSPFID(), false);
            IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1503");
            strRootFolder = iPSTemplDataCtrl.getTemplFolder(psPF);
        }
        return StringHelper.Format((String)"%1$s%2$sPSPFEDITORTEMPL%2$s%3$s__%4$s__%5$s", (Object)strRootFolder, (Object)File.separator, (Object)psPFEditorTempl.getPSEDITORTYPEID(), (Object)psPFEditorTempl.getCONTAINERTYPE(), (Object)psPFEditorTempl.getPSPFPUBCODENAME());
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


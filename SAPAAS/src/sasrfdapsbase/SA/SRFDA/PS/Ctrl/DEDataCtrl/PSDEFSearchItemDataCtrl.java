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
import SA.SRFDA.PS.Data.PSDEFSearchModeV3;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchItemDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEFSearchItemDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDEFSearchModeV3 psDEFSearchItem = new PSDEFSearchModeV3();
            psDEFSearchItem.proxy(dataEntity);
            String strPSDEFSearchItemName = "";
            if (StringHelper.IsNullOrEmpty((String)psDEFSearchItem.getPSSYSDBVFID())) {
                strPSDEFSearchItemName = StringHelper.Format((String)"N_%1$s_%2$s", (Object)psDEFSearchItem.getPSDEFNAME(), (Object)psDEFSearchItem.getPSDBVALUEOPID()).toUpperCase();
            }
            psDEFSearchItem.setPSDEFSFITEMNAME(strPSDEFSearchItemName);
            psDEFSearchItem.setPSDEFSFITEMID(Helper.GenUniqueId((String)psDEFSearchItem.getPSDEFID(), (String)strPSDEFSearchItemName));
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnBeforeRemove(strActionMode, dataEntity);
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnAfterRemoveOK(strActionMode, dataEntity);
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2051", (boolean)true) == 0) {
                String strPSDEFSearchItemName;
                PSDEFSearchModeV3 psDEFSearchItem;
                PSDEField psDEField = new PSDEField();
                psDEField.proxy(dataEntity);
                if (psDEField.getMAJORFIELD() == 1 || StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                    psDEFSearchItem = new PSDEFSearchModeV3();
                    psDEFSearchItem.setPSDEFID(psDEField.getPSDEFIELDID());
                    strPSDEFSearchItemName = StringHelper.Format((String)"N_%1$s_LIKE", (Object)psDEField.getPSDEFIELDNAME());
                    psDEFSearchItem.setPSDEFSFITEMNAME(strPSDEFSearchItemName);
                    psDEFSearchItem.setPSDEFSFITEMID(Helper.GenUniqueId((String)psDEFSearchItem.getPSDEFID(), (String)strPSDEFSearchItemName));
                    psDEFSearchItem.setPSDBVALUEOPID("LIKE");
                    psDEFSearchItem.setPSDEID(psDEField.getPSDEID());
                    psDEFSearchItem.setPSDENAME(psDEField.getPSDENAME());
                    psDEFSearchItem.setPSDEFNAME(psDEField.getPSDEFIELDNAME());
                    callResult = this.Get(psDEFSearchItem);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, psDEFSearchItem)).isError()) {
                        throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5c5e\u6027\u641c\u7d22\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                if (StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUPTEXT", (boolean)true) == 0 || StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"SSCODELIST", (boolean)true) == 0 || StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"NSCODELIST", (boolean)true) == 0) {
                    psDEFSearchItem = new PSDEFSearchModeV3();
                    psDEFSearchItem.setPSDEFID(psDEField.getPSDEFIELDID());
                    strPSDEFSearchItemName = StringHelper.Format((String)"N_%1$s_EQ", (Object)psDEField.getPSDEFIELDNAME());
                    psDEFSearchItem.setPSDEFSFITEMNAME(strPSDEFSearchItemName);
                    psDEFSearchItem.setPSDEFSFITEMID(Helper.GenUniqueId((String)psDEFSearchItem.getPSDEFID(), (String)strPSDEFSearchItemName));
                    psDEFSearchItem.setPSDBVALUEOPID("EQ");
                    psDEFSearchItem.setPSDEID(psDEField.getPSDEID());
                    psDEFSearchItem.setPSDENAME(psDEField.getPSDENAME());
                    psDEFSearchItem.setPSDEFNAME(psDEField.getPSDEFIELDNAME());
                    callResult = this.Get(psDEFSearchItem);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, psDEFSearchItem)).isError()) {
                        throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5c5e\u6027\u641c\u7d22\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                if (StringHelper.Compare((String)psDEField.getPSDATATYPEID(), (String)"PICKUP", (boolean)true) == 0) {
                    psDEFSearchItem = new PSDEFSearchModeV3();
                    psDEFSearchItem.setPSDEFID(psDEField.getPSDEFIELDID());
                    strPSDEFSearchItemName = StringHelper.Format((String)"N_%1$s_EQ", (Object)psDEField.getPSDEFIELDNAME());
                    psDEFSearchItem.setPSDEFSFITEMNAME(strPSDEFSearchItemName);
                    psDEFSearchItem.setPSDEFSFITEMID(Helper.GenUniqueId((String)psDEFSearchItem.getPSDEFID(), (String)strPSDEFSearchItemName));
                    psDEFSearchItem.setPSDBVALUEOPID("EQ");
                    psDEFSearchItem.setPSDEID(psDEField.getPSDEID());
                    psDEFSearchItem.setPSDENAME(psDEField.getPSDENAME());
                    psDEFSearchItem.setPSDEFNAME(psDEField.getPSDEFIELDNAME());
                    callResult = this.Get(psDEFSearchItem);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3) && (callResult = this.Save(true, psDEFSearchItem)).isError()) {
                        throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5c5e\u6027\u641c\u7d22\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                return callResult;
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


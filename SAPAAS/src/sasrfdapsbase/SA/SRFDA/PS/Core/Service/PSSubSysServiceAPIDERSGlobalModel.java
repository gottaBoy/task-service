/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDERSImpl;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIGlobalModelBase;
import SA.SRFDA.PS.Data.PSSubSysSADERS;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysServiceAPIDERSGlobalModel
extends PSSubSysServiceAPIGlobalModelBase<String, PSSubSysSADERS, IPSSubSysServiceAPIDERS> {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDERSGlobalModel.class);

    @Override
    protected PSSubSysSADERS GetObject(String strPSSubSysSADERSId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.warn((Object)StringHelper.Format((String)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb[%1$s]", (Object)strPSSubSysSADERSId));
        return null;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubSysSADERS obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSubSysSADERS vt) {
        return vt.getPSSUBSYSSADERSID();
    }

    @Override
    protected IPSSubSysServiceAPIDERS OnCreateModelHelper(PSSubSysSADERS vt, String strPSSubSysSADERSId) throws Exception {
        if (StringHelper.Compare((String)strPSSubSysSADERSId, (String)vt.getPSSUBSYSSADERSID(), (boolean)false) == 0) {
            PSSubSysServiceAPIDERSImpl iPSSubSysServiceAPIDERS = new PSSubSysServiceAPIDERSImpl();
            iPSSubSysServiceAPIDERS.init(this.iDAGlobalHelper, this.getPSSubSysServiceAPI(), vt);
            return iPSSubSysServiceAPIDERS;
        }
        return (IPSSubSysServiceAPIDERS)this.FindModelHelper(vt.getPSSUBSYSSADERSID());
    }

    @Override
    protected IPSSubSysServiceAPIDERS registerModel(PSSubSysSADERS vt) throws Exception {
        IPSSubSysServiceAPIDERS iPSSubSysSADERS = (IPSSubSysServiceAPIDERS)this.InternalGetModelHelper(vt.getPSSUBSYSSADERSID());
        if (iPSSubSysSADERS != null) {
            return iPSSubSysSADERS;
        }
        this.setModel(vt.getPSSUBSYSSADERSID(), vt, null);
        iPSSubSysSADERS = (IPSSubSysServiceAPIDERS)this.FindModelHelper(vt.getPSSUBSYSSADERSID());
        return iPSSubSysSADERS;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected Vector<PSSubSysSADERS> getAllModels() throws Exception {
        block8: {
            list = new Vector<PSSubSysSADERS>();
            callResult = this.iPSModelHelper.getPSSubSysSADERSs(this.getPSSubSysServiceAPI().getId(), list);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5168\u90e8\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
            if (!this.getPSSubSysServiceAPI().isFromDEModel() || (psSubSysServiceAPIDEs = this.getPSSubSysServiceAPI().getAllPSSubSysServiceAPIDEs()) == null) break block8;
            psSubSysSADERSMap = new HashMap<String, PSSubSysSADERS>();
            for (PSSubSysSADERS psSubSysSADERS : list) {
                psSubSysSADERSMap.put(String.format("%1$s|%2$s", new Object[]{psSubSysSADERS.getPPSSUBSYSSADEID(), psSubSysSADERS.getCPSSUBSYSSADEID()}), psSubSysSADERS);
            }
            psDataEntityMap = new HashMap<String, IPSDataEntity>();
            while (psSubSysServiceAPIDEs.hasNext()) {
                iPSSubSysServiceAPIDE = psSubSysServiceAPIDEs.next();
                if (!iPSSubSysServiceAPIDE.isAutoModel() || (iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(iPSSubSysServiceAPIDE.getId(), true)) == null) continue;
                psDataEntityMap.put(iPSSubSysServiceAPIDE.getId(), iPSDataEntity);
            }
            for (IPSDataEntity iPSDataEntity : psDataEntityMap.values()) {
                psDERBases = iPSDataEntity.getMajorPSDERs();
                if (psDERBases != null) ** GOTO lbl59
                continue;
lbl-1000:
                // 1 sources

                {
                    iPSDERBase = psDERBases.next();
                    minorPSDataEntity = (IPSDataEntity)psDataEntityMap.get(iPSDERBase.getMinorDEId());
                    if (minorPSDataEntity == null) continue;
                    if ("DER1N".equals(iPSDERBase.getDERType())) {
                        iPSDER1N = (IPSDER1N)iPSDERBase;
                        if ((iPSDER1N.getMasterRS() & 1) != 1) continue;
                        psSubSysSADERS = new PSSubSysSADERS();
                        strTag = String.format("%1$s__%2$s", new Object[]{iPSDataEntity.getName(), minorPSDataEntity.getName()});
                        psSubSysSADERS.setPSSUBSYSSADERSNAME(strTag);
                        psSubSysSADERS.setPSSUBSYSSADERSID(strTag);
                        psSubSysSADERS.setPPSSUBSYSSADEID(iPSDataEntity.getId());
                        psSubSysSADERS.setPPSSUBSYSSADENAME(iPSDataEntity.getName());
                        psSubSysSADERS.setCPSSUBSYSSADEID(minorPSDataEntity.getId());
                        psSubSysSADERS.setCPSSUBSYSSADENAME(minorPSDataEntity.getName());
                        psSubSysSADERS.setCODENAME(iPSDER1N.getMinorServiceCodeName());
                        psSubSysSADERS.setCHILDFILTER(iPSDER1N.getPSPickupDEField().getName());
                        psSubSysSADERS.set("AUTOMODEL", 1);
                        list.add(psSubSysSADERS);
                        continue;
                    }
                    if (!"DERCUSTOM".equals(iPSDERBase.getDERType()) || !"DER1N".equals((iPSDERCustom = (IPSDERCustom)iPSDERBase).getDERSubType()) || (iPSDERCustom.getMasterRS() & 1) != 1) continue;
                    psSubSysSADERS = new PSSubSysSADERS();
                    strTag = String.format("%1$s__%2$s", new Object[]{iPSDataEntity.getName(), minorPSDataEntity.getName()});
                    psSubSysSADERS.setPSSUBSYSSADERSNAME(strTag);
                    psSubSysSADERS.setPSSUBSYSSADERSID(strTag);
                    psSubSysSADERS.setPPSSUBSYSSADEID(iPSDataEntity.getId());
                    psSubSysSADERS.setPPSSUBSYSSADENAME(iPSDataEntity.getName());
                    psSubSysSADERS.setCPSSUBSYSSADEID(minorPSDataEntity.getId());
                    psSubSysSADERS.setCPSSUBSYSSADENAME(minorPSDataEntity.getName());
                    psSubSysSADERS.setCODENAME(iPSDERCustom.getMinorServiceCodeName());
                    if (iPSDERCustom.getPickupPSDEField() != null) {
                        psSubSysSADERS.setCHILDFILTER(iPSDERCustom.getPickupPSDEField().getName());
                    } else {
                        psSubSysSADERS.setCHILDFILTER(iPSDERCustom.getPickupDEFName());
                    }
                    psSubSysSADERS.set("AUTOMODEL", 1);
                    list.add(psSubSysSADERS);
lbl59:
                    // 6 sources

                    ** while (psDERBases.hasNext())
                }
lbl60:
                // 1 sources

            }
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5168\u90e8\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }
}


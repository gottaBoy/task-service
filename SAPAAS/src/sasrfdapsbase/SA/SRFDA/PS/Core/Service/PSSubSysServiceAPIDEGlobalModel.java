/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDEImpl;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIGlobalModelBase;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSSubSysSADE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.LinkedHashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysServiceAPIDEGlobalModel
extends PSSubSysServiceAPIGlobalModelBase<String, PSSubSysSADE, IPSSubSysServiceAPIDE> {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDEGlobalModel.class);

    @Override
    protected PSSubSysSADE GetObject(String strPSSubSysSADEId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.warn((Object)StringHelper.Format((String)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53[%1$s]", (Object)strPSSubSysSADEId));
        return null;
    }

    @Override
    protected IPSSubSysServiceAPIDE OnCreateModelHelper(PSSubSysSADE vt, String strPSSubSysSADEId) throws Exception {
        if (StringHelper.Compare((String)strPSSubSysSADEId, (String)vt.getPSSUBSYSSADEID(), (boolean)false) == 0) {
            PSSubSysServiceAPIDEImpl iPSSubSysServiceAPIDE = new PSSubSysServiceAPIDEImpl();
            iPSSubSysServiceAPIDE.init(this.iDAGlobalHelper, this.getPSSubSysServiceAPI(), vt);
            return iPSSubSysServiceAPIDE;
        }
        return (IPSSubSysServiceAPIDE)this.FindModelHelper(vt.getPSSUBSYSSADEID());
    }

    @Override
    protected Boolean TestObjectRenew(PSSubSysSADE obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSubSysSADE vt) {
        return vt.getPSSUBSYSSADEID();
    }

    @Override
    protected IPSSubSysServiceAPIDE registerModel(PSSubSysSADE vt) throws Exception {
        IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = (IPSSubSysServiceAPIDE)this.InternalGetModelHelper(vt.getPSSUBSYSSADEID());
        if (iPSSubSysServiceAPIDE != null) {
            return iPSSubSysServiceAPIDE;
        }
        this.setModel(vt.getPSSUBSYSSADEID(), vt, null);
        iPSSubSysServiceAPIDE = (IPSSubSysServiceAPIDE)this.FindModelHelper(vt.getPSSUBSYSSADEID());
        return iPSSubSysServiceAPIDE;
    }

    @Override
    protected Vector<PSSubSysSADE> getAllModels() throws Exception {
        Vector<PSSubSysSADE> list = new Vector<PSSubSysSADE>();
        CallResult callResult = this.iPSModelHelper.getPSSubSysSADEs(this.getPSSubSysServiceAPI().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u63a5\u53e3\u5168\u90e8\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.getPSSubSysServiceAPI().isFromDEModel()) {
            Vector<PSDataEntity> psDataEntityList = new Vector<PSDataEntity>();
            callResult = this.iPSModelHelper.getAllPSDataEntities(this.getPSSubSysServiceAPI().getPSSystem().getId(), psDataEntityList);
            if (callResult.isOk()) {
                LinkedHashMap<String, PSSubSysSADE> psSubSysSADEMap = new LinkedHashMap<String, PSSubSysSADE>();
                for (PSSubSysSADE psSubSysSADE : list) {
                    psSubSysSADEMap.put(psSubSysSADE.getPSSUBSYSSADENAME().toUpperCase(), psSubSysSADE);
                }
                for (PSSubSysSADE psSubSysSADE : list) {
                    if (StringHelper.IsNullOrEmpty((String)psSubSysSADE.getCODENAME())) continue;
                    psSubSysSADEMap.put(psSubSysSADE.getCODENAME(), psSubSysSADE);
                }
                for (PSDataEntity psDataEntity : psDataEntityList) {
                    if (StringHelper.IsNullOrEmpty((String)psDataEntity.getPSSUBSYSSERVICEAPIID()) || !StringHelper.IsNullOrEmpty((String)psDataEntity.getPSSUBSYSSADEID()) || StringHelper.Compare((String)psDataEntity.getPSSUBSYSSERVICEAPIID(), (String)this.getPSSubSysServiceAPI().getId(), (boolean)false) != 0 || psSubSysSADEMap.containsKey(psDataEntity.getPSDATAENTITYNAME().toUpperCase()) || !StringHelper.IsNullOrEmpty((String)psDataEntity.getCODENAME()) && psSubSysSADEMap.containsKey(psDataEntity.getCODENAME())) continue;
                    PSSubSysSADE psSubSysSADE = new PSSubSysSADE();
                    psSubSysSADE.setPSSUBSYSSADENAME(psDataEntity.getPSDATAENTITYNAME().toUpperCase());
                    psSubSysSADE.setPSSUBSYSSERVICEAPIID(this.getPSSubSysServiceAPI().getId());
                    psSubSysSADE.setCODENAME(psDataEntity.getCODENAME());
                    psSubSysSADE.setLOGICNAME(psDataEntity.getLOGICNAME());
                    psSubSysSADE.setVALIDFLAG(true);
                    psSubSysSADE.setPSSUBSYSSADEID(psDataEntity.getPSDATAENTITYID());
                    psSubSysSADE.set("AUTOMODEL", 1);
                    psSubSysSADEMap.put(psSubSysSADE.getPSSUBSYSSADENAME().toUpperCase(), psSubSysSADE);
                    if (!StringHelper.IsNullOrEmpty((String)psSubSysSADE.getCODENAME())) {
                        psSubSysSADEMap.put(psSubSysSADE.getCODENAME(), psSubSysSADE);
                    }
                    list.add(psSubSysSADE);
                }
            }
        }
        for (PSSubSysSADE psSubSysSADE : list) {
            this.setModel(psSubSysSADE.getPSSUBSYSSADEID(), psSubSysSADE, null);
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
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5168\u90e8\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSubSysSADE vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSSUBSYSSADENAME())) {
            return new String[]{vt.getPSSUBSYSSADENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}


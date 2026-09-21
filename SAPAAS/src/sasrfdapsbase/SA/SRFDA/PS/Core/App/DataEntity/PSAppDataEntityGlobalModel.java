/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDataEntityGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppLocalDE, IPSAppDataEntity> {
    private static final Log log = LogFactory.getLog(PSAppDataEntityGlobalModel.class);

    @Override
    protected PSAppLocalDE GetObject(String strPSAppLocalDEId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppLocalDE psAppLocalDE = new PSAppLocalDE();
        CallResult callResult = this.iPSModelHelper.getPSAppLocalDE(strPSAppLocalDEId, psAppLocalDE);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppLocalDEId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psAppLocalDE;
    }

    @Override
    protected IPSAppDataEntity OnCreateModelHelper(PSAppLocalDE vt, String strPSAppLocalDEId) throws Exception {
        if (StringHelper.Compare((String)strPSAppLocalDEId, (String)vt.getPSAPPLOCALDEID(), (boolean)false) == 0) {
            PSAppDataEntityImpl iPSAppDataEntity = new PSAppDataEntityImpl();
            this.setModel(strPSAppLocalDEId, vt, iPSAppDataEntity);
            try {
                iPSAppDataEntity.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
                return iPSAppDataEntity;
            }
            catch (Exception ex) {
                this.setModel(strPSAppLocalDEId, vt, null);
                throw ex;
            }
        }
        return (IPSAppDataEntity)this.FindModelHelper(vt.getPSAPPLOCALDEID());
    }

    @Override
    protected Boolean TestObjectRenew(PSAppLocalDE obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppLocalDE vt) {
        return vt.getPSAPPLOCALDEID();
    }

    @Override
    protected IPSAppDataEntity registerModel(PSAppLocalDE vt) throws Exception {
        IPSAppDataEntity iPSAppDataEntity = (IPSAppDataEntity)this.InternalGetModelHelper(vt.getPSAPPLOCALDEID());
        if (iPSAppDataEntity != null) {
            return iPSAppDataEntity;
        }
        this.setModel(vt.getPSAPPLOCALDEID(), vt, null);
        iPSAppDataEntity = (IPSAppDataEntity)this.FindModelHelper(vt.getPSAPPLOCALDEID());
        return iPSAppDataEntity;
    }

    @Override
    protected Vector<PSAppLocalDE> getAllModels() throws Exception {
        Vector<PSAppLocalDE> list = new Vector<PSAppLocalDE>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppLocalDEs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppLocalDE psAppLocalDE : list) {
            if (!psAppLocalDE.isDEFAULTFLAGNull()) continue;
            boolean bDefault = StringHelper.Compare((String)psAppLocalDE.getPSAPPLOCALDEID(), (String)KeyValueHelper.genUniqueId((String)psAppLocalDE.getPSSYSAPPID(), (String)psAppLocalDE.getPSDEID()), (boolean)false) == 0;
            psAppLocalDE.setDEFAULTFLAG(bDefault);
        }
        HashMap<String, PSAppLocalDE> defaultPSAppLocalDEMap = new HashMap<String, PSAppLocalDE>();
        for (PSAppLocalDE psAppLocalDE : list) {
            if (!psAppLocalDE.getDEFAULTFLAG()) continue;
            defaultPSAppLocalDEMap.put(psAppLocalDE.getPSDEID(), psAppLocalDE);
        }
        for (PSAppLocalDE psAppLocalDE : list) {
            if (psAppLocalDE.getDEFAULTFLAG() || defaultPSAppLocalDEMap.containsKey(psAppLocalDE.getPSDEID())) continue;
            psAppLocalDE.setDEFAULTFLAG(true);
            defaultPSAppLocalDEMap.put(psAppLocalDE.getPSDEID(), psAppLocalDE);
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
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5168\u90e8\u5e94\u7528\u5b9e\u4f53\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40011, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppLocalDE vt) {
        String strId;
        String strDefaultId = null;
        if (vt.getDEFAULTFLAG() && StringHelper.Compare((String)(strId = KeyValueHelper.genUniqueId((String)vt.getPSSYSAPPID(), (String)vt.getPSDEID())), (String)vt.getPSAPPLOCALDEID(), (boolean)false) != 0) {
            strDefaultId = strId;
        }
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSAPPLOCALDENAME())) {
            if (StringHelper.IsNullOrEmpty(strDefaultId)) {
                return new String[]{vt.getPSAPPLOCALDENAME().toUpperCase()};
            }
            return new String[]{vt.getPSAPPLOCALDENAME().toUpperCase(), strDefaultId.toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}


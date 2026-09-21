/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BackService;

import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.BackService.PSSysBackServiceImpl;
import SA.SRFDA.PS.Core.PSSystemException;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBackService;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBackServiceGlobalModel
extends PSSystemGlobalModelBase<String, PSSysBackService, IPSSysBackService> {
    private static final Log log = LogFactory.getLog(PSSysBackServiceGlobalModel.class);

    @Override
    protected PSSysBackService GetObject(String strPSSysBackServiceId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysBackService psSysBackService = new PSSysBackService();
        CallResult callResult = this.iPSModelHelper.getPSSysBackService(strPSSysBackServiceId, psSysBackService);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysBackServiceId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSSystem().getId(), (String)psSysBackService.getPSSYSTEMID(), (boolean)false) != 0) {
            return null;
        }
        return psSysBackService;
    }

    @Override
    protected IPSSysBackService OnCreateModelHelper(PSSysBackService vt) throws Exception {
        PSSysBackServiceImpl iPSSysBackService = null;
        iPSSysBackService = new PSSysBackServiceImpl();
        iPSSysBackService.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysBackService;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBackService obj) {
        return false;
    }

    @Override
    protected IPSSysBackService registerModel(PSSysBackService vt) throws Exception {
        IPSSysBackService iIPSSysBackService = (IPSSysBackService)this.InternalGetModelHelper(vt.getPSSYSBACKSERVICEID());
        if (iIPSSysBackService != null) {
            return iIPSSysBackService;
        }
        this.setModel(vt.getPSSYSBACKSERVICEID(), vt, null);
        return (IPSSysBackService)this.FindModelHelper(vt.getPSSYSBACKSERVICEID());
    }

    @Override
    protected Vector<PSSysBackService> getAllModels() throws Exception {
        Vector<PSSysBackService> list = new Vector<PSSysBackService>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysBackServices(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.getPSSystem().isEnableModelRT()) {
            PSSysBackService psSysBackService2;
            HashMap<String, PSSysBackService> psSysBackServiceMap = new HashMap<String, PSSysBackService>();
            for (PSSysBackService psSysBackService2 : list) {
                if (StringHelper.Compare((String)psSysBackService2.getTASKTYPE(), (String)"PREDEFINED", (boolean)false) != 0 || StringHelper.IsNullOrEmpty((String)psSysBackService2.getPREDEFINEDTYPE())) continue;
                psSysBackServiceMap.put(psSysBackService2.getPREDEFINEDTYPE(), psSysBackService2);
            }
            if (!psSysBackServiceMap.containsKey("DENOTIFY")) {
                psSysBackService2 = new PSSysBackService();
                psSysBackService2.setPSSYSBACKSERVICEID("DENOTIFY");
                psSysBackService2.setPSSYSBACKSERVICENAME("\u5b9e\u4f53\u901a\u77e5\u5b9a\u65f6\u8c03\u5ea6");
                psSysBackService2.setPREDEFINEDTYPE("DENOTIFY");
                psSysBackService2.setTASKTYPE("PREDEFINED");
                psSysBackService2.setSERVICECONTAINER("SC01");
                psSysBackService2.setSTARTMODE("AUTO");
                psSysBackService2.setTIMERMODE(1);
                psSysBackService2.setTIMERPOLICY("0 */10 * * * ?");
                psSysBackService2.setCODENAME("DENotifyDeamon");
                list.add(psSysBackService2);
            }
            if (!psSysBackServiceMap.containsKey("SYSDATASYNCAGENT")) {
                psSysBackService2 = new PSSysBackService();
                psSysBackService2.setPSSYSBACKSERVICEID("SYSDATASYNCAGENT");
                psSysBackService2.setPSSYSBACKSERVICENAME("\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\uff08\u8f93\u5165\uff09");
                psSysBackService2.setPREDEFINEDTYPE("SYSDATASYNCAGENT");
                psSysBackService2.setTASKTYPE("PREDEFINED");
                psSysBackService2.setSERVICECONTAINER("SC01");
                psSysBackService2.setSTARTMODE("AUTO");
                psSysBackService2.setTIMERMODE(0);
                psSysBackService2.setCODENAME("SysDataSyncAgentDeamon");
                list.add(psSysBackService2);
            }
            if (!psSysBackServiceMap.containsKey("WFCALLBACK")) {
                psSysBackService2 = new PSSysBackService();
                psSysBackService2.setPSSYSBACKSERVICEID("WFCALLBACK");
                psSysBackService2.setPSSYSBACKSERVICENAME("\u5de5\u4f5c\u6d41\u56de\u8c03");
                psSysBackService2.setPREDEFINEDTYPE("WFCALLBACK");
                psSysBackService2.setTASKTYPE("PREDEFINED");
                psSysBackService2.setSERVICECONTAINER("SC01");
                psSysBackService2.setSTARTMODE("AUTO");
                psSysBackService2.setTIMERMODE(0);
                psSysBackService2.setCODENAME("WFCallbackDeamon");
                list.add(psSysBackService2);
            }
            if (!psSysBackServiceMap.containsKey("SYSADMIN")) {
                psSysBackService2 = new PSSysBackService();
                psSysBackService2.setPSSYSBACKSERVICEID("SYSADMIN");
                psSysBackService2.setPSSYSBACKSERVICENAME("\u7cfb\u7edf\u7ba1\u7406");
                psSysBackService2.setPREDEFINEDTYPE("SYSADMIN");
                psSysBackService2.setTASKTYPE("PREDEFINED");
                psSysBackService2.setSERVICECONTAINER("SC01");
                psSysBackService2.setSTARTMODE("AUTO");
                psSysBackService2.setTIMERMODE(0);
                psSysBackService2.setCODENAME("SysAdminDeamon");
                list.add(psSysBackService2);
            }
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBackService vt) {
        return vt.getPSSYSBACKSERVICEID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSSystemException.create(this.getPSSystem(), 10003, objObjectId);
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysBackService vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}


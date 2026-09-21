/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuItemDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSAppMenuItemDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSAppMenuItem psAppMenuItem = new PSAppMenuItem();
        psAppMenuItem.proxy(dataEntity);
        String strPPSAppMenuItemId = psAppMenuItem.getPPSAPPMENUITEMID();
        String strPSAppMenuId = psAppMenuItem.getPSAPPMENUID();
        String strDetailType = psAppMenuItem.getAMITEMTYPE();
        if (StringHelper.IsNullOrEmpty((String)strDetailType) && lastDataEntity != null) {
            strDetailType = lastDataEntity.getParamStringValue("AMITEMTYPE", "");
        }
        try {
            if (bInsert) {
                if (StringHelper.IsNullOrEmpty((String)strPSAppMenuId) && !StringHelper.IsNullOrEmpty((String)strPPSAppMenuItemId)) {
                    PSAppMenuItem psAppMenuItem2 = new PSAppMenuItem();
                    psAppMenuItem2.setPSAPPMENUITEMID(strPPSAppMenuItemId);
                    callResult = this.Get(psAppMenuItem2);
                    if (callResult.isError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7236\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    strPSAppMenuId = psAppMenuItem2.getPSAPPMENUID();
                    psAppMenuItem.setPSAPPMENUID(strPSAppMenuId);
                    psAppMenuItem.setPSAPPMENUNAME(psAppMenuItem2.getPSAPPMENUNAME());
                }
                if (StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPSAPPMENUITEMNAME())) {
                    String strName;
                    BaseDataEntity cond = new BaseDataEntity();
                    cond.setParamValue("PSAPPMENUID", (Object)strPSAppMenuId);
                    Vector psAppMenuItemList = new Vector();
                    callResult = this.Select(cond, psAppMenuItemList, PSAppMenuItem.class.getName(), "UPPER(PSAPPMENUITEMNAME) LIKE '" + strDetailType + "%'", "");
                    if (callResult.isError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u540c\u7c7b\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    HashMap<String, PSAppMenuItem> psAppMenuItemMap = new HashMap<String, PSAppMenuItem>();
                    for (PSAppMenuItem psAppMenuItem2 : psAppMenuItemList) {
                        psAppMenuItemMap.put(psAppMenuItem2.getPSAPPMENUITEMNAME().toUpperCase(), psAppMenuItem2);
                    }
                    int i = 0;
                    do {
                        strName = "";
                    } while (psAppMenuItemMap.containsKey(strName = StringHelper.Format((String)"%1$s%2$s", (Object)strDetailType, (Object)(++i))));
                    psAppMenuItem.setPSAPPMENUITEMNAME(strName.toLowerCase());
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)ex.getMessage(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        String strDetailType = webContext.GetParamValue("AMITEMTYPE");
        dataEntity.setParamValue("AMITEMTYPE", (Object)strDetailType);
        return super.GetDefault(webContext, dataEntity);
    }
}


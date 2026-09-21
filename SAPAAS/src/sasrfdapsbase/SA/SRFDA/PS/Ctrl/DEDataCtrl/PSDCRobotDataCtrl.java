/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotLog
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotLog;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCRobotDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCRobotDataCtrl.class);
    public static final String CUSTOMCALL_INCENERGY = "INCENERGY";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INCENERGY, (boolean)true) == 0) {
            return this.increaseEnergy(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult increaseEnergy(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        boolean bCreateWebContext = false;
        try {
            if (WebContext.getCurrent() == null) {
                SimpleWebContext simpleWebContext = new SimpleWebContext();
                simpleWebContext.setSessionValue("SRFPERSONID", (Object)"SYSTEM");
                simpleWebContext.setSessionValue("SRFLOGINNAME", (Object)"SYSTEM");
                simpleWebContext.setSessionValue("SRFUSERNAME", (Object)"\u7cfb\u7edf\u5185\u7f6e\u7528\u6237");
                WebContext.setCurrent((IWebContext)simpleWebContext);
                bCreateWebContext = true;
            }
            SA.SRFDA.PS.Data.PSDCRobot psDCRobot = new SA.SRFDA.PS.Data.PSDCRobot();
            psDCRobot.proxy(dataEntity);
            this.onIncreaseEnergy(psDCRobot);
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            return callResult;
        }
        catch (Exception ex) {
            if (bCreateWebContext) {
                WebContext.setCurrent(null);
            }
            log.error((Object)StringHelper.Format((String)"\u5e94\u7528\u4e2d\u5fc3\u673a\u5668\u4eba\u589e\u52a0\u80fd\u91cf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onIncreaseEnergy(SA.SRFDA.PS.Data.PSDCRobot psDCRobot) throws Exception {
        ArrayList<PSDCRobotLog> psDCRobotLogList = new ArrayList<PSDCRobotLog>();
        PSDCRobotLog psDCRobotLog = new PSDCRobotLog();
        psDCRobotLog.setLogType(CUSTOMCALL_INCENERGY);
        psDCRobotLog.setEnergy(Integer.valueOf(5000));
        psDCRobotLog.setPSDCRobotId(psDCRobot.getPSDCROBOTID());
        psDCRobotLog.setPSDCRobotName(psDCRobot.getPSDCROBOTNAME());
        psDCRobotLog.setPSDCRobotLogName("\u589e\u52a0\u80fd\u91cf[5000]");
        psDCRobotLogList.add(psDCRobotLog);
        PSDCRobot psDCRobot2 = new PSDCRobot();
        psDCRobot2.setPSDCRobotId(psDCRobot.getPSDCROBOTID());
        PSDCRobotService psDCRobotService = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class);
        if (!psDCRobotService.logPSDCRobotActions(psDCRobot2, psDCRobotLogList)) {
            throw new Exception("\u673a\u5668\u4eba\u65e0\u6cd5\u5145\u80fd");
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.TM.Ctrl.Data.TMBTPRJ;
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.Data.TMBTPlan;
import SA.TM.Ctrl.Data.TMBTPlanMT;
import SA.TM.Ctrl.Data.TMBTPlanTask;
import SA.TM.Ctrl.Data.TMBTTask;
import SA.TM.Ctrl.Data.TMBTTaskRes;
import SA.TM.Ctrl.Data.TMBookingTest;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMBTMainTaskInstPlanHelper;
import SA.TM.Ctrl.ITMBTPRJInstHelper;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTProjectHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstPlanHelper;
import SA.TM.Ctrl.ITMBTTaskResHelper;
import SA.TM.Ctrl.TMBTMainTaskInstPlanHelper;
import SA.TM.Ctrl.TMBTPRJInstHelper;
import SA.TM.Ctrl.TMBTPlanHelper;
import SA.TM.Ctrl.TMBTProjectHelper;
import SA.TM.Ctrl.TMBTTaskInstPlanHelper;
import SA.TM.Ctrl.TMBTTaskResHelper;

public class TMObjectFactory {
    private static TMObjectFactory tmObjectFactory = new TMObjectFactory();

    public static TMObjectFactory getCurrent() throws Exception {
        return tmObjectFactory;
    }

    public ITMBTPlanHelper CreateBTPlanHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPlan tmBTPlan) throws Exception {
        TMBTPlanHelper iTMBTPlanHelper = new TMBTPlanHelper();
        iTMBTPlanHelper.Init(iDAGlobalHelper, tmBTPlan);
        return iTMBTPlanHelper;
    }

    public ITMBTProjectHelper CreateBTProjectHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPRJ tmBTPRJ) throws Exception {
        TMBTProjectHelper iTMBTProjectHelper = new TMBTProjectHelper();
        iTMBTProjectHelper.Init(iDAGlobalHelper, tmBTPRJ);
        return iTMBTProjectHelper;
    }

    public ITMBTPRJInstHelper CreateBTPRJInstHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPRJInst tmBTPRJInst) throws Exception {
        TMBTPRJInstHelper tmBTPRJInstHelper = new TMBTPRJInstHelper();
        tmBTPRJInstHelper.Init(iDAGlobalHelper, tmBTPRJInst);
        return tmBTPRJInstHelper;
    }

    public ITMBTMainTaskInstHelper CreateBTMainTaskInstHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBookingTest tmBookingTest) throws Exception {
        ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper = (ITMBTMainTaskInstHelper)ObjectHelper.Create((String)"SA.CRM.TM.Ctrl.CRMTMBTClassTaskInstHelper");
        iTMBTMainTaskInstHelper.Init(iDAGlobalHelper, tmBookingTest);
        return iTMBTMainTaskInstHelper;
    }

    public ITMBTTaskInstHelper CreateBTTaskInstHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBTTask tmBTTask) throws Exception {
        ITMBTTaskInstHelper iTMBTTaskInstHelper = (ITMBTTaskInstHelper)ObjectHelper.Create((String)"SA.TM.Ctrl.TMBTTaskInstHelper");
        iTMBTTaskInstHelper.Init(iDAGlobalHelper, tmBTTask);
        return iTMBTTaskInstHelper;
    }

    public ITMBTMainTaskInstPlanHelper CreateBTMainTaskInstPlanHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPlanMT tmBTPlanMT) throws Exception {
        TMBTMainTaskInstPlanHelper iTMBTMainTaskInstPlanHelper = new TMBTMainTaskInstPlanHelper();
        iTMBTMainTaskInstPlanHelper.Init(iDAGlobalHelper, tmBTPlanMT);
        return iTMBTMainTaskInstPlanHelper;
    }

    public ITMBTTaskInstPlanHelper CreateBTTaskInstPlanHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPlanTask tmBTPlanTask) throws Exception {
        TMBTTaskInstPlanHelper iTMBTTaskInstPlanHelper = new TMBTTaskInstPlanHelper();
        iTMBTTaskInstPlanHelper.Init(iDAGlobalHelper, tmBTPlanTask);
        return iTMBTTaskInstPlanHelper;
    }

    public ITMBTTaskResHelper CreateBTTaskResHelper(ISRFDAGlobalHelper iDAGlobalHelper, TMBTTaskRes tmBTTaskRes) throws Exception {
        TMBTTaskResHelper iTMBTTaskResHelper = new TMBTTaskResHelper();
        iTMBTTaskResHelper.Init(iDAGlobalHelper, tmBTTaskRes);
        return iTMBTTaskResHelper;
    }
}


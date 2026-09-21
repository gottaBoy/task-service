/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.ISOAServiceDataCtrl;
import SA.SRFDA.Ctrl.Data.SOAService;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class SOAServiceDataCtrl
extends BaseDEDataCtrl
implements ISOAServiceDataCtrl {
    @Override
    public CallResult SelectAutoStartService(Vector<SOAService> list) {
        String strSQL = "SELECT * from V_SRFSOASERVICE WHERE STARTMODE='AUTO' ";
        return BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, "", strSQL, null, list, SOAService.class.getName());
    }

    @Override
    public CallResult MarkServiceStart(String strServiceId) {
        SOAService service = new SOAService();
        service.setSOASERVICEID(strServiceId);
        service.setSERVICESTATE("START");
        return this.Save(false, service);
    }

    @Override
    public CallResult MarkServiceStop(String strServiceId) {
        SOAService service = new SOAService();
        service.setSOASERVICEID(strServiceId);
        service.setSERVICESTATE("STOP");
        return this.Save(false, service);
    }
}


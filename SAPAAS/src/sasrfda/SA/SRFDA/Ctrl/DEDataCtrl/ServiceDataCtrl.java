/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IServiceDataCtrl;
import SA.SRFDA.Ctrl.Data.Service;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class ServiceDataCtrl
extends BaseDEDataCtrl
implements IServiceDataCtrl {
    @Override
    public CallResult SelectAutoStartService(String strContainer, Vector<Service> list) {
        String strSQL = "";
        CallParamList paramList = new CallParamList();
        if (StringHelper.IsNullOrEmpty((String)strContainer)) {
            strSQL = "SELECT * from V_SRFSERVICE WHERE STARTMODE='AUTO' AND CONTAINER IS NULL  ORDER BY RUNORDER";
        } else {
            strSQL = "SELECT * from V_SRFSERVICE WHERE STARTMODE='AUTO' AND (CONTAINER IS NULL OR UPPER(CONTAINER) = ?) ORDER BY RUNORDER";
            paramList.AddString(strContainer);
        }
        return BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, "", strSQL, paramList.GetList(), list, Service.class.getName());
    }

    @Override
    public CallResult MarkServiceStart(String strServiceId) {
        Service service = new Service();
        service.setSERVICEID(strServiceId);
        service.setSERVICESTATE("START");
        return this.Save(false, service);
    }

    @Override
    public CallResult MarkServiceStop(String strServiceId) {
        Service service = new Service();
        service.setSERVICEID(strServiceId);
        service.setSERVICESTATE("STOP");
        return this.Save(false, service);
    }
}


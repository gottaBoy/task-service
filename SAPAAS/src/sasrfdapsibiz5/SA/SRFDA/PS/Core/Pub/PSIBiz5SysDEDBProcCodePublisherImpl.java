/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction
 *  SA.SRFDA.PS.Core.DataEntity.Action.IPSDEDBSysProcAction
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEDBSysProcAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEDBProcCodePublisherImpl
extends PSIBiz5SysDECodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEActions = iPSDataEntity.getAllPSDEActions();
        if (psDEActions != null) {
            while (psDEActions.hasNext()) {
                IPSDEAction iPSDEAction = (IPSDEAction)psDEActions.next();
                if (StringHelper.Compare((String)"SYSDBPROC", (String)iPSDEAction.getActionType(), (boolean)true) != 0) continue;
                HashMap params = new HashMap();
                IPSDEDBSysProcAction iPSDEDBSysProcAction = (IPSDEDBSysProcAction)iPSDEAction;
                this.savePSSysSFCode(iPSDEDBSysProcAction, null, params);
            }
        }
    }
}


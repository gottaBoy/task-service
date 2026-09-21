/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI
 *  SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod
 *  SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAPIDEAPICodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAPIDEAPIMethodCodePublisherImpl
extends PSIBiz5SysAPIDEAPICodePublisherImpl {
    @Override
    protected void onGenerateDEServiceAPICode(IPSDEServiceAPI iPSDEServiceAPI, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEServiceAPIRSs;
        Iterator psDEServiceAPIMethods = iPSDEServiceAPI.getPSDEServiceAPIMethods();
        if (psDEServiceAPIMethods != null) {
            while (psDEServiceAPIMethods.hasNext()) {
                IPSDEServiceAPIMethod iPSDEServiceAPIMethod = (IPSDEServiceAPIMethod)psDEServiceAPIMethods.next();
                this.onGenerateDEServiceAPICode(iPSDEServiceAPIMethod, list);
            }
        }
        if ((psDEServiceAPIRSs = iPSDEServiceAPI.getMinorPSDEServiceAPIRSs()) != null) {
            while (psDEServiceAPIRSs.hasNext()) {
                IPSDEServiceAPIRS iPSDEServiceAPIRS = (IPSDEServiceAPIRS)psDEServiceAPIRSs.next();
                Iterator psDEServiceAPIMethods2 = iPSDEServiceAPIRS.getPSDEServiceAPIMethods();
                if (psDEServiceAPIMethods2 == null) continue;
                while (psDEServiceAPIMethods2.hasNext()) {
                    IPSDEServiceAPIMethod iPSDEServiceAPIMethod = (IPSDEServiceAPIMethod)psDEServiceAPIMethods2.next();
                    this.onGenerateDEServiceAPICode(iPSDEServiceAPIMethod, list);
                }
            }
        }
    }

    protected void onGenerateDEServiceAPICode(IPSDEServiceAPIMethod iPSDEServiceAPIMethod, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEServiceAPIMethod, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEMainStateCodePublisherImpl
extends PSIBiz5SysDECodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEMainStates = iPSDataEntity.getAllPSDEMainStates();
        if (psDEMainStates != null) {
            while (psDEMainStates.hasNext()) {
                IPSDEMainState iPSDEMainState = (IPSDEMainState)psDEMainStates.next();
                this.generateCode(iPSDEMainState, list);
            }
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDEMainState) {
            IPSDEMainState iPSDEMainState = (IPSDEMainState)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSDEMainState, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSDEMainState iPSDEMainState, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDEMainState.getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEMainState, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SubSysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SubSysDELogicModelCodePublisherImpl
extends PSIBiz5SubSysDECodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDELogics = iPSDataEntity.getAllPSDELogics();
        while (psDELogics.hasNext()) {
            IPSDELogic iPSDELogic = (IPSDELogic)psDELogics.next();
            if (iPSDELogic.getExtendMode() != 2) continue;
            this.generateCode(iPSDELogic, list);
        }
    }

    protected void generateCode(IPSDELogic iPSDELogic, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDELogic.getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDELogic, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDELogic) {
            IPSDELogic iPSDELogic = (IPSDELogic)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            if (iPSDELogic.getExtendMode() != 2) {
                return null;
            }
            this.generateCode(iPSDELogic, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }
}


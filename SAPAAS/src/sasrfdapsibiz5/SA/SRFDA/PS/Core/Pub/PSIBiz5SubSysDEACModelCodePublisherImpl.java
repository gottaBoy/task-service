/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SubSysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SubSysDEACModelCodePublisherImpl
extends PSIBiz5SubSysDECodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEACModes = iPSDataEntity.getAllPSDEACModes();
        while (psDEACModes.hasNext()) {
            IPSDEACMode iPSDEACMode = (IPSDEACMode)psDEACModes.next();
            if (iPSDEACMode.getExtendMode() != 2) continue;
            this.generateCode(iPSDEACMode, list);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDEACMode) {
            IPSDEACMode iPSDEACMode = (IPSDEACMode)iPSObject;
            if (iPSDEACMode.getExtendMode() != 2) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSDEACMode, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSDEACMode iPSDEACMode, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDEACMode.getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEACMode, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}


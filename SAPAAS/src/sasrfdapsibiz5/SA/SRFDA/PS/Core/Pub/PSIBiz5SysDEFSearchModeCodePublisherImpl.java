/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDEFCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEFSearchModeCodePublisherImpl
extends PSIBiz5SysDEFCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDEField iPSDEField, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes();
        if (psDEFSearchModes != null) {
            while (psDEFSearchModes.hasNext()) {
                IPSDEFSearchMode iPSDEFSearchMode = (IPSDEFSearchMode)psDEFSearchModes.next();
                this.onGenerateCode(iPSDEFSearchMode, list);
            }
        }
    }

    protected void onGenerateCode(IPSDEFSearchMode iPSDEFSearchMode, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDEFSearchMode.getPSDEField().getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEFSearchMode, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.IPSDEFUIMode
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDEFCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEFUIModeCodePublisherImpl
extends PSIBiz5SysDEFCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDEField iPSDEField, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEFUIModes = iPSDEField.getAllPSDEFUIModes();
        if (psDEFUIModes != null) {
            while (psDEFUIModes.hasNext()) {
                IPSDEFUIMode iPSDEFUIMode = (IPSDEFUIMode)psDEFUIModes.next();
                this.onGenerateCode(iPSDEFUIMode, list);
            }
        }
    }

    protected void onGenerateCode(IPSDEFUIMode iPSDEFUIMode, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDEFUIMode.getPSDEField().getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEFUIMode, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}


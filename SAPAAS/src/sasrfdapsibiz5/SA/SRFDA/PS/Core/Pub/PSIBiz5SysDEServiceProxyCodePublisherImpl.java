/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIBiz5SysDEServiceProxyCodePublisherImpl
extends PSIBiz5SysDECodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        if (StringHelper.Compare((String)iPSDataEntity.getIndexDEType(), (String)"INHERIT", (boolean)true) != 0) {
            return;
        }
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDataEntity);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDataEntity, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}


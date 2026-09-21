/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEDQModelBaseCodePublisherImpl
extends PSIBiz5SysDECodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
        if (psDEDataQueries != null) {
            while (psDEDataQueries.hasNext()) {
                IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)psDEDataQueries.next();
                this.generateCode(iPSDEDataQuery, list);
            }
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDEDataQuery) {
            IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSDEDataQuery, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSDEDataQuery iPSDEDataQuery, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDEDataQuery.getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEDataQuery, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysModelPublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    public static final String CODETEMPL_DATAENTITY = "DATAENTITY";

    protected void onGenerateCode() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strDEFilter)) {
            return;
        }
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> dataentities = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDataEntities = this.iPSSystem.getAllPSDataEntities();
        while (psDataEntities.hasNext()) {
            IPSDataEntity iPSDataEntity = (IPSDataEntity)psDataEntities.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_DATAENTITY, iPSDataEntity, null);
            dataentities.add(iPSGenerateCodeResult);
        }
        params.put("dataentities", dataentities);
        this.savePSSysSFCode(this.iPSSystem, null, params);
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}


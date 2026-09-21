/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Service.IPSSysServiceAPI
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAPICodePublisherImpl;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAPIDEAPIRSCodePublisherImpl
extends PSIBiz5SysAPICodePublisherImpl {
    private IPSDEServiceAPIRS iPSDEServiceAPIRS = null;

    @Override
    protected void onGenerateCode(IPSSysServiceAPI iPSSysServiceAPI, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEServiceAPIRSs = iPSSysServiceAPI.getPSDEServiceAPIRSs();
        if (psDEServiceAPIRSs != null) {
            while (psDEServiceAPIRSs.hasNext()) {
                this.iPSDEServiceAPIRS = (IPSDEServiceAPIRS)psDEServiceAPIRSs.next();
                this.onGenerateDEServiceAPIRSCode(this.iPSDEServiceAPIRS, null);
            }
        }
    }

    protected void onGenerateDEServiceAPIRSCode(IPSDEServiceAPIRS iPSDEServiceAPIRS, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEServiceAPIRS, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDEServiceAPIRS) {
            this.iPSDEServiceAPIRS = (IPSDEServiceAPIRS)iPSObject;
            this.iPSSysServiceAPI = this.iPSDEServiceAPIRS.getPSSysServiceAPI();
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateDEServiceAPIRSCode(this.iPSDEServiceAPIRS, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    @Override
    protected void onClose() {
        this.iPSDEServiceAPIRS = null;
        super.onClose();
    }
}


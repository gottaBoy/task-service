/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Service.IPSSysServiceAPI
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAPICodePublisherImpl;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAPIDEAPICodePublisherImpl
extends PSIBiz5SysAPICodePublisherImpl {
    private IPSDEServiceAPI iPSDEServiceAPI = null;

    @Override
    protected void onGenerateCode(IPSSysServiceAPI iPSSysServiceAPI, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEServiceAPIs = iPSSysServiceAPI.getPSDEServiceAPIs();
        if (psDEServiceAPIs != null) {
            while (psDEServiceAPIs.hasNext()) {
                this.iPSDEServiceAPI = (IPSDEServiceAPI)psDEServiceAPIs.next();
                this.onGenerateDEServiceAPICode(this.iPSDEServiceAPI, null);
            }
        }
    }

    protected void onGenerateDEServiceAPICode(IPSDEServiceAPI iPSDEServiceAPI, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEServiceAPI, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDEServiceAPI) {
            this.iPSDEServiceAPI = (IPSDEServiceAPI)iPSObject;
            this.iPSSysServiceAPI = this.iPSDEServiceAPI.getPSSysServiceAPI();
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateDEServiceAPICode(this.iPSDEServiceAPI, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (this.iPSDEServiceAPI != null && !params.containsKey("de")) {
            params.put("de", this.iPSDEServiceAPI.getPSDataEntity());
        }
    }

    @Override
    protected void onClose() {
        this.iPSDEServiceAPI = null;
        super.onClose();
    }
}


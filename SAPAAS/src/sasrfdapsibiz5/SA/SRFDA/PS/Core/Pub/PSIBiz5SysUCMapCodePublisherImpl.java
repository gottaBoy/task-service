/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.UML.IPSSysUCMap
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysUCMapCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysUCMap iPSSysUCMap = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysUCMaps = this.iPSSystem.getAllPSSysUCMaps();
        while (psSysUCMaps.hasNext()) {
            IPSSysUCMap iPSSysUCMap;
            this.iPSSysUCMap = iPSSysUCMap = (IPSSysUCMap)psSysUCMaps.next();
            if (iPSSysUCMap.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSSysUCMap.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
            this.onGenerateCode(iPSSysUCMap);
        }
    }

    protected void onGenerateCode(IPSSysUCMap iPSSysUCMap) throws Exception {
        HashMap params = new HashMap();
        this.savePSSysSFCode(this.iPSSysUCMap, null, params);
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysUCMap = null;
        super.onClose();
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}


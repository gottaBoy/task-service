/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDynaModelCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysDynaModel iPSSysDynaModel = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysDynaModels = this.iPSSystem.getAllPSSysDynaModels();
        if (psSysDynaModels != null) {
            while (psSysDynaModels.hasNext()) {
                IPSSysDynaModel iPSSysDynaModel = (IPSSysDynaModel)psSysDynaModels.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysDynaModel.getPSSystemModule() != null && iPSSysDynaModel.getPSSystemModule().isSubSysModule() && !iPSSysDynaModel.getPSSystemModule().isSubSysAsCloud()) continue;
                this.iPSSysDynaModel = iPSSysDynaModel;
                this.onGenerateCode(iPSSysDynaModel, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysDynaModel iPSSysDynaModel, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysDynaModel, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysDynaModel) {
            this.iPSSysDynaModel = (IPSSysDynaModel)iPSObject;
            if (this.iPSSysDynaModel.getPSSystemModule() != null && this.iPSSysDynaModel.getPSSystemModule().isSubSysModule() && !this.iPSSysDynaModel.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysDynaModel, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysDynaModel = null;
        super.onClose();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class PSIBiz5SysDynaDECodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    private IPSDynaDETempl iPSDynaDETempl = null;

    protected void onGenerateCode() throws Exception {
        Iterator psDynaDETempls = this.iPSSystem.getAllPSDynaDETempls();
        while (psDynaDETempls.hasNext()) {
            this.iPSDynaDETempl = (IPSDynaDETempl)psDynaDETempls.next();
            this.onGenerateCode(this.iPSDynaDETempl, null);
        }
    }

    protected abstract void onGenerateCode(IPSDynaDETempl var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDataEntity) {
            this.iPSDynaDETempl = (IPSDynaDETempl)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSDynaDETempl, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (this.iPSDynaDETempl != null) {
            params.put("de", this.iPSDynaDETempl.getTemplPSDE());
        }
    }

    protected void onClose() {
        this.iPSDynaDETempl = null;
        super.onClose();
    }
}


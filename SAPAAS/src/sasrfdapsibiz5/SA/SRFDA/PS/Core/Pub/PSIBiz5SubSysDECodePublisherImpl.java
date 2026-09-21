/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class PSIBiz5SubSysDECodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    private IPSDataEntity iPSDataEntity = null;

    protected void onGenerateCode() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strDEFilter)) {
            this.iPSDataEntity = this.iPSSystem.getPSDataEntity2(this.strDEFilter);
            if (this.iPSDataEntity.isSubSysDE() && !this.iPSDataEntity.isSubSysAsCloud() && this.iPSDataEntity.getDynamicMode() == 2) {
                this.onGenerateCode(this.iPSDataEntity, null);
            }
        } else {
            Iterator psDataEntities = this.iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                this.iPSDataEntity = (IPSDataEntity)psDataEntities.next();
                if (!this.iPSDataEntity.isSubSysDE() || this.iPSDataEntity.isSubSysAsCloud() || this.iPSDataEntity.getDynamicMode() != 2) continue;
                this.onGenerateCode(this.iPSDataEntity, null);
            }
        }
    }

    protected abstract void onGenerateCode(IPSDataEntity var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDataEntity) {
            this.iPSDataEntity = (IPSDataEntity)iPSObject;
            if (this.iPSDataEntity.isSubSysDE() && !this.iPSDataEntity.isSubSysAsCloud() && this.iPSDataEntity.getDynamicMode() == 2) {
                ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
                this.onGenerateCode(this.iPSDataEntity, list);
                return list;
            }
            return null;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (this.iPSDataEntity != null) {
            params.put("de", this.iPSDataEntity);
        }
    }

    protected void onClose() {
        this.iPSDataEntity = null;
        super.onClose();
    }
}


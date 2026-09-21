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

public class PSIBiz5SysDEFieldCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    private IPSDataEntity iPSDataEntity = null;
    private IPSDataEntity prevPSDataEntity = null;
    private IPSDataEntity nextPSDataEntity = null;

    protected void onGenerateCode() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strDEFilter)) {
            this.iPSDataEntity = this.iPSSystem.getPSDataEntity2(this.strDEFilter);
            if (!this.iPSDataEntity.isSubSysDE() || this.iPSDataEntity.isSubSysAsCloud()) {
                this.onGenerateCode(this.iPSDataEntity);
            }
        } else {
            ArrayList<IPSDataEntity> list = new ArrayList<IPSDataEntity>();
            Iterator psDataEntities = this.iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                this.iPSDataEntity = (IPSDataEntity)psDataEntities.next();
                if (this.iPSDataEntity.isSubSysDE() && !this.iPSDataEntity.isSubSysAsCloud()) continue;
                list.add(this.iPSDataEntity);
            }
            int i = 0;
            while (i < list.size()) {
                this.iPSDataEntity = (IPSDataEntity)list.get(i);
                this.prevPSDataEntity = i - 1 >= 0 ? (IPSDataEntity)list.get(i - 1) : null;
                this.nextPSDataEntity = i + 1 < list.size() ? (IPSDataEntity)list.get(i + 1) : null;
                this.onGenerateCode(this.iPSDataEntity);
                ++i;
            }
        }
        this.iPSDataEntity = null;
        this.prevPSDataEntity = null;
        this.nextPSDataEntity = null;
    }

    protected void onGenerateCode(IPSDataEntity iPSDataEntity) throws Exception {
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (this.iPSDataEntity != null) {
            params.put("de", this.iPSDataEntity);
        }
        if (this.prevPSDataEntity != null) {
            params.put("previtem", this.prevPSDataEntity);
        }
        if (this.nextPSDataEntity != null) {
            params.put("nextitem", this.nextPSDataEntity);
        }
    }

    protected void onClose() {
        this.iPSDataEntity = null;
        this.prevPSDataEntity = null;
        this.nextPSDataEntity = null;
        super.onClose();
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}


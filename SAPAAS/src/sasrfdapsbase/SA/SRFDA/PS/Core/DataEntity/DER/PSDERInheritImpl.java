/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERIndexImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFramework.Utility.StringHelper;

@PSModelPFIgnoreMeta
public class PSDERInheritImpl
extends PSDERIndexImpl
implements IPSDERInherit {
    private boolean bSameTable = false;
    private int nInheritMode = 1;

    @Override
    protected void onInit() throws Exception {
        if (this.isSingleInherit()) {
            if (!StringHelper.IsNullOrEmpty((String)this.getMajorPSDataEntity().getTableName()) && !StringHelper.IsNullOrEmpty((String)this.getMinorPSDataEntity().getTableName())) {
                boolean bl = this.bSameTable = StringHelper.Compare((String)this.getMajorPSDataEntity().getTableName(), (String)this.getMinorPSDataEntity().getTableName(), (boolean)true) == 0;
            }
            if (this.getMajorPSDataEntity().isSubSysDE() || this.getMajorPSDataEntity().getPSSubSysServiceAPI() != null) {
                this.nInheritMode = 2;
                if (this.getMajorPSDataEntity().getPSSubSysServiceAPI() != null && this.getMinorPSDataEntity().getPSSubSysServiceAPI() != null) {
                    IPSSubSysServiceAPI iPSSubSysServiceAPI = this.getMajorPSDataEntity().getPSSubSysServiceAPI();
                    IPSSubSysServiceAPI iPSSubSysServiceAPI2 = this.getMinorPSDataEntity().getPSSubSysServiceAPI();
                    if (StringHelper.Compare((String)iPSSubSysServiceAPI.getId(), (String)iPSSubSysServiceAPI2.getId(), (boolean)false) == 0) {
                        this.nInheritMode = 1;
                    }
                } else if (this.getMajorPSDataEntity().isSubSysDE() && this.getMinorPSDataEntity().isSubSysDE()) {
                    IPSSysRef iPSSysRef = this.getMajorPSDataEntity().getPSSystemModule().getPSSysRef();
                    IPSSysRef iPSSysRef2 = this.getMinorPSDataEntity().getPSSystemModule().getPSSysRef();
                    if (iPSSysRef != null && iPSSysRef2 != null && StringHelper.Compare((String)iPSSysRef.getId(), (String)iPSSysRef2.getId(), (boolean)false) == 0) {
                        this.nInheritMode = 1;
                    }
                }
            }
            if (!this.psDER.isINHERITMODENull() && this.psDER.getINHERITMODE() >= 0) {
                this.nInheritMode = this.psDER.getINHERITMODE();
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5355\u7ee7\u627f\u5173\u7cfb", doc="\u6052\u4e3atrue", staticcode="true")
    public boolean isSingleInherit() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u6a21\u5f0f", doc="\u6052\u4e3atrue", staticcode="true")
    public boolean isInherit() {
        return true;
    }

    @Override
    public boolean isSameTable() {
        return this.bSameTable;
    }

    @Override
    @PSModelRTMeta(description="\u4e00\u81f4\u5b58\u50a8", ignoredumpvalues="false", doc="\u5224\u65ad\u4e3b\u4ece\u5b9e\u4f53\u7684\u6570\u636e\u8868\u662f\u5426\u4e00\u81f4")
    public boolean isSameStorage() {
        return this.isSameTable();
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u5904\u7406\u6a21\u5f0f", codelist="DERInheritMode", fields={"INHERITMODE"})
    public int getInheritMode() {
        return this.nInheritMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b58\u50a8\u7ee7\u627f\u6a21\u5f0f", ignoredumpvalues="false", doc="\u4ece{@link #getInheritMode}\u8ba1\u7b97", staticcode="this.getInheritMode() == net.ibizsys.model.PSModelEnums.DERInheritMode.STORAGE.value")
    public boolean isStorageInherit() {
        return this.getInheritMode() == 1;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7ee7\u627f\u6a21\u5f0f", ignoredumpvalues="false", doc="\u4ece{@link #getInheritMode}\u8ba1\u7b97", staticcode="this.getInheritMode() == net.ibizsys.model.PSModelEnums.DERInheritMode.LOGIC.value")
    public boolean isLogicInherit() {
        return this.getInheritMode() == 2;
    }
}


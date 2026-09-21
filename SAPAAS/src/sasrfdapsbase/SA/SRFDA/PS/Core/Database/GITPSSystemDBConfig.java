/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public class GITPSSystemDBConfig
extends PSSystemObjectImpl
implements IPSSystemDBConfig {
    private IPSDBDevInst gitPSDBDevInst = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSystemDBConfig psSystemDBConfig) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSystem(iPSSystem);
        this.gitPSDBDevInst = iPSSystem.getJITPSDBDevInst();
        if (this.gitPSDBDevInst == null) {
            throw new Exception("\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9aJIT\u6570\u636e\u6e90");
        }
        this.setId(this.gitPSDBDevInst.getId());
        this.setName(this.gitPSDBDevInst.getDBType());
        this.onInit();
    }

    @Override
    public String getPSDBDevInstId() {
        return this.gitPSDBDevInst.getId();
    }

    @Override
    public boolean isDefaultMode() {
        return true;
    }

    @Override
    public String getTableSpace(String strTableSpaceId) {
        return null;
    }

    @Override
    public String getDBType() {
        return this.gitPSDBDevInst.getDBType();
    }

    @Override
    public boolean isNoDBInstMode() {
        return false;
    }

    @Override
    public String getPSDCDBDevInstId() {
        return null;
    }

    @Override
    public String getPSDCDBDevInstName() {
        return null;
    }

    @Override
    public boolean isPubModelComment() {
        return false;
    }

    @Override
    public boolean isPubView() {
        return true;
    }

    @Override
    public boolean isPubFKey() {
        return true;
    }

    @Override
    public boolean isPubIndex() {
        return true;
    }

    @Override
    public boolean isPubModel() {
        return true;
    }

    @Override
    public String getObjNameCase() {
        return "DEFAULT";
    }

    @Override
    public String getNullValueOrderMode() {
        return "";
    }
}


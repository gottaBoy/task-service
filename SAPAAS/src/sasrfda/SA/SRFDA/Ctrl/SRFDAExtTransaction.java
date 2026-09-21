/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDAExtTransaction;
import SA.SRFramework.DataEx.BaseDataEntity;

public class SRFDAExtTransaction
implements ISRFDAExtTransaction {
    private String strType = null;
    private IDEDataCtrl iDEDataCtrl = null;
    private BaseDataEntity baseDataEntity = null;
    private Object objUserTag = null;
    private Object objUserTag2 = null;

    @Override
    public String getType() {
        return this.strType;
    }

    public void setType(String strType) {
        this.strType = strType;
    }

    @Override
    public IDEDataCtrl getDEDataCtrl() {
        return this.iDEDataCtrl;
    }

    protected void setDEDataCtrl(IDEDataCtrl iDEDataCtrl) {
        this.iDEDataCtrl = iDEDataCtrl;
    }

    @Override
    public BaseDataEntity getDataEntity() {
        return this.baseDataEntity;
    }

    protected void setDataEntity(BaseDataEntity baseDataEntity) {
        this.baseDataEntity = baseDataEntity;
    }

    @Override
    public Object getUserTag() {
        return this.objUserTag;
    }

    @Override
    public Object getUserTag2() {
        return this.objUserTag2;
    }

    public void setUserTag(Object objUserTag) {
        this.objUserTag = objUserTag;
    }

    public void setUserTag2(Object objUserTag2) {
        this.objUserTag2 = objUserTag2;
    }
}


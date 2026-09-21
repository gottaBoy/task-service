/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelperContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.DataNotify;

import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelperContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

public class DefaultDataNotifyHelperContext
implements IDataNotifyHelperContext {
    protected IDEHelper iDEHelper = null;
    protected BaseDataEntity lastDataEntity = null;
    protected BaseDataEntity dataEntity = null;

    public IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    public BaseDataEntity getDataEntity() {
        return this.dataEntity;
    }

    public BaseDataEntity getLastDataEntity() {
        return this.lastDataEntity;
    }

    public void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    public void setLastDataEntity(BaseDataEntity lastDataEntity) {
        this.lastDataEntity = lastDataEntity;
    }

    public void setDataEntity(BaseDataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }
}


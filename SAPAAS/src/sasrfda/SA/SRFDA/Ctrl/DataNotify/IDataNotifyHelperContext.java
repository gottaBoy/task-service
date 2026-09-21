/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.DataNotify;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IDataNotifyHelperContext {
    public IDEHelper getDEHelper();

    public BaseDataEntity getLastDataEntity();

    public BaseDataEntity getDataEntity();
}


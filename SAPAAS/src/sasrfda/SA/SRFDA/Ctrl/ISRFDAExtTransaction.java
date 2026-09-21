/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface ISRFDAExtTransaction {
    public String getType();

    public IDEDataCtrl getDEDataCtrl();

    public BaseDataEntity getDataEntity();

    public Object getUserTag();

    public Object getUserTag2();
}


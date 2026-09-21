/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Web;

import SA.SRFramework.DataEx.BaseDataEntity;

public interface IActiveDataPage {
    public BaseDataEntity getActiveData() throws Exception;

    public boolean isEnableActiveData();
}


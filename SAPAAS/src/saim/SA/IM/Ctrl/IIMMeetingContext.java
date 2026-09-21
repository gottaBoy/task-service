/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMMessagePackage;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IIMMeetingContext {
    public String getMeetingId();

    public int getMeetingType();

    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction var1) throws Exception;

    public void AsyncSaveData(boolean var1, BaseDataEntity var2);
}


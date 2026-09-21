/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IDBOPProcess {
    public void Init(IDBOPPKGContext var1, BaseDataEntity var2) throws Exception;

    public void Publish(IDBOPPublishContext var1) throws Exception;

    public String getId();

    public boolean isLogDetail();
}


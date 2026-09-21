/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.IWTObjectHelper;
import SA.WT.Data.WTIncomeMessage;
import SA.WT.Data.WTServiceSession;
import SA.WT.Data.WTUser;

public interface IWTServiceHelper
extends IWTObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IWTAccountHelper var2, BaseDataEntity var3) throws Exception;

    public boolean isRequireVerify();

    public WTServiceSession StartSession(WTUser var1) throws Exception;

    public String ContinueSession(WTUser var1, WTServiceSession var2, WTIncomeMessage var3) throws Exception;
}


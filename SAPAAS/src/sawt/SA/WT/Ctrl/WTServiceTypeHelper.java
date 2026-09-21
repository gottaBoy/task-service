/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Ctrl.IWTServiceTypeHelper;
import SA.WT.Ctrl.WTBaseObject;
import SA.WT.Data.WTServiceType;

public class WTServiceTypeHelper
extends WTBaseObject
implements IWTServiceTypeHelper {
    private WTServiceType wtServiceType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, WTServiceType wtServiceType) throws Exception {
        this.wtServiceType = wtServiceType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.wtServiceType.getWTSERVICETYPEID());
        this.setName(this.wtServiceType.getWTSERVICETYPENAME());
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
    }

    @Override
    public IWTServiceHelper CreateWTServiceHelper() throws Exception {
        return (IWTServiceHelper)ObjectHelper.Create((String)this.wtServiceType.getSERVICEHELPER());
    }
}


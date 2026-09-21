/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.IBICacheTableCleaner;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class BaseBICacheTableCleaner
extends BaseBIObject
implements IBICacheTableCleaner {
    @Override
    public void Init(ISRFDAGlobalHelper iSRFDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iSRFDAGlobalHelper;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public void Clean() throws Exception {
        this.OnClean();
    }

    protected void OnClean() throws Exception {
    }
}


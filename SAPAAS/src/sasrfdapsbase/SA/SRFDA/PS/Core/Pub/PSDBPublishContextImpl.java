/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSDBPublishContextImpl
extends PSPublishContextImpl
implements IPSDBPublisherContext {
    private IPSSystemDBConfig iPSSystemDBConfig = null;

    public PSDBPublishContextImpl(IDEDataCtrl iDEDataCtrl) {
        super(iDEDataCtrl);
    }

    public PSDBPublishContextImpl(ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext daWebContext) {
        super(iDAGlobalHelper, daWebContext);
    }

    @Override
    public IPSSystemDBConfig getPSSystemDBConfig() {
        return this.iPSSystemDBConfig;
    }

    public void setPSSystemDBConfig(IPSSystemDBConfig iPSSystemDBConfig) {
        this.iPSSystemDBConfig = iPSSystemDBConfig;
    }
}


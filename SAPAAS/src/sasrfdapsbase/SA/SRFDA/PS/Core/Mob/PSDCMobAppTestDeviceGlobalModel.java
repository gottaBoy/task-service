/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Mob;

import SA.SRFDA.PS.Core.DevCenter.PSDCGlobalModelBase;
import SA.SRFDA.PS.Core.Mob.IPSDCMobAppTestDevice;
import SA.SRFDA.PS.Core.Mob.PSDCMobAppTestDeviceImpl;
import SA.SRFDA.PS.Data.PSDCMobAppTestDevice;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCMobAppTestDeviceGlobalModel
extends PSDCGlobalModelBase<String, PSDCMobAppTestDevice, IPSDCMobAppTestDevice> {
    private static final Log log = LogFactory.getLog(PSDCMobAppTestDeviceGlobalModel.class);

    @Override
    protected PSDCMobAppTestDevice GetObject(String strPSDCMobAppTestDeviceId) {
        return null;
    }

    @Override
    protected IPSDCMobAppTestDevice OnCreateModelHelper(PSDCMobAppTestDevice vt) throws Exception {
        PSDCMobAppTestDeviceImpl iPSDCMobAppTestDevice = new PSDCMobAppTestDeviceImpl();
        iPSDCMobAppTestDevice.init(this.iDAGlobalHelper, vt);
        return iPSDCMobAppTestDevice;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCMobAppTestDevice obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSDCMobAppTestDevice registerModel(PSDCMobAppTestDevice vt) throws Exception {
        IPSDCMobAppTestDevice iPSDCMobAppTestDevice = (IPSDCMobAppTestDevice)this.InternalGetModelHelper(vt.getPSDCMOBAPPTESTDEVICEID());
        if (iPSDCMobAppTestDevice != null) {
            return iPSDCMobAppTestDevice;
        }
        this.setModel(vt.getPSDCMOBAPPTESTDEVICEID(), vt, null);
        return (IPSDCMobAppTestDevice)this.FindModelHelper(vt.getPSDCMOBAPPTESTDEVICEID());
    }

    @Override
    protected Vector<PSDCMobAppTestDevice> getAllModels() throws Exception {
        Vector<PSDCMobAppTestDevice> list = new Vector<PSDCMobAppTestDevice>();
        CallResult callResult = this.iPSModelHelper.getPSDCMobAppTestDevices(this.iPSDevCenter.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u4e2d\u5fc3\u5168\u90e8\u79fb\u52a8\u5e94\u7528\u6d4b\u8bd5\u8bbe\u5907\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDCMobAppTestDevice vt) {
        return vt.getPSDCMOBAPPTESTDEVICEID();
    }
}


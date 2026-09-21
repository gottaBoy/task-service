/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Mob;

import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.Mob.IPSDCMobAppTestDevice;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCMobAppTestDevice;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDCMobAppTestDeviceImpl
extends PSDCResObjectImplBase
implements IPSDCMobAppTestDevice {
    private static final Log log = LogFactory.getLog(PSDCMobAppTestDeviceImpl.class);
    protected PSDCMobAppTestDevice psDCMobAppTestDevice = null;
    private String strDeviceId = null;
    private String strOSType = null;
    private String strOSVersion = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCMobAppTestDevice psDCMobAppTestDevice) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCMobAppTestDevice = psDCMobAppTestDevice;
        this.setId(this.psDCMobAppTestDevice.getPSDCMOBAPPTESTDEVICEID());
        this.setName(this.psDCMobAppTestDevice.getPSDCMOBAPPTESTDEVICENAME());
        this.setPSObjectData(this.psDCMobAppTestDevice);
        this.strDeviceId = this.psDCMobAppTestDevice.getDEVICEID();
        this.strOSType = this.psDCMobAppTestDevice.getOSTYPE();
        this.strOSVersion = this.psDCMobAppTestDevice.getOSVER();
        this.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDCMOBAPPTESTDEVICE";
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getDeviceId() {
        return this.strDeviceId;
    }

    @Override
    public String getOSType() {
        return this.strOSType;
    }

    @Override
    public String getOSVersion() {
        return this.strOSVersion;
    }
}


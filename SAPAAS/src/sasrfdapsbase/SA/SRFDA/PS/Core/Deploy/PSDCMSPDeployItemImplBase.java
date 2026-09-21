/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCMSPDeployItem;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;

public abstract class PSDCMSPDeployItemImplBase
extends PSObjectImpl
implements IPSDCMSPDeployItem {
    private IPSDCMSPlatform iPSDCMSPlatform = null;
    private IPSDCMSPlatformNode iPSDCMSPlatformNode = null;

    @Override
    @PSModelRTMeta(description="\u5fae\u670d\u52a1\u5e73\u53f0")
    public IPSDCMSPlatform getPSDCMSPlatform() {
        return this.iPSDCMSPlatform;
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u670d\u52a1\u8282\u70b9")
    public IPSDCMSPlatformNode getPSDCMSPlatformNode() {
        return this.iPSDCMSPlatformNode;
    }

    protected void setPSDCMSPlatform(IPSDCMSPlatform iPSDCMSPlatform) {
        this.iPSDCMSPlatform = iPSDCMSPlatform;
    }

    protected void setPSDCMSPlatformNode(IPSDCMSPlatformNode iPSDCMSPlatformNode) {
        this.iPSDCMSPlatformNode = iPSDCMSPlatformNode;
    }
}


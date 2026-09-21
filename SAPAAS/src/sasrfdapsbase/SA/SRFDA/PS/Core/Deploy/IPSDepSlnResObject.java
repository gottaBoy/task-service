/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnHost;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDepSlnResObject
extends IPSDepSlnObject {
    public IPSDepSlnHost getPSDepSlnHost();

    public boolean isEnableRemoteDeploy();

    public boolean isEnableLocalDeploy();
}


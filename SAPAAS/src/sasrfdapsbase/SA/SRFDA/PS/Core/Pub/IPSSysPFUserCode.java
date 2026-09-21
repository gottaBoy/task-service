/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSSysPFUserCode
extends IPSObject {
    public String getProjectType();

    public String getUserCode();

    public String getFilePath();

    public IPSApplication getPSApplication();
}


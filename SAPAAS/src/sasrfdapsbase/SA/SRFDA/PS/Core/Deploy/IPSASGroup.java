/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSASGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSASGroup
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSASGroup var2) throws Exception;

    public String getASType();

    public int getHttpPort();

    public int getHttpsPort();

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSlnASItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDepSlnASGroupItem
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDepSlnASGroup var2, PSDepSlnASItem var3) throws Exception;

    public IPSDepSlnASGroup getPSDepSlnASGroup();

    public IPSDepSlnAS getPSDepSlnAS();

    public boolean isBackup();

    public int getWeight();

    public int getMaxFails();

    public int getFailTimeout();
}


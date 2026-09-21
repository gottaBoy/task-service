/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroupItem;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnResObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSlnASGrp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDepSlnASGroup
extends IPSDepSlnResObject {
    public void init(ISRFDAGlobalHelper var1, IPSDepSln var2, PSDepSlnASGrp var3) throws Exception;

    public String getASType(boolean var1) throws Exception;

    public int getHttpPort(boolean var1) throws Exception;

    public int getHttpsPort(boolean var1) throws Exception;

    public Iterator<IPSDepSlnASGroupItem> getPSDepSlnASGroupItems();

    public String getGroupMode();
}


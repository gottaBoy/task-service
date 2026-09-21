/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSObjectProperty;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSObjectEx {
    public IPSObject getPSObject();

    public IPSObjectProperty getPSProperty(String var1) throws Exception;

    public Iterator<IPSObjectProperty> getPSProperties(String var1) throws Exception;

    public IPSObjectProperty registerPSProperty(IPSObjectProperty var1);

    public void unregisterPSProperty(String var1);
}


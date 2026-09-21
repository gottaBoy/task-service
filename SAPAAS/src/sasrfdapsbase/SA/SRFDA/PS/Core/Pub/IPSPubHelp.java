/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherMacro;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSPubHelp
extends IPSModelObject {
    public String getTarget();

    public Iterator<IPSCodePublisherParam> getPSCodePublisherParams();

    public Iterator<IPSCodePublisherMacro> getPSCodePublisherMacros();
}


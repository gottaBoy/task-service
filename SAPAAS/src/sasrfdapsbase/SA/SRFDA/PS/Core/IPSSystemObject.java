/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ISystemObject
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.core.ISystemObject;

@PSModelIgnoreMeta
public interface IPSSystemObject
extends IPSModelObject,
ISystemObject,
IPSDynaInstSupportable {
    public IPSSystem getPSSystem();
}


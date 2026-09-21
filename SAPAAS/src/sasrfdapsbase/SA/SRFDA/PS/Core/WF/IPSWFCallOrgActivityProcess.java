/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFCallActivityProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSWFCallOrgActivityProcess
extends IPSWFCallActivityProcess {
    public Iterator<IPSWFProcessRole> getPSWFProcessRoles();
}


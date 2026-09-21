/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFModel;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IPSJITWFVersionModel
extends IWFVersionModel {
    public IPSJITWFModel getPSJITWFModel();

    public IPSWFVersion getPSWFVersion();
}


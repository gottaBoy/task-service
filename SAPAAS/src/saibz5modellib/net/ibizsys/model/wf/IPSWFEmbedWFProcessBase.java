/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessSubWF;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;

public interface IPSWFEmbedWFProcessBase
extends IPSWFProcess,
IWFEmbedWFProcessModelBase {
    public Iterator<IPSWFProcessSubWF> getPSWFProcessSubWFs();

    public int getPSWFProcessSubWFCount();
}


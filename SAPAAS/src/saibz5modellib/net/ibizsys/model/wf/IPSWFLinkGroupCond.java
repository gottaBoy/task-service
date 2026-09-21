/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkGroupCondModel
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFLinkCond;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;

public interface IPSWFLinkGroupCond
extends IPSWFLinkCond,
IWFLinkGroupCondModel {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<IPSWFLinkCond> getPSWFLinkConds();
}


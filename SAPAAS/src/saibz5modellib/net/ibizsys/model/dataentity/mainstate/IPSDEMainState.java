/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEMainState
 */
package net.ibizsys.model.dataentity.mainstate;

import java.util.Iterator;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateAction;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateOPPriv;
import net.ibizsys.paas.core.IDEMainState;

public interface IPSDEMainState
extends IPSDataEntityObject,
IDEMainState,
IPSModelObject {
    public Iterator<IPSDEMainStateAction> getPSDEMainStateActions();

    public Iterator<IPSDEMainStateOPPriv> getPSDEMainStateOPPrivs();

    public IPSDEDataQuery getPSDEDataQuery();

    public String getPSDEDataQueryId();

    public String getCodeName();

    public boolean isEnableViewActions();

    public long getViewActions();
}


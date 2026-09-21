/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEAction
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDESelectActionParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEAction;

@PSModelPFIgnoreMeta
public interface IPSDESelectAction
extends IPSModelObject,
IDEAction {
    public Iterator<IPSDESelectActionParam> getPSDESelectActionParams();
}


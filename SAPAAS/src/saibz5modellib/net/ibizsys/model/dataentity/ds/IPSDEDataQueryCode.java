/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataQueryCode
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Iterator;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataQueryCode;

public interface IPSDEDataQueryCode
extends IPSModelObject,
IDEDataQueryCode {
    public IPSDEDataQuery getPSDEDataQuery();

    public Iterator<IPSDEDataQueryCodeExp> getPSDEDataQueryCodeExps() throws Exception;

    public Iterator<IPSDEDataQueryCodeCond> getPSDEDataQueryCodeConds() throws Exception;
}


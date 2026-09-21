/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataQuery
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Iterator;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQuery;

public interface IPSDEDataQuery
extends IPSDataEntityObject,
IDEDataQuery {
    public IPSDEDataQueryCode getPSDEDataQueryCode(String var1) throws Exception;

    public Iterator<IPSDEDataQueryCode> getAllPSDEDataQueryCodes() throws Exception;
}


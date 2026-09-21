/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.der.IPSDER1N
 */
package net.ibizsys.model.der;

import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERRuntime;

public interface IPSDER1NRuntime
extends IPSDER1N,
IPSDERRuntime {
    public String getRefPSDEDataSetId();

    public String getRefPSDEDataSetName() throws Exception;

    public String getRefPSDEACModeId();

    public String getRefPSDEACModeName() throws Exception;

    public IPSDEACMode getRefPSDEACMode() throws Exception;

    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public String getRefLinkPSDEViewId();

    public String getRefLinkPSDEViewName();

    public String getRefMPickupPSDEViewId();

    public String getRefMPickupPSDEViewName();

    public String getRefPickupPSDEViewId();

    public String getRefPickupPSDEViewName();
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstyleparam.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B8ED6E49-05E2-492C-8B30-D641ACD503DC", name="AllValid", queries={@DEDataSetQuery(queryid="60EF7F4B-3D53-4BC3-B91F-0899E59ED6D7", queryname="AllDCValid"), @DEDataSetQuery(queryid="637EE543-5EB1-4947-B0DA-4ECBB8A83A21", queryname="CurDCValid")})
public abstract class PSSFStyleParamAllValidDSModelBase
extends DEDataSetModelBase {
    public PSSFStyleParamAllValidDSModelBase() {
        this.initAnnotation(PSSFStyleParamAllValidDSModelBase.class);
    }
}


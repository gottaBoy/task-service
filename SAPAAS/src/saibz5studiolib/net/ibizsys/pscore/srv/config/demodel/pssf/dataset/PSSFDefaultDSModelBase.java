/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssf.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="d1df3dd0e8f63c93511d575892fea5cb", name="DEFAULT", queries={@DEDataSetQuery(queryid="1790E878-F24C-42BA-AC36-ED2B8FAC776B", queryname="DEFAULT")})
public abstract class PSSFDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSFDefaultDSModelBase() {
        this.initAnnotation(PSSFDefaultDSModelBase.class);
    }
}


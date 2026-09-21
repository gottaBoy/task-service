/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psproducttype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="1af2ab55ccc1b8b10751cdc8cc957370", name="DEFAULT", queries={@DEDataSetQuery(queryid="CE207538-D4A1-418E-82E0-EA449C81789C", queryname="DEFAULT")})
public abstract class PSProductTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSProductTypeDefaultDSModelBase() {
        this.initAnnotation(PSProductTypeDefaultDSModelBase.class);
    }
}


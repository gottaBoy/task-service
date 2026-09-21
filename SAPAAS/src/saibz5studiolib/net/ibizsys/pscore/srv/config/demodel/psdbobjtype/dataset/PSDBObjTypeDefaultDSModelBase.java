/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbobjtype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="ce1e9dad0c34122e369810edb4bfa0ae", name="DEFAULT", queries={@DEDataSetQuery(queryid="F46F3A7F-5801-42E0-A491-C76807699FC3", queryname="DEFAULT")})
public abstract class PSDBObjTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSDBObjTypeDefaultDSModelBase() {
        this.initAnnotation(PSDBObjTypeDefaultDSModelBase.class);
    }
}


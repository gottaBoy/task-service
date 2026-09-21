/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbvalueop.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E0A3CA97-156B-4140-8276-5B70C3C2C9D4", name="DBMode", queries={@DEDataSetQuery(queryid="B6E70FE8-8EF1-47C6-A8B9-EEB21057FC66", queryname="DBMode")})
public abstract class PSDBValueOPDBModeDSModelBase
extends DEDataSetModelBase {
    public PSDBValueOPDBModeDSModelBase() {
        this.initAnnotation(PSDBValueOPDBModeDSModelBase.class);
    }
}


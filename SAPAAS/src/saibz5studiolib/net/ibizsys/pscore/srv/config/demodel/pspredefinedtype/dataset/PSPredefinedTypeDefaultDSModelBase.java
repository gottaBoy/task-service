/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspredefinedtype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="db620b9adbb8fcd2c5788f730fdf009c", name="DEFAULT", queries={@DEDataSetQuery(queryid="8C24B430-AA49-4EA5-81DF-D3C19F089040", queryname="DEFAULT")})
public abstract class PSPredefinedTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSPredefinedTypeDefaultDSModelBase() {
        this.initAnnotation(PSPredefinedTypeDefaultDSModelBase.class);
    }
}


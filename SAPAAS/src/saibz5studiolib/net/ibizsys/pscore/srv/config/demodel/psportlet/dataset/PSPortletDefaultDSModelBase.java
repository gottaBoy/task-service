/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psportlet.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="a7be25f688207c4bbad50878e7a22453", name="DEFAULT", queries={@DEDataSetQuery(queryid="1F82A06E-66BE-45C2-B936-028DB9067B03", queryname="DEFAULT")})
public abstract class PSPortletDefaultDSModelBase
extends DEDataSetModelBase {
    public PSPortletDefaultDSModelBase() {
        this.initAnnotation(PSPortletDefaultDSModelBase.class);
    }
}


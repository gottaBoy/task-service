/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubde.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="2d7378ec86d6761e6dfc10807c89afb3", name="DEFAULT", queries={@DEDataSetQuery(queryid="E582121F-5235-4959-8E2B-65E945D7F629", queryname="DEFAULT")})
public abstract class PSSubDEDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSubDEDefaultDSModelBase() {
        this.initAnnotation(PSSubDEDefaultDSModelBase.class);
    }
}


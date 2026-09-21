/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pseditortype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="8E698706-2120-4999-A651-8A63527F2B93", name="Valid", queries={@DEDataSetQuery(queryid="8E698706-2120-4999-A651-8A63527F2B93", queryname="Valid")})
public abstract class PSEditorTypeValidDSModelBase
extends DEDataSetModelBase {
    public PSEditorTypeValidDSModelBase() {
        this.initAnnotation(PSEditorTypeValidDSModelBase.class);
    }
}


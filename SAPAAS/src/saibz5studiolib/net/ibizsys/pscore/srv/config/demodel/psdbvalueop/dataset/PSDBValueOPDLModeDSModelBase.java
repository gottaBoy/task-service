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

@DEDataSet(id="3E6F3F8F-391E-4FAE-83C1-8600E6B44D19", name="DLMode", queries={@DEDataSetQuery(queryid="ADD9303E-DE49-445D-8445-EBA7ADC5C5AD", queryname="DLMode")})
public abstract class PSDBValueOPDLModeDSModelBase
extends DEDataSetModelBase {
    public PSDBValueOPDLModeDSModelBase() {
        this.initAnnotation(PSDBValueOPDLModeDSModelBase.class);
    }
}


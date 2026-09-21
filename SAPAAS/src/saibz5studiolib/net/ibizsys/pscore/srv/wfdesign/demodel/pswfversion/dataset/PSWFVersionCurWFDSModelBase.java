/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfversion.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="ECC67EC0-FB7A-484A-90A0-51F98686719C", name="CurWF", queries={@DEDataSetQuery(queryid="E12F86E1-9BAE-4520-A84D-9283F15CA043", queryname="CurWF")})
public abstract class PSWFVersionCurWFDSModelBase
extends DEDataSetModelBase {
    public PSWFVersionCurWFDSModelBase() {
        this.initAnnotation(PSWFVersionCurWFDSModelBase.class);
    }
}


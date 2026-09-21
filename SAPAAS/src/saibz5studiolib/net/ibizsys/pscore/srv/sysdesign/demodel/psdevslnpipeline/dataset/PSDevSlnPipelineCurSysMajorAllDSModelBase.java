/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnpipeline.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="19B851C9-D71D-4E6B-B907-6814699DA370", name="CurSysMajorAll", queries={@DEDataSetQuery(queryid="CED48203-16FF-48B6-872E-70AEC6F9DA34", queryname="CurSlnMajorNotSys"), @DEDataSetQuery(queryid="8A08CF72-D77A-4C8E-8438-89D38A265993", queryname="CurSysMajor")})
public abstract class PSDevSlnPipelineCurSysMajorAllDSModelBase
extends DEDataSetModelBase {
    public PSDevSlnPipelineCurSysMajorAllDSModelBase() {
        this.initAnnotation(PSDevSlnPipelineCurSysMajorAllDSModelBase.class);
    }
}


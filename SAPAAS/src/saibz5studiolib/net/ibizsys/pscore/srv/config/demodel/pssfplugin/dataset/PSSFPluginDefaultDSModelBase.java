/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="8ab682c175266f8dd776d7233a086b4c", name="DEFAULT", queries={@DEDataSetQuery(queryid="186C563D-E772-4BF7-8DF3-58D92B92D70C", queryname="DEFAULT")})
public abstract class PSSFPluginDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSFPluginDefaultDSModelBase() {
        this.initAnnotation(PSSFPluginDefaultDSModelBase.class);
    }
}


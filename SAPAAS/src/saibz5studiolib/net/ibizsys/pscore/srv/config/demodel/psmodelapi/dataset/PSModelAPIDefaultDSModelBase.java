/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelapi.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="8dc086fd65f5f2e63b7a3047a5df21ea", name="DEFAULT", queries={@DEDataSetQuery(queryid="A81AA712-8376-4809-9024-8796A4B941A2", queryname="DEFAULT")})
public abstract class PSModelAPIDefaultDSModelBase
extends DEDataSetModelBase {
    public PSModelAPIDefaultDSModelBase() {
        this.initAnnotation(PSModelAPIDefaultDSModelBase.class);
    }
}


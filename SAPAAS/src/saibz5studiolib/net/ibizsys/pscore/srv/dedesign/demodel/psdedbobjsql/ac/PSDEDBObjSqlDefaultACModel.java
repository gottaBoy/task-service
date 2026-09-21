/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbobjsql.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8ad5613ba0aaac3f835ecf7cf5c1d3b4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDBOBJSQLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDBOBJSQLNAME", format="")})})
public class PSDEDBObjSqlDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDBObjSqlDefaultACModel() {
        this.initAnnotation(PSDEDBObjSqlDefaultACModel.class);
    }
}


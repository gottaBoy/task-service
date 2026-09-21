/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappstoryboard.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a3d06b5b00a72ad034ab973593e04eda", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPSTORYBOARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPSTORYBOARDNAME", format="")})})
public class PSAppStoryBoardDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppStoryBoardDefaultACModel() {
        this.initAnnotation(PSAppStoryBoardDefaultACModel.class);
    }
}


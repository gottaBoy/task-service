/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfcodefolder.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e1f4f4bc2a47459d6fedecc3511629c9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFCODEFOLDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFCODEFOLDERNAME", format="")})})
public class PSSFCodeFolderDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFCodeFolderDefaultACModel() {
        this.initAnnotation(PSSFCodeFolderDefaultACModel.class);
    }
}


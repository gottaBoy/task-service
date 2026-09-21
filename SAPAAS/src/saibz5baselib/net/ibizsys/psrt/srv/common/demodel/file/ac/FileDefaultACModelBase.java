/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.file.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1c1b5758a629c73a4e148d5328a921fd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="FILE_ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="FILE_NAME", format="")})})
public abstract class FileDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public FileDefaultACModelBase() {
        this.initAnnotation(FileDefaultACModelBase.class);
    }
}


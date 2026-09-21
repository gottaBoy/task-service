/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDynaModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pswf.core.IDynaWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IDynaWFVersionModel
extends IWFVersionModel,
IDynaModel,
IDynaModelJsonLoader {
    public static final String ATTR_WFPROCESSES = "wfprocesses";
    public static final String ATTR_WFLINKS = "wflinks";
    public static final String ATTR_WFMODE = "wfmode";
    public static final String ATTR_BPMNMODEL = "bpmnmodel";

    public void init(IDynaWFModel var1, IEntity var2) throws Exception;

    public String getDynaInstId();
}


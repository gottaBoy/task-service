/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFProcessModel;

public interface IWFInteractiveProcessModel
extends IWFProcessModel {
    public static final String MULTIINSTMODE_NONE = "NONE";
    public static final String MULTIINSTMODE_PARALLEL = "PARALLEL";
    public static final String MULTIINSTMODE_SEQUENTIAL = "SEQUENTIAL";

    public Iterator<IWFInteractiveLinkModel> getWFInteractiveLinkModels();

    public IWFInteractiveLinkModel getWFInteractiveLinkModel(String var1, boolean var2) throws Exception;

    public Iterator<IWFProcRoleModel> getWFProcRoleModels();

    public boolean isSendInform();

    public String getMsgTemplateId();

    public int getMsgType();

    public boolean isActorIAActionControl();

    public Iterator<String> getUDActors();

    public boolean isEditable();

    public String getMemoField();

    public String getMultiInstMode();
}


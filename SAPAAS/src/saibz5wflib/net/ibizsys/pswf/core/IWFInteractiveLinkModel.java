/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;

public interface IWFInteractiveLinkModel
extends IWFLinkModel {
    public static final String NEXTCOND_ANY = "ANY";
    public static final String NEXTCOND_ALL = "ALL";

    public boolean isActorIAActionControl();

    public boolean containsWFProcRole(IWFProcRoleModel var1);

    public boolean containsUDActor(String var1);

    public int getActionCount();

    public String getNextCondition();

    public String getMemoField();

    public String getActionField();

    public ICodeList getActionCodeList();

    public String getAddedWFRoleId();

    public IWFRoleModel getAddedWFRoleModel();

    public Iterator<IWFRoleUser> getAddedWFRoleUserModels(IWFActionContext var1) throws Exception;
}


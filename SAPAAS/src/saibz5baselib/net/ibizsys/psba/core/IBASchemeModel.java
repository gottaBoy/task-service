/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.psba.core.IBAModelBase;
import net.ibizsys.psba.core.IBAScheme;
import net.ibizsys.psba.core.IBASchemeRuntime;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.entity.IBAEntity;

public interface IBASchemeModel
extends IBAModelBase,
IBAScheme,
IBASchemeRuntime {
    public void registerBATable(IBATable var1);

    public ISystemModel getSystemModel();

    public IBADAO getBADAO(IBATable var1) throws Exception;

    public IBAEntity createBAEntity(IBATable var1) throws Exception;
}


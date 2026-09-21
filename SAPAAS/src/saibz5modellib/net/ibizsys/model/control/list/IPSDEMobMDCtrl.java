/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

public interface IPSDEMobMDCtrl
extends IPSDEList {
    @Override
    public String getControlSubType();

    public IPSDEUIActionGroup getPSDEUIActionGroup() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup2() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup3() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup4() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup5() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup6() throws Exception;
}


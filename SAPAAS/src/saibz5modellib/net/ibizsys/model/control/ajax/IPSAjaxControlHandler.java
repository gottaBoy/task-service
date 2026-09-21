/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.ajax;

import java.util.Iterator;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.dataentity.IPSDataEntity;

public interface IPSAjaxControlHandler
extends IPSAjaxHandler {
    public static final int CACHESCOPE_NONE = 0;
    public static final int CACHESCOPE_GLOBAL = 1;
    public static final int CACHESCOPE_ORG = 2;
    public static final int CACHESCOPE_USER = 3;
    public static final int CACHESCOPE_APP = 4;

    public boolean isEnableDEFieldPrivilege();

    public boolean isEnableAjaxAction(String var1);

    public String getDEActionName(String var1);

    public String getDataAccessAction(String var1);

    public Iterator<String> getAjaxActions();

    public int getTempMode();

    @Override
    public String getUserTag();

    @Override
    public String getUserTag2();

    @Override
    public String getUserTag3();

    @Override
    public String getUserTag4();

    public IPSAjaxControl getPSAjaxControl();

    public IPSDataEntity getPSDataEntity();
}


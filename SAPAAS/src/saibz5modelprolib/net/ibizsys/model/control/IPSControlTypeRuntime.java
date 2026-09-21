/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.model.control.ajax.IPSAjaxControlHandler
 */
package net.ibizsys.model.control;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSControlType;

public interface IPSControlTypeRuntime
extends IPSControlType {
    public void init(IPSModelStorageContext var1, PSControlType var2) throws Exception;

    public IPSControl createPSControl(IPSControlParam var1) throws Exception;

    public IPSControlParam createPSControlParam(BaseDataEntity var1) throws Exception;

    public IPSAjaxControlHandler createPSAjaxControlHandler(PSACHandler var1) throws Exception;
}


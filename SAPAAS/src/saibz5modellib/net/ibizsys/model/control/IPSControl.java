/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.IControl
 */
package net.ibizsys.model.control;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.paas.control.IControl;

public interface IPSControl
extends IControl,
IPSModelObject,
IPSModelJsonExporter {
    public boolean hasCtrlModel();

    public IPSControlParam getPSControlParam();

    public IPSDataEntity getPSDataEntity();

    public IPSAppView getPSAppView();

    public IPSControlType getPSControlType();

    public IPSControlContainer getPSControlContainer();

    public IPSControlXDataContainer getPSControlXDataContainer();

    public double getWidth();

    public double getHeight();

    public IPSSysCss getPSSysCss();

    public String getControlSubType();

    public boolean isDefaultCtrl();

    public boolean isDynamicCtrl();

    public String getDynaViewContent() throws Exception;

    public String getDynaModelContent() throws Exception;
}


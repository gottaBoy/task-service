/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.control.drctrl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.res.IPSLanguageRes;

public interface IPSDEDRCtrlItem
extends IPSModelObject {
    public String getCaption();

    public IPSDEDRDetail getPSDEDRDetail();

    public IPSAppView getPSAppView();

    public String getEmbedViewId();

    public IPSDEDRItem getPSDEDRItem();

    public ObjectNode getViewParamJO();

    public IPSLanguageRes getCapPSLanguageRes();
}


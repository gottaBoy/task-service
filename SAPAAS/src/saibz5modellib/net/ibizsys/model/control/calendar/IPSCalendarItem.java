/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.ctrlmodel.ICalendarItemModel
 */
package net.ibizsys.model.control.calendar;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlMDataContainer;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.calendar.IPSCalendarItemDataItem;
import net.ibizsys.model.control.toolbar.IPSDEContextMenu;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;

public interface IPSCalendarItem
extends IPSModelObject,
ICalendarItemModel,
IPSControlXDataContainer,
IPSControlMDataContainer {
    public IPSDataEntity getPSDataEntity();

    public String getEmbedViewId();

    public String getNavPSDEViewId();

    public IPSAppView getNavPSAppView();

    public ObjectNode getNavViewParam();

    public IPSSysImage getPSSysImage();

    public IPSDEContextMenu getPSDEContextMenu();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public String getCreatePSDEActionName();

    public String getCreatePSDEOPPrivName();

    public String getUpdatePSDEActionName();

    public String getUpdatePSDEOPPrivName();

    public String getRemovePSDEActionName();

    public String getRemovePSDEOPPrivName();

    public Iterator<IPSCalendarItemDataItem> getPSCalendarItemDataItems();

    public String getUserTag();

    public String getUserTag2();

    public String getModelObj();
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.ctrlmodel.ITreeNodeModel
 */
package net.ibizsys.model.control.tree;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlMDataContainer;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.control.tree.IPSDETreeNodeDataItem;
import net.ibizsys.model.control.tree.IPSDETreeNodeRV;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;

public interface IPSDETreeNode
extends IPSModelObject,
ITreeNodeModel,
IPSControlXDataContainer,
IPSControlMDataContainer {
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;

    public IPSDETree getPSDETree();

    public IPSDataEntity getPSDataEntity();

    public String getEmbedViewId();

    public String getNavPSDEViewId();

    public IPSAppView getNavPSAppView();

    public ObjectNode getNavViewParam();

    public IPSSysImage getPSSysImage();

    public Iterator<IPSDETreeNodeRV> getPSDETreeNodeRVs();

    public String getRemovePSDEActionName();

    public String getRemovePSDEOPPrivName();

    public String getNavPSDERId();

    public IPSDERBase getNavPSDER();

    public String getCounterId();

    public int getCounterMode();

    public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems();

    public String getUserTag();

    public String getUserTag2();

    public String getModelObj();
}


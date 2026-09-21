/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"VIEWLAYOUTPANEL"})
public class PSSysViewLayoutPanelImpl
extends PSSysPanelImpl
implements IPSSysViewLayoutPanel {
    private boolean bUseDefaultLayout = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        IPSSysPanelParam iPSSysPanelParam = (IPSSysPanelParam)iPSControlParam;
        this.bUseDefaultLayout = StringHelper.IsNullOrEmpty((String)iPSSysPanelParam.getPSSysPanelId());
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f")
    public boolean isLayoutPanel() {
        return true;
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWLAYOUTPANEL";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppView() != null) {
            return this.getPSAppView().getId();
        }
        return super.getModelId();
    }

    @Override
    public String getControlSubType() {
        if (StringHelper.IsNullOrEmpty((String)this.getId()) && this.getPSAppView() != null) {
            String strAppViewStyle = this.getPSAppView().getViewStyle();
            if (StringHelper.Compare((String)strAppViewStyle, (String)"DEFAULT", (boolean)true) == 0) {
                strAppViewStyle = "";
            } else if (this.getPSAppView().getPSSubViewType() != null && StringHelper.Compare((String)this.getPSAppView().getPSSubViewType().getTypeCode(), (String)strAppViewStyle, (boolean)true) == 0) {
                if (!this.getPSAppView().getPSSubViewType().isExtendView()) {
                    strAppViewStyle = "";
                } else if (StringHelper.Compare((String)this.getPSAppView().getPSSubViewType().getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                    return strAppViewStyle;
                }
            }
            String strAppViewType = this.getPSAppView().getViewType();
            if (strAppViewType.indexOf("APP") == 0) {
                if (StringHelper.IsNullOrEmpty((String)strAppViewStyle)) {
                    return strAppViewType;
                }
                return StringHelper.Format((String)"%1$s_%2$s", (Object)strAppViewType, (Object)strAppViewStyle.toUpperCase());
            }
            if (StringHelper.IsNullOrEmpty((String)strAppViewStyle)) {
                return StringHelper.Format((String)"APP%1$s", (Object)strAppViewType);
            }
            return StringHelper.Format((String)"APP%1$s_%2$s", (Object)strAppViewType, (Object)strAppViewStyle.toUpperCase());
        }
        return super.getControlSubType();
    }

    @Override
    protected String onGetControlType() {
        return "VIEWLAYOUTPANEL";
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u4f7f\u7528\u9ed8\u8ba4\u5e03\u5c40")
    public boolean isUseDefaultLayout() {
        return this.bUseDefaultLayout;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u5e03\u5c40\u5185\u5bb9\u533a", fields={"BODYONLYFLAG"})
    public boolean isLayoutBodyOnly() {
        if (this.psSysPanel != null && !this.psSysPanel.isBODYONLYFLAGNull()) {
            return this.psSysPanel.getBODYONLYFLAG();
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u89c6\u56fe\u4ee3\u7406\u6a21\u5f0f", ignoredumpvalues="false", fields={"VIEWLAYOUTFLAG"})
    public boolean isViewProxyMode() {
        return super.isViewProxyMode();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.isViewProxyMode() && this.getPSAppView() != null) {
            this.appendViewModels(objectNode, "getPSAppCounterRefs", this.getPSAppView().getPSAppCounterRefs(), null);
            this.appendViewModels(objectNode, "getPSAppViewEngines", this.getPSAppView().getPSAppViewEngines(), null);
            this.appendViewModels(objectNode, "getPSAppViewLogics", this.getPSAppView().getPSAppViewLogics(), null);
            this.appendViewModels(objectNode, "getPSAppViewRefs", this.getPSAppView().getPSAppViewRefs(), null);
            this.appendViewModels(objectNode, "getPSAppViewUIActions", this.getPSAppView().getPSAppViewUIActions(), null);
            this.appendViewModels(objectNode, "getPSControls", this.getPSAppView().getPSControls(), "IGNOREDESIGN");
            if (this.getPSAppView() instanceof IPSAppDEView) {
                IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
                this.appendViewModel(objectNode, "getPSAppCounterRef", iPSAppDEView.getPSAppCounterRef(), true, null);
            }
        }
    }

    protected void appendViewModels(ObjectNode objectNode, String strField, Iterator<? extends IPSModelObject> list, String strMode) throws Exception {
        if (list == null) {
            return;
        }
        ArrayNode arrayNode = null;
        JsonNode node = objectNode.get(strField);
        if (node instanceof ArrayNode) {
            arrayNode = (ArrayNode)node;
        }
        int nPos = 0;
        while (list.hasNext()) {
            IPSModelObject iPSModelObject = list.next();
            ObjectNode objNode = iPSModelObject.toModel(strMode);
            if (objNode == null) continue;
            if (arrayNode == null) {
                arrayNode = objectNode.putArray(strField);
            }
            arrayNode.insert(nPos, (JsonNode)objNode);
            ++nPos;
        }
    }

    protected void appendViewModel(ObjectNode objectNode, String strField, IPSModelObject item, boolean bRef, String strMode) throws Exception {
        if (item == null) {
            return;
        }
        if (bRef) {
            objectNode.put(strField, (JsonNode)item.toModelRef(strMode));
        } else {
            objectNode.put(strField, (JsonNode)item.toModel(strMode));
        }
    }
}


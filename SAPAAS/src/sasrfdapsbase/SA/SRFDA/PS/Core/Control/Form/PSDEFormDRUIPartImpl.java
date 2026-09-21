/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;

public class PSDEFormDRUIPartImpl
extends PSDEFormDetailImpl
implements IPSDEFormDRUIPart {
    private IPSDEDRItem iPSDEDRItem = null;
    private IPSAppView iPSAppView = null;
    private String strEmbedViewId = null;
    private String strRefreshItems = null;
    private int nRefreshAction = 3;
    private boolean bIngoreRefreshItemsRefresh = false;
    private int nMaskMode = -1;
    private String strMaskInfo = null;
    private IPSLanguageRes maskPSLanguageRes = null;

    @Override
    protected void onInit() throws Exception {
        this.getPSDEForm().hookPSDEFormItem("srfkey", this);
        if (!this.psDEFormDetail.isMASKMODENull()) {
            this.nMaskMode = this.psDEFormDetail.getMASKMODE();
        }
        if (this.nMaskMode == -1 || this.nMaskMode == 1) {
            this.strMaskInfo = this.psDEFormDetail.getMASKINFO();
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMASKPSLANRESID())) {
                this.maskPSLanguageRes = this.getPSDEForm().getPSAppView().getPSApplication().getPSLanguageRes(this.psDEFormDetail.getMASKPSLANRESID());
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getRESETITEMNAME())) {
            String[] items;
            this.strRefreshItems = this.psDEFormDetail.getRESETITEMNAME();
            String[] stringArray = items = StringHelper.SplitEx((String)this.strRefreshItems);
            int n = items.length;
            int n2 = 0;
            while (n2 < n) {
                String strItem = stringArray[n2];
                if (StringHelper.IsNullOrEmpty((String)(strItem = strItem.trim()))) {
                    this.getPSDEForm().hookPSDEFormItem(strItem, this);
                }
                ++n2;
            }
        }
        if (!this.psDEFormDetail.isBUILDINACTIONNull()) {
            this.nRefreshAction = 0;
            int nIgnoreRefreshAction = this.psDEFormDetail.getBUILDINACTION();
            if ((nIgnoreRefreshAction & 1) == 0) {
                this.nRefreshAction |= 1;
            }
            if ((nIgnoreRefreshAction & 2) == 0) {
                this.nRefreshAction |= 2;
            }
            if ((nIgnoreRefreshAction & 4) == 4) {
                this.bIngoreRefreshItemsRefresh = true;
            }
        } else {
            this.nRefreshAction = 3;
        }
        super.onInit();
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEDRITEMID())) {
            this.iPSDEDRItem = this.getPSDEForm().getPSDataEntity().getPSDEDRItem(this.psDEFormDetail.getPSDEDRITEMID());
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDEDRItem.getPSDEViewId())) {
                try {
                    boolean bTryMode = this.getPSDEForm().isDesignMode();
                    String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)this.iPSDEDRItem.getPSDEViewId());
                    this.iPSAppView = bTryMode ? this.getPSDEForm().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, this.iPSDEDRItem.getPSDEViewId(), bTryMode) : this.getPSDEForm().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, this.iPSDEDRItem.getPSDEViewId(), this.getPSDEForm().getPSAppView());
                    if (this.iPSAppView != null) {
                        this.strEmbedViewId = this.getPSDEForm().getPSAppView().generateViewUniId();
                        this.iPSAppView.markViewUsage(4, this);
                    }
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5173\u7cfb\u754c\u9762\u9879[%1$s]\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.iPSDEDRItem.getName(), (Object)ex.getMessage()), ex);
                }
            }
        }
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u9879")
    public IPSDEDRItem getPSDEDRItem() {
        return this.iPSDEDRItem;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u9879\u6807\u8bb0", ignorert=3, fields={"DRITEMTAG"})
    public String getDRItemTag() {
        return this.getPSDEDRItem() != null ? this.getPSDEDRItem().getCodeName() : null;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u89c6\u56fe", child=true, rtdump=1, doc="\u8ba1\u7b97\u5173\u7cfb\u754c\u9762\u9879{@link net.ibizsys.centralstudio.dto.PSDEFormDetailDTO#FIELD_PSDEDRITEMID}")
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.iPSAppView != null) {
            relatedAppViewList.add(this.iPSAppView);
        }
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
        psDEFormDRUIPartList.add(this);
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (StringHelper.IsNullOrEmpty((String)this.getEmbedViewId())) {
            return;
        }
        IPSAppView refPSAppView = this.getPSAppView();
        if (refPSAppView == null) {
            return;
        }
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        PSAppViewRef psAppViewRef = new PSAppViewRef();
        psAppViewRefImpl.init(this.getDAGlobalHelper(), this.getPSDEForm().getPSAppView(), psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(refPSAppView);
        String strFullViewId = "";
        strFullViewId = StringHelper.IsNullOrEmpty((String)strContainerId) ? this.getEmbedViewId() : StringHelper.Format((String)"%1$s_%2$s", (Object)strContainerId, (Object)this.getEmbedViewId());
        psAppViewRefImpl.setEmbedId(strFullViewId);
        embeddedPSAppViewRefList.add(psAppViewRefImpl);
        Iterator<IPSAppViewRef> childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
        if (childPSAppViewRefs != null) {
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add(childPSAppViewRefs.next());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u5237\u65b0\u89e6\u53d1\u8868\u5355\u9879", fields={"RESETITEMNAME"})
    public String getRefreshItems() {
        return this.strRefreshItems;
    }

    @Override
    public String getPSDEFIUpdateId() {
        return this.psDEFormDetail.getPSDEFIUPDATEID();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8868\u5355\u9879\u66f4\u65b0", hideempty=true, dumpref=true, from="IPSDEForm", fields={"PSDEFIUPDATEID"})
    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFIUpdateId())) {
            return null;
        }
        return this.getPSDEForm().getPSDEFormItemUpdate(this.getPSDEFIUpdateId());
    }

    @Override
    public int getRefreshActions() {
        return this.nRefreshAction;
    }

    @Override
    public boolean isEnableRefreshAction(int nAction) {
        return (this.getRefreshActions() & nAction) == nAction;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u53c2\u6570\u9879\u540d\u79f0", fields={"VALUEITEMNAME"})
    public String getParamItem() {
        String strValueItemName = this.psDEFormDetail.getVALUEITEMNAME();
        if (StringHelper.IsNullOrEmpty((String)strValueItemName)) {
            return null;
        }
        return strValueItemName;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u8fdb\u884c\u4fdd\u5b58", fields={"WBDEFMODE"})
    public boolean isNeedSave() {
        if (this.psDEFormDetail.isWBDEFMODENull()) {
            return false;
        }
        return this.psDEFormDetail.getWBDEFMODE() == 1;
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_DRUIPART";
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u5237\u65b0\u9879\u53ea\u8d4b\u503c\u4e0d\u5237\u65b0", fields={"BUILDINACTION"})
    public boolean isRefreshItemsSetParamOnly() {
        return this.bIngoreRefreshItemsRefresh;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u6570\u636e\u5bf9\u8c61")
    public JSONObject getParentDataJO() {
        if (this.getPSDEDRItem() == null) {
            return null;
        }
        return this.getPSDEDRItem().getParentDataJO();
    }

    @Override
    public String getParamJOString() {
        return null;
    }

    @Override
    public String getContextJOString() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.getPSDEDRItem() == null) {
            return null;
        }
        return this.getPSDEDRItem().getPSNavigateParams();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.getPSDEDRItem() == null) {
            return null;
        }
        return this.getPSDEDRItem().getPSNavigateContexts();
    }

    @Override
    @PSModelRTMeta(description="\u906e\u7f69\u6a21\u5f0f", codelist="FormDRUIPartMaskMode", ignoredumpvalues="-1", fields={"MASKMODE"})
    public int getMaskMode() {
        return this.nMaskMode;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u906e\u7f69\u4fe1\u606f", fields={"MASKINFO"})
    public String getMaskInfo() {
        return this.strMaskInfo;
    }

    @Override
    @PSModelRTMeta(description="\u906e\u7f69\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", fields={"MASKPSLANRESID"})
    public IPSLanguageRes getMaskPSLanguageRes() {
        if (this.maskPSLanguageRes == null) {
            return this.onGetMaskPSLanguageRes();
        }
        return this.maskPSLanguageRes;
    }

    protected IPSLanguageRes onGetMaskPSLanguageRes() {
        return null;
    }
}


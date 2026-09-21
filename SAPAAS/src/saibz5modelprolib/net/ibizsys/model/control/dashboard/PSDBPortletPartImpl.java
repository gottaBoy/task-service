/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPartParam
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.paas.util.StringBuilderEx
 */
package net.ibizsys.model.control.dashboard;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.PSAjaxControlContainerImpl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDBPortletPartParam;
import net.ibizsys.model.control.dashboard.IPSDBPortletPartRuntime;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.paas.util.StringBuilderEx;

public abstract class PSDBPortletPartImpl
extends PSAjaxControlContainerImpl
implements IPSDBPortletPart,
IPSDBPortletPartRuntime {
    private IPSDBPortletPartParam iPSDBPortletPartParam = null;
    private String strColCssClass = "";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.iPSDBPortletPartParam = (IPSDBPortletPartParam)iPSControlParam;
        super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strColCssClass = this.prepareColCssClass();
    }

    public String getControlType() {
        return "PORTLET";
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDBPortletPartParam;
    }

    @PSModelRTMeta(description="\u8868\u683c\u5e03\u5c40\u5217\u6807\u8bc6")
    public int getDefaultColId() {
        return this.iPSDBPortletPartParam.getColumnId();
    }

    public IPSControl getContentPSControl() {
        return null;
    }

    @PSModelRTMeta(description="\u6805\u683c\u5e03\u5c40\u6837\u5f0f")
    public String getColCssClass() {
        return this.strColCssClass;
    }

    protected String prepareColCssClass() {
        StringBuilderEx sb = new StringBuilderEx();
        if (this.iPSDBPortletPartParam.getColXS() != -1) {
            sb.append(" col-xs-%1$s", (Object)this.iPSDBPortletPartParam.getColXS());
        }
        if (this.iPSDBPortletPartParam.getColSM() != -1) {
            sb.append(" col-sm-%1$s", (Object)this.iPSDBPortletPartParam.getColSM());
        }
        if (this.iPSDBPortletPartParam.getColMD() != -1) {
            sb.append(" col-md-%1$s", (Object)this.iPSDBPortletPartParam.getColMD());
        }
        if (this.iPSDBPortletPartParam.getColLG() != -1) {
            sb.append(" col-lg-%1$s", (Object)this.iPSDBPortletPartParam.getColLG());
        }
        if (this.iPSDBPortletPartParam.getColXSOffset() != -1) {
            sb.append(" col-xs-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColXSOffset());
        }
        if (this.iPSDBPortletPartParam.getColSMOffset() != -1) {
            sb.append(" col-sm-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColSMOffset());
        }
        if (this.iPSDBPortletPartParam.getColMDOffset() != -1) {
            sb.append(" col-md-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColMDOffset());
        }
        if (this.iPSDBPortletPartParam.getColLGOffset() != -1) {
            sb.append(" col-lg-offset-%1$s", (Object)this.iPSDBPortletPartParam.getColLGOffset());
        }
        return sb.toString();
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6")
    public double getHeight() {
        if (this.iPSDBPortletPartParam.getHeight() != null) {
            return this.iPSDBPortletPartParam.getHeight();
        }
        return 0.0;
    }

    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        return this.iPSDBPortletPartParam.getTitle();
    }

    public abstract IPSPortletType getPSPortetType();

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getContentPSControl() != null) {
            ((IPSControlRuntime)this.getContentPSControl()).fillRelatedPSAppViews(relatedAppViewList);
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        if (this.getContentPSControl() != null) {
            ((IPSControlRuntime)this.getContentPSControl()).fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        if (this.getContentPSControl() != null) {
            ((IPSControlRuntime)this.getContentPSControl()).fillRelatedPSCodeLists(relatedPSCodeListList);
        }
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
    }

    @Override
    public String getModelType() {
        return "PSSYSDBPART";
    }

    public boolean isShowTitleBar() {
        if (this.iPSDBPortletPartParam.getShowTitleBar() == null) {
            return this.onGetShowTitleBar();
        }
        return this.iPSDBPortletPartParam.getShowTitleBar();
    }

    protected boolean onGetShowTitleBar() {
        return true;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewDataItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataViewDataItemImpl
extends PSDataItemImpl
implements IPSDEDataViewDataItem {
    private static final Log log = LogFactory.getLog(PSDEDataViewDataItemImpl.class);
    public static final String KEYITEM = "srfkey";
    public static final String MAJORTEXTITEM = "srfmajortext";
    private IPSCodeList frontPSCodeList = null;
    private IPSDEDataView iPSDEDataView = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private boolean bCustomCode = false;
    private String strScriptCode = null;

    public void init(IPSDEDataView iPSDEDataView) throws Exception {
        this.iPSDEDataView = iPSDEDataView;
        this.onInit();
    }

    protected void onInit() throws Exception {
        if (this.getPSCodeList() != null) {
            this.setConvertToCodeItemText(true);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true)
    public IPSCodeList getFrontPSCodeList() {
        return this.frontPSCodeList;
    }

    public void setFrontPSCodeList(IPSCodeList frontPSCodeList) {
        this.frontPSCodeList = frontPSCodeList;
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDataView() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDataView().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSDEDATAVIEWDATAITEM";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5361\u7247\u89c6\u56fe")
    public IPSDEDataView getPSDEDataView() {
        return this.iPSDEDataView;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSDEDataView() != null) {
            return this.getPSDEDataView().getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        if (this.iPSDEField != null) {
            return this.iPSDEField;
        }
        IPSDEField iPSDEField = null;
        if (this.getDataItemParam() != null && this.getDataItemParam() instanceof IPSDataItemParam && (iPSDEField = ((IPSDataItemParam)this.getDataItemParam()).getPSDEField()) == null && this.getPSDEDataView() != null) {
            try {
                iPSDEField = this.getPSDEDataView().getPSDataEntity().getPSDEField(this.getDataItemParam().getName(), true);
                if (iPSDEField != null && this.getPSDEDataView().getPSAppDataEntity() != null) {
                    this.iPSAppDEField = this.getPSDEDataView().getPSAppDataEntity().getPSAppDEField(iPSDEField.getName(), true);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        try {
            if (iPSDEField != null && this.getPSDEDataView() != null && this.getPSDEDataView().getPSAppDataEntity() != null) {
                this.iPSAppDEField = this.getPSDEDataView().getPSAppDataEntity().getPSAppDEField(iPSDEField.getName(), true);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.iPSDEField = iPSDEField;
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true)
    public IPSAppDEField getPSAppDEField() {
        this.getPSDEField();
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    public void setCustomCode(boolean bCustomCode) {
        this.bCustomCode = bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801")
    public String getScriptCode() {
        return this.strScriptCode;
    }

    public void setScriptCode(String strScriptCode) {
        this.strScriptCode = strScriptCode;
    }
}


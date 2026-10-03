/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlParamRuntime;
import net.ibizsys.model.entity.PSDEViewCtrl;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlParamImpl
extends PSObjectImpl
implements IPSControlParam,
IPSControlParamRuntime {
    protected IPSAppView iPSAppView = null;
    protected PSDEViewCtrl psDEViewCtrl = null;
    private HashMap<String, Object> ctrlParams = null;
    private static final Log log = LogFactory.getLog(PSControlParamImpl.class);
    private Double fWidth = null;
    private Double fHeight = null;
    private Integer nOrderValue = null;
    private String strCtrlParam = null;
    private String strCtrlParam2 = null;
    private String strPSSysPFPluginId = null;
    private String strPSSysCssId = null;
    private Boolean bDefaultCtrl = null;
    private Boolean bDynamicCtrl = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSAppView iPSAppView, PSDEViewCtrl psDEViewCtrl) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSAppView(iPSAppView);
        this.setPSDEViewCtrlData(psDEViewCtrl);
        this.setName(this.psDEViewCtrl.getPSDEVIEWCTRLNAME());
        if (!psDEViewCtrl.isWIDTHNull()) {
            this.fWidth = (double)psDEViewCtrl.getWIDTH();
        }
        if (!psDEViewCtrl.isHEIGHTNull()) {
            this.fHeight = (double)psDEViewCtrl.getHEIGHT();
        }
        if (!psDEViewCtrl.isORDERVALUENull() && psDEViewCtrl.getORDERVALUE() >= 0) {
            this.nOrderValue = psDEViewCtrl.getORDERVALUE();
        }
        if (!psDEViewCtrl.isCTRLPARAMNull()) {
            this.strCtrlParam = psDEViewCtrl.getCTRLPARAM();
        }
        if (!psDEViewCtrl.isCTRLPARAM2Null()) {
            this.strCtrlParam2 = psDEViewCtrl.getCTRLPARAM2();
        }
        if (!psDEViewCtrl.isPSSYSPFPLUGINIDNull()) {
            this.strPSSysPFPluginId = psDEViewCtrl.getPSSYSPFPLUGINID();
        }
        if (!psDEViewCtrl.isPSSYSCSSIDNull()) {
            this.strPSSysCssId = psDEViewCtrl.getPSSYSCSSID();
        }
        if (!psDEViewCtrl.isDEFAULTFLAGNull()) {
            this.bDefaultCtrl = psDEViewCtrl.getDEFAULTFLAG();
        }
        if (!psDEViewCtrl.isDYNCMODENull()) {
            this.bDynamicCtrl = psDEViewCtrl.getDYNCMODE();
        }
        if (!StringHelper.isNullOrEmpty((String)psDEViewCtrl.getCTRLPARAMS())) {
            Properties properties = PropertiesHelper.load((String)psDEViewCtrl.getCTRLPARAMS());
            for (Object objKey : properties.keySet()) {
                String strValue = PropertiesHelper.getProperty((Properties)properties, (String)objKey.toString());
                this.setCtrlParam(objKey.toString(), strValue);
            }
        }
        this.onInit();
    }

    public void merge(IPSControlParam iPSControlParam) {
        this.onMerge(iPSControlParam);
    }

    protected void onMerge(IPSControlParam iPSControlParam) {
        Iterator ctrlParamNames;
        if (!StringHelper.isNullOrEmpty((String)iPSControlParam.getName())) {
            this.setName(iPSControlParam.getName());
        }
        if (iPSControlParam.getPSAppView() != null) {
            this.setPSAppView(iPSControlParam.getPSAppView());
        }
        if (iPSControlParam.getWidth() != null) {
            this.setWidth(iPSControlParam.getWidth());
        }
        if (iPSControlParam.getHeight() != null) {
            this.setHeight(iPSControlParam.getHeight());
        }
        if (iPSControlParam.getOrderValue() != null) {
            this.setOrderValue(iPSControlParam.getOrderValue());
        }
        if (iPSControlParam.getCtrlParam() != null) {
            this.setCtrlParam(iPSControlParam.getCtrlParam());
        }
        if (iPSControlParam.getCtrlParam2() != null) {
            this.setCtrlParam2(iPSControlParam.getCtrlParam2());
        }
        if (((IPSControlParamRuntime)iPSControlParam).getPSSysPFPluginId() != null) {
            this.setPSSysPFPluginId(((IPSControlParamRuntime)iPSControlParam).getPSSysPFPluginId());
        }
        if (iPSControlParam.getPSSysCssId() != null) {
            this.setPSSysCssId(iPSControlParam.getPSSysCssId());
        }
        if (iPSControlParam.isDefaultCtrl() != null) {
            this.setDefaultCtrl(iPSControlParam.isDefaultCtrl());
        }
        if (iPSControlParam.isDynamicCtrl() != null) {
            this.setDynamicCtrl(iPSControlParam.isDynamicCtrl());
        }
        if ((ctrlParamNames = iPSControlParam.getCtrlParamNames()) != null) {
            while (ctrlParamNames.hasNext()) {
                String strParamName = (String)ctrlParamNames.next();
                Object objValue = iPSControlParam.getCtrlParam(strParamName);
                this.setCtrlParam(strParamName, objValue);
            }
        }
    }

    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    protected void setPSDEViewCtrlData(PSDEViewCtrl psDEViewCtrl) {
        this.psDEViewCtrl = psDEViewCtrl;
    }

    public void setCtrlParam(String strParamName, Object objValue) {
        if (this.ctrlParams == null) {
            this.ctrlParams = new HashMap();
        }
        strParamName = strParamName.toUpperCase();
        this.ctrlParams.put(strParamName, objValue);
    }

    public Object getCtrlParam(String strParamName) {
        if (this.ctrlParams == null) {
            return null;
        }
        return this.ctrlParams.get(strParamName.toUpperCase());
    }

    public boolean containsCtrlParam(String strParamName) {
        if (this.ctrlParams == null) {
            return false;
        }
        return this.ctrlParams.get(strParamName.toUpperCase()) != null;
    }

    public String getCtrlParam(String strParamName, String strDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        return objValue.toString();
    }

    public boolean getCtrlParam(String strParamName, boolean bDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return bDefault;
        }
        return StringHelper.compare((String)objValue.toString(), (String)"TRUE", (boolean)true) == 0;
    }

    public int getCtrlParam(String strParamName, int nDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(objValue.toString());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public Iterator<String> getCtrlParamNames() {
        if (this.ctrlParams == null) {
            return null;
        }
        return this.ctrlParams.keySet().iterator();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSAppView).getPSSysModelInstId();
    }

    public Double getWidth() {
        return this.fWidth;
    }

    public Double getHeight() {
        return this.fHeight;
    }

    public void setWidth(Double fWidth) {
        this.fWidth = fWidth;
    }

    public void setHeight(Double fHeight) {
        this.fHeight = fHeight;
    }

    protected PSDEViewCtrl getPSDEViewCtrlData() {
        return this.psDEViewCtrl;
    }

    public Integer getOrderValue() {
        return this.nOrderValue;
    }

    public void setOrderValue(Integer nOrderValue) {
        this.nOrderValue = nOrderValue;
    }

    public String getCtrlParam() {
        return this.strCtrlParam;
    }

    public void setCtrlParam(String strCtrlParam) {
        this.strCtrlParam = strCtrlParam;
    }

    public String getCtrlParam2() {
        return this.strCtrlParam2;
    }

    public void setCtrlParam2(String strCtrlParam2) {
        this.strCtrlParam2 = strCtrlParam2;
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.strPSSysPFPluginId;
    }

    public void setPSSysPFPluginId(String strSysPFPluginId) {
        this.strPSSysPFPluginId = strSysPFPluginId;
    }

    public String getPSSysCssId() {
        return this.strPSSysCssId;
    }

    public void setPSSysCssId(String strSysCssId) {
        this.strPSSysCssId = strSysCssId;
    }

    public Boolean isDefaultCtrl() {
        return this.bDefaultCtrl;
    }

    public void setDefaultCtrl(Boolean bDefaultCtrl) {
        this.bDefaultCtrl = bDefaultCtrl;
    }

    public Boolean isDynamicCtrl() {
        return this.bDynamicCtrl;
    }

    public void setDynamicCtrl(Boolean bDynamicCtrl) {
        this.bDynamicCtrl = bDynamicCtrl;
    }
}

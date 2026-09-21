/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSSubViewType;
import SA.SRFDA.PS.Data.PSUIEngineType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubViewTypeImpl
extends PSSystemObjectImpl
implements IPSSubViewType,
IPSUIEngineType {
    private static final Log log = LogFactory.getLog(PSSubViewTypeImpl.class);
    protected PSSubViewType psSubViewType = null;
    private Properties viewParamProperties = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private Properties rtParams = null;
    private ArrayList<String> rtParamList = new ArrayList();
    private IPSSystemModule iPSSystemModule = null;
    private boolean bExtendStyleOnly = false;
    private ObjectNode viewModel = null;
    private boolean bReplaceDefault = false;
    private String strPSViewTypeId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSubViewType psSubViewType) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSubViewType = psSubViewType;
            this.setId(this.psSubViewType.getPSSUBVIEWTYPEID());
            this.setName(this.psSubViewType.getPSSUBVIEWTYPENAME());
            this.setPSObjectData(this.psSubViewType);
            if (!this.psSubViewType.isEXTENDSTYLEONLYNull()) {
                this.bExtendStyleOnly = this.psSubViewType.getEXTENDSTYLEONLY();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubViewType.getVIEWMODEL())) {
                this.viewModel = (ObjectNode)JsonNodeHelper.fromString((String)this.psSubViewType.getVIEWMODEL());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubViewType.getVIEWPARAMS())) {
                this.viewParamProperties = PropertiesHelper.load((String)this.psSubViewType.getVIEWPARAMS());
            }
            this.rtParams = PropertiesHelper.load((String)this.psSubViewType.getUTILPARAMS());
            Enumeration<Object> objKeys = this.rtParams.keys();
            if (objKeys != null) {
                while (objKeys.hasMoreElements()) {
                    this.rtParamList.add((String)objKeys.nextElement());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubViewType.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSubViewType.getPSMODULEID());
            }
            if (!this.psSubViewType.isREPDEFAULTNull()) {
                this.bReplaceDefault = this.psSubViewType.getREPDEFAULT();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psSubViewType.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.psSubViewType.getPSSYSPFPLUGINID());
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.isReplaceDefault()) {
            if (StringHelper.isNullOrEmpty((String)this.getViewType())) {
                throw new Exception(String.format("\u672a\u6307\u5b9a\u9ed8\u8ba4\u66ff\u6362\u7684\u89c6\u56fe\u7c7b\u578b", new Object[0]));
            }
            if (StringHelper.isNullOrEmpty((String)this.getPSSysViewPanelId())) {
                throw new Exception(String.format("\u672a\u6307\u5b9a\u9ed8\u8ba4\u66ff\u6362\u7684\u89c6\u56fe\u5e03\u5c40\u9762\u677f", new Object[0]));
            }
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b\u4ee3\u7801")
    public String getTypeCode() {
        return this.psSubViewType.getTYPECODE();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u547d\u540d\u6a21\u5f0f", codelist="SubViewTypeNameMode")
    public String getNameMode() {
        return this.psSubViewType.getNAMEMODE();
    }

    @Override
    public boolean isExtendView() {
        return this.psSubViewType.getEXTENDVIEW();
    }

    @Override
    public boolean isExtendCtrl() {
        return this.psSubViewType.getEXTENDCTRL();
    }

    @Override
    public String getViewParam(String strKey, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.viewParamProperties, (String)strKey, (String)strDefault);
    }

    @Override
    public int getViewParam(String strKey, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.viewParamProperties, (String)strKey, (int)nDefault);
    }

    @Override
    public boolean getViewParam(String strKey, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.viewParamProperties, (String)strKey, (boolean)bDefault);
    }

    @Override
    public String getModelType() {
        return "PSSUBVIEWTYPE";
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public IPSUIEngineType getPSUIEngineType() {
        if (this.isExtendCtrl()) {
            return this;
        }
        return null;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSUIEngineType psUIEngineType) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getEngineCat() {
        return "UXVIEW";
    }

    @Override
    public Iterator<String> getEngineParamNames() throws Exception {
        return this.rtParamList.iterator();
    }

    @Override
    public String getEngineParamKey(String strName) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.rtParams, (String)strName);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSubViewType.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u6269\u5c55\u754c\u9762\u6837\u5f0f", ignoredumpvalues="false")
    public boolean isExtendStyleOnly() {
        return this.bExtendStyleOnly;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6a21\u578b", hideempty=true)
    public ObjectNode getViewModel() {
        return this.viewModel;
    }

    @Override
    public int getEngineParamMode(String strTag) throws Exception {
        return 1;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u9ed8\u8ba4\u66ff\u6362", ignoredumpvalues="false", fields={"REPDEFAULT"})
    public boolean isReplaceDefault() {
        return this.bReplaceDefault;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u89c6\u56fe\u7c7b\u578b", fields={"PSVIEWTYPEID"})
    public String getViewType() {
        if (!this.isReplaceDefault()) {
            return null;
        }
        return this.psSubViewType.getPSVIEWTYPEID();
    }

    @Override
    public String getPSSysViewPanelId() {
        if (!this.isReplaceDefault()) {
            return null;
        }
        return this.psSubViewType.getPSSYSVIEWPANELID();
    }
}


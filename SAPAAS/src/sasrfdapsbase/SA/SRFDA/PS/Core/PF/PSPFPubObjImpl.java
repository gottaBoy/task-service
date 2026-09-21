/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPubObj;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherHelper;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Data.PSPFPubObj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPubObjImpl
extends PSPFObjectImpl
implements IPSPFPubObj {
    protected PSPFPubObj psPFPubObj = null;
    private static final Log log = LogFactory.getLog(PSPFPubObjImpl.class);
    private String strTag = null;
    private String strTag2 = null;
    private String strTarget = null;
    private String strTargetType = null;
    private String strPubObj = null;
    private Properties macroParams = null;
    private Map<String, String> macroParamMap = null;
    private IPSCodePublisherHelper iPSCodePublisherHelper = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFPubObj psPFPubObj) throws Exception {
        try {
            this.psPFPubObj = psPFPubObj;
            this.setPSPF(iPSPF);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(this.psPFPubObj.getPSPFPUBOBJID());
            this.setName(this.psPFPubObj.getPSPFPUBOBJNAME());
            this.setPSObjectData(this.psPFPubObj);
            this.strTag = this.psPFPubObj.getPUBOBJTAG();
            this.strTag2 = this.psPFPubObj.getPUBOBJTAG2();
            this.strTarget = this.psPFPubObj.getTARGET();
            this.strTargetType = this.psPFPubObj.getTARGETTYPE();
            this.strPubObj = this.psPFPubObj.getPUBOBJ();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPubObj) && SA.SRFramework.Utility.StringHelper.Compare((String)this.getTargetType(), (String)"VIEW", (boolean)true) == 0 && this.getPSPF2() != null) {
                this.strPubObj = this.getPSPF2().getViewPubObj2();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psPFPubObj.getMACROPARAMS())) {
                this.macroParams = PropertiesHelper.load((String)this.psPFPubObj.getMACROPARAMS());
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getTargetType(), (String)"VIEW", (boolean)true) == 0 && this.getPSPF2() != null) {
                this.macroParams = PropertiesHelper.load((String)this.getPSPF2().getViewPubObj2MacroParams());
            }
            if (this.macroParams != null) {
                this.macroParamMap = new HashMap<String, String>();
                Enumeration<Object> keys = this.macroParams.keys();
                while (keys.hasMoreElements()) {
                    String strKey = (String)keys.nextElement();
                    String strValue = PropertiesHelper.getProperty((Properties)this.macroParams, (String)strKey, (String)"");
                    this.macroParamMap.put(strKey, strValue);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPubObj())) {
                try {
                    Object objPublisher = ObjectHelper.create((String)this.getPubObj());
                    if (objPublisher instanceof IPSCodePublisherHelper) {
                        this.iPSCodePublisherHelper = (IPSCodePublisherHelper)objPublisher;
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSPF.getPSSysModelInstId();
    }

    @Override
    public String getTag() {
        return this.strTag;
    }

    @Override
    public String getTag2() {
        return this.strTag2;
    }

    @Override
    public String getTarget() {
        return this.strTarget;
    }

    @Override
    public String getTargetType() {
        return this.strTargetType;
    }

    @Override
    public String getPubObj() {
        return this.strPubObj;
    }

    @Override
    public String replaceMacros(String strContent) throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strContent) || strContent.indexOf("%") == -1) {
            return strContent;
        }
        if (this.macroParams != null) {
            for (Map.Entry<Object, Object> entry : this.macroParams.entrySet()) {
                String strKey = (String)entry.getKey();
                if (strKey.indexOf("%") != 0) continue;
                String strValue = (String)entry.getValue();
                strContent = strContent.replace(strKey, strValue);
            }
        }
        if (strContent.indexOf("%") == -1) {
            return strContent;
        }
        IPSPFPubObj parentPSPFPubObj = this.getParentPSPFPubObj();
        if (parentPSPFPubObj != null) {
            return parentPSPFPubObj.replaceMacros(strContent);
        }
        return strContent;
    }

    public IPSPFPubObj getParentPSPFPubObj() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psPFPubObj.getPPSPFPUBOBJID())) {
            return null;
        }
        return this.getPSPF().getPSPFPubObj(this.psPFPubObj.getPPSPFPUBOBJID(), false);
    }

    @Override
    public String getModelType() {
        return "PSPFPUBOBJ";
    }

    protected IPSCodePublisherHelper getPSCodePublisherHelper() {
        return this.iPSCodePublisherHelper;
    }

    @Override
    public void fillPublisherMacros(Map<String, String> macroParamMap) {
        if (this.macroParamMap != null) {
            macroParamMap.putAll(this.macroParamMap);
        }
    }

    @Override
    public void fillPublisherParams(IPSModelObject iPSModelObject, Map<String, IPSCodePublisherParam> publisherParamMap) {
        if (this.getPSCodePublisherHelper() != null) {
            this.getPSCodePublisherHelper().fillPublisherParams(iPSModelObject, publisherParamMap);
        }
    }
}


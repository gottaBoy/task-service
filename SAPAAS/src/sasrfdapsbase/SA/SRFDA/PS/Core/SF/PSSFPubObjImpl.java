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
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherHelper;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisherParamImpl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPubObj;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFPubObj;
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

public class PSSFPubObjImpl
extends PSSFObjectImpl
implements IPSSFPubObj {
    private static final Log log = LogFactory.getLog(PSSFPubObjImpl.class);
    private String strTag = null;
    private String strTag2 = null;
    private String strTarget = null;
    private String strPubObj = null;
    private Properties macroParams = null;
    protected PSSFPubObj psSFPubObj = null;
    private Map<String, String> macroParamMap = null;
    private IPSCodePublisherHelper iPSCodePublisherHelper = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFPubObj psSFPubObj) throws Exception {
        try {
            this.psSFPubObj = psSFPubObj;
            this.setPSSF(iPSSF);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(this.psSFPubObj.getPSSFPUBOBJID());
            this.setName(this.psSFPubObj.getPSSFPUBOBJNAME());
            this.setPSObjectData(this.psSFPubObj);
            this.strTag = this.psSFPubObj.getPUBOBJTAG();
            this.strTag2 = this.psSFPubObj.getPUBOBJTAG2();
            this.strTarget = this.psSFPubObj.getTARGET();
            this.strPubObj = this.psSFPubObj.getPUBOBJ();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSFPubObj.getMACROPARAMS())) {
                this.macroParams = PropertiesHelper.load((String)this.psSFPubObj.getMACROPARAMS());
                if (this.macroParams != null) {
                    this.macroParamMap = new HashMap<String, String>();
                    Enumeration<Object> keys = this.macroParams.keys();
                    while (keys.hasMoreElements()) {
                        String strKey = (String)keys.nextElement();
                        String strValue = PropertiesHelper.getProperty((Properties)this.macroParams, (String)strKey, (String)"");
                        this.macroParamMap.put(strKey, strValue);
                    }
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
        return this.iPSSF.getPSSysModelInstId();
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
        IPSSFPubObj parentPSSFPubObj = this.getParentPSSFPubObj();
        if (parentPSSFPubObj != null) {
            return parentPSSFPubObj.replaceMacros(strContent);
        }
        return strContent;
    }

    public IPSSFPubObj getParentPSSFPubObj() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSFPubObj.getPPSSFPUBOBJID())) {
            return null;
        }
        return this.getPSSF().getPSSFPubObj(this.psSFPubObj.getPPSSFPUBOBJID(), false);
    }

    @Override
    public String getModelList() {
        return this.psSFPubObj.getMODELLIST();
    }

    @Override
    public String getModelType() {
        return "PSSFPUBOBJ";
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
        if (!publisherParamMap.containsKey("P")) {
            publisherParamMap.put("P", new PSSFCodePublisherParamImpl(iPSModelObject, "P", null, "\u53d1\u5e03\u5668\u4e0a\u4e0b\u6587\u5bf9\u8c61", "net.ibizsys.model.pub.IPSSFSysCodePublisherContext"));
        }
        if (!publisherParamMap.containsKey("pub")) {
            publisherParamMap.put("pub", new PSSFCodePublisherParamImpl(iPSModelObject, "pub", null, "\u540e\u53f0\u6a21\u677f\u53d1\u5e03\u5bf9\u8c61", "net.ibizsys.model.pub.IPSSysSFPub"));
        }
    }
}


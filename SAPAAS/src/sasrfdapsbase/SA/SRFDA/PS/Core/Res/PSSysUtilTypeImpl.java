/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.Res.IPSSysUtilType;
import SA.SRFDA.PS.Core.Res.PSSysUtilImpl;
import SA.SRFDA.PS.Data.PSSysUtil;
import SA.SRFDA.PS.Data.PSSysUtilType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysUtilTypeImpl
extends PSObjectImpl
implements IPSSysUtilType {
    protected PSSysUtilType psSysUtilType = null;
    private static final Log log = LogFactory.getLog(PSSysUtilTypeImpl.class);
    private Properties baseClassParams = null;
    private boolean bRegisterSys = false;
    private Properties rtParams = null;
    private ArrayList<String> rtParamList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSysUtilType psSysUtilType) throws Exception {
        Enumeration<Object> objKeys;
        this.psSysUtilType = psSysUtilType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSysUtilType.getPSSYSUTILTYPEID());
        this.setName(psSysUtilType.getPSSYSUTILTYPENAME());
        this.setPSObjectData(this.psSysUtilType);
        this.baseClassParams = PropertiesHelper.Load((String)this.psSysUtilType.getUTILRTOBJS());
        this.rtParams = PropertiesHelper.Load((String)this.psSysUtilType.getUTILPARAMS());
        if (!this.psSysUtilType.isREGTOSYSFLAGNull()) {
            this.bRegisterSys = this.psSysUtilType.getREGTOSYSFLAG();
        }
        if ((objKeys = this.rtParams.keys()) != null) {
            while (objKeys.hasMoreElements()) {
                this.rtParamList.add((String)objKeys.nextElement());
            }
        }
        this.onInit();
    }

    @Override
    public IPSSysUtil createPSSysUtil(PSSysUtil psSysUtil) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysUtilType.getUTILOBJ())) {
            return new PSSysUtilImpl();
        }
        return (IPSSysUtil)ObjectHelper.Create((String)this.psSysUtilType.getUTILOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getBaseClass(String strPSSFStyleId) throws Exception {
        return this.getBaseClass(strPSSFStyleId, false);
    }

    public String getBaseClass(String strPSSFStyleId, boolean bTryMode) throws Exception {
        String strBaseClass = PropertiesHelper.GetProperty((Properties)this.baseClassParams, (String)strPSSFStyleId);
        if (StringHelper.isNullOrEmpty((String)strBaseClass) && this.baseClassParams != null) {
            for (Object objKey : this.baseClassParams.keySet()) {
                String strKey = (String)objKey;
                if (strPSSFStyleId.indexOf(strKey) != 0) continue;
                strBaseClass = PropertiesHelper.GetProperty((Properties)this.baseClassParams, (String)strKey);
                break;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)strBaseClass)) {
            strBaseClass = strBaseClass.trim();
        }
        if (StringHelper.isNullOrEmpty((String)strBaseClass) && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u529f\u80fd\u7c7b\u578b[%1$s]\u670d\u52a1\u6846\u67b6[%2$s]\u57fa\u7c7b", (Object)this.getName(), (Object)strPSSFStyleId));
        }
        return strBaseClass;
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        return this.getClassOrPkgName(strCodeType, iPSSysSFPub, false);
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub, boolean bTryMode) throws Exception {
        String strId = "";
        strId = StringHelper.isNullOrEmpty((String)strCodeType) ? StringHelper.format((String)"%1$s", (Object)iPSSysSFPub.getPSSFStyle().getId()) : StringHelper.format((String)"%1$s.%2$s", (Object)strCodeType, (Object)iPSSysSFPub.getPSSFStyle().getId());
        return this.getBaseClass(strId, bTryMode);
    }

    @Override
    public String getCodeName() {
        return null;
    }

    @Override
    public boolean isRegToSys() {
        return this.bRegisterSys;
    }

    @Override
    public Iterator<String> getRTParamNames() throws Exception {
        return this.rtParamList.iterator();
    }

    @Override
    public String getRTParamKey(String strName) throws Exception {
        return PropertiesHelper.GetProperty((Properties)this.rtParams, (String)strName);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleParamImpl
extends PSSFObjectImpl
implements IPSSFStyleParam {
    protected PSSFStyleParam psSFStyleParam = null;
    private static final Log log = LogFactory.getLog(PSSFStyleParamImpl.class);
    private Properties classPkgParamsMap = null;
    private static ThreadLocal<IPSSFStyleParam> currentPSSFStyleParam = new ThreadLocal();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFStyleParam psSFStyleParam) throws Exception {
        this.psSFStyleParam = psSFStyleParam;
        this.setPSSF(iPSSF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFStyleParam.getPSSFSTYLEPARAMID());
        this.setName(this.psSFStyleParam.getPSSFSTYLEPARAMNAME());
        this.setPSObjectData(this.psSFStyleParam);
        this.classPkgParamsMap = PropertiesHelper.Load((String)this.psSFStyleParam.getSTYLEPARAMS());
        this.onInit();
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
    public String getStyleParam(String strParamName, String strDefault) {
        return PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strParamName, (String)strDefault);
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        return PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strParamName, (int)nDefault);
    }

    @Override
    public boolean containsStyleParam(String strParamName) {
        return this.classPkgParamsMap.containsKey(strParamName);
    }

    public static void setCurrent(IPSSFStyleParam iPSSFStyleParam) {
        currentPSSFStyleParam.set(iPSSFStyleParam);
    }

    public static IPSSFStyleParam getCurrent() {
        return currentPSSFStyleParam.get();
    }
}


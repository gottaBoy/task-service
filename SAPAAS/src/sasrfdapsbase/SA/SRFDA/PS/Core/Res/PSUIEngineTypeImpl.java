/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSUIEngineType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSUIEngineTypeImpl
extends PSObjectImpl
implements IPSUIEngineType {
    protected PSUIEngineType psUIEngineType = null;
    private static final Log log = LogFactory.getLog(PSUIEngineTypeImpl.class);
    private Properties rtParams = null;
    private ArrayList<String> rtParamList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSUIEngineType psUIEngineType) throws Exception {
        this.psUIEngineType = psUIEngineType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psUIEngineType.getPSUIENGINETYPEID());
        this.setName(psUIEngineType.getPSUIENGINETYPENAME());
        this.setPSObjectData(this.psUIEngineType);
        this.rtParams = PropertiesHelper.Load((String)this.psUIEngineType.getUTILPARAMS());
        Enumeration<Object> objKeys = this.rtParams.keys();
        if (objKeys != null) {
            while (objKeys.hasMoreElements()) {
                this.rtParamList.add((String)objKeys.nextElement());
            }
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getEngineCat() {
        return this.psUIEngineType.getENGINECAT();
    }

    @Override
    public Iterator<String> getEngineParamNames() throws Exception {
        return this.rtParamList.iterator();
    }

    @Override
    public String getEngineParamKey(String strName) throws Exception {
        return PropertiesHelper.GetProperty((Properties)this.rtParams, (String)strName);
    }

    @Override
    public String getTypeCode() {
        return this.psUIEngineType.getTYPECODE();
    }

    @Override
    public int getEngineParamMode(String strTag) throws Exception {
        return this.psUIEngineType.GetParamIntValue(strTag, 1);
    }
}


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
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtilType;
import SA.SRFDA.PS.Core.App.Util.PSAppUtilImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.PS.Data.PSAppUtilType;
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
public class PSAppUtilTypeImpl
extends PSObjectImpl
implements IPSAppUtilType {
    private static final Log log = LogFactory.getLog(PSAppUtilTypeImpl.class);
    protected PSAppUtilType psAppUtilType = null;
    private boolean bRegisterApp = false;
    private Properties rtParams = null;
    private ArrayList<String> rtParamList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSAppUtilType psAppUtilType) throws Exception {
        Enumeration<Object> objKeys;
        this.psAppUtilType = psAppUtilType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psAppUtilType.getPSAPPUTILTYPEID());
        this.setName(psAppUtilType.getPSAPPUTILTYPENAME());
        this.setPSObjectData(this.psAppUtilType);
        this.rtParams = PropertiesHelper.Load((String)this.psAppUtilType.getUTILPARAMS());
        if (!this.psAppUtilType.isREGTOAPPFLAGNull()) {
            this.bRegisterApp = this.psAppUtilType.getREGTOAPPFLAG();
        }
        if ((objKeys = this.rtParams.keys()) != null) {
            while (objKeys.hasMoreElements()) {
                this.rtParamList.add((String)objKeys.nextElement());
            }
        }
        this.onInit();
    }

    @Override
    public IPSAppUtil createPSAppUtil(PSAppUtil psAppUtil) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psAppUtilType.getUTILOBJ())) {
            return new PSAppUtilImpl();
        }
        return (IPSAppUtil)ObjectHelper.Create((String)this.psAppUtilType.getUTILOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isRegToApp() {
        return this.bRegisterApp;
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


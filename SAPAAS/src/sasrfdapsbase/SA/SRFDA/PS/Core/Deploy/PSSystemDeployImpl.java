/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeployDB;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Data.PSSystemDeploy;
import SA.SRFDA.PS.Data.PSSystemDeployDB;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemDeployImpl
extends PSSystemObjectImpl
implements IPSSystemDeploy {
    private static final Log log = LogFactory.getLog(PSSystemDeployImpl.class);
    protected PSSystemDeploy psSystemDeploy = null;
    protected HashMap<String, IPSSystemDeployDB> psSystemDeployDBMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSystemDeploy psSystemDeploy) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSystem(iPSSystem);
        this.psSystemDeploy = psSystemDeploy;
        this.setId(this.psSystemDeploy.getPSSYSDEPLOYID());
        this.setName(this.psSystemDeploy.getPSSYSDEPLOYNAME());
        this.setPSObjectData(this.psSystemDeploy);
        this.onPrepareSystemDeployDBs();
        this.onInit();
    }

    protected void onPrepareSystemDeployDBs() throws Exception {
        this.psSystemDeployDBMap.clear();
        Vector<PSSystemDeployDB> psSystemDeployDBList = new Vector<PSSystemDeployDB>();
        CallResult callResult = this.getPSModelHelper().getPSSystemDeployDBs(this.getId(), psSystemDeployDBList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u90e8\u7f72\u6570\u636e\u5e93\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSystemDeployDB psSystemDeployDB : psSystemDeployDBList) {
            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psSystemDeployDB.getDBTYPE());
            IPSSystemDeployDB iPSSystemDeployDB = iPSDBType.createPSSystemDeployDB(psSystemDeployDB);
            iPSSystemDeployDB.init(this.getDAGlobalHelper(), this, psSystemDeployDB);
            this.psSystemDeployDBMap.put(iPSSystemDeployDB.getName(), iPSSystemDeployDB);
        }
    }

    @Override
    public IPSSystemDeployDB getDefaultPSSystemDeployDB() throws Exception {
        return this.getPSSystemDeployDB("DEFAULT", false);
    }

    @Override
    public IPSSystemDeployDB getPSSystemDeployDB(String strName, boolean bTryMode) throws Exception {
        IPSSystemDeployDB iPSSystemDeployDB = this.psSystemDeployDBMap.get(strName);
        if (iPSSystemDeployDB == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u8fde\u63a5[%1$s]", (Object)strName));
        }
        return iPSSystemDeployDB;
    }

    @Override
    public String getModelType() {
        return "PSSYSDEPLOY";
    }
}


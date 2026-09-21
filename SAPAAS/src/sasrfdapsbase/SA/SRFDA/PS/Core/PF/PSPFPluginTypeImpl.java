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
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.PSSysPFPluginImpl;
import SA.SRFDA.PS.Core.Res.PSSysPFPluginTemplImpl;
import SA.SRFDA.PS.Data.PSPFPluginType;
import SA.SRFDA.PS.Data.PSSysPFPlugin;
import SA.SRFDA.PS.Data.PSSysPFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPluginTypeImpl
extends PSObjectImpl
implements IPSPFPluginType {
    protected PSPFPluginType psPFPluginType = null;
    private static final Log log = LogFactory.getLog(PSPFPluginTypeImpl.class);
    private Properties typeParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPFPluginType psPFPluginType) throws Exception {
        this.psPFPluginType = psPFPluginType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPFPluginType.getPSPFPLUGINTYPEID());
        this.setName(psPFPluginType.getPSPFPLUGINTYPENAME());
        this.setPSObjectData(this.psPFPluginType);
        this.typeParams = PropertiesHelper.Load((String)this.psPFPluginType.getTYPEPARAMS());
        this.onInit();
    }

    @Override
    public IPSSysPFPlugin createPSSysPFPlugin(PSSysPFPlugin psSysPFPlugin) throws Exception {
        String strPluginObj = this.psPFPluginType.getPLUGINOBJ();
        if (StringHelper.isNullOrEmpty((String)strPluginObj)) {
            return new PSSysPFPluginImpl();
        }
        return (IPSSysPFPlugin)ObjectHelper.Create((String)strPluginObj);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSSysPFPluginTempl createPSSysPFPluginTempl(PSSysPFPluginTempl psSysPFPluginTempl) throws Exception {
        return new PSSysPFPluginTemplImpl();
    }
}


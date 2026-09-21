/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BackService;

import SA.SRFDA.PS.Core.BackService.IPSBackService;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Data.PSBackService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSBackServiceImpl
extends PSObjectImpl
implements IPSBackService {
    protected PSBackService psBackService = null;
    private static final Log log = LogFactory.getLog(PSBackServiceImpl.class);
    private Properties properties = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSBackService psBackService) throws Exception {
        this.psBackService = psBackService;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psBackService.getPSBACKSERVICEID());
        this.setName(psBackService.getPSBACKSERVICENAME());
        this.setPSObjectData(this.psBackService);
        this.properties = PropertiesHelper.load((Properties)this.properties, (String)psBackService.getSERVICEOBJ());
        this.onInit();
    }

    @Override
    public String getServiceObject(IPSSysSFPub iPSSysSFPub) throws Exception {
        String strFullKey = StringHelper.Format((String)"%1$s", (Object)iPSSysSFPub.getSFStyle());
        String strClsOrPkgName = PropertiesHelper.getProperty((Properties)this.properties, (String)strFullKey);
        if (StringHelper.IsNullOrEmpty((String)strClsOrPkgName) && this.properties != null) {
            for (Object objKey : this.properties.keySet()) {
                String strKey = (String)objKey;
                if (strFullKey.indexOf(strKey) != 0) continue;
                strClsOrPkgName = PropertiesHelper.getProperty((Properties)this.properties, (String)strKey);
                break;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
            strClsOrPkgName = strClsOrPkgName.trim();
        }
        if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
            return strClsOrPkgName;
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u83b7\u53d6\u5e73\u53f0\u9884\u7f6e\u540e\u53f0\u4f5c\u4e1a[%1$s]\u670d\u52a1[%2$s]\u5bf9\u5e94\u5904\u7406\u5bf9\u8c61", (Object)this.getName(), (Object)iPSSysSFPub.getSFStyle()));
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getServiceParams() {
        return this.psBackService.getSERVICEPARAMS();
    }
}


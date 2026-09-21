/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSFormDetailType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormDetailTypeImpl
extends PSObjectImpl
implements IPSFormDetailType {
    protected PSFormDetailType psFormDetailType = null;
    private static final Log log = LogFactory.getLog(PSFormDetailTypeImpl.class);
    private HashMap<String, String> parentFDTypeMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSFormDetailType psFormDetailType) throws Exception {
        this.psFormDetailType = psFormDetailType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psFormDetailType.getPSFORMDETAILTYPEID());
        this.setName(psFormDetailType.getPSFORMDETAILTYPENAME());
        String strPFDTypes = this.psFormDetailType.getPFDTYPE();
        if (!StringHelper.isNullOrEmpty((String)strPFDTypes)) {
            String[] items = strPFDTypes.split("[;]");
            int i = 0;
            while (i < items.length) {
                this.parentFDTypeMap.put(items[i], "");
                ++i;
            }
        }
        this.onInit();
    }

    @Override
    public IPSDEFormDetail createPSDEFormDetail(PSDEFormDetail psDEFormDetail) throws Exception {
        return (IPSDEFormDetail)ObjectHelper.Create((String)this.psFormDetailType.getDETAILOBJ());
    }

    @Override
    public boolean isRootFDType() {
        return this.parentFDTypeMap.size() == 0;
    }

    @Override
    public boolean isSupportPFDType(String strPFDType) {
        return this.parentFDTypeMap.containsKey(strPFDType);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}


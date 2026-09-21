/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.util.WebUtility
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.util.WebUtility;

public class DEDataQueryPreviewPage
extends DECtrlPreviewPage {
    public DEDataQueryPreviewPage() {
        this.setJSCache(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        boolean bRet = super.PreparePageEnv();
        if (!bRet) {
            return false;
        }
        try {
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSTEMID");
            IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId);
            String strPSDEDataQueryId = this.getWebContext().GetParamValue("PSDEDATAQUERYID");
            PSDEDataQuery psDEDataQuery = new PSDEDataQuery();
            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEDataQuery(strPSDEDataQueryId, psDEDataQuery);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u67e5\u8be2"));
            }
            IPSDataEntity iPSDataEntity = iPSSystem.getPSDataEntity(psDEDataQuery.getPSDEID(), false);
            if (iPSDataEntity == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEDataQuery.getPSDEID()));
            }
            PSDEDataQueryImpl iPSDEDataQuery = new PSDEDataQueryImpl();
            iPSDEDataQuery.init(this.getDAGlobalHelper(), iPSDataEntity, psDEDataQuery);
            IPSSystemDBConfig iPSSystemDBConfig = null;
            Iterator<IPSSystemDBConfig> psSystemDBConfigs = iPSSystem.getAllPSSystemDBConfigs();
            while (psSystemDBConfigs.hasNext()) {
                iPSSystemDBConfig = psSystemDBConfigs.next();
                if (iPSSystemDBConfig.isDefaultMode()) break;
            }
            if (iPSSystemDBConfig == null) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u914d\u7f6e\u7cfb\u7edf\u652f\u6301\u7684\u6570\u636e\u5e93"));
            }
            IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(iPSSystemDBConfig.getName());
            IPSDEDQEngine iPSDEDQEngine = iPSDEDataQuery.getPSDEDQEngine(iPSDBType.getId());
            this.sb.Append("\u6570\u636e\u5e93\u7c7b\u578b<B>[%1$s]</B>", (Object)iPSDBType.getName());
            if (iPSDEDataQuery.isCustomCode()) {
                this.sb.Append("<B><span style='color:red'>\u6ce8\u610f\uff1a\u67e5\u8be2\u5df2\u8bbe\u7f6e\u4e3a\u81ea\u5b9a\u4e49\u4ee3\u7801\uff0c\u4e0b\u9762\u4ee3\u7801\u4e3a\u673a\u5668\u7f16\u8bd1\u7684\u9ed8\u8ba4\u4ee3\u7801\uff0c\u4ec5\u4f9b\u53c2\u8003\uff01</span></B>", (Object)iPSDBType.getName());
            }
            this.sb.Append("<BR>");
            this.sb.Append(WebUtility.textToHTML((String)iPSDEDQEngine.getQueryScript()));
            int nOrder = 0;
            Iterator<IDEDataQueryCodeCond> deDataQueryConds = iPSDEDQEngine.getDEDataQueryCodeConds();
            if (deDataQueryConds != null) {
                while (deDataQueryConds.hasNext()) {
                    IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryConds.next();
                    if (nOrder == 0) {
                        this.sb.Append("<BR>WHERE&nbsp;");
                    } else {
                        this.sb.Append("<BR>AND&nbsp;");
                    }
                    ++nOrder;
                    this.sb.Append("<BR>%1$s ", (Object)WebUtility.textToHTML((String)iDEDataQueryCodeCond.getCustomCond()));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            this.PageLog((Object)this, 1, ex.getMessage());
            this.OutputAlertMsg(ex.getMessage(), false);
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Plugin.IPSModelPlugin;
import SA.SRFDA.PS.Core.Plugin.PSModelCheckPluginImpl;
import SA.SRFDA.PS.Data.PSModel;
import SA.SRFDA.PS.Data.PSModelPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelImpl
extends PSObjectImpl
implements IPSModel {
    protected PSModel psModel = null;
    private static final Log log = LogFactory.getLog(PSModelImpl.class);
    private HashMap<String, ArrayList<IPSModelPlugin>> psModelPluginListMap = new HashMap();
    private String strHelpArticleUrl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSModel psModel) throws Exception {
        this.psModel = psModel;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psModel.getPSMODELID());
        this.setName(psModel.getPSMODELNAME());
        this.setPSObjectData(this.psModel);
        this.strHelpArticleUrl = this.psModel.getARTICLEURL();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSModelPlugins();
        super.onInit();
    }

    protected void onPreparePSModelPlugins() throws Exception {
        Vector<PSModelPlugin> psModelPluginList = new Vector<PSModelPlugin>();
        CallResult callResult = this.getPSModelHelper().getPSModelPlugins(this.getId(), psModelPluginList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u6a21\u578b\u63d2\u4ef6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSModelPlugin psModelPlugin : psModelPluginList) {
            if (!psModelPlugin.isVALIDFLAGNull() && !psModelPlugin.getVALIDFLAG()) continue;
            IPSModelPlugin iPSModelPlugin = this.createPSModelPlugin(psModelPlugin);
            iPSModelPlugin.init(this.getDAGlobalHelper(), psModelPlugin);
            ArrayList<IPSModelPlugin> psModelPluginList2 = this.psModelPluginListMap.get(iPSModelPlugin.getPluginType());
            if (psModelPluginList2 == null) {
                psModelPluginList2 = new ArrayList();
                this.psModelPluginListMap.put(iPSModelPlugin.getPluginType(), psModelPluginList2);
            }
            psModelPluginList2.add(iPSModelPlugin);
        }
    }

    @Override
    public Iterator<IPSModelPlugin> getPSModelPlugins(String strPluginType) throws Exception {
        ArrayList<IPSModelPlugin> psModelPluginList2 = this.psModelPluginListMap.get(strPluginType);
        if (psModelPluginList2 == null) {
            return null;
        }
        return psModelPluginList2.iterator();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected IPSModelPlugin createPSModelPlugin(PSModelPlugin psModelPlugin) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)psModelPlugin.getDIFFOBJ())) {
            return (IPSModelPlugin)ObjectHelper.create((String)psModelPlugin.getDIFFOBJ());
        }
        StringHelper.compare((String)psModelPlugin.getPLUGINTYPE(), (String)"DIFF", (boolean)true);
        if (StringHelper.compare((String)psModelPlugin.getPLUGINTYPE(), (String)"CHECK", (boolean)true) == 0) {
            return new PSModelCheckPluginImpl();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6a21\u578b\u63d2\u4ef6\u7c7b\u578b[%1$s]", (Object)psModelPlugin.getPLUGINTYPE()));
    }

    @Override
    public String getHelpArticleUrl() {
        return this.strHelpArticleUrl;
    }
}


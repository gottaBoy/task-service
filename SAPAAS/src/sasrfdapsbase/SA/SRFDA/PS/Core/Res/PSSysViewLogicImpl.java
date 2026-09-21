/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogicParam;
import SA.SRFDA.PS.Core.Res.PSSysViewLogicParamImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewLogicParam;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.PS.Data.PSSysViewLogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysViewLogicImpl
extends PSSystemObjectImpl
implements IPSSysViewLogic {
    private static final Log log = LogFactory.getLog(PSSysViewLogicImpl.class);
    protected PSSysViewLogic psSysViewLogic = null;
    private String strPSViewLogicTypeId = null;
    private IPSViewLogicType iPSViewLogicType = null;
    private ArrayList<IPSSysViewLogicParam> psSysViewLogicParamList = null;
    private IPSSystemModule iPSSystemModule = null;
    private String strViewLogicType = "PREDEFINED";
    private String strPSDEId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysViewLogic psSysViewLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysViewLogic = psSysViewLogic;
            this.setId(this.psSysViewLogic.getPSSYSVIEWLOGICID());
            this.setName(this.psSysViewLogic.getPSSYSVIEWLOGICNAME());
            this.setPSObjectData(this.psSysViewLogic);
            if (!StringHelper.isNullOrEmpty((String)this.psSysViewLogic.getLOGICTYPE())) {
                this.strViewLogicType = this.psSysViewLogic.getLOGICTYPE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysViewLogic.getPSVIEWLOGICTYPEID())) {
                this.strPSViewLogicTypeId = this.psSysViewLogic.getPSVIEWLOGICTYPEID();
                try {
                    this.iPSViewLogicType = this.getPSModelStorage().getPSViewLogicType(this.strPSViewLogicTypeId);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)psSysViewLogic.getPSDELOGICID())) {
                this.strPSDEId = this.psSysViewLogic.getPSDEID();
                if (StringHelper.isNullOrEmpty((String)this.strPSDEId)) {
                    this.strPSDEId = this.psSysViewLogic.getLOGICPSDEID();
                }
                if (StringHelper.isNullOrEmpty((String)this.strPSDEId)) {
                    throw new Exception("\u7cfb\u7edf\u89c6\u56fe\u903b\u8f91\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u6807\u8bc6");
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysViewLogic.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysViewLogic.getPSMODULEID());
            }
            if (StringHelper.isNullOrEmpty((String)this.strViewLogicType)) {
                this.strViewLogicType = !StringHelper.isNullOrEmpty((String)this.strPSViewLogicTypeId) ? "PREDEFINED" : (!StringHelper.isNullOrEmpty((String)this.getPSDEUILogicId()) ? "DEUILOGIC" : (!StringHelper.isNullOrEmpty((String)this.getPSSysPFPluginId()) ? "PFPLUGIN" : "UNKNOWN"));
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSSysViewLogicParams();
        super.onInit();
    }

    protected void onPreparePSSysViewLogicParams() throws Exception {
        if (this.psSysViewLogicParamList != null) {
            this.psSysViewLogicParamList.clear();
        }
        Vector<PSSysViewLogicParam> psSysViewLogicParamList = new Vector<PSSysViewLogicParam>();
        CallResult callResult = this.getPSModelHelper().getPSSysViewLogicParams(this.getId(), psSysViewLogicParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u89c6\u56fe\u903b\u8f91\u53c2\u6570\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysViewLogicParam psSysViewLogicParam : psSysViewLogicParamList) {
            PSSysViewLogicParamImpl iPSSysViewLogicParam = new PSSysViewLogicParamImpl();
            iPSSysViewLogicParam.init(this.getDAGlobalHelper(), this, psSysViewLogicParam);
            if (this.psSysViewLogicParamList != null) {
                this.psSysViewLogicParamList = new ArrayList();
            }
            this.psSysViewLogicParamList.add(iPSSysViewLogicParam);
        }
    }

    @Override
    public Iterator<? extends IPSSysViewLogicParam> getPSSysViewLogicParams() {
        if (this.psSysViewLogicParamList == null || this.psSysViewLogicParamList.size() == 0) {
            return null;
        }
        return this.psSysViewLogicParamList.iterator();
    }

    @Override
    public Iterator<? extends IPSViewLogicParam> getPSViewLogicParams() {
        return this.getPSSysViewLogicParams();
    }

    @Override
    public String getPSViewLogicTypeId() {
        return this.strPSViewLogicTypeId;
    }

    @Override
    public IPSDEViewLogic getPSDEViewLogic() {
        return null;
    }

    @Override
    public IPSViewLogicType getPSViewLogicType() {
        return this.iPSViewLogicType;
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWLOGIC";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91\u7c7b\u578b")
    public String getViewLogicType() {
        return this.strViewLogicType;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91\u6837\u5f0f")
    public String getViewLogicStyle() {
        return this.psSysViewLogic.getCUSTOMSTYLE();
    }

    @Override
    public Iterator<? extends IPSViewLogicParam> getPSViewLogicParams(String strPrefix) {
        strPrefix = strPrefix.toUpperCase();
        ArrayList<IPSViewLogicParam> psViewLogicParamList = new ArrayList<IPSViewLogicParam>();
        Iterator<? extends IPSViewLogicParam> psViewLogicParams = this.getPSViewLogicParams();
        if (psViewLogicParams != null) {
            while (psViewLogicParams.hasNext()) {
                IPSViewLogicParam iPSViewLogicParam = psViewLogicParams.next();
                if (StringHelper.isNullOrEmpty((String)iPSViewLogicParam.getName()) || iPSViewLogicParam.getName().toUpperCase().indexOf(strPrefix) != 0) continue;
                psViewLogicParamList.add(iPSViewLogicParam);
            }
        }
        Collections.sort(psViewLogicParamList, new Comparator<IPSViewLogicParam>(){

            @Override
            public int compare(IPSViewLogicParam o1, IPSViewLogicParam o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return psViewLogicParamList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psSysViewLogic.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    public String getPSDEId() {
        return this.strPSDEId;
    }

    @Override
    public String getPSDEUILogicId() {
        return this.psSysViewLogic.getPSDELOGICID();
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.psSysViewLogic.getPSSYSPFPLUGINID();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7c7b\u578b", group="\u57fa\u672c", order=125)
    public String getLogicType() {
        return this.strViewLogicType;
    }
}


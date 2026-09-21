/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTOField;
import SA.SRFDA.PS.Core.Service.PSSysMethodDTOFieldImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysMethodDTOImpl
extends PSSystemObjectImpl
implements IPSSysMethodDTO {
    private static final Log log = LogFactory.getLog(PSSysMethodDTOImpl.class);
    private IPSSysDynaModel srcPSSysDynaModel = null;
    private String strCodeName = null;
    private List<IPSSysMethodDTOField> psSysMethodDTOFieldList = null;
    private String strSourceType = null;
    private String strType = "DEFAULT";

    public void initFromDynaModel(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDynaModel iPSSysDynaModel) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSysDynaModel.getPSSystem());
            this.srcPSSysDynaModel = iPSSysDynaModel;
            this.setId(KeyValueHelper.genUniqueId((String)this.getType(), (String)this.srcPSSysDynaModel.getId()));
            this.setCodeName(this.calcCodeName());
            this.setName(this.getCodeName());
            this.strSourceType = "DYNAMODEL";
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysMethodDTO>(){

                public IPSSysMethodDTO execute(Object obj) throws Exception {
                    PSSysMethodDTOImpl.this.onInit();
                    return null;
                }
            }, (IPSModelObject)this);
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
        super.onInit();
        this.preparePSSysMethodDTOFields();
    }

    protected void preparePSSysMethodDTOFields() throws Exception {
        Iterator<? extends IPSSysDynaModelAttr> psSysDynaModelAttrs;
        this.psSysMethodDTOFieldList = new ArrayList<IPSSysMethodDTOField>();
        LinkedHashMap<String, PSSysMethodDTOFieldImpl> psSysMethodDTOFieldMap = new LinkedHashMap<String, PSSysMethodDTOFieldImpl>();
        if (StringHelper.compare((String)this.getSourceType(), (String)"DYNAMODEL", (boolean)false) == 0 && (psSysDynaModelAttrs = this.getSrcPSSysDynaModel().getPSSysDynaModelAttrs()) != null) {
            while (psSysDynaModelAttrs.hasNext()) {
                IPSSysDynaModelAttr iPSSysDynaModelAttr = psSysDynaModelAttrs.next();
                PSSysMethodDTOFieldImpl psSysMethodDTOFieldImpl = new PSSysMethodDTOFieldImpl();
                psSysMethodDTOFieldImpl.initFromDynaModelAttr(this.getDAGlobalHelper(), this, iPSSysDynaModelAttr);
                if (psSysMethodDTOFieldMap.containsKey(psSysMethodDTOFieldImpl.getCodeName().toUpperCase())) {
                    throw new Exception(String.format("\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6307\u5b9a\u4ee3\u7801\u6807\u8bc6[%2$s]\u5df2\u5b58\u5728", iPSSysDynaModelAttr.getName(), psSysMethodDTOFieldImpl.getCodeName()));
                }
                psSysMethodDTOFieldMap.put(psSysMethodDTOFieldImpl.getCodeName().toUpperCase(), psSysMethodDTOFieldImpl);
                this.psSysMethodDTOFieldList.add(psSysMethodDTOFieldImpl);
            }
        }
        PSModelUtil.sort(this.psSysMethodDTOFieldList);
    }

    @Override
    protected int onCheck() throws Exception {
        Iterator<? extends IPSSysMethodDTOField> psSysMethodDTOFields = this.getPSSysMethodDTOFields();
        if (psSysMethodDTOFields != null) {
            while (psSysMethodDTOFields.hasNext()) {
                IPSSysMethodDTOField iPSSysMethodDTOField = psSysMethodDTOFields.next();
                iPSSysMethodDTOField.check();
            }
        }
        return super.onCheck();
    }

    @Override
    public String getModelType() {
        return "PSSYSMETHODDTO";
    }

    @Override
    @PSModelRTMeta(description="DTO\u5c5e\u6027\u96c6\u5408", child=true, group="\u57fa\u672c", order=140)
    public Iterator<? extends IPSSysMethodDTOField> getPSSysMethodDTOFields() {
        if (this.psSysMethodDTOFieldList == null || this.psSysMethodDTOFieldList.size() == 0) {
            return null;
        }
        return this.psSysMethodDTOFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
    }

    protected void setCodeName(String strCodeName) {
        this.strCodeName = strCodeName;
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u65b9\u6cd5DTO\u5bf9\u8c61\u6765\u6e90\u7c7b\u578b", codelist="DEMethodDTOSourceType")
    public String getSourceType() {
        return this.strSourceType;
    }

    protected void setSourceType(String strSourceType) {
        this.strSourceType = strSourceType;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", hideempty=true)
    public IPSSysDynaModel getSrcPSSysDynaModel() {
        return this.srcPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        if (this.getSrcPSSysDynaModel() != null) {
            return this.getSrcPSSysDynaModel().getPSSystemModule();
        }
        return super.getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b", codelist="DEMethodDTOType", group="\u57fa\u672c", order=125)
    public String getType() {
        return this.strType;
    }

    protected void setType(String strType) {
        this.strType = strType;
    }

    protected String calcCodeName() throws Exception {
        return this.getPSSystem().getSysMethodDTOCodeName(this);
    }

    @Override
    protected boolean isExportModelCodeName() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0")
    public String getTag() {
        if (this.getSrcPSSysDynaModel() != null) {
            return this.getSrcPSSysDynaModel().getModelTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb02")
    public String getTag2() {
        if (this.getSrcPSSysDynaModel() != null) {
            return this.getSrcPSSysDynaModel().getModelTag2();
        }
        return null;
    }
}


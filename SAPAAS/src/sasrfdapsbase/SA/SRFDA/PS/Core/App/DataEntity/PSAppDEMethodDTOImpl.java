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
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEMethodDTOFieldImpl;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityObjectImpl;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSLinkDEMethodDTO;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEMethodDTOImpl
extends PSAppDataEntityObjectImpl
implements IPSAppDEMethodDTO {
    private static final Log log = LogFactory.getLog(PSAppDEMethodDTOImpl.class);
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private List<IPSAppDEMethodDTOField> psAppDEMethodDTOFieldList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSAppDataEntity(iPSAppDataEntity);
            this.iPSDEMethodDTO = iPSDEMethodDTO;
            this.setId(KeyValueHelper.genUniqueId((String)iPSAppDataEntity.getId(), (String)this.getPSDEMethodDTO().getId()));
            this.setName(this.getPSDEMethodDTO().getName());
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSAppDEMethodDTO>(){

                public IPSAppDEMethodDTO execute(Object obj) throws Exception {
                    PSAppDEMethodDTOImpl.this.onInit();
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
        this.preparePSAppDEMethodDTOFields();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getRefPSAppDataEntity();
        this.getRefPSAppDEMethodDTO();
        this.getSrcPSAppMethodDTO();
        Iterator<? extends IPSAppDEMethodDTOField> psAppDEMethodDTOFields = this.getPSAppDEMethodDTOFields();
        if (psAppDEMethodDTOFields != null) {
            while (psAppDEMethodDTOFields.hasNext()) {
                IPSAppDEMethodDTOField iPSAppDEMethodDTOField = psAppDEMethodDTOFields.next();
                iPSAppDEMethodDTOField.check();
            }
        }
        return super.onCheck();
    }

    protected void preparePSAppDEMethodDTOFields() throws Exception {
        this.psAppDEMethodDTOFieldList = new ArrayList<IPSAppDEMethodDTOField>();
        Iterator<? extends IPSDEMethodDTOField> psDEMethodDTOFields = this.getPSDEMethodDTO().getPSDEMethodDTOFields();
        if (psDEMethodDTOFields != null) {
            while (psDEMethodDTOFields.hasNext()) {
                IPSDEMethodDTOField iPSDEMethodDTOField = psDEMethodDTOFields.next();
                PSAppDEMethodDTOFieldImpl psAppDEMethodDTOFieldImpl = new PSAppDEMethodDTOFieldImpl();
                psAppDEMethodDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEMethodDTOField);
                this.psAppDEMethodDTOFieldList.add(psAppDEMethodDTOFieldImpl);
            }
        }
    }

    @Override
    public String getModelType() {
        return "PSAPPDEMETHODDTO";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDataEntity().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="DTO\u5bf9\u8c61\u5c5e\u6027\u96c6\u5408", child=true, group="\u57fa\u672c", order=140)
    public Iterator<? extends IPSAppDEMethodDTOField> getPSAppDEMethodDTOFields() {
        if (this.psAppDEMethodDTOFieldList == null || this.psAppDEMethodDTOFieldList.size() == 0) {
            return null;
        }
        return this.psAppDEMethodDTOFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSDEMethodDTO().getCodeName();
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61\u6765\u6e90\u7c7b\u578b", codelist="DEMethodDTOSourceType")
    public String getSourceType() {
        return this.getPSDEMethodDTO().getSourceType();
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b", codelist="DEMethodDTOType", group="\u57fa\u672c", order=125)
    public String getType() {
        return this.getPSDEMethodDTO().getType();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61")
    public IPSDEMethodDTO getPSDEMethodDTO() {
        return this.iPSDEMethodDTO;
    }

    @Override
    public IPSApplication getPSApplication() {
        return this.getPSAppDataEntity().getPSApplication();
    }

    @Override
    public IPSAppDEMethodDTOField getPSAppDEMethodDTOField(IPSAppDEField iPSAppDEField, boolean bTryMode) throws Exception {
        Iterator<? extends IPSAppDEMethodDTOField> psAppDEMethodDTOFields = this.getPSAppDEMethodDTOFields();
        if (psAppDEMethodDTOFields != null) {
            while (psAppDEMethodDTOFields.hasNext()) {
                IPSAppDEMethodDTOField iPSAppDEMethodDTOField = psAppDEMethodDTOFields.next();
                if (iPSAppDEMethodDTOField.getPSAppDEField() == null || StringHelper.compare((String)iPSAppDEField.getId(), (String)iPSAppDEMethodDTOField.getPSAppDEField().getId(), (boolean)false) != 0) continue;
                return iPSAppDEMethodDTOField;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5c5e\u6027[%1$s]\u5bf9\u5e94DTO\u5c5e\u6027\u5bf9\u8c61", iPSAppDEField.getName()));
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e94\u7528\u5b9e\u4f53", dumpref=true)
    public IPSAppDataEntity getRefPSAppDataEntity() throws Exception {
        IPSDataEntity refPSDataEntity;
        if (this.getPSDEMethodDTO() instanceof IPSLinkDEMethodDTO && (refPSDataEntity = ((IPSLinkDEMethodDTO)this.getPSDEMethodDTO()).getRefPSDataEntity()) != null) {
            if (StringHelper.compare((String)refPSDataEntity.getId(), (String)this.getPSAppDataEntity().getPSDataEntity().getId(), (boolean)false) == 0) {
                return this.getPSAppDataEntity();
            }
            IPSAppDataEntity refPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(refPSDataEntity, true);
            if (refPSAppDataEntity == null) {
                throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u52a0\u5165\u5f53\u524d\u5e94\u7528", refPSDataEntity.getFullName()));
            }
            return refPSAppDataEntity;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e94\u7528\u5b9e\u4f53DTO", dumpref=true, from="__self__", from_method="getRefPSAppDataEntityMust().getPSAppDEMethodDTO")
    public IPSAppDEMethodDTO getRefPSAppDEMethodDTO() throws Exception {
        IPSDEMethodDTO refPSDEMethodDTO;
        if (this.getPSDEMethodDTO() instanceof IPSLinkDEMethodDTO && (refPSDEMethodDTO = ((IPSLinkDEMethodDTO)this.getPSDEMethodDTO()).getRefPSDEMethodDTO()) != null) {
            return this.getRefPSAppDataEntity().getPSAppDEMethodDTO(refPSDEMethodDTO);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5e94\u7528DTO", dumpref=true, from="IPSApplication")
    public IPSAppMethodDTO getSrcPSAppMethodDTO() throws Exception {
        if (this.getPSDEMethodDTO().getSrcPSSysMethodDTO() != null) {
            this.getPSApplication().getPSAppMethodDTO(this.getPSDEMethodDTO().getSrcPSSysMethodDTO());
        }
        return null;
    }
}


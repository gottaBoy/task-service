/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTOField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTOField;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDTOFieldImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIDTOImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIDTO {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDTOImpl.class);
    private IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = null;
    private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;
    private String strCodeName = null;
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private List<IPSSubSysServiceAPIDTOField> psSubSysServiceAPIDTOFieldList = new ArrayList<IPSSubSysServiceAPIDTOField>();
    private String strType = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPI iPSSubSysServiceAPI, IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
            this.iPSSubSysServiceAPIDE = iPSSubSysServiceAPIDE;
            this.setId(KeyValueHelper.genUniqueId((String)iPSSubSysServiceAPI.getId(), (String)"PSSUBSYSSERVICEAPI", (String)iPSSubSysServiceAPIDE.getId()));
            this.strCodeName = iPSSubSysServiceAPI.getDTOCodeName(iPSSubSysServiceAPIDE);
            this.setName(this.strCodeName);
            this.strType = "SUBSYSSERVICEAPIDE";
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

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPI iPSSubSysServiceAPI, IPSDEMethodDTO iPSDEMethodDTO) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
            this.iPSDEMethodDTO = iPSDEMethodDTO;
            this.setId(KeyValueHelper.genUniqueId((String)iPSSubSysServiceAPI.getId(), (String)"PSSUBSYSSERVICEAPI", (String)iPSDEMethodDTO.getId()));
            this.strCodeName = iPSSubSysServiceAPI.getDTOCodeName(iPSDEMethodDTO);
            this.setName(this.strCodeName);
            this.strType = "DEMETHODDTO";
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
        this.onPreparePSSubSysServiceAPIDTOFields();
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        Iterator<? extends IPSSubSysServiceAPIDTOField> psSubSysServiceAPIDTOFields = this.getPSSubSysServiceAPIDTOFields();
        if (psSubSysServiceAPIDTOFields != null) {
            while (psSubSysServiceAPIDTOFields.hasNext()) {
                IPSSubSysServiceAPIDTOField iPSSubSysServiceAPIDTOField = psSubSysServiceAPIDTOFields.next();
                iPSSubSysServiceAPIDTOField.check();
            }
        }
        return super.onCheck();
    }

    protected void onPreparePSSubSysServiceAPIDTOFields() throws Exception {
        block6: {
            Iterator<? extends IPSDEMethodDTOField> psDEMethodDTOFields;
            block5: {
                Iterator<IPSSubSysServiceAPIDERS> psSubSysServiceAPIDERSs;
                this.psSubSysServiceAPIDTOFieldList.clear();
                if (StringHelper.compare((String)this.getType(), (String)"SUBSYSSERVICEAPIDE", (boolean)false) != 0) break block5;
                Iterator<IPSSubSysServiceAPIDEField> psSubSysServiceAPIDEFields = this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEFields();
                if (psSubSysServiceAPIDEFields != null) {
                    while (psSubSysServiceAPIDEFields.hasNext()) {
                        IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField = psSubSysServiceAPIDEFields.next();
                        PSSubSysServiceAPIDTOFieldImpl psSubSysServiceAPIDTOFieldImpl = new PSSubSysServiceAPIDTOFieldImpl();
                        psSubSysServiceAPIDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSSubSysServiceAPIDEField);
                        this.psSubSysServiceAPIDTOFieldList.add(psSubSysServiceAPIDTOFieldImpl);
                    }
                }
                if ((psSubSysServiceAPIDERSs = this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDERSs(true)) == null) break block6;
                while (psSubSysServiceAPIDERSs.hasNext()) {
                    IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = psSubSysServiceAPIDERSs.next();
                    if (iPSSubSysServiceAPIDERS.getMinorPSSubSysServiceAPIDE().getAPIMode() != 9) continue;
                    PSSubSysServiceAPIDTOFieldImpl psSubSysServiceAPIDTOFieldImpl = new PSSubSysServiceAPIDTOFieldImpl();
                    psSubSysServiceAPIDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSSubSysServiceAPIDERS);
                    this.psSubSysServiceAPIDTOFieldList.add(psSubSysServiceAPIDTOFieldImpl);
                }
                break block6;
            }
            if (StringHelper.compare((String)this.getType(), (String)"DEMETHODDTO", (boolean)false) == 0 && (psDEMethodDTOFields = this.getPSDEMethodDTO().getPSDEMethodDTOFields()) != null) {
                while (psDEMethodDTOFields.hasNext()) {
                    IPSDEMethodDTOField iPSDEMethodDTOField = psDEMethodDTOFields.next();
                    PSSubSysServiceAPIDTOFieldImpl psSubSysServiceAPIDTOFieldImpl = new PSSubSysServiceAPIDTOFieldImpl();
                    psSubSysServiceAPIDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEMethodDTOField);
                    this.psSubSysServiceAPIDTOFieldList.add(psSubSysServiceAPIDTOFieldImpl);
                }
            }
        }
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3")
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() {
        return this.iPSSubSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53", hideempty=true)
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() {
        return this.iPSSubSysServiceAPIDE;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", hideempty=true)
    public IPSDEMethodDTO getPSDEMethodDTO() {
        return this.iPSDEMethodDTO;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPI().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSERVICEAPIDTO";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSubSysServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSubSysServiceAPI().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    public Iterator<? extends IPSServiceAPIDTOField> getPSServiceAPIDTOFields() {
        return this.getPSSubSysServiceAPIDTOFields();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3DTO\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSSubSysServiceAPIDTOField> getPSSubSysServiceAPIDTOFields() {
        if (this.psSubSysServiceAPIDTOFieldList == null || this.psSubSysServiceAPIDTOFieldList.size() == 0) {
            return null;
        }
        return this.psSubSysServiceAPIDTOFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\u7c7b\u578b")
    public String getType() {
        return this.strType;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0")
    public String getTag() {
        if (StringHelper.compare((String)this.getType(), (String)"SUBSYSSERVICEAPIDE", (boolean)false) == 0) {
            if (this.getPSSubSysServiceAPIDE() != null) {
                return this.getPSSubSysServiceAPIDE().getDETag();
            }
        } else if (StringHelper.compare((String)this.getType(), (String)"DEMETHODDTO", (boolean)false) == 0 && this.getPSDEMethodDTO() != null) {
            return this.getPSDEMethodDTO().getTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb02")
    public String getTag2() {
        if (StringHelper.compare((String)this.getType(), (String)"SUBSYSSERVICEAPIDE", (boolean)false) == 0) {
            if (this.getPSSubSysServiceAPIDE() != null) {
                return this.getPSSubSysServiceAPIDE().getDETag2();
            }
        } else if (StringHelper.compare((String)this.getType(), (String)"DEMETHODDTO", (boolean)false) == 0 && this.getPSDEMethodDTO() != null) {
            return this.getPSDEMethodDTO().getTag2();
        }
        return null;
    }
}


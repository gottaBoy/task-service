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
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSLinkDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSLinkDEMethodDTOImpl
extends PSDEMethodDTOImpl
implements IPSLinkDEMethodDTO {
    private static final Log log = LogFactory.getLog(PSLinkDEMethodDTOImpl.class);
    private IPSDataEntity refPSDataEntity = null;
    private IPSDEFGroup refPSDEFGroup = null;
    private IPSDEMethodDTO refPSDEMethodDTO = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDataEntity refPSDataEntity, IPSDEFGroup refPSDEFGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.refPSDataEntity = refPSDataEntity;
            this.refPSDEFGroup = refPSDEFGroup;
            this.setType("LINK");
            this.setSourceType("REFDE");
            if (this.refPSDEFGroup == null) {
                this.setId(KeyValueHelper.genUniqueId((String)iPSDataEntity.getId(), (String)this.getType(), (String)this.refPSDataEntity.getId()));
            } else {
                this.setId(KeyValueHelper.genUniqueId((String)iPSDataEntity.getId(), (String)this.getType(), (String)this.refPSDataEntity.getId(), (String)this.refPSDEFGroup.getId()));
            }
            this.setCodeName(this.calcCodeName());
            this.setName(this.getCodeName());
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                public IPSDEMethodDTO execute(Object obj) throws Exception {
                    PSLinkDEMethodDTOImpl.this.onInit();
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
        this.refPSDEMethodDTO = this.getRefPSDataEntity().getPSDEMethodDTO(this.getRefPSDEFGroup());
        super.onInit();
    }

    @Override
    protected void preparePSDEMethodDTOFields() throws Exception {
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSDataEntity getRefPSDataEntity() {
        return this.refPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getRefPSDEFGroup() {
        return this.refPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", dumpref=true, from="__self__", from_method="getRefPSDataEntityMust().getPSDEMethodDTO")
    public IPSDEMethodDTO getRefPSDEMethodDTO() throws Exception {
        return this.refPSDEMethodDTO;
    }
}


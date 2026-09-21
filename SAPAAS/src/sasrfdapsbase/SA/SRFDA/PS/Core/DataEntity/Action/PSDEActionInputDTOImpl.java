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
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTOField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionInputDTOFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOImpl;
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

public class PSDEActionInputDTOImpl
extends PSDEMethodDTOImpl
implements IPSDEActionInputDTO {
    private static final Log log = LogFactory.getLog(PSDEActionInputDTOImpl.class);
    private IPSDEActionInput iPSDEActionInput = null;
    private List<IPSDEActionInputDTOField> psDEActionInputDTOFieldList = null;
    private boolean bContainsKeyField = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDEActionInput iPSDEActionInput) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.iPSDEActionInput = iPSDEActionInput;
            if (this.getPSDEActionInput() == null) {
                throw new Exception("\u6ca1\u6709\u4f20\u5165\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165\u5bf9\u8c61");
            }
            this.setType("DEACTIONINPUT");
            this.setSourceType("DEACTIONINPUT");
            this.setId(KeyValueHelper.genUniqueId((String)iPSDataEntity.getId(), (String)this.getType(), (String)iPSDEActionInput.getId()));
            this.setCodeName(this.calcCodeName());
            this.setName(this.getCodeName());
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                public IPSDEMethodDTO execute(Object obj) throws Exception {
                    PSDEActionInputDTOImpl.this.onInit();
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
    protected void preparePSDEMethodDTOFields() throws Exception {
        this.psDEActionInputDTOFieldList = new ArrayList<IPSDEActionInputDTOField>();
        Iterator<IPSDEActionParam> psDEActionParams = this.getPSDEActionInput().getPSDEActionParams();
        if (psDEActionParams != null) {
            while (psDEActionParams.hasNext()) {
                IPSDEActionParam iPSDEActionParam = psDEActionParams.next();
                PSDEActionInputDTOFieldImpl psDEMethodDTOFieldImpl = new PSDEActionInputDTOFieldImpl();
                psDEMethodDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSDEActionParam);
                this.psDEActionInputDTOFieldList.add(psDEMethodDTOFieldImpl);
                if (iPSDEActionParam.getPSDEField() == null || !iPSDEActionParam.getPSDEField().isKeyDEField()) continue;
                this.bContainsKeyField = true;
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165\u5bf9\u8c61")
    public IPSDEActionInput getPSDEActionInput() {
        return this.iPSDEActionInput;
    }

    @Override
    public Iterator<? extends IPSDEMethodDTOField> getPSDEMethodDTOFields() {
        return this.getPSDEActionInputDTOFields();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165DTO\u5bf9\u8c61\u5c5e\u6027\u96c6\u5408", child=true, alias="getPSDEMethodDTOFields", rtname="getDEActionInputDTOFields")
    public Iterator<? extends IPSDEActionInputDTOField> getPSDEActionInputDTOFields() {
        if (this.psDEActionInputDTOFieldList == null || this.psDEActionInputDTOFieldList.size() == 0) {
            return null;
        }
        return this.psDEActionInputDTOFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u643a\u5e26\u4e3b\u952e\u5c5e\u6027", ignoredumpvalues="false", dump=false)
    public boolean containsKeyField() {
        return this.bContainsKeyField;
    }
}


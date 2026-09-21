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
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTOField;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSAppMethodDTOFieldImpl;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTOField;
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

public class PSAppMethodDTOImpl
extends PSApplicationObjectImpl
implements IPSAppMethodDTO {
    private static final Log log = LogFactory.getLog(PSAppMethodDTOImpl.class);
    private IPSSysMethodDTO iPSSysMethodDTO = null;
    private List<IPSAppMethodDTOField> psAppMethodDTOFieldList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysMethodDTO iPSSysMethodDTO) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysMethodDTO = iPSSysMethodDTO;
            this.setId(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)this.getPSSysMethodDTO().getId()));
            this.setName(this.getPSSysMethodDTO().getName());
            PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSAppMethodDTO>(){

                public IPSAppMethodDTO execute(Object obj) throws Exception {
                    PSAppMethodDTOImpl.this.onInit();
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
        this.preparePSAppMethodDTOFields();
    }

    @Override
    protected int onCheck() throws Exception {
        Iterator<? extends IPSAppMethodDTOField> psAppMethodDTOFieldList = this.getPSAppMethodDTOFields();
        if (psAppMethodDTOFieldList != null) {
            while (psAppMethodDTOFieldList.hasNext()) {
                IPSAppMethodDTOField iPSAppMethodDTOField = psAppMethodDTOFieldList.next();
                iPSAppMethodDTOField.check();
            }
        }
        return super.onCheck();
    }

    protected void preparePSAppMethodDTOFields() throws Exception {
        this.psAppMethodDTOFieldList = new ArrayList<IPSAppMethodDTOField>();
        Iterator<? extends IPSSysMethodDTOField> psSysMethodDTOFields = this.getPSSysMethodDTO().getPSSysMethodDTOFields();
        if (psSysMethodDTOFields != null) {
            while (psSysMethodDTOFields.hasNext()) {
                IPSSysMethodDTOField iPSSysMethodDTOField = psSysMethodDTOFields.next();
                PSAppMethodDTOFieldImpl psAppMethodDTOFieldImpl = new PSAppMethodDTOFieldImpl();
                psAppMethodDTOFieldImpl.init(this.getDAGlobalHelper(), this, iPSSysMethodDTOField);
                this.psAppMethodDTOFieldList.add(psAppMethodDTOFieldImpl);
            }
        }
    }

    @Override
    public String getModelType() {
        return "PSAPPMETHODDTO";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="DTO\u5bf9\u8c61\u5c5e\u6027\u96c6\u5408", child=true, group="\u57fa\u672c", order=140)
    public Iterator<? extends IPSAppMethodDTOField> getPSAppMethodDTOFields() {
        if (this.psAppMethodDTOFieldList == null || this.psAppMethodDTOFieldList.size() == 0) {
            return null;
        }
        return this.psAppMethodDTOFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysMethodDTO().getCodeName();
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
        return this.getPSSysMethodDTO().getSourceType();
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b", codelist="DEMethodDTOType", group="\u57fa\u672c", order=125)
    public String getType() {
        return this.getPSSysMethodDTO().getType();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u65b9\u6cd5DTO\u5bf9\u8c61")
    public IPSSysMethodDTO getPSSysMethodDTO() {
        return this.iPSSysMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0")
    public String getTag() {
        if (this.getPSSysMethodDTO() != null) {
            return this.getPSSysMethodDTO().getTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb02")
    public String getTag2() {
        if (this.getPSSysMethodDTO() != null) {
            return this.getPSSysMethodDTO().getTag2();
        }
        return null;
    }
}


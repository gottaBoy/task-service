/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Util;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Data.PSDEUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUtilImpl
extends PSDataEntityObjectImpl
implements IPSDEUtil {
    private static final Log log = LogFactory.getLog(PSDEUtilImpl.class);
    protected PSDEUtil psDEUtil;
    private String strUtilPSDEId = null;
    private String strUtilPSDE2Id = null;
    private String strUtilPSDE3Id = null;
    private String strUtilPSDE4Id = null;
    private String strUtilPSDE5Id = null;
    private String strUtilPSDE6Id = null;
    private String strUtilPSDE7Id = null;
    private String strUtilPSDE8Id = null;
    private String strUtilPSDE9Id = null;
    private String strUtilPSDE10Id = null;
    private String strUtilPSDE11Id = null;
    private String strUtilPSDE12Id = null;
    private String strUtilPSDE13Id = null;
    private String strUtilPSDE14Id = null;
    private String strUtilPSDE15Id = null;
    private String strUtilPSDE16Id = null;
    private String strUtilPSDE17Id = null;
    private String strUtilPSDE18Id = null;
    private String strUtilPSDE19Id = null;
    private String strUtilPSDE20Id = null;
    private String strUtilPSDEName = null;
    private String strUtilPSDE2Name = null;
    private String strUtilPSDE3Name = null;
    private String strUtilPSDE4Name = null;
    private String strUtilPSDE5Name = null;
    private String strUtilPSDE6Name = null;
    private String strUtilPSDE7Name = null;
    private String strUtilPSDE8Name = null;
    private String strUtilPSDE9Name = null;
    private String strUtilPSDE10Name = null;
    private String strUtilPSDE11Name = null;
    private String strUtilPSDE12Name = null;
    private String strUtilPSDE13Name = null;
    private String strUtilPSDE14Name = null;
    private String strUtilPSDE15Name = null;
    private String strUtilPSDE16Name = null;
    private String strUtilPSDE17Name = null;
    private String strUtilPSDE18Name = null;
    private String strUtilPSDE19Name = null;
    private String strUtilPSDE20Name = null;
    private String strUtilType = null;
    private int nExtendMode = 0;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private Properties utilParams = null;
    private String strCodeName = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEUtil psDEUtil) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEUtil = psDEUtil;
            this.setId(psDEUtil.getPSDEUTILDEID());
            this.setName(psDEUtil.getPSDEUTILDENAME());
            this.setPSObjectData(this.psDEUtil);
            if (!this.psDEUtil.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEUtil.getEXTENDMODE();
            }
            this.strUtilPSDEId = this.psDEUtil.getUTILPSDEID();
            this.strUtilPSDE2Id = this.psDEUtil.getUTILPSDE2ID();
            this.strUtilPSDE3Id = this.psDEUtil.getUTILPSDE3ID();
            this.strUtilPSDE4Id = this.psDEUtil.getUTILPSDE4ID();
            this.strUtilPSDE5Id = this.psDEUtil.getUTILPSDE5ID();
            this.strUtilPSDE6Id = this.psDEUtil.getUTILPSDE6ID();
            this.strUtilPSDE7Id = this.psDEUtil.getUTILPSDE7ID();
            this.strUtilPSDE8Id = this.psDEUtil.getUTILPSDE8ID();
            this.strUtilPSDE9Id = this.psDEUtil.getUTILPSDE9ID();
            this.strUtilPSDE10Id = this.psDEUtil.getUTILPSDE10ID();
            this.strUtilPSDE11Id = this.psDEUtil.getUTILPSDE11ID();
            this.strUtilPSDE12Id = this.psDEUtil.getUTILPSDE12ID();
            this.strUtilPSDE13Id = this.psDEUtil.getUTILPSDE13ID();
            this.strUtilPSDE14Id = this.psDEUtil.getUTILPSDE14ID();
            this.strUtilPSDE15Id = this.psDEUtil.getUTILPSDE15ID();
            this.strUtilPSDE16Id = this.psDEUtil.getUTILPSDE16ID();
            this.strUtilPSDE17Id = this.psDEUtil.getUTILPSDE17ID();
            this.strUtilPSDE18Id = this.psDEUtil.getUTILPSDE18ID();
            this.strUtilPSDE19Id = this.psDEUtil.getUTILPSDE19ID();
            this.strUtilPSDE20Id = this.psDEUtil.getUTILPSDE20ID();
            this.strUtilPSDEName = this.psDEUtil.getUTILPSDENAME();
            this.strUtilPSDE2Name = this.psDEUtil.getUTILPSDE2NAME();
            this.strUtilPSDE3Name = this.psDEUtil.getUTILPSDE3NAME();
            this.strUtilPSDE4Name = this.psDEUtil.getUTILPSDE4NAME();
            this.strUtilPSDE5Name = this.psDEUtil.getUTILPSDE5NAME();
            this.strUtilPSDE6Name = this.psDEUtil.getUTILPSDE6NAME();
            this.strUtilPSDE7Name = this.psDEUtil.getUTILPSDE7NAME();
            this.strUtilPSDE8Name = this.psDEUtil.getUTILPSDE8NAME();
            this.strUtilPSDE9Name = this.psDEUtil.getUTILPSDE9NAME();
            this.strUtilPSDE10Name = this.psDEUtil.getUTILPSDE10NAME();
            this.strUtilPSDE11Name = this.psDEUtil.getUTILPSDE11NAME();
            this.strUtilPSDE12Name = this.psDEUtil.getUTILPSDE12NAME();
            this.strUtilPSDE13Name = this.psDEUtil.getUTILPSDE13NAME();
            this.strUtilPSDE14Name = this.psDEUtil.getUTILPSDE14NAME();
            this.strUtilPSDE15Name = this.psDEUtil.getUTILPSDE15NAME();
            this.strUtilPSDE16Name = this.psDEUtil.getUTILPSDE16NAME();
            this.strUtilPSDE17Name = this.psDEUtil.getUTILPSDE17NAME();
            this.strUtilPSDE18Name = this.psDEUtil.getUTILPSDE18NAME();
            this.strUtilPSDE19Name = this.psDEUtil.getUTILPSDE19NAME();
            this.strUtilPSDE20Name = this.psDEUtil.getUTILPSDE20NAME();
            this.strUtilType = this.psDEUtil.getUTILTYPE();
            if (!StringHelper.isNullOrEmpty((String)this.psDEUtil.getUTILPARAMS())) {
                this.utilParams = PropertiesHelper.load((String)this.psDEUtil.getUTILPARAMS());
            }
            this.strCodeName = this.psDEUtil.getCODENAME();
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
        String strPSSysSFPluginId = this.psDEUtil.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDEUTILDE";
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b", codelist="DEUtilType", fields={"UTILTYPE"})
    public String getUtilType() {
        return this.strUtilType;
    }

    @Override
    public String getUtilPSDEId() {
        return this.strUtilPSDEId;
    }

    @Override
    public String getUtilPSDE2Id() {
        return this.strUtilPSDE2Id;
    }

    @Override
    public String getUtilPSDE3Id() {
        return this.strUtilPSDE3Id;
    }

    @Override
    public String getUtilPSDE4Id() {
        return this.strUtilPSDE4Id;
    }

    @Override
    public String getUtilPSDE5Id() {
        return this.strUtilPSDE5Id;
    }

    @Override
    public String getUtilPSDE6Id() {
        return this.strUtilPSDE6Id;
    }

    @Override
    public String getUtilPSDE7Id() {
        return this.strUtilPSDE7Id;
    }

    @Override
    public String getUtilPSDE8Id() {
        return this.strUtilPSDE8Id;
    }

    @Override
    public String getUtilPSDE9Id() {
        return this.strUtilPSDE9Id;
    }

    @Override
    public String getUtilPSDE10Id() {
        return this.strUtilPSDE10Id;
    }

    @Override
    public String getUtilPSDE11Id() {
        return this.strUtilPSDE11Id;
    }

    @Override
    public String getUtilPSDE12Id() {
        return this.strUtilPSDE12Id;
    }

    @Override
    public String getUtilPSDE13Id() {
        return this.strUtilPSDE13Id;
    }

    @Override
    public String getUtilPSDE14Id() {
        return this.strUtilPSDE14Id;
    }

    @Override
    public String getUtilPSDE15Id() {
        return this.strUtilPSDE15Id;
    }

    @Override
    public String getUtilPSDE16Id() {
        return this.strUtilPSDE16Id;
    }

    @Override
    public String getUtilPSDE17Id() {
        return this.strUtilPSDE17Id;
    }

    @Override
    public String getUtilPSDE18Id() {
        return this.strUtilPSDE18Id;
    }

    @Override
    public String getUtilPSDE19Id() {
        return this.strUtilPSDE19Id;
    }

    @Override
    public String getUtilPSDE20Id() {
        return this.strUtilPSDE20Id;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f53\u540d\u79f0", hideempty2=true)
    public String getUtilPSDEName() {
        return this.strUtilPSDEName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f532\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE2Name() {
        return this.strUtilPSDE2Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f533\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE3Name() {
        return this.strUtilPSDE3Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f534\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE4Name() {
        return this.strUtilPSDE4Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f535\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE5Name() {
        return this.strUtilPSDE5Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f536\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE6Name() {
        return this.strUtilPSDE6Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f537\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE7Name() {
        return this.strUtilPSDE7Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f538\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE8Name() {
        return this.strUtilPSDE8Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f539\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE9Name() {
        return this.strUtilPSDE9Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5310\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE10Name() {
        return this.strUtilPSDE10Name;
    }

    @Override
    public String getUtilPSDE11Name() {
        return this.strUtilPSDE11Name;
    }

    @Override
    public String getUtilPSDE12Name() {
        return this.strUtilPSDE12Name;
    }

    @Override
    public String getUtilPSDE13Name() {
        return this.strUtilPSDE13Name;
    }

    @Override
    public String getUtilPSDE14Name() {
        return this.strUtilPSDE14Name;
    }

    @Override
    public String getUtilPSDE15Name() {
        return this.strUtilPSDE15Name;
    }

    @Override
    public String getUtilPSDE16Name() {
        return this.strUtilPSDE16Name;
    }

    @Override
    public String getUtilPSDE17Name() {
        return this.strUtilPSDE17Name;
    }

    @Override
    public String getUtilPSDE18Name() {
        return this.strUtilPSDE18Name;
    }

    @Override
    public String getUtilPSDE19Name() {
        return this.strUtilPSDE19Name;
    }

    @Override
    public String getUtilPSDE20Name() {
        return this.strUtilPSDE20Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6807\u8bb0", hideempty=true)
    public String getUtilTag() {
        if (StringHelper.isNullOrEmpty((String)this.psDEUtil.getUTILTAG())) {
            return null;
        }
        return this.psDEUtil.getUTILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6807\u8bb02", hideempty=true)
    public String getUtilTag2() {
        if (StringHelper.isNullOrEmpty((String)this.psDEUtil.getUTILTAG2())) {
            return null;
        }
        return this.psDEUtil.getUTILTAG2();
    }

    @Override
    public String getModelId() {
        if (this.getPSDataEntity() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f53", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDEId())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDEId(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f532", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE2() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE2Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE2Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f533", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE3() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE3Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE3Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f534", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE4() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE4Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE4Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f535", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE5() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE5Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE5Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f536", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE6() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE6Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE6Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f537", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE7() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE7Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE7Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f538", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE8() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE8Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE8Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f539", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE9() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE9Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE9Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5310", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE10() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE10Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE10Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5311", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE11() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE11Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE11Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5312", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE12() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE12Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE12Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5313", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE13() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE13Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE13Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5314", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE14() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE14Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE14Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5315", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE15() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE15Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE15Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5316", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE16() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE16Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE16Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5317", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE17() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE17Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE17Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5318", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE18() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE18Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE18Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5319", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE19() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE19Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE19Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5320", hideempty2=true, dumpref=true)
    public IPSDataEntity getUtilPSDE20() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDE20Id())) {
            return this.getPSSystem().getPSDataEntity2(this.getUtilPSDE20Id(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3", hideempty2=true, dumpref=true)
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEUtil.getPSSUBSYSSERVICEAPIID())) {
            return null;
        }
        return this.getPSSystem().getPSSubSysServiceAPI(this.psDEUtil.getPSSUBSYSSERVICEAPIID());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u529f\u80fd\u53c2\u6570\u96c6\u5408", hideempty=true, fields={"UTILPARAMS"})
    public Properties getUtilParams() {
        return this.utilParams;
    }

    @Override
    protected String onGetDynaModelTag() {
        if (StringHelper.isNullOrEmpty((String)this.getCodeName())) {
            if (!StringHelper.isNullOrEmpty((String)this.getUtilTag())) {
                return this.getUtilTag();
            }
            return this.getUtilType();
        }
        return super.onGetDynaModelTag();
    }
}


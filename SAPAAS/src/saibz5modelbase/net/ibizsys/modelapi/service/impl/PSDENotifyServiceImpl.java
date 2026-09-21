/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSDENotify;
import net.ibizsys.modelapi.domain.PSDENotifyTarget;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDENotifyDTO;
import net.ibizsys.modelapi.dto.PSDENotifyTargetDTO;
import net.ibizsys.modelapi.dto.PSDEPrintDTO;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysMsgQueueDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDENotifyService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDENotifyServiceImpl
extends PSModelServiceImplBase<PSDENotify, PSDENotifyDTO>
implements IPSDENotifyService {
    private static final Log log = LogFactory.getLog(PSDENotifyServiceImpl.class);

    @Override
    public List<PSDENotify> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDENotify get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDENotify> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDENotify item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSDENotifyDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDENotify> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDENotifyDTO> dtoList = new ArrayList<PSDENotifyDTO>();
            for (PSDENotify item : list) {
                PSDENotifyDTO dto = (PSDENotifyDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDENotify> onListAll() throws Exception {
        ArrayList<PSDENotify> list = new ArrayList<PSDENotify>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDENotify> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSDENotify onGet(String strParentKey, String strCurKey) throws Exception {
        PSDENotify item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDENotify)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDENotifyDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDENotify et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDENotifyName())) {
            return et.getPSDENotifyName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDENotifyDTO dto, PSDENotify t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDENotifyId(t.getId().replace("/", "."));
        }
        if (t.getAttachmentType() != null || !bIgnoreNull) {
            dto.setAttachmentType(t.getAttachmentType());
        }
        if (t.getBeginPSDEFId() != null || !bIgnoreNull) {
            dto.setBeginPSDEFId(t.getBeginPSDEFId());
        }
        if (t.getBeginPSDEFName() != null || !bIgnoreNull) {
            dto.setBeginPSDEFName(t.getBeginPSDEFName());
        }
        if (t.getCheckTimer() != null || !bIgnoreNull) {
            dto.setCheckTimer(t.getCheckTimer());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getEndPSDEFId() != null || !bIgnoreNull) {
            dto.setEndPSDEFId(t.getEndPSDEFId());
        }
        if (t.getEndPSDEFName() != null || !bIgnoreNull) {
            dto.setEndPSDEFName(t.getEndPSDEFName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMsgType() != null || !bIgnoreNull) {
            dto.setMsgType(t.getMsgType());
        }
        if (t.getNotifyEnd() != null || !bIgnoreNull) {
            dto.setNotifyEnd(t.getNotifyEnd());
        }
        if (t.getNotifyStart() != null || !bIgnoreNull) {
            dto.setNotifyStart(t.getNotifyStart());
        }
        if (t.getNotifyTag() != null || !bIgnoreNull) {
            dto.setNotifyTag(t.getNotifyTag());
        }
        if (t.getNotifyTag2() != null || !bIgnoreNull) {
            dto.setNotifyTag2(t.getNotifyTag2());
        }
        if (t.getPropertyMap() != null || !bIgnoreNull) {
            dto.setPropertyMap(t.getPropertyMap());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDENotifyName() != null || !bIgnoreNull) {
            dto.setPSDENotifyName(t.getPSDENotifyName());
        }
        if (t.getPSDEPrintId() != null || !bIgnoreNull) {
            dto.setPSDEPrintId(t.getPSDEPrintId());
        }
        if (t.getPSDEPrintName() != null || !bIgnoreNull) {
            dto.setPSDEPrintName(t.getPSDEPrintName());
        }
        if (t.getPSDEReportId() != null || !bIgnoreNull) {
            dto.setPSDEReportId(t.getPSDEReportId());
        }
        if (t.getPSDEReportName() != null || !bIgnoreNull) {
            dto.setPSDEReportName(t.getPSDEReportName());
        }
        if (t.getPSSysMsgQueueId() != null || !bIgnoreNull) {
            dto.setPSSysMsgQueueId(t.getPSSysMsgQueueId());
        }
        if (t.getPSSysMsgQueueName() != null || !bIgnoreNull) {
            dto.setPSSysMsgQueueName(t.getPSSysMsgQueueName());
        }
        if (t.getPSSysMsgTemplId() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplId(t.getPSSysMsgTemplId());
        }
        if (t.getPSSysMsgTemplName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplName(t.getPSSysMsgTemplName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getTaskMode() != null || !bIgnoreNull) {
            dto.setTaskMode(t.getTaskMode());
        }
        if (t.getTimerMode() != null || !bIgnoreNull) {
            dto.setTimerMode(t.getTimerMode());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getBeginPSDEFId())) {
            dto.setBeginPSDEFId(this.getRealPSModelId(t, dto.getBeginPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEndPSDEFId())) {
            dto.setEndPSDEFId(this.getRealPSModelId(t, dto.getEndPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEPrintId())) {
            dto.setPSDEPrintId(this.getRealPSModelId(t, dto.getPSDEPrintId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            dto.setPSDEReportId(this.getRealPSModelId(t, dto.getPSDEReportId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgQueueId())) {
            dto.setPSSysMsgQueueId(this.getRealPSModelId(t, dto.getPSSysMsgQueueId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            dto.setPSSysMsgTemplId(this.getRealPSModelId(t, dto.getPSSysMsgTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBeginPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getBeginPSDEFId());
            dto.setBeginPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setBeginPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getEndPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getEndPSDEFId());
            dto.setEndPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setEndPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEPrintId())) {
            linkDTO = (PSDEPrintDTO)PSModelServiceUtil.getInstance().getPSDEPrintService().getDTO(dto.getPSDEPrintId());
            dto.setPSDEPrintName(((PSDEPrintDTO)linkDTO).getPSDEPrintName());
        } else {
            dto.setPSDEPrintName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            linkDTO = (PSDEReportDTO)PSModelServiceUtil.getInstance().getPSDEReportService().getDTO(dto.getPSDEReportId());
            dto.setPSDEReportName(((PSDEReportDTO)linkDTO).getPSDEReportName());
        } else {
            dto.setPSDEReportName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgQueueId())) {
            linkDTO = (PSSysMsgQueueDTO)PSModelServiceUtil.getInstance().getPSSysMsgQueueService().getDTO(dto.getPSSysMsgQueueId());
            dto.setPSSysMsgQueueName(((PSSysMsgQueueDTO)linkDTO).getPSSysMsgQueueName());
        } else {
            dto.setPSSysMsgQueueName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            linkDTO = (PSSysMsgTemplDTO)PSModelServiceUtil.getInstance().getPSSysMsgTemplService().getDTO(dto.getPSSysMsgTemplId());
            dto.setPSSysMsgTemplName(((PSSysMsgTemplDTO)linkDTO).getPSSysMsgTemplName());
        } else {
            dto.setPSSysMsgTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        List<PSDENotifyTarget> list = PSModelServiceUtil.getInstance().getPSDENotifyTargetService().listByPSDENotify(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDENotifyTargetDTO> psdenotifytargets = new ArrayList<PSDENotifyTargetDTO>();
            for (PSDENotifyTarget item : list) {
                PSDENotifyTargetDTO dstItem = (PSDENotifyTargetDTO)PSModelServiceUtil.getInstance().getPSDENotifyTargetService().toDTO(item);
                psdenotifytargets.add(dstItem);
            }
            dto.setPsdenotifytargets(psdenotifytargets);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDENOTIFY";
    }

    @Override
    public PSDENotify createDomain() {
        return new PSDENotify();
    }

    @Override
    public PSDENotifyDTO createDTO() {
        return new PSDENotifyDTO();
    }
}


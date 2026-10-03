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
import net.ibizsys.modelapi.domain.PSDERepItem;
import net.ibizsys.modelapi.domain.PSDEReport;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDERepItemDTO;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.service.IPSDEReportService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEReportServiceImpl
extends PSModelServiceImplBase<PSDEReport, PSDEReportDTO>
implements IPSDEReportService {
    private static final Log log = LogFactory.getLog(PSDEReportServiceImpl.class);

    @Override
    public List<PSDEReport> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEReport get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEReport> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEReport item : list) {
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
    public List<PSDEReportDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEReport> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEReportDTO> dtoList = new ArrayList<PSDEReportDTO>();
            for (PSDEReport item : list) {
                PSDEReportDTO dto = (PSDEReportDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEReport> onListAll() throws Exception {
        ArrayList<PSDEReport> list = new ArrayList<PSDEReport>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEReport> items = this.listByPSDataEntity(parent);
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
    protected PSDEReport onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEReport item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEReport)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEReportDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEReport et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEReportName())) {
            return et.getPSDEReportName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEReportDTO dto, PSDEReport t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEReportId(t.getId().replace("/", "."));
        }
        if (t.getADPSDELogicId() != null || !bIgnoreNull) {
            dto.setADPSDELogicId(t.getADPSDELogicId());
        }
        if (t.getADPSDELogicName() != null || !bIgnoreNull) {
            dto.setADPSDELogicName(t.getADPSDELogicName());
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
        if (t.getEnableAudit() != null || !bIgnoreNull) {
            dto.setEnableAudit(t.getEnableAudit());
        }
        if (t.getEnableLog() != null || !bIgnoreNull) {
            dto.setEnableLog(t.getEnableLog());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getLayoutPanelMode() != null || !bIgnoreNull) {
            dto.setLayoutPanelMode(t.getLayoutPanelMode());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMultiPage() != null || !bIgnoreNull) {
            dto.setMultiPage(t.getMultiPage());
        }
        if (t.getPOTime() != null || !bIgnoreNull) {
            dto.setPOTime(t.getPOTime());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSId2() != null || !bIgnoreNull) {
            dto.setPSDEDSId2(t.getPSDEDSId2());
        }
        if (t.getPSDEDSId3() != null || !bIgnoreNull) {
            dto.setPSDEDSId3(t.getPSDEDSId3());
        }
        if (t.getPSDEDSId4() != null || !bIgnoreNull) {
            dto.setPSDEDSId4(t.getPSDEDSId4());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEDSName2() != null || !bIgnoreNull) {
            dto.setPSDEDSName2(t.getPSDEDSName2());
        }
        if (t.getPSDEDSName3() != null || !bIgnoreNull) {
            dto.setPSDEDSName3(t.getPSDEDSName3());
        }
        if (t.getPSDEDSName4() != null || !bIgnoreNull) {
            dto.setPSDEDSName4(t.getPSDEDSName4());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEReportName() != null || !bIgnoreNull) {
            dto.setPSDEReportName(t.getPSDEReportName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getReportFile() != null || !bIgnoreNull) {
            dto.setReportFile(t.getReportFile());
        }
        if (t.getReportModel() != null || !bIgnoreNull) {
            dto.setReportModel(t.getReportModel());
        }
        if (t.getReportType() != null || !bIgnoreNull) {
            dto.setReportType(t.getReportType());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
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
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            dto.setADPSDELogicId(this.getRealPSModelId(t, dto.getADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId2())) {
            dto.setPSDEDSId2(this.getRealPSModelId(t, dto.getPSDEDSId2()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId3())) {
            dto.setPSDEDSId3(this.getRealPSModelId(t, dto.getPSDEDSId3()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId4())) {
            dto.setPSDEDSId4(this.getRealPSModelId(t, dto.getPSDEDSId4()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getADPSDELogicId());
            dto.setADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId2())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId2());
            dto.setPSDEDSName2(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName2(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId3())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId3());
            dto.setPSDEDSName3(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName3(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId4())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId4());
            dto.setPSDEDSName4(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName4(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            linkDTO = (PSSysUniResDTO)PSModelServiceUtil.getInstance().getPSSysUniResService().getDTO(dto.getPSSysUniResId());
            dto.setPSSysUniResName(((PSSysUniResDTO)linkDTO).getPSSysUniResName());
        } else {
            dto.setPSSysUniResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        List<PSDERepItem> list = PSModelServiceUtil.getInstance().getPSDERepItemService().listByPSDEReport(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDERepItemDTO> psderepitems = new ArrayList<PSDERepItemDTO>();
            for (PSDERepItem item : list) {
                PSDERepItemDTO dstItem = (PSDERepItemDTO)PSModelServiceUtil.getInstance().getPSDERepItemService().toDTO(item);
                psderepitems.add(dstItem);
            }
            dto.setPsderepitems(psderepitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEREPORT";
    }

    @Override
    public PSDEReport createDomain() {
        return new PSDEReport();
    }

    @Override
    public PSDEReportDTO createDTO() {
        return new PSDEReportDTO();
    }
}


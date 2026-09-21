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
import net.ibizsys.modelapi.domain.PSSysERMap;
import net.ibizsys.modelapi.domain.PSSysERMapNode;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADEDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysBDSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.dto.PSSysDBSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysDBTableDTO;
import net.ibizsys.modelapi.dto.PSSysERMapDTO;
import net.ibizsys.modelapi.dto.PSSysERMapNodeDTO;
import net.ibizsys.modelapi.dto.PSSysSearchDocDTO;
import net.ibizsys.modelapi.dto.PSSysSearchSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.service.IPSSysERMapNodeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysERMapNodeServiceImpl
extends PSModelServiceImplBase<PSSysERMapNode, PSSysERMapNodeDTO>
implements IPSSysERMapNodeService {
    private static final Log log = LogFactory.getLog(PSSysERMapNodeServiceImpl.class);

    @Override
    public List<PSSysERMapNode> listByPSSysERMap(PSSysERMap parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysERMapNode get(PSSysERMap parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysERMapNode> list = this.listByPSSysERMap(parent);
        if (list != null) {
            for (PSSysERMapNode item : list) {
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
    public List<PSSysERMapNodeDTO> listDTOByPSSysERMap(String strParentKey) throws Exception {
        PSSysERMap pssysermap = (PSSysERMap)PSModelServiceUtil.getInstance().getPSSysERMapService().get(strParentKey);
        List<PSSysERMapNode> list = this.listByPSSysERMap(pssysermap);
        if (list != null) {
            ArrayList<PSSysERMapNodeDTO> dtoList = new ArrayList<PSSysERMapNodeDTO>();
            for (PSSysERMapNode item : list) {
                PSSysERMapNodeDTO dto = (PSSysERMapNodeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysERMapNode> onListAll() throws Exception {
        ArrayList<PSSysERMapNode> list = new ArrayList<PSSysERMapNode>();
        List pssysermaps = PSModelServiceUtil.getInstance().getPSSysERMapService().listAll();
        if (pssysermaps != null) {
            for (PSSysERMap parent : pssysermaps) {
                List<PSSysERMapNode> items = this.listByPSSysERMap(parent);
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
    protected PSSysERMapNode onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysERMapNode item;
        PSSysERMap pssysermap = (PSSysERMap)PSModelServiceUtil.getInstance().getPSSysERMapService().get(strParentKey, true);
        if (pssysermap != null && (item = this.get(pssysermap, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysERMapNode)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysERMapNodeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysERMapId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysERMapService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysERMapNode et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysERMapNodeDTO dto, PSSysERMapNode t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysERMapNodeId(t.getId().replace("/", "."));
        }
        if (t.getColor() != null || !bIgnoreNull) {
            dto.setColor(t.getColor());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDetailMode() != null || !bIgnoreNull) {
            dto.setDetailMode(t.getDetailMode());
        }
        if (t.getLeftPos() != null || !bIgnoreNull) {
            dto.setLeftPos(t.getLeftPos());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModColor() != null || !bIgnoreNull) {
            dto.setModColor(t.getModColor());
        }
        if (t.getNodeTag() != null || !bIgnoreNull) {
            dto.setNodeTag(t.getNodeTag());
        }
        if (t.getNodeTag2() != null || !bIgnoreNull) {
            dto.setNodeTag2(t.getNodeTag2());
        }
        if (t.getNodeType() != null || !bIgnoreNull) {
            dto.setNodeType(t.getNodeType());
        }
        if (t.getPSAppLocalDEId() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEId(t.getPSAppLocalDEId());
        }
        if (t.getPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEName(t.getPSAppLocalDEName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIId(t.getPSDEServiceAPIId());
        }
        if (t.getPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIName(t.getPSDEServiceAPIName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEId(t.getPSSubSysSADEId());
        }
        if (t.getPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEName(t.getPSSubSysSADEName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSubSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIName(t.getPSSubSysServiceAPIName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysBDSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeId(t.getPSSysBDSchemeId());
        }
        if (t.getPSSysBDSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeName(t.getPSSysBDSchemeName());
        }
        if (t.getPSSysBDTableId() != null || !bIgnoreNull) {
            dto.setPSSysBDTableId(t.getPSSysBDTableId());
        }
        if (t.getPSSysBDTableName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableName(t.getPSSysBDTableName());
        }
        if (t.getPSSysDBSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeId(t.getPSSysDBSchemeId());
        }
        if (t.getPSSysDBSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeName(t.getPSSysDBSchemeName());
        }
        if (t.getPSSysDBTableId() != null || !bIgnoreNull) {
            dto.setPSSysDBTableId(t.getPSSysDBTableId());
        }
        if (t.getPSSysDBTableName() != null || !bIgnoreNull) {
            dto.setPSSysDBTableName(t.getPSSysDBTableName());
        }
        if (t.getPSSysERMapId() != null || !bIgnoreNull) {
            dto.setPSSysERMapId(t.getPSSysERMapId());
        }
        if (t.getPSSysERMapName() != null || !bIgnoreNull) {
            dto.setPSSysERMapName(t.getPSSysERMapName());
        }
        if (t.getPSSysERMapNodeName() != null || !bIgnoreNull) {
            dto.setPSSysERMapNodeName(t.getPSSysERMapNodeName());
        }
        if (t.getPSSysSearchDocId() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocId(t.getPSSysSearchDocId());
        }
        if (t.getPSSysSearchDocName() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocName(t.getPSSysSearchDocName());
        }
        if (t.getPSSysSearchSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysSearchSchemeId(t.getPSSysSearchSchemeId());
        }
        if (t.getPSSysSearchSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysSearchSchemeName(t.getPSSysSearchSchemeName());
        }
        if (t.getPSSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIId(t.getPSSysServiceAPIId());
        }
        if (t.getPSSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIName(t.getPSSysServiceAPIName());
        }
        if (t.getShapeParams() != null || !bIgnoreNull) {
            dto.setShapeParams(t.getShapeParams());
        }
        if (t.getShowDEFields() != null || !bIgnoreNull) {
            dto.setShowDEFields(t.getShowDEFields());
        }
        if (t.getTopPos() != null || !bIgnoreNull) {
            dto.setTopPos(t.getTopPos());
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
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            dto.setPSAppLocalDEId(this.getRealPSModelId(t, dto.getPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            dto.setPSDEServiceAPIId(this.getRealPSModelId(t, dto.getPSDEServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            dto.setPSSubSysSADEId(this.getRealPSModelId(t, dto.getPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            dto.setPSSysBDSchemeId(this.getRealPSModelId(t, dto.getPSSysBDSchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            dto.setPSSysBDTableId(this.getRealPSModelId(t, dto.getPSSysBDTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBSchemeId())) {
            dto.setPSSysDBSchemeId(this.getRealPSModelId(t, dto.getPSSysDBSchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            dto.setPSSysDBTableId(this.getRealPSModelId(t, dto.getPSSysDBTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysERMapId())) {
            dto.setPSSysERMapId(this.getRealPSModelId(t, dto.getPSSysERMapId()).replace("/", "."));
        }
        if ("PSSYSERMAP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysERMapId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            dto.setPSSysSearchDocId(this.getRealPSModelId(t, dto.getPSSysSearchDocId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            dto.setPSSysSearchSchemeId(this.getRealPSModelId(t, dto.getPSSysSearchSchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            dto.setPSSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(dto.getPSAppLocalDEId());
            dto.setPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
        } else {
            dto.setPSAppLocalDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setColor(((PSDataEntityDTO)linkDTO).getColor());
            dto.setLogicName(((PSDataEntityDTO)linkDTO).getLogicName());
            dto.setModColor(((PSDataEntityDTO)linkDTO).getModColor());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
            dto.setPSModuleId(((PSDataEntityDTO)linkDTO).getPSModuleId());
            dto.setPSModuleName(((PSDataEntityDTO)linkDTO).getPSModuleName());
        } else {
            dto.setColor(null);
            dto.setLogicName(null);
            dto.setModColor(null);
            dto.setPSDEName(null);
            dto.setPSModuleId(null);
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getPSDEServiceAPIId());
            dto.setPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setPSDEServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getPSSubSysSADEId());
            dto.setPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setPSSubSysSADEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            linkDTO = (PSSubSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().getDTO(dto.getPSSubSysServiceAPIId());
            dto.setPSSubSysServiceAPIName(((PSSubSysServiceAPIDTO)linkDTO).getPSSubSysServiceAPIName());
        } else {
            dto.setPSSubSysServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            linkDTO = (PSSysBDSchemeDTO)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().getDTO(dto.getPSSysBDSchemeId());
            dto.setPSSysBDSchemeName(((PSSysBDSchemeDTO)linkDTO).getPSSysBDSchemeName());
        } else {
            dto.setPSSysBDSchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            linkDTO = (PSSysBDTableDTO)PSModelServiceUtil.getInstance().getPSSysBDTableService().getDTO(dto.getPSSysBDTableId());
            dto.setPSSysBDTableName(((PSSysBDTableDTO)linkDTO).getPSSysBDTableName());
        } else {
            dto.setPSSysBDTableName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBSchemeId())) {
            linkDTO = (PSSysDBSchemeDTO)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().getDTO(dto.getPSSysDBSchemeId());
            dto.setPSSysDBSchemeName(((PSSysDBSchemeDTO)linkDTO).getPSSysDBSchemeName());
        } else {
            dto.setPSSysDBSchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            linkDTO = (PSSysDBTableDTO)PSModelServiceUtil.getInstance().getPSSysDBTableService().getDTO(dto.getPSSysDBTableId());
            dto.setPSSysDBTableName(((PSSysDBTableDTO)linkDTO).getPSSysDBTableName());
        } else {
            dto.setPSSysDBTableName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysERMapId())) {
            linkDTO = (PSSysERMapDTO)PSModelServiceUtil.getInstance().getPSSysERMapService().getDTO(dto.getPSSysERMapId());
            dto.setPSSysERMapName(((PSSysERMapDTO)linkDTO).getPSSysERMapName());
        } else {
            dto.setPSSysERMapName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            linkDTO = (PSSysSearchDocDTO)PSModelServiceUtil.getInstance().getPSSysSearchDocService().getDTO(dto.getPSSysSearchDocId());
            dto.setPSSysSearchDocName(((PSSysSearchDocDTO)linkDTO).getPSSysSearchDocName());
        } else {
            dto.setPSSysSearchDocName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            linkDTO = (PSSysSearchSchemeDTO)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().getDTO(dto.getPSSysSearchSchemeId());
            dto.setPSSysSearchSchemeName(((PSSysSearchSchemeDTO)linkDTO).getPSSysSearchSchemeName());
        } else {
            dto.setPSSysSearchSchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            linkDTO = (PSSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().getDTO(dto.getPSSysServiceAPIId());
            dto.setPSSysServiceAPIName(((PSSysServiceAPIDTO)linkDTO).getPSSysServiceAPIName());
        } else {
            dto.setPSSysServiceAPIName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSERMAPNODE";
    }

    @Override
    public PSSysERMapNode createDomain() {
        return new PSSysERMapNode();
    }

    @Override
    public PSSysERMapNodeDTO createDTO() {
        return new PSSysERMapNodeDTO();
    }
}


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
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDELogicParam;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDELogicParamDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDELogicParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDELogicParamServiceImpl
extends PSModelServiceImplBase<PSDELogicParam, PSDELogicParamDTO>
implements IPSDELogicParamService {
    private static final Log log = LogFactory.getLog(PSDELogicParamServiceImpl.class);

    @Override
    public List<PSDELogicParam> listByPSDELogic(PSDELogic parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDELogicParam get(PSDELogic parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDELogicParam> list = this.listByPSDELogic(parent);
        if (list != null) {
            for (PSDELogicParam item : list) {
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
    public List<PSDELogicParamDTO> listDTOByPSDELogic(String strParentKey) throws Exception {
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey);
        List<PSDELogicParam> list = this.listByPSDELogic(psdelogic);
        if (list != null) {
            ArrayList<PSDELogicParamDTO> dtoList = new ArrayList<PSDELogicParamDTO>();
            for (PSDELogicParam item : list) {
                PSDELogicParamDTO dto = (PSDELogicParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDELogicParam> onListAll() throws Exception {
        ArrayList<PSDELogicParam> list = new ArrayList<PSDELogicParam>();
        List<PSDELogic> psdelogics = PSModelServiceUtil.getInstance().getPSDELogicService().listAll();
        if (psdelogics != null) {
            for (PSDELogic parent : psdelogics) {
                List<PSDELogicParam> items = this.listByPSDELogic(parent);
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
    protected PSDELogicParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSDELogicParam item;
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey, true);
        if (psdelogic != null && (item = this.get(psdelogic, strCurKey, true)) != null) {
            return item;
        }
        return (PSDELogicParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDELogicParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDELogicId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDELogicService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDELogicParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDELogicParamName())) {
            return et.getPSDELogicParamName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDELogicParamDTO dto, PSDELogicParam t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDELogicParamId(t.getId().replace("/", "."));
        }
        if (t.getCloneParamFlag() != null || !bIgnoreNull) {
            dto.setCloneParamFlag(t.getCloneParamFlag());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultParam() != null || !bIgnoreNull) {
            dto.setDefaultParam(t.getDefaultParam());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getDefaultValueType() != null || !bIgnoreNull) {
            dto.setDefaultValueType(t.getDefaultValueType());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getFileType() != null || !bIgnoreNull) {
            dto.setFileType(t.getFileType());
        }
        if (t.getFileUrl() != null || !bIgnoreNull) {
            dto.setFileUrl(t.getFileUrl());
        }
        if (t.getGlobalParam() != null || !bIgnoreNull) {
            dto.setGlobalParam(t.getGlobalParam());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOriginEntityFlag() != null || !bIgnoreNull) {
            dto.setOriginEntityFlag(t.getOriginEntityFlag());
        }
        if (t.getParamPSDEId() != null || !bIgnoreNull) {
            dto.setParamPSDEId(t.getParamPSDEId());
        }
        if (t.getParamPSDEName() != null || !bIgnoreNull) {
            dto.setParamPSDEName(t.getParamPSDEName());
        }
        if (t.getParams() != null || !bIgnoreNull) {
            dto.setParams(t.getParams());
        }
        if (t.getParamTag() != null || !bIgnoreNull) {
            dto.setParamTag(t.getParamTag());
        }
        if (t.getParamTag2() != null || !bIgnoreNull) {
            dto.setParamTag2(t.getParamTag2());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDELogicParamName() != null || !bIgnoreNull) {
            dto.setPSDELogicParamName(t.getPSDELogicParamName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getRefFieldName() != null || !bIgnoreNull) {
            dto.setRefFieldName(t.getRefFieldName());
        }
        if (t.getRefParamName() != null || !bIgnoreNull) {
            dto.setRefParamName(t.getRefParamName());
        }
        if (t.getStdDataType() != null || !bIgnoreNull) {
            dto.setStdDataType(t.getStdDataType());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (StringUtils.hasLength((String)dto.getParamPSDEId())) {
            dto.setParamPSDEId(this.getRealPSModelId(t, dto.getParamPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if ("PSDELOGIC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDELogicId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getParamPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getParamPSDEId());
            dto.setParamPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setParamPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId(), true);
            if (linkDTO != null) {
                dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
            }
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDELOGICPARAM";
    }

    @Override
    public PSDELogicParam createDomain() {
        return new PSDELogicParam();
    }

    @Override
    public PSDELogicParamDTO createDTO() {
        return new PSDELogicParamDTO();
    }
}


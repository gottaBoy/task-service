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
import net.ibizsys.modelapi.domain.PSDELNParam;
import net.ibizsys.modelapi.domain.PSDELogicNode;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELNParamDTO;
import net.ibizsys.modelapi.dto.PSDELogicNodeDTO;
import net.ibizsys.modelapi.dto.PSDELogicParamDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysSequenceDTO;
import net.ibizsys.modelapi.dto.PSSysTranslatorDTO;
import net.ibizsys.modelapi.service.IPSDELNParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDELNParamServiceImpl
extends PSModelServiceImplBase<PSDELNParam, PSDELNParamDTO>
implements IPSDELNParamService {
    private static final Log log = LogFactory.getLog(PSDELNParamServiceImpl.class);

    @Override
    public List<PSDELNParam> listByPSDELogicNode(PSDELogicNode parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDELNParam get(PSDELogicNode parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDELNParam> list = this.listByPSDELogicNode(parent);
        if (list != null) {
            for (PSDELNParam item : list) {
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
    public List<PSDELNParamDTO> listDTOByPSDELogicNode(String strParentKey) throws Exception {
        PSDELogicNode psdelogicnode = (PSDELogicNode)PSModelServiceUtil.getInstance().getPSDELogicNodeService().get(strParentKey);
        List<PSDELNParam> list = this.listByPSDELogicNode(psdelogicnode);
        if (list != null) {
            ArrayList<PSDELNParamDTO> dtoList = new ArrayList<PSDELNParamDTO>();
            for (PSDELNParam item : list) {
                PSDELNParamDTO dto = (PSDELNParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDELNParam> onListAll() throws Exception {
        ArrayList<PSDELNParam> list = new ArrayList<PSDELNParam>();
        List psdelogicnodes = PSModelServiceUtil.getInstance().getPSDELogicNodeService().listAll();
        if (psdelogicnodes != null) {
            for (PSDELogicNode parent : psdelogicnodes) {
                List<PSDELNParam> items = this.listByPSDELogicNode(parent);
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
    protected PSDELNParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSDELNParam item;
        PSDELogicNode psdelogicnode = (PSDELogicNode)PSModelServiceUtil.getInstance().getPSDELogicNodeService().get(strParentKey, true);
        if (psdelogicnode != null && (item = this.get(psdelogicnode, strCurKey, true)) != null) {
            return item;
        }
        return (PSDELNParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDELNParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDELogicNodeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDELogicNodeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDELNParam et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDELNParamDTO dto, PSDELNParam t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDELNParamId(t.getId().replace("/", "."));
        }
        if (t.getAggMode() != null || !bIgnoreNull) {
            dto.setAggMode(t.getAggMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomDstParam() != null || !bIgnoreNull) {
            dto.setCustomDstParam(t.getCustomDstParam());
        }
        if (t.getCustomSrcParam() != null || !bIgnoreNull) {
            dto.setCustomSrcParam(t.getCustomSrcParam());
        }
        if (t.getDirectCode() != null || !bIgnoreNull) {
            dto.setDirectCode(t.getDirectCode());
        }
        if (t.getDstIndex() != null || !bIgnoreNull) {
            dto.setDstIndex(t.getDstIndex());
        }
        if (t.getDstParamPSDEId() != null || !bIgnoreNull) {
            dto.setDstParamPSDEId(t.getDstParamPSDEId());
        }
        if (t.getDstPSDEFId() != null || !bIgnoreNull) {
            dto.setDstPSDEFId(t.getDstPSDEFId());
        }
        if (t.getDstPSDEFName() != null || !bIgnoreNull) {
            dto.setDstPSDEFName(t.getDstPSDEFName());
        }
        if (t.getDstPSDLParamId() != null || !bIgnoreNull) {
            dto.setDstPSDLParamId(t.getDstPSDLParamId());
        }
        if (t.getDstPSDLParamName() != null || !bIgnoreNull) {
            dto.setDstPSDLParamName(t.getDstPSDLParamName());
        }
        if (t.getDstSortDir() != null || !bIgnoreNull) {
            dto.setDstSortDir(t.getDstSortDir());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getInOutFlag() != null || !bIgnoreNull) {
            dto.setInOutFlag(t.getInOutFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamTag() != null || !bIgnoreNull) {
            dto.setParamTag(t.getParamTag());
        }
        if (t.getParamTag2() != null || !bIgnoreNull) {
            dto.setParamTag2(t.getParamTag2());
        }
        if (t.getParamType() != null || !bIgnoreNull) {
            dto.setParamType(t.getParamType());
        }
        if (t.getParamTypeText() != null || !bIgnoreNull) {
            dto.setParamTypeText(t.getParamTypeText());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELNParamName() != null || !bIgnoreNull) {
            dto.setPSDELNParamName(t.getPSDELNParamName());
        }
        if (t.getPSDELogicNodeId() != null || !bIgnoreNull) {
            dto.setPSDELogicNodeId(t.getPSDELogicNodeId());
        }
        if (t.getPSDELogicNodeName() != null || !bIgnoreNull) {
            dto.setPSDELogicNodeName(t.getPSDELogicNodeName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSObjData() != null || !bIgnoreNull) {
            dto.setPSObjData(t.getPSObjData());
        }
        if (t.getPSObjData2() != null || !bIgnoreNull) {
            dto.setPSObjData2(t.getPSObjData2());
        }
        if (t.getPSObjId() != null || !bIgnoreNull) {
            dto.setPSObjId(t.getPSObjId());
        }
        if (t.getPSObjName() != null || !bIgnoreNull) {
            dto.setPSObjName(t.getPSObjName());
        }
        if (t.getPSObjType() != null || !bIgnoreNull) {
            dto.setPSObjType(t.getPSObjType());
        }
        if (t.getPSObjTypeName() != null || !bIgnoreNull) {
            dto.setPSObjTypeName(t.getPSObjTypeName());
        }
        if (t.getPSSysSequenceId() != null || !bIgnoreNull) {
            dto.setPSSysSequenceId(t.getPSSysSequenceId());
        }
        if (t.getPSSysSequenceName() != null || !bIgnoreNull) {
            dto.setPSSysSequenceName(t.getPSSysSequenceName());
        }
        if (t.getPSSysTranslatorId() != null || !bIgnoreNull) {
            dto.setPSSysTranslatorId(t.getPSSysTranslatorId());
        }
        if (t.getPSSysTranslatorName() != null || !bIgnoreNull) {
            dto.setPSSysTranslatorName(t.getPSSysTranslatorName());
        }
        if (t.getSrcIndex() != null || !bIgnoreNull) {
            dto.setSrcIndex(t.getSrcIndex());
        }
        if (t.getSrcParamPSDEId() != null || !bIgnoreNull) {
            dto.setSrcParamPSDEId(t.getSrcParamPSDEId());
        }
        if (t.getSrcPSDEFId() != null || !bIgnoreNull) {
            dto.setSrcPSDEFId(t.getSrcPSDEFId());
        }
        if (t.getSrcPSDEFName() != null || !bIgnoreNull) {
            dto.setSrcPSDEFName(t.getSrcPSDEFName());
        }
        if (t.getSrcPSDLParamId() != null || !bIgnoreNull) {
            dto.setSrcPSDLParamId(t.getSrcPSDLParamId());
        }
        if (t.getSrcPSDLParamName() != null || !bIgnoreNull) {
            dto.setSrcPSDLParamName(t.getSrcPSDLParamName());
        }
        if (t.getSrcSize() != null || !bIgnoreNull) {
            dto.setSrcSize(t.getSrcSize());
        }
        if (t.getSrcValue() != null || !bIgnoreNull) {
            dto.setSrcValue(t.getSrcValue());
        }
        if (t.getSrcValueStdDataType() != null || !bIgnoreNull) {
            dto.setSrcValueStdDataType(t.getSrcValueStdDataType());
        }
        if (t.getSrcValueType() != null || !bIgnoreNull) {
            dto.setSrcValueType(t.getSrcValueType());
        }
        if (t.getSrcValueTypeText() != null || !bIgnoreNull) {
            dto.setSrcValueTypeText(t.getSrcValueTypeText());
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
        if (StringUtils.hasLength((String)dto.getDstPSDEFId())) {
            dto.setDstPSDEFId(this.getRealPSModelId(t, dto.getDstPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            dto.setDstPSDLParamId(this.getRealPSModelId(t, dto.getDstPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicNodeId())) {
            dto.setPSDELogicNodeId(this.getRealPSModelId(t, dto.getPSDELogicNodeId()).replace("/", "."));
        }
        if ("PSDELOGICNODE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDELogicNodeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSequenceId())) {
            dto.setPSSysSequenceId(this.getRealPSModelId(t, dto.getPSSysSequenceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTranslatorId())) {
            dto.setPSSysTranslatorId(this.getRealPSModelId(t, dto.getPSSysTranslatorId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDEFId())) {
            dto.setSrcPSDEFId(this.getRealPSModelId(t, dto.getSrcPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDLParamId())) {
            dto.setSrcPSDLParamId(this.getRealPSModelId(t, dto.getSrcPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDstPSDEFId());
            dto.setDstPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDstPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getDstPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setDstParamPSDEId(((PSDELogicParamDTO)linkDTO).getParamPSDEId());
                dto.setDstPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setDstParamPSDEId(null);
            dto.setDstPSDLParamName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicNodeId())) {
            linkDTO = (PSDELogicNodeDTO)PSModelServiceUtil.getInstance().getPSDELogicNodeService().getDTO(dto.getPSDELogicNodeId(), true);
            if (linkDTO != null) {
                dto.setPSDELogicNodeName(((PSDELogicNodeDTO)linkDTO).getPSDELogicNodeName());
            }
        } else {
            dto.setPSDELogicNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSequenceId())) {
            linkDTO = (PSSysSequenceDTO)PSModelServiceUtil.getInstance().getPSSysSequenceService().getDTO(dto.getPSSysSequenceId());
            dto.setPSSysSequenceName(((PSSysSequenceDTO)linkDTO).getPSSysSequenceName());
        } else {
            dto.setPSSysSequenceName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTranslatorId())) {
            linkDTO = (PSSysTranslatorDTO)PSModelServiceUtil.getInstance().getPSSysTranslatorService().getDTO(dto.getPSSysTranslatorId());
            dto.setPSSysTranslatorName(((PSSysTranslatorDTO)linkDTO).getPSSysTranslatorName());
        } else {
            dto.setPSSysTranslatorName(null);
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getSrcPSDEFId());
            dto.setSrcPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setSrcPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getSrcPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setSrcParamPSDEId(((PSDELogicParamDTO)linkDTO).getParamPSDEId());
                dto.setSrcPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setSrcParamPSDEId(null);
            dto.setSrcPSDLParamName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDELNPARAM";
    }

    @Override
    public PSDELNParam createDomain() {
        return new PSDELNParam();
    }

    @Override
    public PSDELNParamDTO createDTO() {
        return new PSDELNParamDTO();
    }
}


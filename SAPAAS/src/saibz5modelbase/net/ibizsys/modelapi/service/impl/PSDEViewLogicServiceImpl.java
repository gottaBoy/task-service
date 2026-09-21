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
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEViewLogic;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDEViewCtrlDTO;
import net.ibizsys.modelapi.dto.PSDEViewLogicDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysViewLogicDTO;
import net.ibizsys.modelapi.service.IPSDEViewLogicService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEViewLogicServiceImpl
extends PSModelServiceImplBase<PSDEViewLogic, PSDEViewLogicDTO>
implements IPSDEViewLogicService {
    private static final Log log = LogFactory.getLog(PSDEViewLogicServiceImpl.class);

    @Override
    public List<PSDEViewLogic> listByPSDEViewBase(PSDEViewBase parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEViewLogic get(PSDEViewBase parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEViewLogic> list = this.listByPSDEViewBase(parent);
        if (list != null) {
            for (PSDEViewLogic item : list) {
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
    public List<PSDEViewLogicDTO> listDTOByPSDEViewBase(String strParentKey) throws Exception {
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey);
        List<PSDEViewLogic> list = this.listByPSDEViewBase(psdeviewbase);
        if (list != null) {
            ArrayList<PSDEViewLogicDTO> dtoList = new ArrayList<PSDEViewLogicDTO>();
            for (PSDEViewLogic item : list) {
                PSDEViewLogicDTO dto = (PSDEViewLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEViewLogic> onListAll() throws Exception {
        ArrayList<PSDEViewLogic> list = new ArrayList<PSDEViewLogic>();
        List psdeviewbases = PSModelServiceUtil.getInstance().getPSDEViewBaseService().listAll();
        if (psdeviewbases != null) {
            for (PSDEViewBase parent : psdeviewbases) {
                List<PSDEViewLogic> items = this.listByPSDEViewBase(parent);
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
    protected PSDEViewLogic onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEViewLogic item;
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey, true);
        if (psdeviewbase != null && (item = this.get(psdeviewbase, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEViewLogic)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEViewLogicDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEViewBaseId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEViewLogic et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEViewLogicName())) {
            return et.getPSDEViewLogicName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEViewLogicDTO dto, PSDEViewLogic t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEViewLogicId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getDstLogicType() != null || !bIgnoreNull) {
            dto.setDstLogicType(t.getDstLogicType());
        }
        if (t.getEventArg() != null || !bIgnoreNull) {
            dto.setEventArg(t.getEventArg());
        }
        if (t.getEventArg2() != null || !bIgnoreNull) {
            dto.setEventArg2(t.getEventArg2());
        }
        if (t.getEventNames() != null || !bIgnoreNull) {
            dto.setEventNames(t.getEventNames());
        }
        if (t.getLogicParam() != null || !bIgnoreNull) {
            dto.setLogicParam(t.getLogicParam());
        }
        if (t.getLogicParam2() != null || !bIgnoreNull) {
            dto.setLogicParam2(t.getLogicParam2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamPSDEViewCtrlId() != null || !bIgnoreNull) {
            dto.setParamPSDEViewCtrlId(t.getParamPSDEViewCtrlId());
        }
        if (t.getParamPSDEViewCtrlName() != null || !bIgnoreNull) {
            dto.setParamPSDEViewCtrlName(t.getParamPSDEViewCtrlName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSDEViewCtrlId() != null || !bIgnoreNull) {
            dto.setPSDEViewCtrlId(t.getPSDEViewCtrlId());
        }
        if (t.getPSDEViewCtrlName() != null || !bIgnoreNull) {
            dto.setPSDEViewCtrlName(t.getPSDEViewCtrlName());
        }
        if (t.getPSDEViewLogicName() != null || !bIgnoreNull) {
            dto.setPSDEViewLogicName(t.getPSDEViewLogicName());
        }
        if (t.getPSDEViewLogicType() != null || !bIgnoreNull) {
            dto.setPSDEViewLogicType(t.getPSDEViewLogicType());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysViewLogicId() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicId(t.getPSSysViewLogicId());
        }
        if (t.getPSSysViewLogicName() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicName(t.getPSSysViewLogicName());
        }
        if (t.getRefPSDEViewLogicId() != null || !bIgnoreNull) {
            dto.setRefPSDEViewLogicId(t.getRefPSDEViewLogicId());
        }
        if (t.getRefPSDEViewLogicName() != null || !bIgnoreNull) {
            dto.setRefPSDEViewLogicName(t.getRefPSDEViewLogicName());
        }
        if (t.getTimer() != null || !bIgnoreNull) {
            dto.setTimer(t.getTimer());
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
        if (StringUtils.hasLength((String)dto.getParamPSDEViewCtrlId())) {
            dto.setParamPSDEViewCtrlId(this.getRealPSModelId(t, dto.getParamPSDEViewCtrlId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if ("PSDEVIEWBASE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEViewBaseId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewCtrlId())) {
            dto.setPSDEViewCtrlId(this.getRealPSModelId(t, dto.getPSDEViewCtrlId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            dto.setPSSysViewLogicId(this.getRealPSModelId(t, dto.getPSSysViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEViewLogicId())) {
            dto.setRefPSDEViewLogicId(this.getRealPSModelId(t, dto.getRefPSDEViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getParamPSDEViewCtrlId())) {
            linkDTO = (PSDEViewCtrlDTO)PSModelServiceUtil.getInstance().getPSDEViewCtrlService().getDTO(dto.getParamPSDEViewCtrlId());
            dto.setParamPSDEViewCtrlName(((PSDEViewCtrlDTO)linkDTO).getPSDEViewCtrlName());
        } else {
            dto.setParamPSDEViewCtrlName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEId(((PSDEViewBaseDTO)linkDTO).getPSDEId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewCtrlId())) {
            linkDTO = (PSDEViewCtrlDTO)PSModelServiceUtil.getInstance().getPSDEViewCtrlService().getDTO(dto.getPSDEViewCtrlId());
            dto.setPSDEViewCtrlName(((PSDEViewCtrlDTO)linkDTO).getPSDEViewCtrlName());
        } else {
            dto.setPSDEViewCtrlName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            linkDTO = (PSSysViewLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewLogicService().getDTO(dto.getPSSysViewLogicId());
            dto.setPSSysViewLogicName(((PSSysViewLogicDTO)linkDTO).getPSSysViewLogicName());
        } else {
            dto.setPSSysViewLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEViewLogicId())) {
            linkDTO = (PSDEViewLogicDTO)PSModelServiceUtil.getInstance().getPSDEViewLogicService().getDTO(dto.getRefPSDEViewLogicId());
            dto.setRefPSDEViewLogicName(((PSDEViewLogicDTO)linkDTO).getPSDEViewLogicName());
        } else {
            dto.setRefPSDEViewLogicName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEVIEWLOGIC";
    }

    @Override
    public PSDEViewLogic createDomain() {
        return new PSDEViewLogic();
    }

    @Override
    public PSDEViewLogicDTO createDTO() {
        return new PSDEViewLogicDTO();
    }
}


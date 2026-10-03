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
import net.ibizsys.modelapi.domain.PSDEViewEngine;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDEViewCtrlDTO;
import net.ibizsys.modelapi.dto.PSDEViewEngineDTO;
import net.ibizsys.modelapi.dto.PSDEViewLogicDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEViewEngineService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEViewEngineServiceImpl
extends PSModelServiceImplBase<PSDEViewEngine, PSDEViewEngineDTO>
implements IPSDEViewEngineService {
    private static final Log log = LogFactory.getLog(PSDEViewEngineServiceImpl.class);

    @Override
    public List<PSDEViewEngine> listByPSDEViewBase(PSDEViewBase parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEViewEngine get(PSDEViewBase parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEViewEngine> list = this.listByPSDEViewBase(parent);
        if (list != null) {
            for (PSDEViewEngine item : list) {
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
    public List<PSDEViewEngineDTO> listDTOByPSDEViewBase(String strParentKey) throws Exception {
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey);
        List<PSDEViewEngine> list = this.listByPSDEViewBase(psdeviewbase);
        if (list != null) {
            ArrayList<PSDEViewEngineDTO> dtoList = new ArrayList<PSDEViewEngineDTO>();
            for (PSDEViewEngine item : list) {
                PSDEViewEngineDTO dto = (PSDEViewEngineDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEViewEngine> onListAll() throws Exception {
        ArrayList<PSDEViewEngine> list = new ArrayList<PSDEViewEngine>();
        List<PSDEViewBase> psdeviewbases = PSModelServiceUtil.getInstance().getPSDEViewBaseService().listAll();
        if (psdeviewbases != null) {
            for (PSDEViewBase parent : psdeviewbases) {
                List<PSDEViewEngine> items = this.listByPSDEViewBase(parent);
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
    protected PSDEViewEngine onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEViewEngine item;
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey, true);
        if (psdeviewbase != null && (item = this.get(psdeviewbase, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEViewEngine)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEViewEngineDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEViewBaseId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEViewEngine et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEViewEngineName())) {
            return et.getPSDEViewEngineName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEViewEngineDTO dto, PSDEViewEngine t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEViewEngineId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDEViewCtrlFlag() != null || !bIgnoreNull) {
            dto.setDEViewCtrlFlag(t.getDEViewCtrlFlag());
        }
        if (t.getDEViewCtrlLabel() != null || !bIgnoreNull) {
            dto.setDEViewCtrlLabel(t.getDEViewCtrlLabel());
        }
        if (t.getDEViewLogicFlag() != null || !bIgnoreNull) {
            dto.setDEViewLogicFlag(t.getDEViewLogicFlag());
        }
        if (t.getDEViewLogicLabel() != null || !bIgnoreNull) {
            dto.setDEViewLogicLabel(t.getDEViewLogicLabel());
        }
        if (t.getEngineParam() != null || !bIgnoreNull) {
            dto.setEngineParam(t.getEngineParam());
        }
        if (t.getEngineParam10() != null || !bIgnoreNull) {
            dto.setEngineParam10(t.getEngineParam10());
        }
        if (t.getEngineParam10Flag() != null || !bIgnoreNull) {
            dto.setEngineParam10Flag(t.getEngineParam10Flag());
        }
        if (t.getEngineParam10Label() != null || !bIgnoreNull) {
            dto.setEngineParam10Label(t.getEngineParam10Label());
        }
        if (t.getEngineParam2() != null || !bIgnoreNull) {
            dto.setEngineParam2(t.getEngineParam2());
        }
        if (t.getEngineParam2Flag() != null || !bIgnoreNull) {
            dto.setEngineParam2Flag(t.getEngineParam2Flag());
        }
        if (t.getEngineParam2Label() != null || !bIgnoreNull) {
            dto.setEngineParam2Label(t.getEngineParam2Label());
        }
        if (t.getEngineParam3() != null || !bIgnoreNull) {
            dto.setEngineParam3(t.getEngineParam3());
        }
        if (t.getEngineParam3Flag() != null || !bIgnoreNull) {
            dto.setEngineParam3Flag(t.getEngineParam3Flag());
        }
        if (t.getEngineParam3Label() != null || !bIgnoreNull) {
            dto.setEngineParam3Label(t.getEngineParam3Label());
        }
        if (t.getEngineParam4() != null || !bIgnoreNull) {
            dto.setEngineParam4(t.getEngineParam4());
        }
        if (t.getEngineParam4Flag() != null || !bIgnoreNull) {
            dto.setEngineParam4Flag(t.getEngineParam4Flag());
        }
        if (t.getEngineParam4Label() != null || !bIgnoreNull) {
            dto.setEngineParam4Label(t.getEngineParam4Label());
        }
        if (t.getEngineParam5() != null || !bIgnoreNull) {
            dto.setEngineParam5(t.getEngineParam5());
        }
        if (t.getEngineParam5Flag() != null || !bIgnoreNull) {
            dto.setEngineParam5Flag(t.getEngineParam5Flag());
        }
        if (t.getEngineParam5Label() != null || !bIgnoreNull) {
            dto.setEngineParam5Label(t.getEngineParam5Label());
        }
        if (t.getEngineParam6() != null || !bIgnoreNull) {
            dto.setEngineParam6(t.getEngineParam6());
        }
        if (t.getEngineParam6Flag() != null || !bIgnoreNull) {
            dto.setEngineParam6Flag(t.getEngineParam6Flag());
        }
        if (t.getEngineParam6Label() != null || !bIgnoreNull) {
            dto.setEngineParam6Label(t.getEngineParam6Label());
        }
        if (t.getEngineParam7() != null || !bIgnoreNull) {
            dto.setEngineParam7(t.getEngineParam7());
        }
        if (t.getEngineParam7Flag() != null || !bIgnoreNull) {
            dto.setEngineParam7Flag(t.getEngineParam7Flag());
        }
        if (t.getEngineParam7Label() != null || !bIgnoreNull) {
            dto.setEngineParam7Label(t.getEngineParam7Label());
        }
        if (t.getEngineParam8() != null || !bIgnoreNull) {
            dto.setEngineParam8(t.getEngineParam8());
        }
        if (t.getEngineParam8Flag() != null || !bIgnoreNull) {
            dto.setEngineParam8Flag(t.getEngineParam8Flag());
        }
        if (t.getEngineParam8Label() != null || !bIgnoreNull) {
            dto.setEngineParam8Label(t.getEngineParam8Label());
        }
        if (t.getEngineParam9() != null || !bIgnoreNull) {
            dto.setEngineParam9(t.getEngineParam9());
        }
        if (t.getEngineParam9Flag() != null || !bIgnoreNull) {
            dto.setEngineParam9Flag(t.getEngineParam9Flag());
        }
        if (t.getEngineParam9Label() != null || !bIgnoreNull) {
            dto.setEngineParam9Label(t.getEngineParam9Label());
        }
        if (t.getEngineParamFlag() != null || !bIgnoreNull) {
            dto.setEngineParamFlag(t.getEngineParamFlag());
        }
        if (t.getEngineParamLabel() != null || !bIgnoreNull) {
            dto.setEngineParamLabel(t.getEngineParamLabel());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNo2DEViewCtrlFlag() != null || !bIgnoreNull) {
            dto.setNo2DEViewCtrlFlag(t.getNo2DEViewCtrlFlag());
        }
        if (t.getNo2DEViewCtrlLabel() != null || !bIgnoreNull) {
            dto.setNo2DEViewCtrlLabel(t.getNo2DEViewCtrlLabel());
        }
        if (t.getNo2DEViewLogicFlag() != null || !bIgnoreNull) {
            dto.setNo2DEViewLogicFlag(t.getNo2DEViewLogicFlag());
        }
        if (t.getNo2DEViewLogicLabel() != null || !bIgnoreNull) {
            dto.setNo2DEViewLogicLabel(t.getNo2DEViewLogicLabel());
        }
        if (t.getNo2PSDEViewCtrlId() != null || !bIgnoreNull) {
            dto.setNo2PSDEViewCtrlId(t.getNo2PSDEViewCtrlId());
        }
        if (t.getNo2PSDEViewCtrlName() != null || !bIgnoreNull) {
            dto.setNo2PSDEViewCtrlName(t.getNo2PSDEViewCtrlName());
        }
        if (t.getNo2PSDEViewLogicId() != null || !bIgnoreNull) {
            dto.setNo2PSDEViewLogicId(t.getNo2PSDEViewLogicId());
        }
        if (t.getNo2PSDEViewLogicName() != null || !bIgnoreNull) {
            dto.setNo2PSDEViewLogicName(t.getNo2PSDEViewLogicName());
        }
        if (t.getNo3DEViewCtrlFlag() != null || !bIgnoreNull) {
            dto.setNo3DEViewCtrlFlag(t.getNo3DEViewCtrlFlag());
        }
        if (t.getNo3DEViewCtrlLabel() != null || !bIgnoreNull) {
            dto.setNo3DEViewCtrlLabel(t.getNo3DEViewCtrlLabel());
        }
        if (t.getNo3DEViewLogicFlag() != null || !bIgnoreNull) {
            dto.setNo3DEViewLogicFlag(t.getNo3DEViewLogicFlag());
        }
        if (t.getNo3DEViewLogicLabel() != null || !bIgnoreNull) {
            dto.setNo3DEViewLogicLabel(t.getNo3DEViewLogicLabel());
        }
        if (t.getNo3PSDEViewCtrlId() != null || !bIgnoreNull) {
            dto.setNo3PSDEViewCtrlId(t.getNo3PSDEViewCtrlId());
        }
        if (t.getNo3PSDEViewCtrlName() != null || !bIgnoreNull) {
            dto.setNo3PSDEViewCtrlName(t.getNo3PSDEViewCtrlName());
        }
        if (t.getNo3PSDEViewLogicId() != null || !bIgnoreNull) {
            dto.setNo3PSDEViewLogicId(t.getNo3PSDEViewLogicId());
        }
        if (t.getNo3PSDEViewLogicName() != null || !bIgnoreNull) {
            dto.setNo3PSDEViewLogicName(t.getNo3PSDEViewLogicName());
        }
        if (t.getNo4DEViewCtrlFlag() != null || !bIgnoreNull) {
            dto.setNo4DEViewCtrlFlag(t.getNo4DEViewCtrlFlag());
        }
        if (t.getNo4DEViewCtrlLabel() != null || !bIgnoreNull) {
            dto.setNo4DEViewCtrlLabel(t.getNo4DEViewCtrlLabel());
        }
        if (t.getNo4DEViewLogicFlag() != null || !bIgnoreNull) {
            dto.setNo4DEViewLogicFlag(t.getNo4DEViewLogicFlag());
        }
        if (t.getNo4DEViewLogicLabel() != null || !bIgnoreNull) {
            dto.setNo4DEViewLogicLabel(t.getNo4DEViewLogicLabel());
        }
        if (t.getNo4PSDEViewCtrlId() != null || !bIgnoreNull) {
            dto.setNo4PSDEViewCtrlId(t.getNo4PSDEViewCtrlId());
        }
        if (t.getNo4PSDEViewCtrlName() != null || !bIgnoreNull) {
            dto.setNo4PSDEViewCtrlName(t.getNo4PSDEViewCtrlName());
        }
        if (t.getNo4PSDEViewLogicId() != null || !bIgnoreNull) {
            dto.setNo4PSDEViewLogicId(t.getNo4PSDEViewLogicId());
        }
        if (t.getNo4PSDEViewLogicName() != null || !bIgnoreNull) {
            dto.setNo4PSDEViewLogicName(t.getNo4PSDEViewLogicName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
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
        if (t.getPSDEViewEngineName() != null || !bIgnoreNull) {
            dto.setPSDEViewEngineName(t.getPSDEViewEngineName());
        }
        if (t.getPSDEViewLogicId() != null || !bIgnoreNull) {
            dto.setPSDEViewLogicId(t.getPSDEViewLogicId());
        }
        if (t.getPSDEViewLogicName() != null || !bIgnoreNull) {
            dto.setPSDEViewLogicName(t.getPSDEViewLogicName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSUIEngineTypeId() != null || !bIgnoreNull) {
            dto.setPSUIEngineTypeId(t.getPSUIEngineTypeId());
        }
        if (t.getPSUIEngineTypeName() != null || !bIgnoreNull) {
            dto.setPSUIEngineTypeName(t.getPSUIEngineTypeName());
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
        if (t.getViewParam() != null || !bIgnoreNull) {
            dto.setViewParam(t.getViewParam());
        }
        if (t.getViewParam10() != null || !bIgnoreNull) {
            dto.setViewParam10(t.getViewParam10());
        }
        if (t.getViewParam2() != null || !bIgnoreNull) {
            dto.setViewParam2(t.getViewParam2());
        }
        if (t.getViewParam3() != null || !bIgnoreNull) {
            dto.setViewParam3(t.getViewParam3());
        }
        if (t.getViewParam4() != null || !bIgnoreNull) {
            dto.setViewParam4(t.getViewParam4());
        }
        if (t.getViewParam5() != null || !bIgnoreNull) {
            dto.setViewParam5(t.getViewParam5());
        }
        if (t.getViewParam6() != null || !bIgnoreNull) {
            dto.setViewParam6(t.getViewParam6());
        }
        if (t.getViewParam7() != null || !bIgnoreNull) {
            dto.setViewParam7(t.getViewParam7());
        }
        if (t.getViewParam8() != null || !bIgnoreNull) {
            dto.setViewParam8(t.getViewParam8());
        }
        if (t.getViewParam9() != null || !bIgnoreNull) {
            dto.setViewParam9(t.getViewParam9());
        }
        if (t.getWFViewParam() != null || !bIgnoreNull) {
            dto.setWFViewParam(t.getWFViewParam());
        }
        if (t.getWFViewParam2() != null || !bIgnoreNull) {
            dto.setWFViewParam2(t.getWFViewParam2());
        }
        if (t.getWFViewParam3() != null || !bIgnoreNull) {
            dto.setWFViewParam3(t.getWFViewParam3());
        }
        if (t.getWFViewParam4() != null || !bIgnoreNull) {
            dto.setWFViewParam4(t.getWFViewParam4());
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEViewCtrlId())) {
            dto.setNo2PSDEViewCtrlId(this.getRealPSModelId(t, dto.getNo2PSDEViewCtrlId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEViewLogicId())) {
            dto.setNo2PSDEViewLogicId(this.getRealPSModelId(t, dto.getNo2PSDEViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo3PSDEViewCtrlId())) {
            dto.setNo3PSDEViewCtrlId(this.getRealPSModelId(t, dto.getNo3PSDEViewCtrlId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo3PSDEViewLogicId())) {
            dto.setNo3PSDEViewLogicId(this.getRealPSModelId(t, dto.getNo3PSDEViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo4PSDEViewCtrlId())) {
            dto.setNo4PSDEViewCtrlId(this.getRealPSModelId(t, dto.getNo4PSDEViewCtrlId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo4PSDEViewLogicId())) {
            dto.setNo4PSDEViewLogicId(this.getRealPSModelId(t, dto.getNo4PSDEViewLogicId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEViewLogicId())) {
            dto.setPSDEViewLogicId(this.getRealPSModelId(t, dto.getPSDEViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEViewCtrlId())) {
            linkDTO = (PSDEViewCtrlDTO)PSModelServiceUtil.getInstance().getPSDEViewCtrlService().getDTO(dto.getNo2PSDEViewCtrlId());
            dto.setNo2PSDEViewCtrlName(((PSDEViewCtrlDTO)linkDTO).getPSDEViewCtrlName());
        } else {
            dto.setNo2PSDEViewCtrlName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEViewLogicId())) {
            linkDTO = (PSDEViewLogicDTO)PSModelServiceUtil.getInstance().getPSDEViewLogicService().getDTO(dto.getNo2PSDEViewLogicId());
            dto.setNo2PSDEViewLogicName(((PSDEViewLogicDTO)linkDTO).getPSDEViewLogicName());
        } else {
            dto.setNo2PSDEViewLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo3PSDEViewCtrlId())) {
            linkDTO = (PSDEViewCtrlDTO)PSModelServiceUtil.getInstance().getPSDEViewCtrlService().getDTO(dto.getNo3PSDEViewCtrlId());
            dto.setNo3PSDEViewCtrlName(((PSDEViewCtrlDTO)linkDTO).getPSDEViewCtrlName());
        } else {
            dto.setNo3PSDEViewCtrlName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo3PSDEViewLogicId())) {
            linkDTO = (PSDEViewLogicDTO)PSModelServiceUtil.getInstance().getPSDEViewLogicService().getDTO(dto.getNo3PSDEViewLogicId());
            dto.setNo3PSDEViewLogicName(((PSDEViewLogicDTO)linkDTO).getPSDEViewLogicName());
        } else {
            dto.setNo3PSDEViewLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo4PSDEViewCtrlId())) {
            linkDTO = (PSDEViewCtrlDTO)PSModelServiceUtil.getInstance().getPSDEViewCtrlService().getDTO(dto.getNo4PSDEViewCtrlId());
            dto.setNo4PSDEViewCtrlName(((PSDEViewCtrlDTO)linkDTO).getPSDEViewCtrlName());
        } else {
            dto.setNo4PSDEViewCtrlName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo4PSDEViewLogicId())) {
            linkDTO = (PSDEViewLogicDTO)PSModelServiceUtil.getInstance().getPSDEViewLogicService().getDTO(dto.getNo4PSDEViewLogicId());
            dto.setNo4PSDEViewLogicName(((PSDEViewLogicDTO)linkDTO).getPSDEViewLogicName());
        } else {
            dto.setNo4PSDEViewLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewCtrlId())) {
            linkDTO = (PSDEViewCtrlDTO)PSModelServiceUtil.getInstance().getPSDEViewCtrlService().getDTO(dto.getPSDEViewCtrlId());
            dto.setPSDEViewCtrlName(((PSDEViewCtrlDTO)linkDTO).getPSDEViewCtrlName());
        } else {
            dto.setPSDEViewCtrlName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewLogicId())) {
            linkDTO = (PSDEViewLogicDTO)PSModelServiceUtil.getInstance().getPSDEViewLogicService().getDTO(dto.getPSDEViewLogicId());
            dto.setPSDEViewLogicName(((PSDEViewLogicDTO)linkDTO).getPSDEViewLogicName());
        } else {
            dto.setPSDEViewLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEVIEWENGINE";
    }

    @Override
    public PSDEViewEngine createDomain() {
        return new PSDEViewEngine();
    }

    @Override
    public PSDEViewEngineDTO createDTO() {
        return new PSDEViewEngineDTO();
    }
}


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
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.domain.PSDEMainStateRS;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateRSDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDEMainStateRSService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMainStateRSServiceImpl
extends PSModelServiceImplBase<PSDEMainStateRS, PSDEMainStateRSDTO>
implements IPSDEMainStateRSService {
    private static final Log log = LogFactory.getLog(PSDEMainStateRSServiceImpl.class);

    @Override
    public List<PSDEMainStateRS> listByPSDEMainState(PSDEMainState parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMainStateRS get(PSDEMainState parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMainStateRS> list = this.listByPSDEMainState(parent);
        if (list != null) {
            for (PSDEMainStateRS item : list) {
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
    public List<PSDEMainStateRSDTO> listDTOByPSDEMainState(String strParentKey) throws Exception {
        PSDEMainState psdemainstate = (PSDEMainState)PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strParentKey);
        List<PSDEMainStateRS> list = this.listByPSDEMainState(psdemainstate);
        if (list != null) {
            ArrayList<PSDEMainStateRSDTO> dtoList = new ArrayList<PSDEMainStateRSDTO>();
            for (PSDEMainStateRS item : list) {
                PSDEMainStateRSDTO dto = (PSDEMainStateRSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMainStateRS> onListAll() throws Exception {
        ArrayList<PSDEMainStateRS> list = new ArrayList<PSDEMainStateRS>();
        List psdemainstates = PSModelServiceUtil.getInstance().getPSDEMainStateService().listAll();
        if (psdemainstates != null) {
            for (PSDEMainState parent : psdemainstates) {
                List<PSDEMainStateRS> items = this.listByPSDEMainState(parent);
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
    protected PSDEMainStateRS onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMainStateRS item;
        PSDEMainState psdemainstate = (PSDEMainState)PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strParentKey, true);
        if (psdemainstate != null && (item = this.get(psdemainstate, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMainStateRS)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMainStateRSDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getNextPSDEMSId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMainStateRS et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDEMainStateRSName())) {
            return et.getPSDEMainStateRSName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMainStateRSDTO dto, PSDEMainStateRS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMainStateRSId(t.getId().replace("/", "."));
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
        if (t.getEnterPSDEActionId() != null || !bIgnoreNull) {
            dto.setEnterPSDEActionId(t.getEnterPSDEActionId());
        }
        if (t.getEnterPSDEActionName() != null || !bIgnoreNull) {
            dto.setEnterPSDEActionName(t.getEnterPSDEActionName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNextPSDEMSId() != null || !bIgnoreNull) {
            dto.setNextPSDEMSId(t.getNextPSDEMSId());
        }
        if (t.getNextPSDEMSName() != null || !bIgnoreNull) {
            dto.setNextPSDEMSName(t.getNextPSDEMSName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPrevPSDEMSId() != null || !bIgnoreNull) {
            dto.setPrevPSDEMSId(t.getPrevPSDEMSId());
        }
        if (t.getPrevPSDEMSName() != null || !bIgnoreNull) {
            dto.setPrevPSDEMSName(t.getPrevPSDEMSName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMainStateRSName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateRSName(t.getPSDEMainStateRSName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
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
        if (StringUtils.hasLength((String)dto.getEnterPSDEActionId())) {
            dto.setEnterPSDEActionId(this.getRealPSModelId(t, dto.getEnterPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNextPSDEMSId())) {
            dto.setNextPSDEMSId(this.getRealPSModelId(t, dto.getNextPSDEMSId()).replace("/", "."));
        }
        if ("PSDEMAINSTATE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setNextPSDEMSId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPrevPSDEMSId())) {
            dto.setPrevPSDEMSId(this.getRealPSModelId(t, dto.getPrevPSDEMSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEnterPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getEnterPSDEActionId());
            dto.setEnterPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setEnterPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getNextPSDEMSId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getNextPSDEMSId());
            dto.setNextPSDEMSName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setNextPSDEMSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPrevPSDEMSId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPrevPSDEMSId());
            dto.setPrevPSDEMSName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setPrevPSDEMSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEMAINSTATERS";
    }

    @Override
    public PSDEMainStateRS createDomain() {
        return new PSDEMainStateRS();
    }

    @Override
    public PSDEMainStateRSDTO createDTO() {
        return new PSDEMainStateRSDTO();
    }
}


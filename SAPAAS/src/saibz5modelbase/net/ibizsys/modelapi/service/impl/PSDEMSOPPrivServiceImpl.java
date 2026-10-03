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
import net.ibizsys.modelapi.domain.PSDEMSOPPriv;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.dto.PSDEMSOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.service.IPSDEMSOPPrivService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMSOPPrivServiceImpl
extends PSModelServiceImplBase<PSDEMSOPPriv, PSDEMSOPPrivDTO>
implements IPSDEMSOPPrivService {
    private static final Log log = LogFactory.getLog(PSDEMSOPPrivServiceImpl.class);

    @Override
    public List<PSDEMSOPPriv> listByPSDEMainState(PSDEMainState parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMSOPPriv get(PSDEMainState parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMSOPPriv> list = this.listByPSDEMainState(parent);
        if (list != null) {
            for (PSDEMSOPPriv item : list) {
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
    public List<PSDEMSOPPrivDTO> listDTOByPSDEMainState(String strParentKey) throws Exception {
        PSDEMainState psdemainstate = (PSDEMainState)PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strParentKey);
        List<PSDEMSOPPriv> list = this.listByPSDEMainState(psdemainstate);
        if (list != null) {
            ArrayList<PSDEMSOPPrivDTO> dtoList = new ArrayList<PSDEMSOPPrivDTO>();
            for (PSDEMSOPPriv item : list) {
                PSDEMSOPPrivDTO dto = (PSDEMSOPPrivDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMSOPPriv> onListAll() throws Exception {
        ArrayList<PSDEMSOPPriv> list = new ArrayList<PSDEMSOPPriv>();
        List<PSDEMainState> psdemainstates = PSModelServiceUtil.getInstance().getPSDEMainStateService().listAll();
        if (psdemainstates != null) {
            for (PSDEMainState parent : psdemainstates) {
                List<PSDEMSOPPriv> items = this.listByPSDEMainState(parent);
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
    protected PSDEMSOPPriv onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMSOPPriv item;
        PSDEMainState psdemainstate = (PSDEMainState)PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strParentKey, true);
        if (psdemainstate != null && (item = this.get(psdemainstate, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMSOPPriv)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMSOPPrivDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEMainStateId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMSOPPriv et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMSOPPrivDTO dto, PSDEMSOPPriv t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMSOPPrivId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMainStateId() != null || !bIgnoreNull) {
            dto.setPSDEMainStateId(t.getPSDEMainStateId());
        }
        if (t.getPSDEMainStateName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateName(t.getPSDEMainStateName());
        }
        if (t.getPSDEMSOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEMSOPPrivName(t.getPSDEMSOPPrivName());
        }
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
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
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            dto.setPSDEMainStateId(this.getRealPSModelId(t, dto.getPSDEMainStateId()).replace("/", "."));
        }
        if ("PSDEMAINSTATE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEMainStateId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPSDEMainStateId());
            dto.setPSDEId(((PSDEMainStateDTO)linkDTO).getPSDEId());
            dto.setPSDEMainStateName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEMainStateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEMSOPPRIV";
    }

    @Override
    public PSDEMSOPPriv createDomain() {
        return new PSDEMSOPPriv();
    }

    @Override
    public PSDEMSOPPrivDTO createDTO() {
        return new PSDEMSOPPrivDTO();
    }
}


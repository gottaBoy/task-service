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
import net.ibizsys.modelapi.domain.PSSysDBProc;
import net.ibizsys.modelapi.domain.PSSysDBProcParam;
import net.ibizsys.modelapi.dto.PSSysDBProcDTO;
import net.ibizsys.modelapi.dto.PSSysDBProcParamDTO;
import net.ibizsys.modelapi.service.IPSSysDBProcParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDBProcParamServiceImpl
extends PSModelServiceImplBase<PSSysDBProcParam, PSSysDBProcParamDTO>
implements IPSSysDBProcParamService {
    private static final Log log = LogFactory.getLog(PSSysDBProcParamServiceImpl.class);

    @Override
    public List<PSSysDBProcParam> listByPSSysDBProc(PSSysDBProc parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDBProcParam get(PSSysDBProc parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDBProcParam> list = this.listByPSSysDBProc(parent);
        if (list != null) {
            for (PSSysDBProcParam item : list) {
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
    public List<PSSysDBProcParamDTO> listDTOByPSSysDBProc(String strParentKey) throws Exception {
        PSSysDBProc pssysdbproc = (PSSysDBProc)PSModelServiceUtil.getInstance().getPSSysDBProcService().get(strParentKey);
        List<PSSysDBProcParam> list = this.listByPSSysDBProc(pssysdbproc);
        if (list != null) {
            ArrayList<PSSysDBProcParamDTO> dtoList = new ArrayList<PSSysDBProcParamDTO>();
            for (PSSysDBProcParam item : list) {
                PSSysDBProcParamDTO dto = (PSSysDBProcParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDBProcParam> onListAll() throws Exception {
        ArrayList<PSSysDBProcParam> list = new ArrayList<PSSysDBProcParam>();
        List<PSSysDBProc> pssysdbprocs = PSModelServiceUtil.getInstance().getPSSysDBProcService().listAll();
        if (pssysdbprocs != null) {
            for (PSSysDBProc parent : pssysdbprocs) {
                List<PSSysDBProcParam> items = this.listByPSSysDBProc(parent);
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
    protected PSSysDBProcParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDBProcParam item;
        PSSysDBProc pssysdbproc = (PSSysDBProc)PSModelServiceUtil.getInstance().getPSSysDBProcService().get(strParentKey, true);
        if (pssysdbproc != null && (item = this.get(pssysdbproc, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDBProcParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDBProcParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysDBProcId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysDBProcService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDBProcParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDBProcParamName())) {
            return et.getPSSysDBProcParamName();
        }
        if (StringUtils.hasLength((String)et.getPSSysDBProcParamName())) {
            return et.getPSSysDBProcParamName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDBProcParamDTO dto, PSSysDBProcParam t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDBProcParamId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getLength() != null || !bIgnoreNull) {
            dto.setLength(t.getLength());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamDIR() != null || !bIgnoreNull) {
            dto.setParamDIR(t.getParamDIR());
        }
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPSSysDBProcId() != null || !bIgnoreNull) {
            dto.setPSSysDBProcId(t.getPSSysDBProcId());
        }
        if (t.getPSSysDBProcName() != null || !bIgnoreNull) {
            dto.setPSSysDBProcName(t.getPSSysDBProcName());
        }
        if (t.getPSSysDBProcParamName() != null || !bIgnoreNull) {
            dto.setPSSysDBProcParamName(t.getPSSysDBProcParamName());
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
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBProcId())) {
            dto.setPSSysDBProcId(this.getRealPSModelId(t, dto.getPSSysDBProcId()).replace("/", "."));
        }
        if ("PSSYSDBPROC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysDBProcId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBProcId())) {
            PSSysDBProcDTO linkDTO = (PSSysDBProcDTO)PSModelServiceUtil.getInstance().getPSSysDBProcService().getDTO(dto.getPSSysDBProcId());
            dto.setPSSysDBProcName(linkDTO.getPSSysDBProcName());
        } else {
            dto.setPSSysDBProcName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDBPROCPARAM";
    }

    @Override
    public PSSysDBProcParam createDomain() {
        return new PSSysDBProcParam();
    }

    @Override
    public PSSysDBProcParamDTO createDTO() {
        return new PSSysDBProcParamDTO();
    }
}


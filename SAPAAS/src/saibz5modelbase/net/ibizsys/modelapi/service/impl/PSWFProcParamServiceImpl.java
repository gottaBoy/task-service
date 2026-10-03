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
import net.ibizsys.modelapi.domain.PSWFProcParam;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSWFProcParamDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.service.IPSWFProcParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFProcParamServiceImpl
extends PSModelServiceImplBase<PSWFProcParam, PSWFProcParamDTO>
implements IPSWFProcParamService {
    private static final Log log = LogFactory.getLog(PSWFProcParamServiceImpl.class);

    @Override
    public List<PSWFProcParam> listByPSWFProcess(PSWFProcess parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFProcParam get(PSWFProcess parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFProcParam> list = this.listByPSWFProcess(parent);
        if (list != null) {
            for (PSWFProcParam item : list) {
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
    public List<PSWFProcParamDTO> listDTOByPSWFProcess(String strParentKey) throws Exception {
        PSWFProcess pswfprocess = (PSWFProcess)PSModelServiceUtil.getInstance().getPSWFProcessService().get(strParentKey);
        List<PSWFProcParam> list = this.listByPSWFProcess(pswfprocess);
        if (list != null) {
            ArrayList<PSWFProcParamDTO> dtoList = new ArrayList<PSWFProcParamDTO>();
            for (PSWFProcParam item : list) {
                PSWFProcParamDTO dto = (PSWFProcParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFProcParam> onListAll() throws Exception {
        ArrayList<PSWFProcParam> list = new ArrayList<PSWFProcParam>();
        List<PSWFProcess> pswfprocesses = PSModelServiceUtil.getInstance().getPSWFProcessService().listAll();
        if (pswfprocesses != null) {
            for (PSWFProcess parent : pswfprocesses) {
                List<PSWFProcParam> items = this.listByPSWFProcess(parent);
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
    protected PSWFProcParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFProcParam item;
        PSWFProcess pswfprocess = (PSWFProcess)PSModelServiceUtil.getInstance().getPSWFProcessService().get(strParentKey, true);
        if (pswfprocess != null && (item = this.get(pswfprocess, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFProcParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFProcParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFProcessId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFProcessService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFProcParam et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFProcParamDTO dto, PSWFProcParam t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFProcParamId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomDstDEFName() != null || !bIgnoreNull) {
            dto.setCustomDstDEFName(t.getCustomDstDEFName());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSWFProcessId() != null || !bIgnoreNull) {
            dto.setPSWFProcessId(t.getPSWFProcessId());
        }
        if (t.getPSWFProcessName() != null || !bIgnoreNull) {
            dto.setPSWFProcessName(t.getPSWFProcessName());
        }
        if (t.getPSWFProcParamName() != null || !bIgnoreNull) {
            dto.setPSWFProcParamName(t.getPSWFProcParamName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getSrcValue() != null || !bIgnoreNull) {
            dto.setSrcValue(t.getSrcValue());
        }
        if (t.getSrcValueType() != null || !bIgnoreNull) {
            dto.setSrcValueType(t.getSrcValueType());
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
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
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
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            dto.setPSWFProcessId(this.getRealPSModelId(t, dto.getPSWFProcessId()).replace("/", "."));
        }
        if ("PSWFPROCESS".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFProcessId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            linkDTO = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().getDTO(dto.getPSWFProcessId());
            dto.setPSDEId(((PSWFProcessDTO)linkDTO).getPSDEId());
            dto.setPSWFProcessName(((PSWFProcessDTO)linkDTO).getPSWFProcessName());
            dto.setPSWFVersionId(((PSWFProcessDTO)linkDTO).getPSWFVersionId());
        } else {
            dto.setPSDEId(null);
            dto.setPSWFProcessName(null);
            dto.setPSWFVersionId(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWFPROCPARAM";
    }

    @Override
    public PSWFProcParam createDomain() {
        return new PSWFProcParam();
    }

    @Override
    public PSWFProcParamDTO createDTO() {
        return new PSWFProcParamDTO();
    }
}


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
import net.ibizsys.modelapi.domain.PSWFProcSubWF;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSWFDEDTO;
import net.ibizsys.modelapi.dto.PSWFProcSubWFDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSWFProcSubWFService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFProcSubWFServiceImpl
extends PSModelServiceImplBase<PSWFProcSubWF, PSWFProcSubWFDTO>
implements IPSWFProcSubWFService {
    private static final Log log = LogFactory.getLog(PSWFProcSubWFServiceImpl.class);

    @Override
    public List<PSWFProcSubWF> listByPSWFProcess(PSWFProcess parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFProcSubWF get(PSWFProcess parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFProcSubWF> list = this.listByPSWFProcess(parent);
        if (list != null) {
            for (PSWFProcSubWF item : list) {
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
    public List<PSWFProcSubWFDTO> listDTOByPSWFProcess(String strParentKey) throws Exception {
        PSWFProcess pswfprocess = (PSWFProcess)PSModelServiceUtil.getInstance().getPSWFProcessService().get(strParentKey);
        List<PSWFProcSubWF> list = this.listByPSWFProcess(pswfprocess);
        if (list != null) {
            ArrayList<PSWFProcSubWFDTO> dtoList = new ArrayList<PSWFProcSubWFDTO>();
            for (PSWFProcSubWF item : list) {
                PSWFProcSubWFDTO dto = (PSWFProcSubWFDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFProcSubWF> onListAll() throws Exception {
        ArrayList<PSWFProcSubWF> list = new ArrayList<PSWFProcSubWF>();
        List pswfprocesses = PSModelServiceUtil.getInstance().getPSWFProcessService().listAll();
        if (pswfprocesses != null) {
            for (PSWFProcess parent : pswfprocesses) {
                List<PSWFProcSubWF> items = this.listByPSWFProcess(parent);
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
    protected PSWFProcSubWF onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFProcSubWF item;
        PSWFProcess pswfprocess = (PSWFProcess)PSModelServiceUtil.getInstance().getPSWFProcessService().get(strParentKey, true);
        if (pswfprocess != null && (item = this.get(pswfprocess, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFProcSubWF)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFProcSubWFDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFProcessId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFProcessService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFProcSubWF et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFProcSubWFDTO dto, PSWFProcSubWF t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFProcSubWFId(t.getId().replace("/", "."));
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEmbedPSDEDSId() != null || !bIgnoreNull) {
            dto.setEmbedPSDEDSId(t.getEmbedPSDEDSId());
        }
        if (t.getEmbedPSDEDSName() != null || !bIgnoreNull) {
            dto.setEmbedPSDEDSName(t.getEmbedPSDEDSName());
        }
        if (t.getEmbedPSDEId() != null || !bIgnoreNull) {
            dto.setEmbedPSDEId(t.getEmbedPSDEId());
        }
        if (t.getEmbedPSWFDEId() != null || !bIgnoreNull) {
            dto.setEmbedPSWFDEId(t.getEmbedPSWFDEId());
        }
        if (t.getEmbedPSWFDEName() != null || !bIgnoreNull) {
            dto.setEmbedPSWFDEName(t.getEmbedPSWFDEName());
        }
        if (t.getEmbedPSWFId() != null || !bIgnoreNull) {
            dto.setEmbedPSWFId(t.getEmbedPSWFId());
        }
        if (t.getEmbedPSWFName() != null || !bIgnoreNull) {
            dto.setEmbedPSWFName(t.getEmbedPSWFName());
        }
        if (t.getEmbedPSWFVerId() != null || !bIgnoreNull) {
            dto.setEmbedPSWFVerId(t.getEmbedPSWFVerId());
        }
        if (t.getEmbedPSWFVerName() != null || !bIgnoreNull) {
            dto.setEmbedPSWFVerName(t.getEmbedPSWFVerName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFProcessId() != null || !bIgnoreNull) {
            dto.setPSWFProcessId(t.getPSWFProcessId());
        }
        if (t.getPSWFProcessName() != null || !bIgnoreNull) {
            dto.setPSWFProcessName(t.getPSWFProcessName());
        }
        if (t.getPSWFProcSubWFName() != null || !bIgnoreNull) {
            dto.setPSWFProcSubWFName(t.getPSWFProcSubWFName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getSuspendDefault() != null || !bIgnoreNull) {
            dto.setSuspendDefault(t.getSuspendDefault());
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
        if (StringUtils.hasLength((String)dto.getEmbedPSDEDSId())) {
            dto.setEmbedPSDEDSId(this.getRealPSModelId(t, dto.getEmbedPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFDEId())) {
            dto.setEmbedPSWFDEId(this.getRealPSModelId(t, dto.getEmbedPSWFDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFId())) {
            dto.setEmbedPSWFId(this.getRealPSModelId(t, dto.getEmbedPSWFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFVerId())) {
            dto.setEmbedPSWFVerId(this.getRealPSModelId(t, dto.getEmbedPSWFVerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            dto.setPSWFProcessId(this.getRealPSModelId(t, dto.getPSWFProcessId()).replace("/", "."));
        }
        if ("PSWFPROCESS".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFProcessId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getEmbedPSDEDSId());
            dto.setEmbedPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setEmbedPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFDEId())) {
            linkDTO = (PSWFDEDTO)PSModelServiceUtil.getInstance().getPSWFDEService().getDTO(dto.getEmbedPSWFDEId());
            dto.setEmbedPSDEId(((PSWFDEDTO)linkDTO).getPSDEId());
            dto.setEmbedPSWFDEName(((PSWFDEDTO)linkDTO).getPSWFDEName());
        } else {
            dto.setEmbedPSDEId(null);
            dto.setEmbedPSWFDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getEmbedPSWFId());
            dto.setEmbedPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setEmbedPSWFName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFVerId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getEmbedPSWFVerId());
            dto.setEmbedPSWFVerName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setEmbedPSWFVerName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            linkDTO = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().getDTO(dto.getPSWFProcessId());
            dto.setPSSystemId(((PSWFProcessDTO)linkDTO).getPSSystemId());
            dto.setPSWFId(((PSWFProcessDTO)linkDTO).getPSWFId());
            dto.setPSWFProcessName(((PSWFProcessDTO)linkDTO).getPSWFProcessName());
            dto.setPSWFVersionId(((PSWFProcessDTO)linkDTO).getPSWFVersionId());
        } else {
            dto.setPSSystemId(null);
            dto.setPSWFId(null);
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
        return "PSWFPROCSUBWF";
    }

    @Override
    public PSWFProcSubWF createDomain() {
        return new PSWFProcSubWF();
    }

    @Override
    public PSWFProcSubWFDTO createDTO() {
        return new PSWFProcSubWFDTO();
    }
}


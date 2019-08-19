package com.td.tderp.pojo;

import java.io.Serializable;
import java.util.Date;

public class Sampling implements Serializable {
    private String id;

    private String sampleCode;

    private String linkId;

    private String sender;

    private String type;

    private String cargoname;

    private String carnum;

    private String departmentId;

    private Boolean state;

    private Boolean mergeState;

    private String mergeCode;

    private Integer mergeRule;

    private String createId;

    private Date createTime;

    private String depatmentCode;

    private String ruleMergeId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode == null ? null : sampleCode.trim();
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId == null ? null : linkId.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCargoname() {
        return cargoname;
    }

    public void setCargoname(String cargoname) {
        this.cargoname = cargoname == null ? null : cargoname.trim();
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum == null ? null : carnum.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getMergeState() {
        return mergeState;
    }

    public void setMergeState(Boolean mergeState) {
        this.mergeState = mergeState;
    }

    public String getMergeCode() {
        return mergeCode;
    }

    public void setMergeCode(String mergeCode) {
        this.mergeCode = mergeCode == null ? null : mergeCode.trim();
    }

    public Integer getMergeRule() {
        return mergeRule;
    }

    public void setMergeRule(Integer mergeRule) {
        this.mergeRule = mergeRule;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDepatmentCode() {
        return depatmentCode;
    }

    public void setDepatmentCode(String depatmentCode) {
        this.depatmentCode = depatmentCode == null ? null : depatmentCode.trim();
    }

    public String getRuleMergeId() {
        return ruleMergeId;
    }

    public void setRuleMergeId(String ruleMergeId) {
        this.ruleMergeId = ruleMergeId == null ? null : ruleMergeId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sampleCode=").append(sampleCode);
        sb.append(", linkId=").append(linkId);
        sb.append(", sender=").append(sender);
        sb.append(", type=").append(type);
        sb.append(", cargoname=").append(cargoname);
        sb.append(", carnum=").append(carnum);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", state=").append(state);
        sb.append(", mergeState=").append(mergeState);
        sb.append(", mergeCode=").append(mergeCode);
        sb.append(", mergeRule=").append(mergeRule);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", depatmentCode=").append(depatmentCode);
        sb.append(", ruleMergeId=").append(ruleMergeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
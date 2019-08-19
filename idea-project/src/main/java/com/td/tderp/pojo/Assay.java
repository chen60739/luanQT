package com.td.tderp.pojo;

import java.io.Serializable;
import java.util.Date;

public class Assay implements Serializable {
    private String id;

    private String margeCode;

    private String sender;

    private String type;

    private String depatmentCode;

    private String sampleCodes;

    private String margeCarnums;

    private Integer state;

    private String templateId;

    private String templateName;

    private Date createTime;

    private String createId;

    private Date addTime;

    private Date addId;

    private String confirmId;

    private Date confirmTime;

    private String note;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMargeCode() {
        return margeCode;
    }

    public void setMargeCode(String margeCode) {
        this.margeCode = margeCode == null ? null : margeCode.trim();
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

    public String getDepatmentCode() {
        return depatmentCode;
    }

    public void setDepatmentCode(String depatmentCode) {
        this.depatmentCode = depatmentCode == null ? null : depatmentCode.trim();
    }

    public String getSampleCodes() {
        return sampleCodes;
    }

    public void setSampleCodes(String sampleCodes) {
        this.sampleCodes = sampleCodes == null ? null : sampleCodes.trim();
    }

    public String getMargeCarnums() {
        return margeCarnums;
    }

    public void setMargeCarnums(String margeCarnums) {
        this.margeCarnums = margeCarnums == null ? null : margeCarnums.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getAddId() {
        return addId;
    }

    public void setAddId(Date addId) {
        this.addId = addId;
    }

    public String getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(String confirmId) {
        this.confirmId = confirmId == null ? null : confirmId.trim();
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", margeCode=").append(margeCode);
        sb.append(", sender=").append(sender);
        sb.append(", type=").append(type);
        sb.append(", depatmentCode=").append(depatmentCode);
        sb.append(", sampleCodes=").append(sampleCodes);
        sb.append(", margeCarnums=").append(margeCarnums);
        sb.append(", state=").append(state);
        sb.append(", templateId=").append(templateId);
        sb.append(", templateName=").append(templateName);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", addTime=").append(addTime);
        sb.append(", addId=").append(addId);
        sb.append(", confirmId=").append(confirmId);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
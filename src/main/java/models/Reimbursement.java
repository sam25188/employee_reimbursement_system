package models;

import java.sql.Timestamp;

public class Reimbursement {
    private Integer id;
    private Integer amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private Integer userId;
    private Integer resolverId;
    private Integer statusId;
    private Integer typeId;

    public Reimbursement() {
    }


    public Reimbursement(Integer id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Reimbursement(Integer amount, Timestamp submitted, Integer userId, Integer typeId) {
        this.amount = amount;
        this.submitted = submitted;
        this.userId = userId;
        this.typeId = typeId;
    }

    public Reimbursement(Integer amount, Integer userId, Integer typeId) {
        this.amount = amount;
        this.userId = userId;
        this.typeId = typeId;
    }

    public Reimbursement(Integer id, Integer amount, Timestamp submitted, Timestamp resolved, String description, Integer userId, Integer resolverId, Integer statusId, Integer typeId) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.userId = userId;
        this.resolverId = resolverId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Integer getResolverId() {
        return resolverId;
    }

    public void setResolverId(Integer resolverId) {
        this.resolverId = resolverId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "\n" + "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", resolverId=" + resolverId +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                '}';
    }
}


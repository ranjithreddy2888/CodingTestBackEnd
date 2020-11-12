package com.project.backend.entity;

import com.project.backend.constants.ProductArea;

import javax.persistence.*;
import java.util.Date;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"clientId", "clientPriority"}, name = "UNIQUE_CLIENT_PRIORITY"))
@Entity()
public class FeatureRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer clientId;
    private Integer clientPriority;
    private String title;
    private String description;
    private Date targetDate;
    private ProductArea productArea;

    public FeatureRequest() {
    }

    public FeatureRequest(Integer id, Integer clientId, String title, String description, Integer clientPriority, Date targetDate, ProductArea productArea) {
        this.id = id;
        this.clientId = clientId;
        this.title = title;
        this.description = description;
        this.clientPriority = clientPriority;
        this.targetDate = targetDate;
        this.productArea = productArea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getClientPriority() {
        return clientPriority;
    }

    public void setClientPriority(Integer clientPriority) {
        this.clientPriority = clientPriority;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public ProductArea getProductArea() {
        return productArea;
    }

    public void setProductArea(ProductArea productArea) {
        this.productArea = productArea;
    }
}

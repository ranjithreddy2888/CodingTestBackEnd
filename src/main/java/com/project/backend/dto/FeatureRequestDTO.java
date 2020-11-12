package com.project.backend.dto;

import com.project.backend.constants.ProductArea;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class FeatureRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "Invalid client id")
    private Integer clientId;
    @Length(min = 5, max = 50, message = "Title size should be between 5 to 50.")
    private String title;
    @Length(min = 5, max = 500, message = "Description size should be between 5 to 500.")
    private String description;
    @NotNull(message = "Invalid client priority")
    private Integer clientPriority;
    @NotNull(message = "Invalid target data")
    private Date targetDate;
    @NotNull(message = "Invalid product area")
    private ProductArea productArea;

    public FeatureRequestDTO() {
    }

    public FeatureRequestDTO(Integer id, Integer clientId, String title, String description, Integer clientPriority, Date targetDate, ProductArea productArea) {
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

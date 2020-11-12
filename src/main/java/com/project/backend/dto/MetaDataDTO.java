package com.project.backend.dto;

import com.project.backend.constants.ProductArea;

import java.io.Serializable;
import java.util.ArrayList;

public class MetaDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<ClientDTO> clients;
    private ArrayList<ProductArea> productAreas;

    public MetaDataDTO() {
    }

    public MetaDataDTO(ArrayList<ClientDTO> clients, ArrayList<ProductArea> productAreas) {
        this.clients = clients;
        this.productAreas = productAreas;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ArrayList<ClientDTO> getClients() {
        return clients;
    }

    public void setClients(ArrayList<ClientDTO> clients) {
        this.clients = clients;
    }

    public ArrayList<ProductArea> getProductAreas() {
        return productAreas;
    }

    public void setProductAreas(ArrayList<ProductArea> productAreas) {
        this.productAreas = productAreas;
    }
}

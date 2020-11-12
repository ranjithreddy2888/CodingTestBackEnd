package com.project.backend.controllers;

import com.project.backend.constants.ProductArea;
import com.project.backend.dto.ClientDTO;
import com.project.backend.dto.FeatureRequestDTO;
import com.project.backend.dto.MetaDataDTO;
import com.project.backend.dto.ResponseDTO;
import com.project.backend.entity.FeatureRequest;
import com.project.backend.repository.FeatureRequestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Objects;

@RestController
public class Controller {

    @Autowired
    private FeatureRequestRepository featureRequestRepository;

    @Autowired
    private MessageSource messageSource;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveFeatureRequest")
    public ResponseDTO saveFeatureRequest(@Valid @RequestBody FeatureRequestDTO featureRequestDTO, BindingResult bindingResult) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (bindingResult.hasErrors()) {
            responseDTO.setError(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return responseDTO;
        }
        FeatureRequest featureRequestDB = new FeatureRequest();
        if (featureRequestDTO.getId() != null) {
            featureRequestDB = this.featureRequestRepository.getOne(featureRequestDTO.getId());
        }
        BeanUtils.copyProperties(featureRequestDTO, featureRequestDB);
        try {
            this.featureRequestRepository.save(featureRequestDB);
        } catch (Exception e) {
            if (e.getMessage().contains("UNIQUE_CLIENT_PRIORITY")) {
                responseDTO.setError("Feature request priority " + featureRequestDTO.getClientPriority() + " for client already exist.");
                return responseDTO;
            }
            e.printStackTrace();
        }
        BeanUtils.copyProperties(featureRequestDB, featureRequestDTO);
        responseDTO.setMessage("Data Saved Successfully");
        responseDTO.setData(featureRequestDTO);
        return responseDTO;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getFeatureRequest/{clientId}")
    public ResponseDTO getFeatureRequest(@PathVariable("clientId") @NotNull Integer clientId) {
        ResponseDTO responseDTO = new ResponseDTO();
        ArrayList<FeatureRequestDTO> featureRequestDTOS = new ArrayList<>();
        this.featureRequestRepository.findByClientId(clientId).forEach(featureRequest -> {
            FeatureRequestDTO featureRequestDTO = new FeatureRequestDTO();
            BeanUtils.copyProperties(featureRequest, featureRequestDTO);
            featureRequestDTOS.add(featureRequestDTO);
        });
        responseDTO.setData(featureRequestDTOS);
        return responseDTO;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getMetaData")
    public ResponseDTO getMetaDat() {
        ResponseDTO responseDTO = new ResponseDTO();
        ArrayList<ClientDTO> clients = new ArrayList<>();
        clients.add(new ClientDTO(1, "ClientA"));
        clients.add(new ClientDTO(2, "ClientB"));
        clients.add(new ClientDTO(3, "ClientC"));
        ArrayList<ProductArea> productAreas = new ArrayList<>();
        productAreas.add(ProductArea.Billing);
        productAreas.add(ProductArea.Claims);
        productAreas.add(ProductArea.Policies);
        productAreas.add(ProductArea.Reports);
        MetaDataDTO metaDataDTO = new MetaDataDTO();
        metaDataDTO.setClients(clients);
        metaDataDTO.setProductAreas(productAreas);
        responseDTO.setData(metaDataDTO);
        return responseDTO;
    }
}

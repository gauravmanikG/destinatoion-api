package com.destination.api.service;

import com.destination.api.dto.DestinationRequest;
import com.destination.api.dto.DestinationResponse;

import java.util.List;

public interface DestinationService {

    List<DestinationResponse> getAllDestinations();

    DestinationResponse getDestinationById(Long id);

    DestinationResponse createDestination(DestinationRequest request);

    DestinationResponse updateDestination(Long id, DestinationRequest request);

    void deleteDestination(Long id);
}

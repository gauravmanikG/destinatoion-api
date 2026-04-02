package com.destination.api.service;

import com.destination.api.dto.DestinationRequest;
import com.destination.api.dto.DestinationResponse;
import com.destination.api.entity.Destination;
import com.destination.api.exception.ResourceNotFoundException;
import com.destination.api.repository.DestinationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;
    private final ObjectMapper objectMapper;

    public DestinationServiceImpl(DestinationRepository destinationRepository, ObjectMapper objectMapper) {
        this.destinationRepository = destinationRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<DestinationResponse> getAllDestinations() {
        return destinationRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DestinationResponse getDestinationById(Long id) {
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination", id));
        return mapToResponse(destination);
    }

    @Override
    @Transactional
    public DestinationResponse createDestination(DestinationRequest request) {
        Destination destination = mapToEntity(request);
        Destination saved = destinationRepository.save(destination);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public DestinationResponse updateDestination(Long id, DestinationRequest request) {
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination", id));

        destination.setName(request.getName());
        destination.setType(request.getType());
        destination.setUrl(request.getUrl());
        destination.setMethod(request.getMethod());
        destination.setHeaders(convertMapToJson(request.getHeaders()));
        destination.setRetryCount(request.getRetryCount());

        Destination updated = destinationRepository.save(destination);
        return mapToResponse(updated);
    }

    @Override
    @Transactional
    public void deleteDestination(Long id) {
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination", id));
        destinationRepository.delete(destination);
    }

    private DestinationResponse mapToResponse(Destination destination) {
        return DestinationResponse.builder()
                .id(destination.getId())
                .name(destination.getName())
                .type(destination.getType())
                .url(destination.getUrl())
                .method(destination.getMethod())
                .headers(convertJsonToMap(destination.getHeaders()))
                .retryCount(destination.getRetryCount())
                .createdAt(destination.getCreatedAt())
                .updatedAt(destination.getUpdatedAt())
                .build();
    }

    private Destination mapToEntity(DestinationRequest request) {
        return Destination.builder()
                .name(request.getName())
                .type(request.getType())
                .url(request.getUrl())
                .method(request.getMethod())
                .headers(convertMapToJson(request.getHeaders()))
                .retryCount(request.getRetryCount())
                .build();
    }

    private String convertMapToJson(Map<String, String> map) {
        if (map == null || map.isEmpty()) return null;
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert headers to JSON", e);
        }
    }

    private Map<String, String> convertJsonToMap(String json) {
        if (json == null || json.isBlank()) return Collections.emptyMap();
        try {
            return objectMapper.readValue(json, new TypeReference<Map<String, String>>() {});
        } catch (JsonProcessingException e) {
            return Collections.emptyMap();
        }
    }
}

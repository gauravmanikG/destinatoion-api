package com.destination.api.controller;

import com.destination.api.dto.ApiResponse;
import com.destination.api.dto.DestinationRequest;
import com.destination.api.dto.DestinationResponse;
import com.destination.api.service.DestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
@CrossOrigin(origins = "*")
@Tag(name = "Destinations", description = "CRUD operations for destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    @Operation(summary = "Get all destinations", description = "Retrieves a list of all configured destinations")
    public ResponseEntity<ApiResponse<List<DestinationResponse>>> getAllDestinations() {
        List<DestinationResponse> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(ApiResponse.success("Destinations retrieved successfully", destinations));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get destination by ID", description = "Retrieves a single destination by its ID")
    public ResponseEntity<ApiResponse<DestinationResponse>> getDestinationById(@PathVariable Long id) {
        DestinationResponse destination = destinationService.getDestinationById(id);
        return ResponseEntity.ok(ApiResponse.success("Destination retrieved successfully", destination));
    }

    @PostMapping
    @Operation(summary = "Create a new destination", description = "Creates a new destination with the provided details")
    public ResponseEntity<ApiResponse<DestinationResponse>> createDestination(
            @Valid @RequestBody DestinationRequest request) {
        DestinationResponse created = destinationService.createDestination(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Destination created successfully", created));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a destination", description = "Updates an existing destination by its ID")
    public ResponseEntity<ApiResponse<DestinationResponse>> updateDestination(
            @PathVariable Long id,
            @Valid @RequestBody DestinationRequest request) {
        DestinationResponse updated = destinationService.updateDestination(id, request);
        return ResponseEntity.ok(ApiResponse.success("Destination updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a destination", description = "Deletes a destination by its ID")
    public ResponseEntity<ApiResponse<Void>> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.ok(ApiResponse.success("Destination deleted successfully"));
    }
}

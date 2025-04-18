package aide.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aide.service.entity.Aide;
import aide.service.service.AideServiceService;

import java.util.List;

@RestController
@RequestMapping("/aide_service/aides")
public class AideServiceController {

	private final AideServiceService aideService;

	// Constructor-based Dependency Injection
	public AideServiceController(AideServiceService aideService) {
		this.aideService = aideService;
	}

	@GetMapping
	public ResponseEntity<List<Aide>> getAllAides() {
		List<Aide> aides = aideService.getAllAides();
		return ResponseEntity.ok(aides);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aide> getAideById(@PathVariable Long id) {
		Aide aide = aideService.getAideById(id);
		return (aide != null) ? ResponseEntity.ok(aide) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Aide> createAide(@RequestBody Aide aide) {
		Aide createdAide = aideService.createAide(aide);
		return ResponseEntity.status(201).body(createdAide); // HTTP 201 Created
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aide> updateAide(@PathVariable Long id, @RequestBody Aide aideDetails) {
		Aide updatedAide = aideService.updateAide(id, aideDetails);
		return (updatedAide != null) ? ResponseEntity.ok(updatedAide) : ResponseEntity.notFound().build();
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAide(@PathVariable Long id) {
	    aideService.deleteAide(id);
	    return ResponseEntity.noContent().build();  // HTTP 204 No Content
	}
}

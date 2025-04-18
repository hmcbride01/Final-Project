package aide.service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor // Ensures a default constructor is available for JPA
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String serviceName;

	@ManyToMany(mappedBy = "services")
	private Set<Aide> aides = new HashSet<>();

	@OneToMany(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Request> requests = new HashSet<>();

	// Constructor to ensure fields are properly initialized
	public Service(String serviceName) {
		this.serviceName = serviceName;
		this.aides = new HashSet<>();
		this.requests = new HashSet<>();
	}
}

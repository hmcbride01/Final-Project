package aide.service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aide")
@Getter
@Setter
@NoArgsConstructor // Ensures a default constructor is available
public class Aide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "aide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Request> requests = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "aide_service", joinColumns = @JoinColumn(name = "aide_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"))
	private Set<Service> services = new HashSet<>();

	// Constructor to ensure fields are never null
	public Aide(String name) {
		this.name = name;
		this.requests = new HashSet<>();
		this.services = new HashSet<>();
	}
}

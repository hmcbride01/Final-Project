
package aide.service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "request")
@Getter
@Setter
@NoArgsConstructor
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime requestDate;

	@ManyToOne
	@JoinColumn(name = "aide_id", nullable = false)
	@JsonIgnore
	private Aide aide;

	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private Service service;

	// Constructor to ensure fields are properly initialized
	public Request(LocalDateTime requestDate, Aide aide, Service service) {
		this.requestDate = requestDate != null ? requestDate : LocalDateTime.now(); // Default to now if null
		this.aide = aide;
		this.service = service;
	}
}

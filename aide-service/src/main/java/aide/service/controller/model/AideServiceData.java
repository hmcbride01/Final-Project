package aide.service.controller.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import aide.service.entity.Aide;
import aide.service.entity.Request;
import aide.service.entity.Service;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
public class AideServiceData {
	private Long aideId;
	private String aideName;
	private Set<AideService> services = new HashSet<>();
	private Set<AideRequest> requests = new HashSet<>();

	public AideServiceData(Aide aide) {
		this.aideId = aide.getId();
		this.aideName = aide.getName();

		Set<Service> aideServices = aide.getServices() != null ? aide.getServices() : Collections.emptySet();
		Set<Request> aideRequests = aide.getRequests() != null ? aide.getRequests() : Collections.emptySet();

		for (Service service : aideServices) {
			this.services.add(new AideService(service));
		}

		for (Request request : aideRequests) {
			this.requests.add(new AideRequest(request));
		}
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class AideService {
		private Long serviceId;
		private String name;

		public AideService(Service service) {
			this.serviceId = service.getId();
			this.name = service.getServiceName();
		}
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class AideRequest {
		private Long requestId;
		private String requestDate;

		public AideRequest(Request request) {
			this.requestId = request.getId();
			this.requestDate = (request.getRequestDate() != null) ? request.getRequestDate().toString() : null;
		}
	}
}

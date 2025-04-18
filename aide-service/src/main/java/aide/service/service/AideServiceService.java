package aide.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aide.service.Dao.AideDao;
import aide.service.Dao.RequestDao;
import aide.service.entity.Aide;
import aide.service.entity.Request;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // Enables logging for better debugging
public class AideServiceService {

	@Autowired
	private AideDao aideDao;

	@Autowired
	private RequestDao requestDao;

	// CRUD operations for Aide
	public List<Aide> getAllAides() {
		log.info("Fetching all aides");
		return aideDao.findAll();
	}

	public Aide getAideById(Long id) {
		log.info("Fetching aide by ID: {}", id);
		return aideDao.findById(id).orElse(null);
	}

	public Aide createAide(Aide aide) {
		log.info("Creating new aide: {}", aide.getName());
		return aideDao.save(aide);
	}

	public Aide updateAide(Long id, Aide aideDetails) {
		log.info("Updating aide with ID: {}", id);
		Aide aide = aideDao.findById(id).orElse(null);
		if (aide != null) {
			aide.setName(aideDetails.getName());
			return aideDao.save(aide);
		}
		return null;
	}

	public void deleteAide(Long id) {
		log.info("Deleting aide with ID: {}", id);
		aideDao.deleteById(id);
	}

	// CRUD operations for Request
	public List<Request> getAllRequests() {
		log.info("Fetching all requests");
		return requestDao.findAll();
	}

	public Request getRequestById(Long id) {
		log.info("Fetching request by ID: {}", id);
		return requestDao.findById(id).orElse(null);
	}

	public Request createRequest(Request request) {
		log.info("Creating new request");
		return requestDao.save(request);
	}

	public Request updateRequest(Long id, Request requestDetails) {
		log.info("Updating request with ID: {}", id);
		Request request = requestDao.findById(id).orElse(null);
		if (request != null) {
			request.setRequestDate(requestDetails.getRequestDate());
			request.setAide(requestDetails.getAide());
			request.setService(requestDetails.getService());
			return requestDao.save(request);
		}
		return null;
	}

	public void deleteRequest(Long id) {
		log.info("Deleting request with ID: {}", id);
		requestDao.deleteById(id);
	}
}

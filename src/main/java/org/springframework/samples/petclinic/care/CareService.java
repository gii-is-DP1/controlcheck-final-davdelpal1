package org.springframework.samples.petclinic.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.feeding.UnfeasibleFeedingException;
import org.springframework.stereotype.Service;

@Service
public class CareService {    

	private CareProvisionRepository careProvisionRepository;
	
	@Autowired
	public CareService(CareProvisionRepository careProvisionRepository) {
		this.careProvisionRepository = careProvisionRepository;
	}
	
    public List<Care> getAllCares(){
        return this.careProvisionRepository.findAllCares();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        return this.careProvisionRepository.findCompatibleCares(petTypeName);
    }

    public Care getCare(String careName) {
        return this.careProvisionRepository.findCareByName(careName);
    }

    
    public CareProvision save(CareProvision careProvision) throws NonCompatibleCaresException {
    	if(careProvision.getPet().getType().getName().equals(feeding.getFeedingType().getName())) {
        	this.careProvisionRepository.save(careProvision);
        }else {
            throw new NonCompatibleCaresException();
        }      
    }

    public List<CareProvision> getAllCaresProvided(){
        return this.careProvisionRepository.findAll();
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return this.careProvisionRepository.findCaresProvidedByVisitId(visitId);

    }
    
}

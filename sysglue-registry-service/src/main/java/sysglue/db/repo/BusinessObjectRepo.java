package sysglue.db.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sysglue.model.BusinessObject;

@RepositoryRestResource
public interface BusinessObjectRepo extends PagingAndSortingRepository<BusinessObject, String> {

}

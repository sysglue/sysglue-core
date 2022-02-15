package sysglue.api.interfaces;


import java.util.UUID;

import javax.ws.rs.core.Response;


public interface GenericCrudInterface {
      

  Response get(UUID id);


  Response create(Object input);

  Response updateOrCreate(UUID id, Object input);

  Response delete(UUID id);

  Response search(Long page,Long size,String sort);
}

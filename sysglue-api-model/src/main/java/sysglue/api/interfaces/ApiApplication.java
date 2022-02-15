package sysglue.api.interfaces;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;


@OpenAPIDefinition(
    info = @Info(
        title="API for accessing the registry of sysglue",
        version = "0.0.1",
        contact = @Contact(
            name = "Alain Pham",
            url = "https://alainpham.github.io"
            ),
        license = @License(
            name = "GNU AGPLv3",
            url = "https://www.gnu.org/licenses/agpl.txt"))
)
public class ApiApplication extends Application{
    
}

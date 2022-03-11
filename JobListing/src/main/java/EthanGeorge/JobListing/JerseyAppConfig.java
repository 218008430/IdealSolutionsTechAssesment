
package EthanGeorge.JobListing;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author Ethan George
 */
@Component
@ApplicationPath("/api")
public class JerseyAppConfig extends ResourceConfig {
    
    public JerseyAppConfig(){
        packages("EthanGeorge.JobListing.resources");
        packages("EthanGeorge.JobListing.resources");
    }
    
}

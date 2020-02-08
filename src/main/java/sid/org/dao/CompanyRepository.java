package sid.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sid.org.entities.Company;
@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

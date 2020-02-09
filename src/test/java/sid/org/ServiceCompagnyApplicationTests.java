package sid.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import sid.org.dao.CompanyRepository;
import sid.org.entities.Company;
import sid.org.service.CompanyService;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(SpringRunner.class)
class ServiceCompagnyApplicationTests {

    @MockBean
    CompanyRepository companyRepository;
    @Autowired
    CompanyService companyService;
    /*  @Test
      void contextLoads() {
      }*/
    @Test
    public void cpmpanyIsNoEmpty(){

        when(companyRepository.findAll()).thenReturn(Stream
                .of(new Company(null, "Danile",  2500), new Company(null, "Huy", 2900)).collect(Collectors.toList()));

           assertNotNull(companyService.getAllCompany());
           assertEquals(2,companyService.getAllCompany().size());
      /*  Company  C =companyRepository.save(new Company(null,"papa",250));
        assertNotNull(C.getName());

        assertEquals("papa", C.getName());*/

    }
    @Test
     public void saveCompany(){
        Company company=new Company(null,"tottal",3000);
        when(companyRepository.save(company)).thenReturn(company);
        assertEquals(company,companyService.addCompany(company));
     }
   @Test
     public void deleteCompany(){
         Company companyDelete=new Company(null,"ICOD",3770);
         companyRepository.deleteById(companyDelete.getId());
         verify(companyRepository, times(1)).deleteById(companyDelete.getId());


     }

}

package sid.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sid.org.dao.CompanyRepository;
import sid.org.entities.Company;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public void run(String... args) throws Exception {

        companyRepository.deleteAll();

        companyRepository.save(new Company(null,"cn",100+Math.random()*900));
        companyRepository.save(new Company(null,"cn2",100+Math.random()*800));
        companyRepository.save(new Company(null,"cn3",100+Math.random()*700));



        companyRepository.findAll().forEach(System.out::println);

    }
}

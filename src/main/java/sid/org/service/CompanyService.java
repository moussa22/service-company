package sid.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sid.org.dao.CompanyRepository;
import sid.org.entities.Company;

import java.util.List;
@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompany(Long id){
        return companyRepository.getOne(id);
    }

    public List<Company> getAllCompany(){

        List<Company> listCompany=companyRepository.findAll();
        return listCompany;

    }

    public void updateCompany(Company company){
        companyRepository.save(company);
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }

}

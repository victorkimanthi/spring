package com.eazybytes.jobportal.company.service;

import com.eazybytes.jobportal.dto.CompanyDto;
import com.eazybytes.jobportal.entity.Company;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ICompanyService {
    List<CompanyDto> getAllCompanies();

    void deleteCompanyById(Long id);

    boolean updateCompanyDetails(Long id, CompanyDto companyDto);

    boolean createCompany(CompanyDto companyDto);

    List<CompanyDto> getAllCompaniesForAdmin();

}

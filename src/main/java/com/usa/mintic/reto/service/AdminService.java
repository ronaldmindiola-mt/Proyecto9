package com.usa.mintic.reto.service;

import com.usa.mintic.reto.entities.Admin;
import com.usa.mintic.reto.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return (List<Admin>)adminRepository.getAll();

    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save (Admin admin){
        if(admin.getIdAdmin()== null){
            return adminRepository.save(admin);

        }else{
            Optional<Admin> element = adminRepository.getAdmin(admin.getIdAdmin());
            if(element.isEmpty()){
                return adminRepository.save(admin);

            }else{
                return admin;
            }
        }

    }

    public Admin updateAdmin(Admin admin){
        if(admin.getIdAdmin() !=null){
            Optional<Admin> element = adminRepository.getAdmin(admin.getIdAdmin());
            if(!element.isEmpty()){
                if(admin.getPassword() !=null){
                    element.get().setPassword(admin.getPassword());
                }

                return adminRepository.save(element.get());
            }
        }
        return admin;
    }

    public boolean deleteAdmin(int adminId){
        Boolean res = getAdmin(adminId).map(adminDelete ->{
            adminRepository.delete(adminDelete);
            return true ;
        }).orElse(false);
        return res;
    }
}

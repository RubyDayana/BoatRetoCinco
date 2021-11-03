package com.boat.service;

import com.boat.model.Admin;
import com.boat.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int adminId) {
        return adminRepository.getAdmin(adminId);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public boolean deleteAdmin(int id) {
        Optional<Admin> admin = adminRepository.getAdmin(id);

        if (admin.isEmpty()) {
            return false;
        } else {
            adminRepository.delete(admin.get());
            return true;
        }
    }

    public Admin updateAdmin(Admin admin) {
        if (admin.getIdAdmin()!= null) {
            Optional<Admin> user = adminRepository.getAdmin(admin.getIdAdmin());

            if (!user.isEmpty()) {
                if (admin.getName() != null) {
                    user.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    user.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword()!= null) {
                    user.get().setPassword(admin.getPassword());
                }
                
                return adminRepository.save(user.get());
            } else {
                return admin;
            }
        }
        return admin;
    }
}

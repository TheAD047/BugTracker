package com.example.BugTracker.Controllers;

import com.example.BugTracker.Models.Admin;
import com.example.BugTracker.Repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/Admins")
@AllArgsConstructor
public class AdminController {
    private final AdminRepository adminRepository;;

    @GetMapping
    public String getAdmins(Model model) {
        Iterable<Admin> admins = this.adminRepository.findAll();
        List<Admin> adminList = new ArrayList<>();
        admins.forEach(adminList::add);
        adminList.sort(new Comparator<Admin>() {
            @Override
            public int compare(Admin o1, Admin o2) {
                return o1.getAdminID().compareTo(o2.getAdminID());
            }
        });
        model.addAttribute("admins", adminList);
        model.addAttribute("module", adminList);
        return "Admins";
    }
}

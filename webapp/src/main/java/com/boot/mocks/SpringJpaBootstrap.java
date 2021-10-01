package com.boot.mocks;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.boot.entities.Product;
import com.boot.entities.Role;
import com.boot.entities.User;
import com.boot.repositories.ProductRepository;
import com.boot.service.RoleService;
import com.boot.service.UserService;

import javassist.NotFoundException;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private UserService userService;
    private RoleService roleService;

    private Logger log = LoggerFactory.getLogger(SpringJpaBootstrap.class);

    public ProductRepository getProductRepository() {
		return productRepository;
	}

    @Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public UserService getUserService() {
		return userService;
	}

    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

    @Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	private Logger getLog() {
		return log;
	}

	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadUsers();
        loadRoles();
        assignUsersToUserRole();
        assignUsersToAdminRole();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription(" Chemise Lacouste");
        shirt.setPrice(18.95f);
        shirt.setImageUrl("https://www.vision-naire.com/wp-content/uploads/2016/11/T-SHIRT-V-150x150.jpg");
        shirt.setProductId("235268845711068308");
        getProductRepository().save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product pant = new Product();
        pant.setDescription("Pantalon Hugo Boot");
        pant.setPrice(120.9f);
        pant.setImageUrl("https://www.vision-naire.com/wp-content/uploads/2020/06/jogging-visionnaire-2-100x100.jpg");
        pant.setProductId("168639393495335947");
        getProductRepository().save(pant);

        log.info("Saved Mug - id:" + pant.getId());
    }

    private void loadUsers() {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        getUserService().saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        getUserService().saveOrUpdate(user2);

    }

    private void loadRoles() {
        getRoleService().saveOrUpdate(new Role("USER", new ArrayList<>()));
        getRoleService().saveOrUpdate(new Role("ADMIN", new ArrayList<>()));
    }
    
    private void assignUsersToUserRole() {
    	//Assign "user" role to "user" user
    	try {
			User user = getUserService().findByUsername("user");
			user.addRole(
					getRoleService().findRoleByName("USER")
			);
			getUserService().saveOrUpdate(user);
		} catch (UsernameNotFoundException e) {
			getLog().warn(e.getMessage());
		} catch (NotFoundException e) {
			getLog().warn(e.getMessage());
		}
    }
    
    private void assignUsersToAdminRole() {
    	//Assign "admin" role to "admin" user
    	try {
			User user = getUserService().findByUsername("admin");
			user.addRole(
					getRoleService().findRoleByName("ADMIN")
			);
			getUserService().saveOrUpdate(user);
		} catch (UsernameNotFoundException e) {
			getLog().warn(e.getMessage());
		} catch (NotFoundException e) {
			getLog().warn(e.getMessage());
		}
    }
}
package com.example.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.app.entity.AppRole;
import com.example.app.entity.AppUser;
import com.example.app.entity.Bill;
import com.example.app.entity.BillDetail;
import com.example.app.entity.Cart;
import com.example.app.entity.CartDetail;
import com.example.app.entity.PaymentMethod;
import com.example.app.entity.Product;
import com.example.app.entity.ProductCategoty;
import com.example.app.entity.Review;
import com.example.app.entity.Thumbnail;
import com.example.app.entity.TransferMethod;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {

	private static final String FRONTEND_URL = "http://localhost:5173"; // hoặc http://127.0.0.1:3000

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		// Hiển thị ID trong JSON
		config.exposeIdsFor(AppRole.class, AppUser.class, Bill.class, BillDetail.class, Cart.class, CartDetail.class,
				PaymentMethod.class, Product.class, ProductCategoty.class, Review.class, Thumbnail.class,
				TransferMethod.class);

//		// Chặn các methods cho Category
//		HttpMethod[] blockCategory = { HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE };
//		disableHttpMethods(ProductCategoty.class, config, blockCategory);
//
//		// Chặn DELETE cho User
//		HttpMethod[] blockUser = { HttpMethod.DELETE };
//		disableHttpMethods(AppUser.class, config, blockUser);

		// Cho phép CORS cho Postman / Frontend
		cors.addMapping("/**").allowedOrigins(FRONTEND_URL).allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH",
				"OPTIONS");
	}

//	private void disableHttpMethods(Class<?> domainType, RepositoryRestConfiguration config, HttpMethod[] methods) {
//		config.getExposureConfiguration().forDomainType(domainType)
//				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(methods))
//				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(methods));
//	}
}
